---
title: ClassNamedLikeTypeParameter
summary: This class's name looks like a Type Parameter.
layout: bugpattern
tags: Style
severity: SUGGESTION
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
In the [Google Style Guide][gsg], type parameters are named in one of two
patterns:

> *   A single capital letter, optionally followed by a single numeral (such as
>     E, T, X, T2)
> *   A name in the form used for classes..., followed by the capital letter T
>     (examples: RequestT, FooBarT).

If a regular class is named like this, then it might be confusing for users of
your API:

```java
class Bar {
  ...
  public void doSomething(T object) {
    // Here, object is the static class T in this file
  }

  public <T> void doSomethingElse(T object) {
    // Here, object is a generic T
  }
  ...
  public static class T {...}
}
```

Looking at `T`, it's very likely to be confused as a type parameter instead of a
class.

[gsg]: https://google.github.io/styleguide/javaguide.html#s5.2.8-type-variable-names

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("ClassNamedLikeTypeParameter")` to the enclosing element.
