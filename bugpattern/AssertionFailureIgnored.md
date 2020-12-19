---
title: AssertionFailureIgnored
summary: This assertion throws an AssertionError if it fails, which will be caught
  by an enclosing try block.
layout: bugpattern
tags: LikelyError
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
JUnit's `fail()` and `assert*` methods throw an `AssertionError`, so using the
try/fail/catch pattern to test for `AssertionError` (or any of its super-types)
is incorrect. The following example will never fail:

```java
try {
  doSomething();
  fail("expected doSomething to throw AssertionError");
} catch (AssertionError expected) {
  // expected exception
}
```

To avoid this issue, prefer JUnit's `assertThrows()` API:

```java
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

@Test
public void testFailsWithAssertionError() {
  AssertionError thrown = assertThrows(
      AssertionError.class,
      () -> {
        doSomething();
      });
  assertThat(thrown).hasMessageThat().contains("something went terribly wrong");
}
```

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("AssertionFailureIgnored")` to the enclosing element.
