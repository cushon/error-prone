---
title: Bug Patterns
layout: bugpatterns
---


# Bug patterns

This list is auto-generated from our sources. Each bug pattern includes code
examples of both positive and negative cases; these examples are used in our
regression test suite.

Patterns which are marked __Experimental__ will not be evaluated against your
code, unless you specifically configure Error Prone. The default checks are
marked __On by default__, and each release promotes some experimental checks
after we've vetted them against Google's codebase.

## On by default : ERROR

__[AndroidInjectionBeforeSuper](bugpattern/AndroidInjectionBeforeSuper)__<br>
AndroidInjection.inject() should always be invoked before calling super.lifecycleMethod()

__[ArrayEquals](bugpattern/ArrayEquals)__<br>
Reference equality used to compare arrays

__[ArrayFillIncompatibleType](bugpattern/ArrayFillIncompatibleType)__<br>
Arrays.fill(Object[], Object) called with incompatible types.

__[ArrayHashCode](bugpattern/ArrayHashCode)__<br>
hashcode method on array does not hash array contents

__[ArrayToString](bugpattern/ArrayToString)__<br>
Calling toString on an array does not provide useful information

__[ArraysAsListPrimitiveArray](bugpattern/ArraysAsListPrimitiveArray)__<br>
Arrays.asList does not autobox primitive arrays, as one might expect.

__[AsyncCallableReturnsNull](bugpattern/AsyncCallableReturnsNull)__<br>
AsyncCallable should not return a null Future, only a Future whose result is null.

__[AsyncFunctionReturnsNull](bugpattern/AsyncFunctionReturnsNull)__<br>
AsyncFunction should not return a null Future, only a Future whose result is null.

__[AutoValueConstructorOrderChecker](bugpattern/AutoValueConstructorOrderChecker)__<br>
Arguments to AutoValue constructor are in the wrong order

__[BadAnnotationImplementation](bugpattern/BadAnnotationImplementation)__<br>
Classes that implement Annotation must override equals and hashCode. Consider using AutoAnnotation instead of implementing Annotation by hand.

__[BadShiftAmount](bugpattern/BadShiftAmount)__<br>
Shift by an amount that is out of range

__[BundleDeserializationCast](bugpattern/BundleDeserializationCast)__<br>
Object serialized in Bundle may have been flattened to base type.

__[ChainingConstructorIgnoresParameter](bugpattern/ChainingConstructorIgnoresParameter)__<br>
The called constructor accepts a parameter with the same name and type as one of its caller&#39;s parameters, but its caller doesn&#39;t pass that parameter to it.  It&#39;s likely that it was intended to.

__[CheckNotNullMultipleTimes](bugpattern/CheckNotNullMultipleTimes)__<br>
A variable was checkNotNulled multiple times. Did you mean to check something else?

__[CheckReturnValue](bugpattern/CheckReturnValue)__<br>
Ignored return value of method that is annotated with @CheckReturnValue

__[CollectionIncompatibleType](bugpattern/CollectionIncompatibleType)__<br>
Incompatible type as argument to Object-accepting Java collections method

__[CollectionToArraySafeParameter](bugpattern/CollectionToArraySafeParameter)__<br>
The type of the array parameter of Collection.toArray needs to be compatible with the array type

__[ComparableType](bugpattern/ComparableType)__<br>
Implementing &#39;Comparable&lt;T&gt;&#39; where T is not the same as the implementing class is incorrect, since it violates the symmetry contract of compareTo.

__[ComparingThisWithNull](bugpattern/ComparingThisWithNull)__<br>
this == null is always false, this != null is always true

__[ComparisonOutOfRange](bugpattern/ComparisonOutOfRange)__<br>
Comparison to value that is out of range for the compared type

__[CompatibleWithAnnotationMisuse](bugpattern/CompatibleWithAnnotationMisuse)__<br>
@CompatibleWith&#39;s value is not a type argument.

__[CompileTimeConstant](bugpattern/CompileTimeConstant)__<br>
Non-compile-time constant expression passed to parameter with @CompileTimeConstant type annotation.

__[ComputeIfAbsentAmbiguousReference](bugpattern/ComputeIfAbsentAmbiguousReference)__<br>
computeIfAbsent passes the map key to the provided class&#39;s constructor

__[ConditionalExpressionNumericPromotion](bugpattern/ConditionalExpressionNumericPromotion)__<br>
A conditional expression with numeric operands of differing types will perform binary numeric promotion of the operands; when these operands are of reference types, the expression&#39;s result may not be of the expected type.

__[ConstantOverflow](bugpattern/ConstantOverflow)__<br>
Compile-time constant expression overflows

__[DaggerProvidesNull](bugpattern/DaggerProvidesNull)__<br>
Dagger @Provides methods may not return null unless annotated with @Nullable

__[DangerousLiteralNull](bugpattern/DangerousLiteralNull)__<br>
This method is null-hostile: passing a null literal to it is always wrong

__[DeadException](bugpattern/DeadException)__<br>
Exception created but not thrown

__[DeadThread](bugpattern/DeadThread)__<br>
Thread created but not started

__[DiscardedPostfixExpression](bugpattern/DiscardedPostfixExpression)__<br>
The result of this unary operation on a lambda parameter is discarded

__[DoNotCall](bugpattern/DoNotCall)__<br>
This method should not be called.

__[DoNotMock](bugpattern/DoNotMock)__<br>
Identifies undesirable mocks.

__[DuplicateMapKeys](bugpattern/DuplicateMapKeys)__<br>
Map#ofEntries will throw an IllegalArgumentException if there are any duplicate keys

__[DurationFrom](bugpattern/DurationFrom)__<br>
Duration.from(Duration) returns itself; from(Period) throws a runtime exception.

__[DurationGetTemporalUnit](bugpattern/DurationGetTemporalUnit)__<br>
Duration.get() only works with SECONDS or NANOS.

__[DurationTemporalUnit](bugpattern/DurationTemporalUnit)__<br>
Duration APIs only work for DAYS or exact durations.

__[DurationToLongTimeUnit](bugpattern/DurationToLongTimeUnit)__<br>
Unit mismatch when decomposing a Duration or Instant to call a &lt;long, TimeUnit&gt; API

__[EqualsHashCode](bugpattern/EqualsHashCode)__<br>
Classes that override equals should also override hashCode.

__[EqualsNaN](bugpattern/EqualsNaN)__<br>
== NaN always returns false; use the isNaN methods instead

__[EqualsReference](bugpattern/EqualsReference)__<br>
== must be used in equals method to check equality to itself or an infinite loop will occur.

__[EqualsWrongThing](bugpattern/EqualsWrongThing)__<br>
Comparing different pairs of fields/getters in an equals implementation is probably a mistake.

__[FloggerFormatString](bugpattern/FloggerFormatString)__<br>
Invalid printf-style format string

__[FloggerLogVarargs](bugpattern/FloggerLogVarargs)__<br>
logVarargs should be used to pass through format strings and arguments.

__[FloggerSplitLogStatement](bugpattern/FloggerSplitLogStatement)__<br>
Splitting log statements and using Api instances directly breaks logging.

__[ForOverride](bugpattern/ForOverride)__<br>
Method annotated @ForOverride must be protected or package-private and only invoked from declaring class, or from an override of the method

__[FormatString](bugpattern/FormatString)__<br>
Invalid printf-style format string

__[FormatStringAnnotation](bugpattern/FormatStringAnnotation)__<br>
Invalid format string passed to formatting method.

__[FromTemporalAccessor](bugpattern/FromTemporalAccessor)__<br>
Certain combinations of javaTimeType.from(TemporalAccessor) will always throw a DateTimeException or return the parameter directly.

__[FunctionalInterfaceMethodChanged](bugpattern/FunctionalInterfaceMethodChanged)__<br>
Casting a lambda to this @FunctionalInterface can cause a behavior change from casting to a functional superinterface, which is surprising to users.  Prefer decorator methods to this surprising behavior.

__[FuturesGetCheckedIllegalExceptionType](bugpattern/FuturesGetCheckedIllegalExceptionType)__<br>
Futures.getChecked requires a checked exception type with a standard constructor.

__[GetClassOnAnnotation](bugpattern/GetClassOnAnnotation)__<br>
Calling getClass() on an annotation may return a proxy class

__[GetClassOnClass](bugpattern/GetClassOnClass)__<br>
Calling getClass() on an object of type Class returns the Class object for java.lang.Class; you probably meant to operate on the object directly

__[GuardedBy](bugpattern/GuardedBy)__<br>
Checks for unguarded accesses to fields and methods with @GuardedBy annotations

__[GuiceAssistedInjectScoping](bugpattern/GuiceAssistedInjectScoping)__<br>
Scope annotation on implementation class of AssistedInject factory is not allowed

__[GuiceAssistedParameters](bugpattern/GuiceAssistedParameters)__<br>
A constructor cannot have two @Assisted parameters of the same type unless they are disambiguated with named @Assisted annotations.

__[GuiceInjectOnFinalField](bugpattern/GuiceInjectOnFinalField)__<br>
Although Guice allows injecting final fields, doing so is disallowed because the injected value may not be visible to other threads.

__[HashtableContains](bugpattern/HashtableContains)__<br>
contains() is a legacy method that is equivalent to containsValue()

__[IdentityBinaryExpression](bugpattern/IdentityBinaryExpression)__<br>
A binary expression where both operands are the same is usually incorrect.

__[IdentityHashMapBoxing](bugpattern/IdentityHashMapBoxing)__<br>
Using IdentityHashMap with a boxed type as the key is risky since boxing may produce distinct instances

__[Immutable](bugpattern/Immutable)__<br>
Type declaration annotated with @Immutable is not immutable

__[ImmutableModification](bugpattern/ImmutableModification)__<br>
Modifying an immutable collection is guaranteed to throw an exception and leave the collection unmodified

__[Incomparable](bugpattern/Incomparable)__<br>
Types contained in sorted collections must implement Comparable.

__[IncompatibleArgumentType](bugpattern/IncompatibleArgumentType)__<br>
Passing argument to a generic method with an incompatible type.

__[IncompatibleModifiers](bugpattern/IncompatibleModifiers)__<br>
This annotation has incompatible modifiers as specified by its @IncompatibleModifiers annotation

__[IndexOfChar](bugpattern/IndexOfChar)__<br>
The first argument to indexOf is a Unicode code point, and the second is the index to start the search from

__[InexactVarargsConditional](bugpattern/InexactVarargsConditional)__<br>
Conditional expression in varargs call contains array and non-array arguments

__[InfiniteRecursion](bugpattern/InfiniteRecursion)__<br>
This method always recurses, and will cause a StackOverflowError

__[InjectMoreThanOneScopeAnnotationOnClass](bugpattern/InjectMoreThanOneScopeAnnotationOnClass)__<br>
A class can be annotated with at most one scope annotation.

__[InjectOnMemberAndConstructor](bugpattern/InjectOnMemberAndConstructor)__<br>
Members shouldn&#39;t be annotated with @Inject if constructor is already annotated @Inject

__[InstantTemporalUnit](bugpattern/InstantTemporalUnit)__<br>
Instant APIs only work for NANOS, MICROS, MILLIS, SECONDS, MINUTES, HOURS, HALF_DAYS and DAYS.

__[InvalidJavaTimeConstant](bugpattern/InvalidJavaTimeConstant)__<br>
This checker errors on calls to java.time methods using values that are guaranteed to throw a DateTimeException.

__[InvalidPatternSyntax](bugpattern/InvalidPatternSyntax)__<br>
Invalid syntax used for a regular expression

__[InvalidTimeZoneID](bugpattern/InvalidTimeZoneID)__<br>
Invalid time zone identifier. TimeZone.getTimeZone(String) will silently return GMT instead of the time zone you intended.

__[InvalidZoneId](bugpattern/InvalidZoneId)__<br>
Invalid zone identifier. ZoneId.of(String) will throw exception at runtime.

__[IsInstanceIncompatibleType](bugpattern/IsInstanceIncompatibleType)__<br>
This use of isInstance will always evaluate to false.

__[IsInstanceOfClass](bugpattern/IsInstanceOfClass)__<br>
The argument to Class#isInstance(Object) should not be a Class

__[IsLoggableTagLength](bugpattern/IsLoggableTagLength)__<br>
Log tag too long, cannot exceed 23 characters.

__[JUnit3TestNotRun](bugpattern/JUnit3TestNotRun)__<br>
Test method will not be run; please correct method signature (Should be public, non-static, and method name should begin with &quot;test&quot;).

__[JUnit4ClassAnnotationNonStatic](bugpattern/JUnit4ClassAnnotationNonStatic)__<br>
This method should be static

__[JUnit4SetUpNotRun](bugpattern/JUnit4SetUpNotRun)__<br>
setUp() method will not be run; please add JUnit&#39;s @Before annotation

__[JUnit4TearDownNotRun](bugpattern/JUnit4TearDownNotRun)__<br>
tearDown() method will not be run; please add JUnit&#39;s @After annotation

__[JUnit4TestNotRun](bugpattern/JUnit4TestNotRun)__<br>
This looks like a test method but is not run; please add @Test and @Ignore, or, if this is a helper method, reduce its visibility.

__[JUnitAssertSameCheck](bugpattern/JUnitAssertSameCheck)__<br>
An object is tested for reference equality to itself using JUnit library.

__[JavaxInjectOnAbstractMethod](bugpattern/JavaxInjectOnAbstractMethod)__<br>
Abstract and default methods are not injectable with javax.inject.Inject

__[JodaToSelf](bugpattern/JodaToSelf)__<br>
Use of Joda-Time&#39;s DateTime.toDateTime(), Duration.toDuration(), Instant.toInstant(), Interval.toInterval(), and Period.toPeriod() are not allowed.

__[LiteByteStringUtf8](bugpattern/LiteByteStringUtf8)__<br>
This pattern will silently corrupt certain byte sequences from the serialized protocol message. Use ByteString or byte[] directly

__[LocalDateTemporalAmount](bugpattern/LocalDateTemporalAmount)__<br>
LocalDate.plus() and minus() does not work with Durations. LocalDate represents civil time (years/months/days), so java.time.Period is the appropriate thing to add or subtract instead.

__[LoopConditionChecker](bugpattern/LoopConditionChecker)__<br>
Loop condition is never modified in loop body.

__[LossyPrimitiveCompare](bugpattern/LossyPrimitiveCompare)__<br>
Using an unnecessarily-wide comparison method can lead to lossy comparison

__[MathRoundIntLong](bugpattern/MathRoundIntLong)__<br>
Math.round(Integer) results in truncation

__[MislabeledAndroidString](bugpattern/MislabeledAndroidString)__<br>
Certain resources in `android.R.string` have names that do not match their content

__[MisplacedScopeAnnotations](bugpattern/MisplacedScopeAnnotations)__<br>
Scope annotations used as qualifier annotations don&#39;t have any effect. Move the scope annotation to the binding location or delete it.

__[MissingSuperCall](bugpattern/MissingSuperCall)__<br>
Overriding method is missing a call to overridden super method

__[MissingTestCall](bugpattern/MissingTestCall)__<br>
A terminating method call is required for a test helper to have any effect.

__[MisusedDayOfYear](bugpattern/MisusedDayOfYear)__<br>
Use of &#39;DD&#39; (day of year) in a date pattern with &#39;MM&#39; (month of year) is not likely to be intentional, as it would lead to dates like &#39;March 73rd&#39;.

__[MisusedWeekYear](bugpattern/MisusedWeekYear)__<br>
Use of &quot;YYYY&quot; (week year) in a date pattern without &quot;ww&quot; (week in year). You probably meant to use &quot;yyyy&quot; (year) instead.

__[MixedDescriptors](bugpattern/MixedDescriptors)__<br>
The field number passed into #getFieldByNumber belongs to a different proto to the Descriptor.

__[MockitoUsage](bugpattern/MockitoUsage)__<br>
Missing method call for verify(mock) here

__[ModifyingCollectionWithItself](bugpattern/ModifyingCollectionWithItself)__<br>
Using a collection function with itself as the argument.

__[MoreThanOneInjectableConstructor](bugpattern/MoreThanOneInjectableConstructor)__<br>
This class has more than one @Inject-annotated constructor. Please remove the @Inject annotation from all but one of them.

__[MustBeClosedChecker](bugpattern/MustBeClosedChecker)__<br>
The result of this method must be closed.

__[NCopiesOfChar](bugpattern/NCopiesOfChar)__<br>
The first argument to nCopies is the number of copies, and the second is the item to copy

__[NonCanonicalStaticImport](bugpattern/NonCanonicalStaticImport)__<br>
Static import of type uses non-canonical name

__[NonFinalCompileTimeConstant](bugpattern/NonFinalCompileTimeConstant)__<br>
@CompileTimeConstant parameters should be final or effectively final

__[NonRuntimeAnnotation](bugpattern/NonRuntimeAnnotation)__<br>
Calling getAnnotation on an annotation that is not retained at runtime.

__[NullTernary](bugpattern/NullTernary)__<br>
This conditional expression may evaluate to null, which will result in an NPE when the result is unboxed.

__[OptionalEquality](bugpattern/OptionalEquality)__<br>
Comparison using reference equality instead of value equality

__[OverlappingQualifierAndScopeAnnotation](bugpattern/OverlappingQualifierAndScopeAnnotation)__<br>
Annotations cannot be both Scope annotations and Qualifier annotations: this causes confusion when trying to use them.

__[OverridesJavaxInjectableMethod](bugpattern/OverridesJavaxInjectableMethod)__<br>
This method is not annotated with @Inject, but it overrides a method that is  annotated with @javax.inject.Inject. The method will not be Injected.

__[PackageInfo](bugpattern/PackageInfo)__<br>
Declaring types inside package-info.java files is very bad form

__[ParametersButNotParameterized](bugpattern/ParametersButNotParameterized)__<br>
This test has @Parameters but is using the default JUnit4 runner. The parameters will have no effect.

__[ParcelableCreator](bugpattern/ParcelableCreator)__<br>
Detects classes which implement Parcelable but don&#39;t have CREATOR

__[PeriodFrom](bugpattern/PeriodFrom)__<br>
Period.from(Period) returns itself; from(Duration) throws a runtime exception.

__[PeriodGetTemporalUnit](bugpattern/PeriodGetTemporalUnit)__<br>
Period.get() only works with YEARS, MONTHS, or DAYS.

__[PeriodTimeMath](bugpattern/PeriodTimeMath)__<br>
When adding or subtracting from a Period, Duration is incompatible.

__[PreconditionsInvalidPlaceholder](bugpattern/PreconditionsInvalidPlaceholder)__<br>
Preconditions only accepts the %s placeholder in error message strings

__[PrivateSecurityContractProtoAccess](bugpattern/PrivateSecurityContractProtoAccess)__<br>
Access to a private protocol buffer field is forbidden. This protocol buffer carries a security contract, and can only be created using an approved library. Direct access to the fields is forbidden.

__[ProtoFieldNullComparison](bugpattern/ProtoFieldNullComparison)__<br>
Protobuf fields cannot be null.

__[ProtoStringFieldReferenceEquality](bugpattern/ProtoStringFieldReferenceEquality)__<br>
Comparing protobuf fields of type String using reference equality

__[ProtoTruthMixedDescriptors](bugpattern/ProtoTruthMixedDescriptors)__<br>
The arguments passed to `ignoringFields` are inconsistent with the proto which is the subject of the assertion.

__[ProtocolBufferOrdinal](bugpattern/ProtocolBufferOrdinal)__<br>
To get the tag number of a protocol buffer enum, use getNumber() instead.

__[ProvidesMethodOutsideOfModule](bugpattern/ProvidesMethodOutsideOfModule)__<br>
@Provides methods need to be declared in a Module to have any effect.

__[RandomCast](bugpattern/RandomCast)__<br>
Casting a random number in the range [0.0, 1.0) to an integer or long always results in 0.

__[RandomModInteger](bugpattern/RandomModInteger)__<br>
Use Random.nextInt(int).  Random.nextInt() % n can have negative results

__[RectIntersectReturnValueIgnored](bugpattern/RectIntersectReturnValueIgnored)__<br>
Return value of android.graphics.Rect.intersect() must be checked

__[RequiredModifiers](bugpattern/RequiredModifiers)__<br>
This annotation is missing required modifiers as specified by its @RequiredModifiers annotation

__[RestrictedApiChecker](bugpattern/RestrictedApiChecker)__<br>
Check for non-whitelisted callers to RestrictedApiChecker.

__[ReturnValueIgnored](bugpattern/ReturnValueIgnored)__<br>
Return value of this method must be used

__[SelfAssignment](bugpattern/SelfAssignment)__<br>
Variable assigned to itself

__[SelfComparison](bugpattern/SelfComparison)__<br>
An object is compared to itself

__[SelfEquals](bugpattern/SelfEquals)__<br>
Testing an object for equality with itself will always be true.

__[ShouldHaveEvenArgs](bugpattern/ShouldHaveEvenArgs)__<br>
This method must be called with an even number of arguments.

__[SizeGreaterThanOrEqualsZero](bugpattern/SizeGreaterThanOrEqualsZero)__<br>
Comparison of a size &gt;= 0 is always true, did you intend to check for non-emptiness?

__[StreamToString](bugpattern/StreamToString)__<br>
Calling toString on a Stream does not provide useful information

__[StringBuilderInitWithChar](bugpattern/StringBuilderInitWithChar)__<br>
StringBuilder does not have a char constructor; this invokes the int constructor.

__[SubstringOfZero](bugpattern/SubstringOfZero)__<br>
String.substring(0) returns the original String

__[SuppressWarningsDeprecated](bugpattern/SuppressWarningsDeprecated)__<br>
Suppressing &quot;deprecated&quot; is probably a typo for &quot;deprecation&quot;

__[TemporalAccessorGetChronoField](bugpattern/TemporalAccessorGetChronoField)__<br>
TemporalAccessor.get() only works for certain values of ChronoField.

__[TheoryButNoTheories](bugpattern/TheoryButNoTheories)__<br>
This test has members annotated with @Theory, @DataPoint, or @DataPoints but is using the default JUnit4 runner.

__[ThrowIfUncheckedKnownChecked](bugpattern/ThrowIfUncheckedKnownChecked)__<br>
throwIfUnchecked(knownCheckedException) is a no-op.

__[ThrowNull](bugpattern/ThrowNull)__<br>
Throwing &#39;null&#39; always results in a NullPointerException being thrown.

__[TreeToString](bugpattern/TreeToString)__<br>
Tree#toString shouldn&#39;t be used for Trees deriving from the code being compiled, as it discards whitespace and comments.

__[TruthSelfEquals](bugpattern/TruthSelfEquals)__<br>
isEqualTo should not be used to test an object for equality with itself; the assertion will never fail.

__[TryFailThrowable](bugpattern/TryFailThrowable)__<br>
Catching Throwable/Error masks failures from fail() or assert*() in the try block

__[TypeParameterQualifier](bugpattern/TypeParameterQualifier)__<br>
Type parameter used as type qualifier

__[UnnecessaryCheckNotNull](bugpattern/UnnecessaryCheckNotNull)__<br>
This null check is unnecessary; the expression can never be null

__[UnnecessaryTypeArgument](bugpattern/UnnecessaryTypeArgument)__<br>
Non-generic methods should not be invoked with type arguments

__[UnusedAnonymousClass](bugpattern/UnusedAnonymousClass)__<br>
Instance created but never used

__[UnusedCollectionModifiedInPlace](bugpattern/UnusedCollectionModifiedInPlace)__<br>
Collection is modified in place, but the result is not used

__[VarTypeName](bugpattern/VarTypeName)__<br>
`var` should not be used as a type name.

__[WrongOneof](bugpattern/WrongOneof)__<br>
This field is guaranteed not to be set given it&#39;s within a switch over a one_of.

__[XorPower](bugpattern/XorPower)__<br>
The `^` operator is binary XOR, not a power operator.

__[ZoneIdOfZ](bugpattern/ZoneIdOfZ)__<br>
Use ZoneOffset.UTC instead of ZoneId.of(&quot;Z&quot;).

## On by default : WARNING

__[AlmostJavadoc](bugpattern/AlmostJavadoc)__<br>
This comment contains Javadoc or HTML tags, but isn&#39;t started with a double asterisk (/**); is it meant to be Javadoc?

__[AmbiguousMethodReference](bugpattern/AmbiguousMethodReference)__<br>
Method reference is ambiguous

__[AnnotateFormatMethod](bugpattern/AnnotateFormatMethod)__<br>
This method passes a pair of parameters through to String.format, but the enclosing method wasn&#39;t annotated @FormatMethod. Doing so gives compile-time rather than run-time protection against malformed format strings.

__[ArgumentSelectionDefectChecker](bugpattern/ArgumentSelectionDefectChecker)__<br>
Arguments are in the wrong order or could be commented for clarity.

__[ArrayAsKeyOfSetOrMap](bugpattern/ArrayAsKeyOfSetOrMap)__<br>
Arrays do not override equals() or hashCode, so comparisons will be done on reference equality only. If neither deduplication nor lookup are needed, consider using a List instead. Otherwise, use IdentityHashMap/Set, a Map from a library that handles object arrays, or an Iterable/List of pairs.

__[AssertEqualsArgumentOrderChecker](bugpattern/AssertEqualsArgumentOrderChecker)__<br>
Arguments are swapped in assertEquals-like call

__[AssertThrowsMultipleStatements](bugpattern/AssertThrowsMultipleStatements)__<br>
The lambda passed to assertThrows should contain exactly one statement

__[AssertionFailureIgnored](bugpattern/AssertionFailureIgnored)__<br>
This assertion throws an AssertionError if it fails, which will be caught by an enclosing try block.

__[AssignmentToMock](bugpattern/AssignmentToMock)__<br>
Fields annotated with @Mock should not be manually assigned to.

__[AssistedInjectAndInjectOnSameConstructor](bugpattern/AssistedInjectAndInjectOnSameConstructor)__<br>
@AssistedInject and @Inject cannot be used on the same constructor.

__[AutoValueFinalMethods](bugpattern/AutoValueFinalMethods)__<br>
Make toString(), hashCode() and equals() final in AutoValue classes, so it is clear to readers that AutoValue is not overriding them

__[AutoValueImmutableFields](bugpattern/AutoValueImmutableFields)__<br>
AutoValue recommends using immutable collections

__[AutoValueSubclassLeaked](bugpattern/AutoValueSubclassLeaked)__<br>
Do not refer to the autogenerated AutoValue_ class outside the file containing the corresponding @AutoValue base class.

__[BadComparable](bugpattern/BadComparable)__<br>
Possible sign flip from narrowing conversion

__[BadImport](bugpattern/BadImport)__<br>
Importing nested classes/static methods/static fields with commonly-used names can make code harder to read, because it may not be clear from the context exactly which type is being referred to. Qualifying the name with that of the containing class can make the code clearer.

__[BadInstanceof](bugpattern/BadInstanceof)__<br>
instanceof used in a way that is equivalent to a null check.

__[BigDecimalEquals](bugpattern/BigDecimalEquals)__<br>
BigDecimal#equals has surprising behavior: it also compares scale.

__[BigDecimalLiteralDouble](bugpattern/BigDecimalLiteralDouble)__<br>
new BigDecimal(double) loses precision in this case.

__[BoxedPrimitiveConstructor](bugpattern/BoxedPrimitiveConstructor)__<br>
valueOf or autoboxing provides better time and space performance

__[BoxedPrimitiveEquality](bugpattern/BoxedPrimitiveEquality)__<br>
Comparison using reference equality instead of value equality. Reference equality of boxed primitive types is usually not useful, as they are value objects, and it is bug-prone, as instances are cached for some values but not others.

__[ByteBufferBackingArray](bugpattern/ByteBufferBackingArray)__<br>
ByteBuffer.array() shouldn&#39;t be called unless ByteBuffer.arrayOffset() is used or if the ByteBuffer was initialized using ByteBuffer.wrap() or ByteBuffer.allocate().

__[CacheLoaderNull](bugpattern/CacheLoaderNull)__<br>
The result of CacheLoader#load must be non-null.

__[CannotMockFinalClass](bugpattern/CannotMockFinalClass)__<br>
Mockito cannot mock final classes

__[CanonicalDuration](bugpattern/CanonicalDuration)__<br>
Duration can be expressed more clearly with different units

__[CatchAndPrintStackTrace](bugpattern/CatchAndPrintStackTrace)__<br>
Logging or rethrowing exceptions should usually be preferred to catching and calling printStackTrace

__[CatchFail](bugpattern/CatchFail)__<br>
Ignoring exceptions and calling fail() is unnecessary, and makes test output less useful

__[ChainedAssertionLosesContext](bugpattern/ChainedAssertionLosesContext)__<br>
Inside a Subject, use check(...) instead of assert*() to preserve user-supplied messages and other settings.

__[ClassCanBeStatic](bugpattern/ClassCanBeStatic)__<br>
Inner class is non-static but does not reference enclosing class

__[ClassNewInstance](bugpattern/ClassNewInstance)__<br>
Class.newInstance() bypasses exception checking; prefer getDeclaredConstructor().newInstance()

__[CloseableProvides](bugpattern/CloseableProvides)__<br>
Providing Closeable resources makes their lifecycle unclear

__[CollectionUndefinedEquality](bugpattern/CollectionUndefinedEquality)__<br>
This type does not have well-defined equals behavior.

__[CollectorShouldNotUseState](bugpattern/CollectorShouldNotUseState)__<br>
Collector.of() should not use state

__[ComparableAndComparator](bugpattern/ComparableAndComparator)__<br>
Class should not implement both `Comparable` and `Comparator`

__[CompareToZero](bugpattern/CompareToZero)__<br>
The result of #compareTo or #compare should only be compared to 0. It is an implementation detail whether a given type returns strictly the values {-1, 0, +1} or others.

__[ComplexBooleanConstant](bugpattern/ComplexBooleanConstant)__<br>
Non-trivial compile time constant boolean expressions shouldn&#39;t be used.

__[DateChecker](bugpattern/DateChecker)__<br>
Warns against suspect looking calls to java.util.Date APIs

__[DateFormatConstant](bugpattern/DateFormatConstant)__<br>
DateFormat is not thread-safe, and should not be used as a constant field.

__[DefaultCharset](bugpattern/DefaultCharset)__<br>
Implicit use of the platform default charset, which can result in differing behaviour between JVM executions or incorrect behavior if the encoding of the data source doesn&#39;t match expectations.

__[DefaultPackage](bugpattern/DefaultPackage)__<br>
Java classes shouldn&#39;t use default package

__[DoNotCallSuggester](bugpattern/DoNotCallSuggester)__<br>
Consider annotating methods that always throw with @DoNotCall. Read more at https://errorprone.info/bugpattern/DoNotCall

__[DoNotClaimAnnotations](bugpattern/DoNotClaimAnnotations)__<br>
Don&#39;t &#39;claim&#39; annotations in annotation processors; Processor#process should unconditionally return `false`

__[DoNotMockAutoValue](bugpattern/DoNotMockAutoValue)__<br>
AutoValue classes represent pure data classes, so mocking them should not be necessary. Construct a real instance of the class instead.

__[DoubleBraceInitialization](bugpattern/DoubleBraceInitialization)__<br>
Prefer collection factory methods or builders to the double-brace initialization pattern.

__[DoubleCheckedLocking](bugpattern/DoubleCheckedLocking)__<br>
Double-checked locking on non-volatile fields is unsafe

__[EmptyBlockTag](bugpattern/EmptyBlockTag)__<br>
A block tag (@param, @return, @throws, @deprecated) has an empty description. Block tags without descriptions don&#39;t add much value for future readers of the code; consider removing the tag entirely or adding a description.

__[EmptyCatch](bugpattern/EmptyCatch)__<br>
Caught exceptions should not be ignored

__[EmptySetMultibindingContributions](bugpattern/EmptySetMultibindingContributions)__<br>
@Multibinds is a more efficient and declarative mechanism for ensuring that a set multibinding is present in the graph.

__[EqualsGetClass](bugpattern/EqualsGetClass)__<br>
Prefer instanceof to getClass when implementing Object#equals.

__[EqualsIncompatibleType](bugpattern/EqualsIncompatibleType)__<br>
An equality test between objects with incompatible types always returns false

__[EqualsUnsafeCast](bugpattern/EqualsUnsafeCast)__<br>
The contract of #equals states that it should return false for incompatible types, while this implementation may throw ClassCastException.

__[EqualsUsingHashCode](bugpattern/EqualsUsingHashCode)__<br>
Implementing #equals by just comparing hashCodes is fragile. Hashes collide frequently, and this will lead to false positives in #equals.

__[EscapedEntity](bugpattern/EscapedEntity)__<br>
HTML entities in @code/@literal tags will appear literally in the rendered javadoc.

__[ExtendingJUnitAssert](bugpattern/ExtendingJUnitAssert)__<br>
When only using JUnit Assert&#39;s static methods, you should import statically instead of extending.

__[FallThrough](bugpattern/FallThrough)__<br>
Switch case may fall through

__[Finally](bugpattern/Finally)__<br>
If you return or throw from a finally, then values returned or thrown from the try-catch block will be ignored. Consider using try-with-resources instead.

__[FloatCast](bugpattern/FloatCast)__<br>
Use parentheses to make the precedence explicit

__[FloatingPointAssertionWithinEpsilon](bugpattern/FloatingPointAssertionWithinEpsilon)__<br>
This fuzzy equality check is using a tolerance less than the gap to the next number. You may want a less restrictive tolerance, or to assert equality.

__[FloatingPointLiteralPrecision](bugpattern/FloatingPointLiteralPrecision)__<br>
Floating point literal loses precision

__[FragmentInjection](bugpattern/FragmentInjection)__<br>
Classes extending PreferenceActivity must implement isValidFragment such that it does not unconditionally return true to prevent vulnerability to fragment injection attacks.

__[FragmentNotInstantiable](bugpattern/FragmentNotInstantiable)__<br>
Subclasses of Fragment must be instantiable via Class#newInstance(): the class must be public, static and have a public nullary constructor

__[FutureReturnValueIgnored](bugpattern/FutureReturnValueIgnored)__<br>
Return value of methods returning Future must be checked. Ignoring returned Futures suppresses exceptions thrown from the code that completes the Future.

__[GetClassOnEnum](bugpattern/GetClassOnEnum)__<br>
Calling getClass() on an enum may return a subclass of the enum type

__[HidingField](bugpattern/HidingField)__<br>
Hiding fields of superclasses may cause confusion and errors

__[IdentityHashMapUsage](bugpattern/IdentityHashMapUsage)__<br>
IdentityHashMap usage shouldn&#39;t be intermingled with Map

__[IgnoredPureGetter](bugpattern/IgnoredPureGetter)__<br>
Getters on AutoValue classes and protos are side-effect free, so there is no point in calling them if the return value is ignored.

__[ImmutableAnnotationChecker](bugpattern/ImmutableAnnotationChecker)__<br>
Annotations should always be immutable

__[ImmutableEnumChecker](bugpattern/ImmutableEnumChecker)__<br>
Enums should always be immutable

__[InconsistentCapitalization](bugpattern/InconsistentCapitalization)__<br>
It is confusing to have a field and a parameter under the same scope that differ only in capitalization.

__[InconsistentHashCode](bugpattern/InconsistentHashCode)__<br>
Including fields in hashCode which are not compared in equals violates the contract of hashCode.

__[IncrementInForLoopAndHeader](bugpattern/IncrementInForLoopAndHeader)__<br>
This for loop increments the same variable in the header and in the body

__[InheritDoc](bugpattern/InheritDoc)__<br>
Invalid use of @inheritDoc.

__[InjectInvalidTargetingOnScopingAnnotation](bugpattern/InjectInvalidTargetingOnScopingAnnotation)__<br>
A scoping annotation&#39;s Target should include TYPE and METHOD.

__[InjectOnConstructorOfAbstractClass](bugpattern/InjectOnConstructorOfAbstractClass)__<br>
Constructors on abstract classes are never directly @Inject&#39;ed, only the constructors of their subclasses can be @Inject&#39;ed.

__[InjectScopeAnnotationOnInterfaceOrAbstractClass](bugpattern/InjectScopeAnnotationOnInterfaceOrAbstractClass)__<br>
Scope annotation on an interface or abstract class is not allowed

__[InjectedConstructorAnnotations](bugpattern/InjectedConstructorAnnotations)__<br>
Injected constructors cannot be optional nor have binding annotations

__[InlineFormatString](bugpattern/InlineFormatString)__<br>
Prefer to create format strings inline, instead of extracting them to a single-use constant

__[InputStreamSlowMultibyteRead](bugpattern/InputStreamSlowMultibyteRead)__<br>
Please also override int read(byte[], int, int), otherwise multi-byte reads from this input stream are likely to be slow.

__[InstanceOfAndCastMatchWrongType](bugpattern/InstanceOfAndCastMatchWrongType)__<br>
Casting inside an if block should be plausibly consistent with the instanceof type

__[IntLongMath](bugpattern/IntLongMath)__<br>
Expression of type int may overflow before being assigned to a long

__[InvalidBlockTag](bugpattern/InvalidBlockTag)__<br>
This tag is invalid.

__[InvalidInlineTag](bugpattern/InvalidInlineTag)__<br>
This tag is invalid.

__[InvalidLink](bugpattern/InvalidLink)__<br>
This @link tag looks wrong.

__[InvalidParam](bugpattern/InvalidParam)__<br>
This @param tag doesn&#39;t refer to a parameter of the method.

__[InvalidThrows](bugpattern/InvalidThrows)__<br>
The documented method doesn&#39;t actually throw this checked exception.

__[InvalidThrowsLink](bugpattern/InvalidThrowsLink)__<br>
Javadoc links to exceptions in @throws without a @link tag (@throws Exception, not @throws {@link Exception}).

__[IterableAndIterator](bugpattern/IterableAndIterator)__<br>
Class should not implement both `Iterable` and `Iterator`

__[JUnit3FloatingPointComparisonWithoutDelta](bugpattern/JUnit3FloatingPointComparisonWithoutDelta)__<br>
Floating-point comparison without error tolerance

__[JUnit4ClassUsedInJUnit3](bugpattern/JUnit4ClassUsedInJUnit3)__<br>
Some JUnit4 construct cannot be used in a JUnit3 context. Convert your class to JUnit4 style to use them.

__[JUnitAmbiguousTestClass](bugpattern/JUnitAmbiguousTestClass)__<br>
Test class inherits from JUnit 3&#39;s TestCase but has JUnit 4 @Test or @RunWith annotations.

__[JavaDurationGetSecondsGetNano](bugpattern/JavaDurationGetSecondsGetNano)__<br>
duration.getNano() only accesses the underlying nanosecond adjustment from the whole second.

__[JavaDurationWithNanos](bugpattern/JavaDurationWithNanos)__<br>
Use of java.time.Duration.withNanos(int) is not allowed.

__[JavaDurationWithSeconds](bugpattern/JavaDurationWithSeconds)__<br>
Use of java.time.Duration.withSeconds(long) is not allowed.

__[JavaInstantGetSecondsGetNano](bugpattern/JavaInstantGetSecondsGetNano)__<br>
instant.getNano() only accesses the underlying nanosecond adjustment from the whole second.

__[JavaLangClash](bugpattern/JavaLangClash)__<br>
Never reuse class names from java.lang

__[JavaLocalDateTimeGetNano](bugpattern/JavaLocalDateTimeGetNano)__<br>
localDateTime.getNano() only accesss the nanos-of-second field. It&#39;s rare to only use getNano() without a nearby getSecond() call.

__[JavaLocalTimeGetNano](bugpattern/JavaLocalTimeGetNano)__<br>
localTime.getNano() only accesses the nanos-of-second field. It&#39;s rare to only use getNano() without a nearby getSecond() call.

__[JavaPeriodGetDays](bugpattern/JavaPeriodGetDays)__<br>
period.getDays() only accesses the &quot;days&quot; portion of the Period, and doesn&#39;t represent the total span of time of the period. Consider using org.threeten.extra.Days to extract the difference between two civil dates if you want the whole time.

__[JavaTimeDefaultTimeZone](bugpattern/JavaTimeDefaultTimeZone)__<br>
java.time APIs that silently use the default system time-zone are not allowed.

__[JavaUtilDate](bugpattern/JavaUtilDate)__<br>
Date has a bad API that leads to bugs; prefer java.time.Instant or LocalDate.

__[JavaxInjectOnFinalField](bugpattern/JavaxInjectOnFinalField)__<br>
@javax.inject.Inject cannot be put on a final field.

__[JdkObsolete](bugpattern/JdkObsolete)__<br>
Suggests alternatives to obsolete JDK classes.

__[JodaConstructors](bugpattern/JodaConstructors)__<br>
Use of certain JodaTime constructors are not allowed.

__[JodaDateTimeConstants](bugpattern/JodaDateTimeConstants)__<br>
Usage of the `_PER_` constants in `DateTimeConstants` are problematic because they encourage manual date/time math.

__[JodaDurationWithMillis](bugpattern/JodaDurationWithMillis)__<br>
Use of duration.withMillis(long) is not allowed. Please use Duration.millis(long) instead.

__[JodaInstantWithMillis](bugpattern/JodaInstantWithMillis)__<br>
Use of instant.withMillis(long) is not allowed. Please use new Instant(long) instead.

__[JodaNewPeriod](bugpattern/JodaNewPeriod)__<br>
This may have surprising semantics, e.g. new Period(LocalDate.parse(&quot;1970-01-01&quot;), LocalDate.parse(&quot;1970-02-02&quot;)).getDays() == 1, not 32.

__[JodaPlusMinusLong](bugpattern/JodaPlusMinusLong)__<br>
Use of JodaTime&#39;s type.plus(long) or type.minus(long) is not allowed (where &lt;type&gt; = {Duration,Instant,DateTime,DateMidnight}). Please use type.plus(Duration.millis(long)) or type.minus(Duration.millis(long)) instead.

__[JodaTimeConverterManager](bugpattern/JodaTimeConverterManager)__<br>
Joda-Time&#39;s ConverterManager makes the semantics of DateTime/Instant/etc construction subject to global static state. If you need to define your own converters, use a helper.

__[JodaWithDurationAddedLong](bugpattern/JodaWithDurationAddedLong)__<br>
Use of JodaTime&#39;s type.withDurationAdded(long, int) (where &lt;type&gt; = {Duration,Instant,DateTime}). Please use type.withDurationAdded(Duration.millis(long), int) instead.

__[LiteEnumValueOf](bugpattern/LiteEnumValueOf)__<br>
Instead of converting enums to string and back, its numeric value should be used instead as it is the stable part of the protocol defined by the enum.

__[LiteProtoToString](bugpattern/LiteProtoToString)__<br>
toString() on lite protos will not generate a useful representation of the proto from optimized builds. Consider whether using some subset of fields instead would provide useful information.

__[LockNotBeforeTry](bugpattern/LockNotBeforeTry)__<br>
Calls to Lock#lock should be immediately followed by a try block which releases the lock.

__[LockOnBoxedPrimitive](bugpattern/LockOnBoxedPrimitive)__<br>
It is dangerous to use a boxed primitive as a lock as it can unintentionally lead to sharing a lock with another piece of code.

__[LogicalAssignment](bugpattern/LogicalAssignment)__<br>
Assignment where a boolean expression was expected; use == if this assignment wasn&#39;t expected or add parentheses for clarity.

__[MathAbsoluteRandom](bugpattern/MathAbsoluteRandom)__<br>
Math.abs does not always give a positive result. Please consider other methods for positive random numbers.

__[MissingCasesInEnumSwitch](bugpattern/MissingCasesInEnumSwitch)__<br>
Switches on enum types should either handle all values, or have a default case.

__[MissingFail](bugpattern/MissingFail)__<br>
Not calling fail() when expecting an exception masks bugs

__[MissingOverride](bugpattern/MissingOverride)__<br>
method overrides method in supertype; expected @Override

__[MissingSummary](bugpattern/MissingSummary)__<br>
A summary line is required on public/protected Javadocs.

__[MixedMutabilityReturnType](bugpattern/MixedMutabilityReturnType)__<br>
This method returns both mutable and immutable collections or maps from different paths. This may be confusing for users of the method.

__[ModifiedButNotUsed](bugpattern/ModifiedButNotUsed)__<br>
A collection or proto builder was created, but its values were never accessed.

__[ModifyCollectionInEnhancedForLoop](bugpattern/ModifyCollectionInEnhancedForLoop)__<br>
Modifying a collection while iterating over it in a loop may cause a ConcurrentModificationException to be thrown or lead to undefined behavior.

__[ModifySourceCollectionInStream](bugpattern/ModifySourceCollectionInStream)__<br>
Modifying the backing source during stream operations may cause unintended results.

__[MultipleParallelOrSequentialCalls](bugpattern/MultipleParallelOrSequentialCalls)__<br>
Multiple calls to either parallel or sequential are unnecessary and cause confusion.

__[MultipleUnaryOperatorsInMethodCall](bugpattern/MultipleUnaryOperatorsInMethodCall)__<br>
Avoid having multiple unary operators acting on the same variable in a method call

__[MutableConstantField](bugpattern/MutableConstantField)__<br>
Constant field declarations should use the immutable type (such as ImmutableList) instead of the general collection interface type (such as List)

__[MutablePublicArray](bugpattern/MutablePublicArray)__<br>
Non-empty arrays are mutable, so this `public static final` array is not a constant and can be modified by clients of this class.  Prefer an ImmutableList, or provide an accessor method that returns a defensive copy.

__[NarrowingCompoundAssignment](bugpattern/NarrowingCompoundAssignment)__<br>
Compound assignments may hide dangerous casts

__[NestedInstanceOfConditions](bugpattern/NestedInstanceOfConditions)__<br>
Nested instanceOf conditions of disjoint types create blocks of code that never execute

__[NonAtomicVolatileUpdate](bugpattern/NonAtomicVolatileUpdate)__<br>
This update of a volatile variable is non-atomic

__[NonCanonicalType](bugpattern/NonCanonicalType)__<br>
This type is referred to by a non-canonical name, which may be misleading.

__[NonOverridingEquals](bugpattern/NonOverridingEquals)__<br>
equals method doesn&#39;t override Object.equals

__[NullOptional](bugpattern/NullOptional)__<br>
Passing a literal null to an Optional parameter is almost certainly a mistake. Did you mean to provide an empty Optional?

__[NullableConstructor](bugpattern/NullableConstructor)__<br>
Constructors should not be annotated with @Nullable since they cannot return null

__[NullablePrimitive](bugpattern/NullablePrimitive)__<br>
@Nullable should not be used for primitive types since they cannot be null

__[NullableVoid](bugpattern/NullableVoid)__<br>
void-returning methods should not be annotated with @Nullable, since they cannot return null

__[ObjectToString](bugpattern/ObjectToString)__<br>
Calling toString on Objects that don&#39;t override toString() doesn&#39;t provide useful information

__[ObjectsHashCodePrimitive](bugpattern/ObjectsHashCodePrimitive)__<br>
Objects.hashCode(Object o) should not be passed a primitive value

__[OperatorPrecedence](bugpattern/OperatorPrecedence)__<br>
Use grouping parenthesis to make the operator precedence explicit

__[OptionalMapToOptional](bugpattern/OptionalMapToOptional)__<br>
Mapping to another Optional will yield a nested Optional. Did you mean flatMap?

__[OptionalMapUnusedValue](bugpattern/OptionalMapUnusedValue)__<br>
Optional.ifPresent is preferred over Optional.map when the return value is unused

__[OptionalNotPresent](bugpattern/OptionalNotPresent)__<br>
One should not call optional.get() inside an if statement that checks !optional.isPresent

__[OrphanedFormatString](bugpattern/OrphanedFormatString)__<br>
String literal contains format specifiers, but is not passed to a format method

__[OutlineNone](bugpattern/OutlineNone)__<br>
Setting CSS outline style to none or 0 (while not otherwise providing visual focus indicators) is inaccessible for users navigating a web page without a mouse.

__[OverrideThrowableToString](bugpattern/OverrideThrowableToString)__<br>
To return a custom message with a Throwable class, one should override getMessage() instead of toString().

__[Overrides](bugpattern/Overrides)__<br>
Varargs doesn&#39;t agree for overridden method

__[OverridesGuiceInjectableMethod](bugpattern/OverridesGuiceInjectableMethod)__<br>
This method is not annotated with @Inject, but it overrides a method that is annotated with @com.google.inject.Inject. Guice will inject this method, and it is recommended to annotate it explicitly.

__[ParameterName](bugpattern/ParameterName)__<br>
Detects `/* name= */`-style comments on actual parameters where the name doesn&#39;t match the formal parameter

__[PreconditionsCheckNotNullRepeated](bugpattern/PreconditionsCheckNotNullRepeated)__<br>
Including the first argument of checkNotNull in the failure message is not useful, as it will always be `null`.

__[PrimitiveAtomicReference](bugpattern/PrimitiveAtomicReference)__<br>
Using compareAndSet with boxed primitives is dangerous, as reference rather than value equality is used. Consider using AtomicInteger, AtomicLong, or AtomicBoolean instead.

__[ProtectedMembersInFinalClass](bugpattern/ProtectedMembersInFinalClass)__<br>
Protected members in final classes can be package-private

__[ProtoDurationGetSecondsGetNano](bugpattern/ProtoDurationGetSecondsGetNano)__<br>
getNanos() only accesses the underlying nanosecond-adjustment of the duration.

__[ProtoRedundantSet](bugpattern/ProtoRedundantSet)__<br>
A field on a protocol buffer was set twice in the same chained expression.

__[ProtoTimestampGetSecondsGetNano](bugpattern/ProtoTimestampGetSecondsGetNano)__<br>
getNanos() only accesses the underlying nanosecond-adjustment of the instant.

__[QualifierOrScopeOnInjectMethod](bugpattern/QualifierOrScopeOnInjectMethod)__<br>
Qualifiers/Scope annotations on @Inject methods don&#39;t have any effect. Move the qualifier annotation to the binding location.

__[ReachabilityFenceUsage](bugpattern/ReachabilityFenceUsage)__<br>
reachabilityFence should always be called inside a finally block

__[ReferenceEquality](bugpattern/ReferenceEquality)__<br>
Comparison using reference equality instead of value equality

__[ReturnFromVoid](bugpattern/ReturnFromVoid)__<br>
Void methods should not have a @return tag.

__[RxReturnValueIgnored](bugpattern/RxReturnValueIgnored)__<br>
Returned Rx objects must be checked. Ignoring a returned Rx value means it is never scheduled for execution

__[SameNameButDifferent](bugpattern/SameNameButDifferent)__<br>
This type name shadows another in a way that may be confusing.

__[ShortCircuitBoolean](bugpattern/ShortCircuitBoolean)__<br>
Prefer the short-circuiting boolean operators &amp;&amp; and || to &amp; and |.

__[StaticAssignmentInConstructor](bugpattern/StaticAssignmentInConstructor)__<br>
This assignment is to a static field. Mutating static state from a constructor is highly error-prone.

__[StaticGuardedByInstance](bugpattern/StaticGuardedByInstance)__<br>
Writes to static fields should not be guarded by instance locks

__[StaticMockMember](bugpattern/StaticMockMember)__<br>
@Mock members of test classes shouldn&#39;t share state between tests and preferably be non-static

__[StreamResourceLeak](bugpattern/StreamResourceLeak)__<br>
Streams that encapsulate a closeable resource should be closed using try-with-resources

__[StreamToIterable](bugpattern/StreamToIterable)__<br>
Using stream::iterator creates a one-shot Iterable, which may cause surprising failures.

__[StringSplitter](bugpattern/StringSplitter)__<br>
String.split(String) has surprising behavior

__[SwigMemoryLeak](bugpattern/SwigMemoryLeak)__<br>
SWIG generated code that can&#39;t call a C++ destructor will leak memory

__[SynchronizeOnNonFinalField](bugpattern/SynchronizeOnNonFinalField)__<br>
Synchronizing on non-final fields is not safe: if the field is ever updated, different threads may end up locking on different objects.

__[ThreadJoinLoop](bugpattern/ThreadJoinLoop)__<br>
Thread.join needs to be surrounded by a loop until it succeeds, as in Uninterruptibles.joinUninterruptibly.

__[ThreadLocalUsage](bugpattern/ThreadLocalUsage)__<br>
ThreadLocals should be stored in static fields

__[ThreadPriorityCheck](bugpattern/ThreadPriorityCheck)__<br>
Relying on the thread scheduler is discouraged; see Effective Java 3rd Edition Item 84.

__[ThreeLetterTimeZoneID](bugpattern/ThreeLetterTimeZoneID)__<br>
Three-letter time zone identifiers are deprecated, may be ambiguous, and might not do what you intend; the full IANA time zone ID should be used instead.

__[TimeUnitConversionChecker](bugpattern/TimeUnitConversionChecker)__<br>
This TimeUnit conversion looks buggy: converting from a smaller unit to a larger unit (and passing a constant), converting to/from the same TimeUnit, or converting TimeUnits where the result is statically known to be 0 or 1 are all buggy patterns.

__[ToStringReturnsNull](bugpattern/ToStringReturnsNull)__<br>
An implementation of Object.toString() should never return null.

__[TruthAssertExpected](bugpattern/TruthAssertExpected)__<br>
The actual and expected values appear to be swapped, which results in poor assertion failure messages. The actual value should come first.

__[TruthConstantAsserts](bugpattern/TruthConstantAsserts)__<br>
Truth Library assert is called on a constant.

__[TruthGetOrDefault](bugpattern/TruthGetOrDefault)__<br>
Asserting on getOrDefault is unclear; prefer containsEntry or doesNotContainKey

__[TruthIncompatibleType](bugpattern/TruthIncompatibleType)__<br>
Argument is not compatible with the subject&#39;s type.

__[TypeEquals](bugpattern/TypeEquals)__<br>
com.sun.tools.javac.code.Type doesn&#39;t override Object.equals and instances are not interned by javac, so testing types for equality should be done with Types#isSameType instead

__[TypeNameShadowing](bugpattern/TypeNameShadowing)__<br>
Type parameter declaration shadows another named type

__[TypeParameterShadowing](bugpattern/TypeParameterShadowing)__<br>
Type parameter declaration overrides another type parameter already declared

__[TypeParameterUnusedInFormals](bugpattern/TypeParameterUnusedInFormals)__<br>
Declaring a type parameter that is only used in the return type is a misuse of generics: operations on the type parameter are unchecked, it hides unsafe casts at invocations of the method, and it interacts badly with method overload resolution.

__[URLEqualsHashCode](bugpattern/URLEqualsHashCode)__<br>
Avoid hash-based containers of java.net.URL--the containers rely on equals() and hashCode(), which cause java.net.URL to make blocking internet connections.

__[UndefinedEquals](bugpattern/UndefinedEquals)__<br>
This type is not guaranteed to implement a useful #equals method.

__[UnescapedEntity](bugpattern/UnescapedEntity)__<br>
Javadoc is interpreted as HTML, so HTML entities such as &amp;, &lt;, &gt; must be escaped.

__[UnnecessaryAnonymousClass](bugpattern/UnnecessaryAnonymousClass)__<br>
Implementing a functional interface is unnecessary; prefer to implement the functional interface method directly and use a method reference instead.

__[UnnecessaryLambda](bugpattern/UnnecessaryLambda)__<br>
Returning a lambda from a helper method or saving it in a constant is unnecessary; prefer to implement the functional interface method directly and use a method reference instead.

__[UnnecessaryMethodInvocationMatcher](bugpattern/UnnecessaryMethodInvocationMatcher)__<br>
It is not necessary to wrap a MethodMatcher with methodInvocation().

__[UnnecessaryMethodReference](bugpattern/UnnecessaryMethodReference)__<br>
This method reference is unnecessary, and can be replaced with the variable itself.

__[UnnecessaryParentheses](bugpattern/UnnecessaryParentheses)__<br>
These grouping parentheses are unnecessary; it is unlikely the code will be misinterpreted without them

__[UnsafeFinalization](bugpattern/UnsafeFinalization)__<br>
Finalizer may run before native code finishes execution

__[UnsafeReflectiveConstructionCast](bugpattern/UnsafeReflectiveConstructionCast)__<br>
Prefer `asSubclass` instead of casting the result of `newInstance`, to detect classes of incorrect type before invoking their constructors.This way, if the class is of the incorrect type,it will throw an exception before invoking its constructor.

__[UnsynchronizedOverridesSynchronized](bugpattern/UnsynchronizedOverridesSynchronized)__<br>
Unsynchronized method overrides a synchronized method.

__[UnusedMethod](bugpattern/UnusedMethod)__<br>
Unused.

__[UnusedNestedClass](bugpattern/UnusedNestedClass)__<br>
This nested class is unused, and can be removed.

__[UnusedVariable](bugpattern/UnusedVariable)__<br>
Unused.

__[UseBinds](bugpattern/UseBinds)__<br>
@Binds is a more efficient and declarative mechanism for delegating a binding.

__[UseCorrectAssertInTests](bugpattern/UseCorrectAssertInTests)__<br>
Java assert is used in test. For testing purposes Assert.* matchers should be used.

__[UseTimeInScope](bugpattern/UseTimeInScope)__<br>
Prefer to reuse time sources rather than creating new ones. Having multiple unsynchronized time sources in scope risks accidents.

__[VariableNameSameAsType](bugpattern/VariableNameSameAsType)__<br>
variableName and type with the same name would refer to the static field instead of the class

__[WaitNotInLoop](bugpattern/WaitNotInLoop)__<br>
Because of spurious wakeups, Object.wait() and Condition.await() must always be called in a loop

__[WakelockReleasedDangerously](bugpattern/WakelockReleasedDangerously)__<br>
A wakelock acquired with a timeout may be released by the system before calling `release`, even after checking `isHeld()`. If so, it will throw a RuntimeException. Please wrap in a try/catch block.

__[WithSignatureDiscouraged](bugpattern/WithSignatureDiscouraged)__<br>
withSignature is discouraged. Prefer .named and/or .withParameters where possible.

## Experimental : ERROR

__[AndroidJdkLibsChecker](bugpattern/AndroidJdkLibsChecker)__<br>
Use of class, field, or method that is not compatible with legacy Android devices

__[AutoFactoryAtInject](bugpattern/AutoFactoryAtInject)__<br>
@AutoFactory and @Inject should not be used in the same type.

__[ClassName](bugpattern/ClassName)__<br>
The source file name should match the name of the top-level class it contains

__[ComparisonContractViolated](bugpattern/ComparisonContractViolated)__<br>
This comparison method violates the contract

__[DeduplicateConstants](bugpattern/DeduplicateConstants)__<br>
This expression was previously declared as a constant; consider replacing this occurrence.

__[DepAnn](bugpattern/DepAnn)__<br>
Item documented with a @deprecated javadoc note is not annotated with @Deprecated

__[DescribeMatch](bugpattern/DescribeMatch)__<br>
`describeMatch(tree, fix)` is equivalent to and simpler than `buildDescription(tree).addFix(fix).build()`

__[DivZero](bugpattern/DivZero)__<br>
Division by integer literal zero

__[EmptyIf](bugpattern/EmptyIf)__<br>
Empty statement after if

__[ExtendsAutoValue](bugpattern/ExtendsAutoValue)__<br>
Do not extend an @AutoValue/@AutoOneOf class in non-generated code.

__[FuzzyEqualsShouldNotBeUsedInEqualsMethod](bugpattern/FuzzyEqualsShouldNotBeUsedInEqualsMethod)__<br>
DoubleMath.fuzzyEquals should never be used in an Object.equals() method

__[InjectMoreThanOneQualifier](bugpattern/InjectMoreThanOneQualifier)__<br>
Using more than one qualifier annotation on the same element is not allowed.

__[InjectScopeOrQualifierAnnotationRetention](bugpattern/InjectScopeOrQualifierAnnotationRetention)__<br>
Scoping and qualifier annotations must have runtime retention.

__[InsecureCryptoUsage](bugpattern/InsecureCryptoUsage)__<br>
A standard cryptographic operation is used in a mode that is prone to vulnerabilities

__[IterablePathParameter](bugpattern/IterablePathParameter)__<br>
Path implements Iterable&lt;Path&gt;; prefer Collection&lt;Path&gt; for clarity

__[JMockTestWithoutRunWithOrRuleAnnotation](bugpattern/JMockTestWithoutRunWithOrRuleAnnotation)__<br>
jMock tests must have a @RunWith(JMock.class) annotation, or the Mockery field must have a @Rule JUnit annotation

__[Java7ApiChecker](bugpattern/Java7ApiChecker)__<br>
Use of class, field, or method that is not compatible with JDK 7

__[LockMethodChecker](bugpattern/LockMethodChecker)__<br>
This method does not acquire the locks specified by its @LockMethod annotation

__[LongLiteralLowerCaseSuffix](bugpattern/LongLiteralLowerCaseSuffix)__<br>
Prefer &#39;L&#39; to &#39;l&#39; for the suffix to long literals

__[NoAllocation](bugpattern/NoAllocation)__<br>
@NoAllocation was specified on this method, but something was found that would trigger an allocation

__[NumericEquality](bugpattern/NumericEquality)__<br>
Numeric comparison using reference equality instead of value equality

__[ParameterPackage](bugpattern/ParameterPackage)__<br>
Method parameter has wrong package

__[RefersToDaggerCodegen](bugpattern/RefersToDaggerCodegen)__<br>
Don&#39;t refer to Dagger&#39;s internal or generated code

__[StaticOrDefaultInterfaceMethod](bugpattern/StaticOrDefaultInterfaceMethod)__<br>
Static and default interface methods are not natively supported on older Android devices. 

__[StaticQualifiedUsingExpression](bugpattern/StaticQualifiedUsingExpression)__<br>
A static variable or method should be qualified with a class name, not expression

__[UnlockMethod](bugpattern/UnlockMethod)__<br>
This method does not acquire the locks specified by its @UnlockMethod annotation

## Experimental : WARNING

__[AnnotationPosition](bugpattern/AnnotationPosition)__<br>
Annotations should be positioned after Javadocs, but before modifiers.

__[AssertFalse](bugpattern/AssertFalse)__<br>
Assertions may be disabled at runtime and do not guarantee that execution will halt here; consider throwing an exception instead

__[AssistedInjectAndInjectOnConstructors](bugpattern/AssistedInjectAndInjectOnConstructors)__<br>
@AssistedInject and @Inject should not be used on different constructors in the same class.

__[BinderIdentityRestoredDangerously](bugpattern/BinderIdentityRestoredDangerously)__<br>
A call to Binder.clearCallingIdentity() should be followed by Binder.restoreCallingIdentity() in a finally block. Otherwise the wrong Binder identity may be used by subsequent code.

__[BindingToUnqualifiedCommonType](bugpattern/BindingToUnqualifiedCommonType)__<br>
This code declares a binding for a common value type without a Qualifier annotation.

__[CatchingUnchecked](bugpattern/CatchingUnchecked)__<br>
This catch block catches `Exception`, but can only catch unchecked exceptions. Consider catching RuntimeException (or something more specific) instead so it is more apparent that no checked exceptions are being handled.

__[CheckedExceptionNotThrown](bugpattern/CheckedExceptionNotThrown)__<br>
This method cannot throw a checked exception that it claims to. This may cause consumers of the API to incorrectly attempt to handle, or propagate, this exception.

__[DifferentNameButSame](bugpattern/DifferentNameButSame)__<br>
This type is referred to in different ways within this file, which may be confusing.

__[EmptyTopLevelDeclaration](bugpattern/EmptyTopLevelDeclaration)__<br>
Empty top-level type declaration

__[EqualsBrokenForNull](bugpattern/EqualsBrokenForNull)__<br>
equals() implementation may throw NullPointerException when given null

__[ExpectedExceptionChecker](bugpattern/ExpectedExceptionChecker)__<br>
Prefer assertThrows to ExpectedException

__[FloggerLogWithCause](bugpattern/FloggerLogWithCause)__<br>
Setting the caught exception as the cause of the log message may provide more context for anyone debugging errors.

__[FloggerMessageFormat](bugpattern/FloggerMessageFormat)__<br>
Invalid message format-style format specifier ({0}), expected printf-style (%s)

__[FloggerPassedAround](bugpattern/FloggerPassedAround)__<br>
There is no advantage to passing around a logger rather than declaring one in the class that needs it.

__[FloggerRedundantIsEnabled](bugpattern/FloggerRedundantIsEnabled)__<br>
Logger level check is already implied in the log() call. An explicit at[Level]().isEnabled() check is redundant.

__[FloggerRequiredModifiers](bugpattern/FloggerRequiredModifiers)__<br>
FluentLogger.forEnclosingClass should always be saved to a private static final field.

__[FloggerWithCause](bugpattern/FloggerWithCause)__<br>
Calling withCause(Throwable) with an inline allocated Throwable is discouraged. Consider using withStackTrace(StackSize) instead, and specifying a reduced stack size (e.g. SMALL, MEDIUM or LARGE) instead of FULL, to improve performance.

__[FloggerWithoutCause](bugpattern/FloggerWithoutCause)__<br>
Use withCause to associate Exceptions with log statements

__[FunctionalInterfaceClash](bugpattern/FunctionalInterfaceClash)__<br>
Overloads will be ambiguous when passing lambda arguments.

__[HardCodedSdCardPath](bugpattern/HardCodedSdCardPath)__<br>
Hardcoded reference to /sdcard

__[InconsistentOverloads](bugpattern/InconsistentOverloads)__<br>
The ordering of parameters in overloaded methods should be as consistent as possible (when viewed from left to right)

__[InitializeInline](bugpattern/InitializeInline)__<br>
Initializing variables in their declaring statement is clearer, where possible.

__[InterfaceWithOnlyStatics](bugpattern/InterfaceWithOnlyStatics)__<br>
This interface only contains static fields and methods; consider making it a final class instead to prevent subclassing.

__[InterruptedExceptionSwallowed](bugpattern/InterruptedExceptionSwallowed)__<br>
This catch block appears to be catching an explicitly declared InterruptedException as an Exception/Throwable and not handling the interruption separately.

__[MemberName](bugpattern/MemberName)__<br>
Methods and non-static variables should be named in lowerCamelCase.

__[MissingDefault](bugpattern/MissingDefault)__<br>
The Google Java Style Guide requires that each switch statement includes a default statement group, even if it contains no code. (This requirement is lifted for any switch statement that covers all values of an enum.)

__[MutableMethodReturnType](bugpattern/MutableMethodReturnType)__<br>
Method return type should use the immutable type (such as ImmutableList) instead of the general collection interface type (such as List).

__[NoFunctionalReturnType](bugpattern/NoFunctionalReturnType)__<br>
Instead of returning a functional type, return the actual type that the returned function would return and use lambdas at use site.

__[NonCanonicalStaticMemberImport](bugpattern/NonCanonicalStaticMemberImport)__<br>
Static import of member uses non-canonical name

__[PreferJavaTimeOverload](bugpattern/PreferJavaTimeOverload)__<br>
Prefer using java.time-based APIs when available. Note that this checker does not and cannot guarantee that the overloads have equivalent semantics, but that is generally the case with overloaded methods.

__[PrimitiveArrayPassedToVarargsMethod](bugpattern/PrimitiveArrayPassedToVarargsMethod)__<br>
Passing a primitive array to a varargs method is usually wrong

__[ProtosAsKeyOfSetOrMap](bugpattern/ProtosAsKeyOfSetOrMap)__<br>
Protos should not be used as a key to a map, in a set, or in a contains method on a descendant of a collection. Protos have non deterministic ordering and proto equality is deep, which is a performance issue.

__[QualifierWithTypeUse](bugpattern/QualifierWithTypeUse)__<br>
Injection frameworks currently don&#39;t understand Qualifiers in TYPE_PARAMETER or TYPE_USE contexts.

__[RedundantCondition](bugpattern/RedundantCondition)__<br>
Redundant usage of a boolean variable with known value

__[RedundantOverride](bugpattern/RedundantOverride)__<br>
This overriding method is redundant, and can be removed.

__[RedundantThrows](bugpattern/RedundantThrows)__<br>
Thrown exception is a subtype of another

__[StringEquality](bugpattern/StringEquality)__<br>
String comparison using reference equality instead of value equality

__[StronglyTypeTime](bugpattern/StronglyTypeTime)__<br>
This primitive integral type is only used to construct time types. It would be clearer to strongly type the field instead.

__[SuppressWarningsWithoutExplanation](bugpattern/SuppressWarningsWithoutExplanation)__<br>
Use of @SuppressWarnings should be accompanied by a comment describing why the warning is safe to ignore.

__[SystemExitOutsideMain](bugpattern/SystemExitOutsideMain)__<br>
Code that contains System.exit() is untestable.

__[TestExceptionChecker](bugpattern/TestExceptionChecker)__<br>
Using @Test(expected=...) is discouraged, since the test will pass if *any* statement in the test method throws the expected exception

__[ThrowSpecificExceptions](bugpattern/ThrowSpecificExceptions)__<br>
Base exception classes should be treated as abstract. If the exception is intended to be caught, throw a domain-specific exception. Otherwise, prefer a more specific exception for clarity. Common alternatives include: AssertionError, IllegalArgumentException, IllegalStateException, and (Guava&#39;s) VerifyException.

__[TimeUnitMismatch](bugpattern/TimeUnitMismatch)__<br>
An value that appears to be represented in one unit is used where another appears to be required (e.g., seconds where nanos are needed)

__[TransientMisuse](bugpattern/TransientMisuse)__<br>
Static fields are implicitly transient, so the explicit modifier is unnecessary

__[UnnecessarilyFullyQualified](bugpattern/UnnecessarilyFullyQualified)__<br>
This fully qualified name is unambiguous to the compiler if imported.

__[UnnecessarilyVisible](bugpattern/UnnecessarilyVisible)__<br>
Some methods (such as those annotated with @Inject or @Provides) are only intended to be called by a framework, and so should have default visibility

__[UnnecessaryDefaultInEnumSwitch](bugpattern/UnnecessaryDefaultInEnumSwitch)__<br>
Switch handles all enum values: an explicit default case is unnecessary and defeats error checking for non-exhaustive switches.

__[UnnecessaryOptionalGet](bugpattern/UnnecessaryOptionalGet)__<br>
This code can be simplified by directly using the lambda parameters instead of calling get..() on optional.

__[UnsafeLocaleUsage](bugpattern/UnsafeLocaleUsage)__<br>
Possible unsafe operation related to the java.util.Locale library.

__[UnusedException](bugpattern/UnusedException)__<br>
This catch block catches an exception and re-throws another, but swallows the caught exception rather than setting it as a cause. This can make debugging harder.

__[UrlInSee](bugpattern/UrlInSee)__<br>
URLs should not be used in @see tags; they are designed for Java elements which could be used with @link.

__[Var](bugpattern/Var)__<br>
Non-constant variable missing @Var annotation

## Experimental : SUGGESTION

__[BooleanParameter](bugpattern/BooleanParameter)__<br>
Use parameter comments to document ambiguous literals

__[ClassNamedLikeTypeParameter](bugpattern/ClassNamedLikeTypeParameter)__<br>
This class&#39;s name looks like a Type Parameter.

__[ConstantField](bugpattern/ConstantField)__<br>
Field name is CONSTANT_CASE, but field is not static and final

__[ConstantPatternCompile](bugpattern/ConstantPatternCompile)__<br>
Variables initialized with Pattern#compile calls on constants can be constants

__[FieldCanBeFinal](bugpattern/FieldCanBeFinal)__<br>
This field is only assigned during initialization; consider making it final

__[FieldCanBeLocal](bugpattern/FieldCanBeLocal)__<br>
This field can be replaced with a local variable in the methods that use it.

__[FieldCanBeStatic](bugpattern/FieldCanBeStatic)__<br>
A final field initialized at compile-time with an instance of an immutable type can be static.

__[ForEachIterable](bugpattern/ForEachIterable)__<br>
This loop can be replaced with an enhanced for loop.

__[HashCodeToString](bugpattern/HashCodeToString)__<br>
Classes that override hashCode should also consider overriding toString.

__[ImmutableMemberCollection](bugpattern/ImmutableMemberCollection)__<br>
If you don&#39;t intend to mutate a member collection prefer using Immutable types.

__[ImmutableRefactoring](bugpattern/ImmutableRefactoring)__<br>
Refactors uses of the JSR 305 @Immutable to Error Prone&#39;s annotation

__[ImmutableSetForContains](bugpattern/ImmutableSetForContains)__<br>
This private static ImmutableList either does not contain duplicates or is only used for contains, containsAll or isEmpty checks or both. ImmutableSet is a better type for such collection. It is often more efficient and / or captures useful info about absence of duplicates.

__[ImplementAssertionWithChaining](bugpattern/ImplementAssertionWithChaining)__<br>
Prefer check(...), which usually generates more readable failure messages.

__[LambdaFunctionalInterface](bugpattern/LambdaFunctionalInterface)__<br>
Use Java&#39;s utility functional interfaces instead of Function&lt;A, B&gt; for primitive types.

__[MethodCanBeStatic](bugpattern/MethodCanBeStatic)__<br>
A private method that does not reference the enclosing instance can be static

__[MixedArrayDimensions](bugpattern/MixedArrayDimensions)__<br>
C-style array declarations should not be used

__[MultiVariableDeclaration](bugpattern/MultiVariableDeclaration)__<br>
Variable declarations should declare only one variable

__[MultipleTopLevelClasses](bugpattern/MultipleTopLevelClasses)__<br>
Source files should not contain multiple top-level class declarations

__[PackageLocation](bugpattern/PackageLocation)__<br>
Package names should match the directory they are declared in

__[ParameterComment](bugpattern/ParameterComment)__<br>
Non-standard parameter comment; prefer `/* paramName= */ arg`

__[ParameterNotNullable](bugpattern/ParameterNotNullable)__<br>
Method parameters that aren&#39;t checked for null shouldn&#39;t be annotated @Nullable

__[PrivateConstructorForNoninstantiableModule](bugpattern/PrivateConstructorForNoninstantiableModule)__<br>
Add a private constructor to modules that will not be instantiated by Dagger.

__[PrivateConstructorForUtilityClass](bugpattern/PrivateConstructorForUtilityClass)__<br>
Classes which are not intended to be instantiated should be made non-instantiable with a private constructor. This includes utility classes (classes with only static members), and the main class.

__[PublicConstructorForAbstractClass](bugpattern/PublicConstructorForAbstractClass)__<br>
Constructors of an abstract class can be declared protected as there is never a need for them to be public

__[RemoveUnusedImports](bugpattern/RemoveUnusedImports)__<br>
Unused imports

__[ReturnsNullCollection](bugpattern/ReturnsNullCollection)__<br>
Methods has a collection return type and returns {@code null} in some cases but does not annotate the method as @Nullable. See Effective Java 3rd Edition Item 54.

__[ScopeOnModule](bugpattern/ScopeOnModule)__<br>
Scopes on modules have no function and will soon be an error.

__[SwitchDefault](bugpattern/SwitchDefault)__<br>
The default case of a switch should appear at the end of the last statement group

__[SymbolToString](bugpattern/SymbolToString)__<br>
Symbol#toString shouldn&#39;t be used for comparison as it is expensive and fragile.

__[ThrowsUncheckedException](bugpattern/ThrowsUncheckedException)__<br>
Unchecked exceptions do not need to be declared in the method signature.

__[TryFailRefactoring](bugpattern/TryFailRefactoring)__<br>
Prefer assertThrows to try/fail

__[TypeParameterNaming](bugpattern/TypeParameterNaming)__<br>
Type parameters must be a single letter with an optional numeric suffix, or an UpperCamelCase name followed by the letter &#39;T&#39;.

__[TypeToString](bugpattern/TypeToString)__<br>
Type#toString shouldn&#39;t be used for comparison as it is expensive and fragile.

__[UngroupedOverloads](bugpattern/UngroupedOverloads)__<br>
Constructors and methods with the same name should appear sequentially with no other code in between. Please re-order or re-name methods.

__[UnnecessaryBoxedAssignment](bugpattern/UnnecessaryBoxedAssignment)__<br>
This expression can be implicitly boxed.

__[UnnecessaryBoxedVariable](bugpattern/UnnecessaryBoxedVariable)__<br>
It is unnecessary for this variable to be boxed. Use the primitive instead.

__[UnnecessarySetDefault](bugpattern/UnnecessarySetDefault)__<br>
Unnecessary call to NullPointerTester#setDefault

__[UnnecessaryStaticImport](bugpattern/UnnecessaryStaticImport)__<br>
Using static imports for types is unnecessary

__[UseEnumSwitch](bugpattern/UseEnumSwitch)__<br>
Prefer using a switch instead of a chained if-else for enums

__[WildcardImport](bugpattern/WildcardImport)__<br>
Wildcard imports, static or otherwise, should not be used

