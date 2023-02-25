/*
 * Copyright 2023 The Error Prone Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.apply;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.BugCheckerRefactoringTestHelper;
import com.google.errorprone.BugPattern;
import com.google.errorprone.VisitorState;
import com.google.errorprone.bugpatterns.BugChecker;
import com.google.errorprone.bugpatterns.BugChecker.ClassTreeMatcher;
import com.google.errorprone.fixes.SuggestedFix;
import com.google.errorprone.matchers.Description;
import com.google.errorprone.util.MoreAnnotations;
import com.sun.source.tree.ClassTree;
import com.sun.tools.javac.code.Attribute;
import org.assertj.core.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Optional;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static com.google.errorprone.BugCheckerRefactoringTestHelper.TestMode.TEXT_MATCH;
import static com.google.errorprone.BugPattern.SeverityLevel.ERROR;
import static com.google.errorprone.matchers.Description.NO_MATCH;
import static com.google.errorprone.util.ASTHelpers.getSymbol;
import static com.google.errorprone.util.MoreAnnotations.getAnnotationValue;
import static java.util.stream.Collectors.joining;

/**
 * Unit tests for {@link ImportStatements}
 *
 * @author eaftan@google.com (Eddie Aftandilian)
 */
@RunWith(JUnit4.class)
public class ImportStatementsTest {

    @Target(ElementType.TYPE)
    public @interface ImportsToAdd {
        String[] toAdd() default {};

        String[] toRemove() default {};
    }

    @BugPattern(summary = "Refactoring to add imports", severity = ERROR)
    public
    static class ImportsToAddChecker extends BugChecker implements ClassTreeMatcher {
        @Override
        public Description matchClass(ClassTree tree, VisitorState state) {
            Optional<Attribute.Compound> annotation = getSymbol(tree).getAnnotationMirrors().stream().filter(a -> a.type.tsym.getQualifiedName().contentEquals(ImportsToAdd.class.getCanonicalName())).findAny();
            if (annotation.isEmpty()) {
                return NO_MATCH;
            }
            ImmutableSet<String> toAdd = getAnnotationValue(annotation.get(), "toAdd").map(MoreAnnotations::asStrings).orElse(Stream.empty()).collect(toImmutableSet());
            ImmutableSet<String> toRemove = getAnnotationValue(annotation.get(), "toRemove").map(MoreAnnotations::asStrings).orElse(Stream.empty()).collect(toImmutableSet());
            SuggestedFix.Builder fix = SuggestedFix.builder();
            toAdd.forEach(i -> {
                if (i.startsWith("static ")) {
                    fix.addStaticImport(i.substring("static ".length()));
                } else {
                    fix.addImport(i);
                }
            });
            toRemove.forEach(i -> {
                if (i.startsWith("static ")) {
                    fix.removeStaticImport(i.substring("static ".length()));
                } else {
                    fix.removeImport(i);
                }
            });
            return describeMatch(tree, fix.build());
        }
    }

    private static final ImmutableList<String> BASE_IMPORTS = ImmutableList.of(
            "static com.google.common.base.Preconditions.checkNotNull",
            "static java.lang.annotation.ElementType.TYPE_USE",
            "com.google.common.collect.ImmutableMap",
            "com.google.common.collect.ImmutableList",
            "org.joda.time.Interval",
            "org.joda.time.DateTime",
            "org.joda.time.DateTimeZone",
            "com.sun.tools.javac.tree.JCTree",
            "com.sun.source.tree.ImportTree",
            "com.sun.tools.javac.tree.JCTree.JCExpression",
            "com.sun.source.tree.CompilationUnitTree",
            "java.io.File",
            "java.util.Iterator",
            "java.io.IOException",
            "javax.tools.StandardJavaFileManager",
            "javax.tools.JavaFileObject",
            "javax.tools.JavaCompiler",
            "javax.tools.ToolProvider");

    private void testImports(String pkg, ImmutableList<String> baseImports, ImmutableList<String> toAdd, ImmutableList<String> toRemove, String expected) {
        String prefix = !Strings.isNullOrEmpty(pkg) ? String.format("%s;\n", pkg) : "";
        String suffix = Joiner.on('\n').join(
                "@com.google.errorprone.apply.ImportStatementsTest.ImportsToAdd(",
                "    toAdd = {" + toAdd.stream().map(x -> "\"" + x + "\"").collect(joining(", ")) + "},",
                "    toRemove = {" + toRemove.stream().map(x -> "\"" + x + "\"").collect(joining(", ")) + "})",
                "class Test {}");
        BugCheckerRefactoringTestHelper.newInstance(ImportsToAddChecker.class, getClass())
                .addInputLines(
                        "Test.java",
                        prefix,
                        baseImports.stream().map(i -> String.format("import %s;", i)).collect(joining("\n")),
                        "",
                        suffix).addOutputLines(
                        "Test.java",
                        prefix, expected, suffix)
                .addModules("jdk.compiler/com.sun.tools.javac.tree").doTest(TEXT_MATCH);
    }

    private final BugCheckerRefactoringTestHelper
            testHelper =
            BugCheckerRefactoringTestHelper.newInstance(ImportsToAddChecker.class, getClass());

    /**
     * Test that adding a new import inserts it in the correct position.
     */
    @Test
    public void shouldAddImportInCorrectPosition() {
        testImports("",
                BASE_IMPORTS,
                ImmutableList.of("static org.junit.Assert.assertEquals"),
                ImmutableList.of(),

                "import static com.google.common.base.Preconditions.checkNotNull;\n"
                        + "import static java.lang.annotation.ElementType.TYPE_USE;\n"
                        + "import static org.junit.Assert.assertEquals;\n"
                        + "\n"
                        + "import com.google.common.collect.ImmutableList;\n"
                        + "import com.google.common.collect.ImmutableMap;\n"
                        + "import com.sun.source.tree.CompilationUnitTree;\n"
                        + "import com.sun.source.tree.ImportTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree.JCExpression;\n"
                        + "import java.io.File;\n"
                        + "import java.io.IOException;\n"
                        + "import java.util.Iterator;\n"
                        + "import javax.tools.JavaCompiler;\n"
                        + "import javax.tools.JavaFileObject;\n"
                        + "import javax.tools.StandardJavaFileManager;\n"
                        + "import javax.tools.ToolProvider;\n"
                        + "import org.joda.time.DateTime;\n"
                        + "import org.joda.time.DateTimeZone;\n"
                        + "import org.joda.time.Interval;");
    }

    /**
     * Test that adding multiple new imports using addAll() inserts them in the correct positions.
     */
    @Test
    public void shouldAddMultipleImportsInCorrectPositions() {
        testImports(
                "package p",
                BASE_IMPORTS,
                ImmutableList.of(
                        "static org.junit.Assert.assertEquals",
                        "javax.servlet.http.HttpServletRequest",
                        "com.google.common.graph.Graph"),
                ImmutableList.of(),
                "import static com.google.common.base.Preconditions.checkNotNull;\n"
                        + "import static java.lang.annotation.ElementType.TYPE_USE;\n"
                        + "import static org.junit.Assert.assertEquals;\n"
                        + "\n"
                        + "import com.google.common.collect.ImmutableList;\n"
                        + "import com.google.common.collect.ImmutableMap;\n"
                        + "import com.google.common.graph.Graph;\n"
                        + "import com.sun.source.tree.CompilationUnitTree;\n"
                        + "import com.sun.source.tree.ImportTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree.JCExpression;\n"
                        + "import java.io.File;\n"
                        + "import java.io.IOException;\n"
                        + "import java.util.Iterator;\n"
                        + "import javax.servlet.http.HttpServletRequest;\n"
                        + "import javax.tools.JavaCompiler;\n"
                        + "import javax.tools.JavaFileObject;\n"
                        + "import javax.tools.StandardJavaFileManager;\n"
                        + "import javax.tools.ToolProvider;\n"
                        + "import org.joda.time.DateTime;\n"
                        + "import org.joda.time.DateTimeZone;\n"
                        + "import org.joda.time.Interval;");
    }


    /**
     * Test that adding an already-existing import doesn't change anything.
     */
    @Test
    public void shouldNotAddExistingImport() {
        testImports("", BASE_IMPORTS,
                ImmutableList.of(
                        "com.google.common.collect.ImmutableMap"),
                ImmutableList.of(),
                "import static com.google.common.base.Preconditions.checkNotNull;\n"
                        + "import static java.lang.annotation.ElementType.TYPE_USE;\n"
                        + "import com.google.common.collect.ImmutableMap;\n"
                        + "import com.google.common.collect.ImmutableList;\n"
                        + "import org.joda.time.Interval;\n"
                        + "import org.joda.time.DateTime;\n"
                        + "import org.joda.time.DateTimeZone;\n"
                        + "import com.sun.tools.javac.tree.JCTree;\n"
                        + "import com.sun.source.tree.ImportTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree.JCExpression;\n"
                        + "import com.sun.source.tree.CompilationUnitTree;\n"
                        + "import java.io.File;\n"
                        + "import java.util.Iterator;\n"
                        + "import java.io.IOException;\n"
                        + "import javax.tools.StandardJavaFileManager;\n"
                        + "import javax.tools.JavaFileObject;\n"
                        + "import javax.tools.JavaCompiler;\n"
                        + "import javax.tools.ToolProvider;"
        );
    }

    /**
     * Test that removing an import works and the resulting output is correctly sorted.
     */
    @Test
    public void shouldRemoveImportAndSort() {
        testImports("", BASE_IMPORTS, ImmutableList.of(), ImmutableList.of(
                        "com.sun.tools.javac.tree.JCTree"),
                "import static com.google.common.base.Preconditions.checkNotNull;\n"
                        + "import static java.lang.annotation.ElementType.TYPE_USE;\n"
                        + "\n"
                        + "import com.google.common.collect.ImmutableList;\n"
                        + "import com.google.common.collect.ImmutableMap;\n"
                        + "import com.sun.source.tree.CompilationUnitTree;\n"
                        + "import com.sun.source.tree.ImportTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree.JCExpression;\n"
                        + "import java.io.File;\n"
                        + "import java.io.IOException;\n"
                        + "import java.util.Iterator;\n"
                        + "import javax.tools.JavaCompiler;\n"
                        + "import javax.tools.JavaFileObject;\n"
                        + "import javax.tools.StandardJavaFileManager;\n"
                        + "import javax.tools.ToolProvider;\n"
                        + "import org.joda.time.DateTime;\n"
                        + "import org.joda.time.DateTimeZone;\n"
                        + "import org.joda.time.Interval;");
    }

    /**
     * Test that removing multiple imports using removeAll() works and the resulting output is
     * correctly sorted.
     */
    @Test
    public void shouldRemoveMultipleImportsAndSort() {
        testImports("", BASE_IMPORTS, ImmutableList.of(), ImmutableList.of(
                        "com.sun.tools.javac.tree.JCTree",
                        "static com.google.common.base.Preconditions.checkNotNull",
                        "org.joda.time.Interval"),
                "import static java.lang.annotation.ElementType.TYPE_USE;\n"
                        + "\n"
                        + "import com.google.common.collect.ImmutableList;\n"
                        + "import com.google.common.collect.ImmutableMap;\n"
                        + "import com.sun.source.tree.CompilationUnitTree;\n"
                        + "import com.sun.source.tree.ImportTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree.JCExpression;\n"
                        + "import java.io.File;\n"
                        + "import java.io.IOException;\n"
                        + "import java.util.Iterator;\n"
                        + "import javax.tools.JavaCompiler;\n"
                        + "import javax.tools.JavaFileObject;\n"
                        + "import javax.tools.StandardJavaFileManager;\n"
                        + "import javax.tools.ToolProvider;\n"
                        + "import org.joda.time.DateTime;\n"
                        + "import org.joda.time.DateTimeZone;");
    }

    /**
     * Tests that a list of imports with no static imports is handled correctly.
     */
    @Test
    public void noRemainingStaticImports() {
        testImports("", BASE_IMPORTS,
                ImmutableList.of(),
                ImmutableList.of(
                        "static com.google.common.base.Preconditions.checkNotNull",
                        "static java.lang.annotation.ElementType.TYPE_USE"),
                "import com.google.common.collect.ImmutableList;\n"
                        + "import com.google.common.collect.ImmutableMap;\n"
                        + "import com.sun.source.tree.CompilationUnitTree;\n"
                        + "import com.sun.source.tree.ImportTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree.JCExpression;\n"
                        + "import java.io.File;\n"
                        + "import java.io.IOException;\n"
                        + "import java.util.Iterator;\n"
                        + "import javax.tools.JavaCompiler;\n"
                        + "import javax.tools.JavaFileObject;\n"
                        + "import javax.tools.StandardJavaFileManager;\n"
                        + "import javax.tools.ToolProvider;\n"
                        + "import org.joda.time.DateTime;\n"
                        + "import org.joda.time.DateTimeZone;\n"
                        + "import org.joda.time.Interval;");
    }

    /**
     * Test that removing a non-existent import doesn't change anything.
     */
    @Test
    public void removingNonExistingImportShouldntChangeImports() {
        testImports("",
                BASE_IMPORTS,
                ImmutableList.of(),
                ImmutableList.of("org.joda.time.format.ISODateTimeFormat"),
                "import static com.google.common.base.Preconditions.checkNotNull;\n"
                        + "import static java.lang.annotation.ElementType.TYPE_USE;\n"
                        + "import com.google.common.collect.ImmutableMap;\n"
                        + "import com.google.common.collect.ImmutableList;\n"
                        + "import org.joda.time.Interval;\n"
                        + "import org.joda.time.DateTime;\n"
                        + "import org.joda.time.DateTimeZone;\n"
                        + "import com.sun.tools.javac.tree.JCTree;\n"
                        + "import com.sun.source.tree.ImportTree;\n"
                        + "import com.sun.tools.javac.tree.JCTree.JCExpression;\n"
                        + "import com.sun.source.tree.CompilationUnitTree;\n"
                        + "import java.io.File;\n"
                        + "import java.util.Iterator;\n"
                        + "import java.io.IOException;\n"
                        + "import javax.tools.StandardJavaFileManager;\n"
                        + "import javax.tools.JavaFileObject;\n"
                        + "import javax.tools.JavaCompiler;\n"
                        + "import javax.tools.ToolProvider;");
    }

    @Test
    public void addingToEmptyImportList() {
        testImports("package p", ImmutableList.of(), ImmutableList.of("org.joda.time.Interval"), ImmutableList.of(),
                "import org.joda.time.Interval;\n");
    }

    @Test
    public void addingToEmptyImportListInDefaultPackage() {
        testImports("", ImmutableList.of(), ImmutableList.of("org.joda.time.Interval"), ImmutableList.of(),
                "import org.joda.time.Interval;\n");
    }
}
