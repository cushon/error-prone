---
title: UnlockMethod
summary: This method does not acquire the locks specified by its @UnlockMethod annotation
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->

_Alternate names: GuardedBy_

## The problem
Methods with the @UnlockMethod annotation are expected to release one or more
locks. The caller must hold the locks when the function is entered, and will not
hold them when it completes.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("UnlockMethod")` to the enclosing element.
