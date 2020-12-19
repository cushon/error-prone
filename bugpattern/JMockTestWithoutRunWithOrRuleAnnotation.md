---
title: JMockTestWithoutRunWithOrRuleAnnotation
summary: jMock tests must have a @RunWith(JMock.class) annotation, or the Mockery
  field must have a @Rule JUnit annotation
layout: bugpattern
tags: ''
severity: ERROR
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
jMock tests must have a @RunWith(JMock.class) annotation, or the Mockery field
must have a @Rule JUnit annotation. If this is not done, then all of your jMock
tests will run and pass, but none of your assertions will actually be evaluated.
Your tests will pass even if they shouldn't.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("JMockTestWithoutRunWithOrRuleAnnotation")` to the enclosing element.
