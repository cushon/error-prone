---
title: EmptySetMultibindingContributions
summary: '@Multibinds is a more efficient and declarative mechanism for ensuring that
  a set multibinding is present in the graph.'
layout: bugpattern
tags: ''
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
When using [Dagger Multibinding][dmb], you can use methods like the below to
make sure that there's a (potentially empty) Set binding for your type:

```java
@Provides @ElementsIntoSet Set<MyType> provideEmptySetOfMyType() {
  return new HashSet<>();
}
```

However, there's a slightly easier way to express this:

```java
@Multibinds abstract Set<MyType> provideEmptySetOfMyType();
```

[dmb]: https://dagger.dev/multibindings.html

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("EmptySetMultibindingContributions")` to the enclosing element.
