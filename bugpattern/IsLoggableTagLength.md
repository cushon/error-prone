---
title: IsLoggableTagLength
summary: Log tag too long, cannot exceed 23 characters.
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
`Log.isLoggable(tag, level)` throws an `IllegalArgumentException` if its tag
argument is more than 23 characters long.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("IsLoggableTagLength")` to the enclosing element.
