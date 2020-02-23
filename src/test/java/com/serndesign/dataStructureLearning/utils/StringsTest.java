package com.serndesign.dataStructureLearning.utils;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void centerAbcIn9LeanStart() {
        doTest(
                "abc",
                9,
                Strings.Lean.START,
                "   abc   "
        );
    }

    @Test
    public void centerAbcIn9LeanEnd() {
        doTest(
                "abc",
                9,
                Strings.Lean.END,
                "   abc   "
        );
    }

    @Test
    public void centerAbcIn10LeanStart() {
        doTest(
                "abc",
                10,
                Strings.Lean.START,
                "   abc    "
        );
    }

    @Test
    public void centerAbcIn10LeanEnd() {
        doTest(
                "abc",
                10,
                Strings.Lean.END,
                "    abc   "
        );
    }

    @Test
    public void centerAbcdIn9LeanStart() {
        doTest(
                "abcd",
                9,
                Strings.Lean.START,
                "  abcd   "
        );
    }

    @Test
    public void centerAbcdIn9LeanEnd() {
        doTest(
                "abcd",
                9,
                Strings.Lean.END,
                "   abcd  "
        );
    }

    @Test
    public void centerAbcdIn10LeanStart() {
        doTest(
                "abcd",
                10,
                Strings.Lean.START,
                "   abcd   "
        );
    }

    @Test
    public void centerAbcdIn10LeanEnd() {
        doTest(
                "abcd",
                10,
                Strings.Lean.START,
                "   abcd   "
        );
    }

    @Test
    public void centerAIn1LeanStart() {
        doTest(
                "a",
                1,
                Strings.Lean.START,
                "a"
        );
    }

    @Test
    public void centerAIn1LeanEnd() {
        doTest(
                "a",
                1,
                Strings.Lean.END,
                "a"
        );
    }

    @Test
    public void centerAIn2LeanStart() {
        doTest(
                "a",
                2,
                Strings.Lean.START,
                "a "
        );
    }

    @Test
    public void centerAIn2LeanEnd() {
        doTest(
                "a",
                2,
                Strings.Lean.END,
                " a"
        );
    }

    @Test
    public void centerAIn3LeanStart() {
        doTest(
                "a",
                3,
                Strings.Lean.START,
                " a "
        );
    }

    @Test
    public void centerAIn3LeanEnd() {
        doTest(
                "a",
                3,
                Strings.Lean.END,
                " a "
        );
    }

    @Test
    public void centerAbIn3LeanStart() {
        doTest(
                "ab",
                3,
                Strings.Lean.START,
                "ab "
        );
    }

    @Test
    public void centerAbIn3LeanEnd() {
        doTest(
                "ab",
                3,
                Strings.Lean.END,
                " ab"
        );
    }

    public void doTest(String value, int targetLength, Strings.Lean lean, String expected) {

        assertThat(
                "Test setup error: targetLength != expected.length()",
                targetLength,
                equalTo(expected.length()));

        assertThat(
                "Test setup error: value != expected.trim()",
                value,
                equalTo(expected.trim()));

        String actual = Strings.center(value, targetLength, lean);
        assertThat(actual, equalTo(expected));
    }
}