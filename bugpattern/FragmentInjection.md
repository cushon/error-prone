---
title: FragmentInjection
summary: Classes extending PreferenceActivity must implement isValidFragment such
  that it does not unconditionally return true to prevent vulnerability to fragment
  injection attacks.
layout: bugpattern
tags: LikelyError
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->



## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("FragmentInjection")` to the enclosing element.
