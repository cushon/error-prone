---
title: WakelockReleasedDangerously
summary: A wakelock acquired with a timeout may be released by the system before calling
  `release`, even after checking `isHeld()`. If so, it will throw a RuntimeException.
  Please wrap in a try/catch block.
layout: bugpattern
tags: FragileCode
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->



## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("WakelockReleasedDangerously")` to the enclosing element.
