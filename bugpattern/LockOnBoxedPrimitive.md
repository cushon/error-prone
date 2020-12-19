---
title: LockOnBoxedPrimitive
summary: It is dangerous to use a boxed primitive as a lock as it can unintentionally
  lead to sharing a lock with another piece of code.
layout: bugpattern
tags: ''
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
Instances of boxed primitive types may be cached by the standard library `valueOf` method. This method is used for autoboxing. This means that using a boxed primitive as a lock can result in unintentionally sharing a lock with another piece of code.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("LockOnBoxedPrimitive")` to the enclosing element.
