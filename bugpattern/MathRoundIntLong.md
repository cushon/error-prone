---
title: MathRoundIntLong
summary: Math.round(Integer) results in truncation
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
Math.round() called with an integer or long type results in truncation because Math.round only accepts floats or doubles and some integers and longs can't be represented with float.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("MathRoundIntLong")` to the enclosing element.
