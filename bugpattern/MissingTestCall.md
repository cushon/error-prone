---
title: MissingTestCall
summary: A terminating method call is required for a test helper to have any effect.
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
Some test helpers such as `EqualsTester` require a terminating method call to be
of any use.

```java
  @Test
  public void string() {
    new EqualsTester()
        .addEqualityGroup("hello", new String("hello"))
        .addEqualityGroup("world", new String("world"))
        .addEqualityGroup(2, Integer.valueOf(2));
    // Oops: forgot to call `testEquals()`
  }
```

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("MissingTestCall")` to the enclosing element.
