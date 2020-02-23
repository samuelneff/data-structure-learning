package com.serndesign.dataStructureLearning;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class TutorialTreeTest {

    @Test
    public void containsEmpty() {
        TutorialTree<String> tree = new TutorialTree<>();
        boolean actual = tree.contains("a");
        assertThat(actual, equalTo(false));
    }

    @Test
    public void containsAA() {
        TutorialTree<String> tree = new TutorialTree<>();
        tree.add("a");
        boolean actual = tree.contains("a");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void containsBacA() {
        TutorialTree<String> tree = new TutorialTree<>();
        tree.add("b");
        tree.add("a");
        tree.add("c");
        boolean actual = tree.contains("a");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void containsBacB() {
        TutorialTree<String> tree = new TutorialTree<>();
        tree.add("b");
        tree.add("a");
        tree.add("c");
        boolean actual = tree.contains("b");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void containsBacC() {
        TutorialTree<String> tree = new TutorialTree<>();
        tree.add("b");
        tree.add("a");
        tree.add("c");
        boolean actual = tree.contains("c");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void containsBacD() {
        TutorialTree<String> tree = new TutorialTree<>();
        tree.add("b");
        tree.add("a");
        tree.add("c");
        boolean actual = tree.contains("d");
        assertThat(actual, equalTo(false));
    }
}