---
title: FunctionalInterfaceMethodChanged
summary: Casting a lambda to this @FunctionalInterface can cause a behavior change
  from casting to a functional superinterface, which is surprising to users.  Prefer
  decorator methods to this surprising behavior.
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
There are only two correct ways to have one [`@FunctionalInterface`] extend
another [`@FunctionalInterface`]—the way where you leave the abstract method
alone, and the way where you make a different abstract method but a default
method for the original abstract method simply delegates to the new name.

If you do anything else, you create a situation where what looks like a "cast"
actually changes behavior. That is really quite bad for understandability.

For example, if the method `bar()` changes the behaviour of `qux()`, then the
same lambda cast to `A` or `B` could have completely different behaviour.

```java
@FunctionalInterface
interface A {
  Foo bar();
}

@FunctionalInterface
interface B extends A {
  Foo qux();
  @Override
  default Foo bar() {
    // anything here but exactly `return qux();` or perhaps `return (SomeType) qux();`
  }
}
```

If you need to change the behaviour of an existing lambda, prefer an explicit
decorator method, e.g.:

```java
static Runnable crashTerminating(Runnable r) {
  return () -> { ...wrapping behavior goes here... }
}
```

[`@FunctionalInterface`]: https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("FunctionalInterfaceMethodChanged")` to the enclosing element.
