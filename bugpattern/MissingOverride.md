---
title: MissingOverride
summary: method overrides method in supertype; expected @Override
layout: bugpattern
tags: Style
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
The [Google Java Style Guide §6.1][style] requires that a method is marked with
the `@Override` annotation whenever it is legal. This includes a class method
overriding a superclass method, a class method implementing an interface method,
and an interface method respecifying a superinterface method.

Exception: `@Override` may be omitted when the parent method is `@Deprecated`.
If the flag `-XepOpt:MissingOverride:IgnoreInterfaceOverrides=true` is used,
`@Override` can be omitted for an interface method respecifying a superinterface
method.

[style]: https://google.github.io/styleguide/javaguide.html#s6.1-override-annotation

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("MissingOverride")` to the enclosing element.
