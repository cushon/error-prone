---
title: InjectScopeAnnotationOnInterfaceOrAbstractClass
summary: Scope annotation on an interface or abstract class is not allowed
layout: bugpattern
tags: ''
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
Scoping annotations are not allowed on abstract types.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("InjectScopeAnnotationOnInterfaceOrAbstractClass")` to the enclosing element.
