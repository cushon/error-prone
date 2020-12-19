---
title: CompatibleWithAnnotationMisuse
summary: '@CompatibleWith''s value is not a type argument.'
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
The `@CompatibleWith` annotation is used to mark parameters that need extra type
checking on arguments passed to the method. The annotation was not appropriately
placed on a parameter with a valid type argument. See the javadoc for more
details.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("CompatibleWithAnnotationMisuse")` to the enclosing element.
