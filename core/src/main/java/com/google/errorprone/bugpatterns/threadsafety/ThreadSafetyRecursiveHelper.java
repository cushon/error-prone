/*
 * Copyright 2021 The Error Prone Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.bugpatterns.threadsafety;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.bugpatterns.threadsafety.ThreadSafety.Violation;
import com.sun.tools.javac.code.Symbol.TypeVariableSymbol;
import com.sun.tools.javac.code.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

final class ThreadSafetyRecursiveHelper {
  private final Set<TypeVariableSymbol> recursiveThreadSafeTypeParameter;
  private final ThreadSafety threadSafety;

  private ThreadSafetyRecursiveHelper(ThreadSafety threadSafety) {
    this.threadSafety = threadSafety;
    this.recursiveThreadSafeTypeParameter = new HashSet<>();
  }

  static Violation threadSafeInstantiation(
      ThreadSafety threadSafety,
      Set<String> containerTypeParameters,
      AnnotationInfo annotation,
      Type type) {
    ThreadSafetyRecursiveHelper threadSafetyRecursiveHelper =
        new ThreadSafetyRecursiveHelper(threadSafety);
    return threadSafety.threadSafeInstantiation(
        threadSafetyRecursiveHelper, containerTypeParameters, annotation, type);
  }

  static Violation isThreadSafeType(
      ThreadSafety threadSafety,
      boolean allowContainerTypeParameters,
      Set<String> containerTypeParameters,
      Type type) {
    return threadSafety.isThreadSafeType(
        new ThreadSafetyRecursiveHelper(threadSafety),
        allowContainerTypeParameters,
        containerTypeParameters,
        type);
  }

  /**
   * Returns whether a type parameter is thread-safe.
   *
   * <p>This is true if either the type parameter's declaration is annotated with type parameter
   * annotation (indicating it can only be instantiated with thread-safe types), or the type
   * parameter has a thread-safe upper bound (sub-classes of thread-safe types are also
   * thread-safe).
   *
   * <p>If a type has a recursive bound, we recursively assume that this type satisfies all
   * thread-safety constraints. Recursion can only happen with type variables that have recursive
   * type bounds. These type variables do not need to be called out in the "containerOf" attribute
   * or annotated with type parameter annotation.
   *
   * <p>Recursion does not apply to other kinds of types because all declared types must be
   * annotated thread-safe, which means that thread-safety checkers don't need to analyze all
   * referenced types recursively.
   */
  static boolean isTypeParameterThreadSafe(
      ThreadSafety threadSafety, TypeVariableSymbol symbol, Set<String> containerTypeParameters) {
    ThreadSafetyRecursiveHelper threadSafetyRecursiveHelper =
        new ThreadSafetyRecursiveHelper(threadSafety);
    return threadSafetyRecursiveHelper.isTypeParameterThreadSafe(symbol, containerTypeParameters);
  }

  boolean isTypeParameterThreadSafe(
      TypeVariableSymbol symbol, Set<String> containerTypeParameters) {
    if (!recursiveThreadSafeTypeParameter.add(symbol)) {
      return true;
    }

    try {
      if (threadSafety.hasThreadSafeTypeParameterAnnotation(symbol)) {
        return true;
      }

      return isBoundedToThreadSafeTypesOnly(symbol.getBounds().stream(), containerTypeParameters);
    } finally {
      recursiveThreadSafeTypeParameter.remove(symbol);
    }
  }

  static boolean isBoundedToThreadSafeTypesOnly(
      ThreadSafety threadSafety, ImmutableList<Type> bounds, Set<String> containerTypeParameters) {
    ThreadSafetyRecursiveHelper threadSafetyRecursiveHelper =
        new ThreadSafetyRecursiveHelper(threadSafety);
    return threadSafetyRecursiveHelper.isBoundedToThreadSafeTypesOnly(
        bounds.stream(), containerTypeParameters);
  }

  private boolean isBoundedToThreadSafeTypesOnly(
      Stream<Type> bounds, Set<String> containerTypeParameters) {
    // A type variable is thread-safe if any upper bound is thread-safe.
    return bounds.anyMatch(
        bound ->
            !threadSafety.isThreadSafeType(this, true, containerTypeParameters, bound).isPresent());
  }
}
