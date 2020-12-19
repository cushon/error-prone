---
title: ParameterComment
summary: Non-standard parameter comment; prefer `/* paramName= */ arg`
layout: bugpattern
tags: Style
severity: SUGGESTION
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
When documenting the name of the corresponding formal parameter for a method
argument, prefer the `f(/* foo= */ value)` style of comment.

The problem with e.g. `f(false /* exclusive */)` is it can be interpreted
multiple ways:

*   Exclusiveness is false, so this is inclusive.
*   I am making this exclusive by setting the inclusiveness to false.

TIP: When you feel the need to add a parameter comment, consider whether the API
could be changed to be more self-documenting.

NOTE: The `f(/* foo= */ value)` format leads to compile-time enforcement that
the parameter comment matches the formal parameter name.

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("ParameterComment")` to the enclosing element.
