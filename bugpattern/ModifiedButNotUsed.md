---
title: ModifiedButNotUsed
summary: A collection or proto builder was created, but its values were never accessed.
layout: bugpattern
tags: ''
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->


## The problem
Collections and proto builders which are created and mutated but never used may
be a sign of a bug, for example:

```java
  MyProto.Builder builder = MyProto.newBuilder();
  if (field != null) {
    MyProto.NestedField.Builder nestedBuilder = MyProto.NestedField.newBuilder();
    nestedBuilder.setValue(field);
    // Oops--forgot to do anything with nestedBuilder.
  }
  return builder.build();
```

Likewise, converting a proto to a builder and modifying it is a no-op unless
something is done with the return value:

```java
  void setFoo(MyProto proto, String foo) {
    proto.toBuilder().setFoo(foo).build();
  }
```

As protos are immutable, either the return value must be used:

```java
  @CheckReturnValue
  MyProto withFoo(MyProto proto, String foo) {
    return proto.toBuilder().setFoo(foo).build();
  }
```

or the Builder modified in place:

```java
  void setFoo(MyProto.Builder protoBuilder, String foo) {
    protoBuilder.setFoo(foo);
  }
```

## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("ModifiedButNotUsed")` to the enclosing element.
