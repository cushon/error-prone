---
title: InconsistentOverloads
summary: The ordering of parameters in overloaded methods should be as consistent
  as possible (when viewed from left to right)
layout: bugpattern
tags: ''
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
Inconsistently ordered parameters in method overloads can be very confusing to
the users. For example, the following overloads are considered to be consistent:

```java
public void foo(Bar bar, Baz baz) { ... }
public void foo(Bar bar, Baz baz, int x) { ... }
```

However, these are not consistent:

```java
public void foo(Bar bar, Baz baz) { ... }
public void foo(Bar bar, int x, Baz baz) { ... }
```

Having inconsistent parameters not only makes the code more confusing and puts
additional burden on the user, but can also lead to very serious bugs. Consider
the following overloaded methods:

```java
public void foo(Bar bar, String suffix) { ... }
public void foo(Bar bar, String prefix, String suffix) { ... }
```

If the caller has a code like `foo(bar, "quux")` and wants to add custom prefix
support they will most likely do it like `foo(bar, "quux", "norf")`. The
compiler will accept this because the types match perfectly. However, this is
clearly a bug caused by unintuitive API and method overloading.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("InconsistentOverloads")` to the enclosing element.
