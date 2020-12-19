---
title: NCopiesOfChar
summary: The first argument to nCopies is the number of copies, and the second is
  the item to copy
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
Calling `nCopies('a', 10)` returns a list with 97 copies of 10, not a list with
10 copies of 'a'.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("NCopiesOfChar")` to the enclosing element.
