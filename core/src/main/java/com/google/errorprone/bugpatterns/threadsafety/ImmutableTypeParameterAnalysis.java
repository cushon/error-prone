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

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Streams;
import com.google.errorprone.bugpatterns.threadsafety.ThreadSafety.Violation;
import com.sun.tools.javac.code.Symbol.TypeVariableSymbol;
import com.sun.tools.javac.code.Type;

final class ImmutableTypeParameterAnalysis {
  private final ImmutableAnalysis immutableAnalysis;
  private final ImmutableList.Builder<String> violationList;

  private ImmutableTypeParameterAnalysis(ImmutableAnalysis immutableAnalysis) {
    this.violationList = ImmutableList.builder();
    this.immutableAnalysis = immutableAnalysis;
  }

  static ImmutableList<String> getTypeViolations(ImmutableAnalysis immutableAnalysis, Type type) {
    ImmutableTypeParameterAnalysis analysis = new ImmutableTypeParameterAnalysis(immutableAnalysis);
    // Endless recursion is not possible here due to the declaration statements are finite.
    analysis.populateTypeViolations(type);
    return analysis.violationList.build();
  }

  private void populateTypeViolations(Type type) {
    for (TypePargs typePargs :
        Streams.iterating(
            Streams.zip(
                type.tsym.getTypeParameters().stream(),
                type.getTypeArguments().stream(),
                TypePargs::of))) {
      if (immutableAnalysis.hasThreadSafeTypeParameterAnnotation(typePargs.typeParam())) {
        // Container type parameters are required to check class definition only. This method checks
        // the usage and, therefore it requires all containerOf generic parameters to be immutable
        // as well. Obtaining the containerOf context is not necessary here.
        Violation violation =
            immutableAnalysis.isThreadSafeType(false, ImmutableSet.of(), typePargs.typeArg());
        if (violation.isPresent()) {
          violationList.add(violation.message());
        }
      } else {
        populateTypeViolations(typePargs.typeArg());
      }
    }
  }

  @AutoValue
  abstract static class TypePargs {
    abstract TypeVariableSymbol typeParam();

    abstract Type typeArg();

    static TypePargs of(TypeVariableSymbol typeParam, Type typeArg) {
      return new AutoValue_ImmutableTypeParameterAnalysis_TypePargs(typeParam, typeArg);
    }
  }
}
