package com.serndesign.dataStructureLearning;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DoubleLinkedListTest {

    DoubleLinkedList<String> list;

    @Before
    public void beforeEach() {
        list = new DoubleLinkedList<>();
    }

    @Test
    public void emptyToString() {
        assertThat(list.toString(), equalTo(""));
    }

    @Test
    public void addA() {
        list.add("a");
        assertThat(list.toString(), equalTo("a"));
    }

    @Test
    public void addAbc() {
        list.add("a").add("b").add("c");
        assertThat(list.toString(), equalTo("a b c"));
    }


    @Test
    public void removeEmpty() {
        list.remove();
        assertThat(list.toString(), equalTo(""));
    }

    @Test
    public void removeA() {
        list.add("a");
        list.remove();
        assertThat(list.toString(), equalTo(""));
    }

    @Test
    public void removeAb() {
        list.add("a");
        list.add("b");
        list.remove();
        assertThat(list.toString(), equalTo("a"));
    }

    @Test
    public void removeAbc() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove();
        assertThat(list.toString(), equalTo("a b"));
    }

    @Test
    public void removeAbc2() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove();
        list.remove();
        assertThat(list.toString(), equalTo("a"));
    }

    @Test
    public void insertAtA() {
        list.insertAt("a", 0);
        assertThat(list.toString(), equalTo("a"));
    }

    @Test
    public void insertAtAb() {
        list.insertAt("a", 0).insertAt("b", 1);
        assertThat(list.toString(), equalTo("a b"));
    }

    @Test
    public void insertAtBa() {
        list.insertAt("b", 0).insertAt("a", 0);
        assertThat(list.toString(), equalTo("a b"));
    }

    @Test
    public void insertAtAbc() {
        list.insertAt("a", 0);
        list.insertAt("b", 1);
        list.insertAt("c", 2);
        assertThat(list.toString(), equalTo("a b c"));
    }

    @Test
    public void insertAtAcb() {
        list.insertAt("a", 0);
        list.insertAt("c", 1);
        list.insertAt("b", 1);

        assertThat(list.toString(), equalTo("a b c"));
    }

    @Test
    public void insertAtAbdec() {
        list.add("a");
        list.add("b");
        list.add("d");
        list.add("e");

        list.insertAt("c", 2);

        assertThat(list.toString(), equalTo("a b c d e"));
    }
    @Test
    public void insertAtCab() {
        list.insertAt("c", 0).insertAt("a", 0).insertAt("b", 1);
        assertThat(list.toString(), equalTo("a b c"));
    }

    @Test
    public void removeAtAa() {
        list.add("a");
        list.removeAt(0);
        assertThat(list.toString(), equalTo(""));
    }

    @Test
    public void removeAtAba() {
        list.add("a");
        list.add("b");
        list.removeAt(0);
        assertThat(list.toString(), equalTo("b"));
    }

    @Test
    public void removeAtAbcb() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.removeAt(1);
        assertThat(list.toString(), equalTo("a c"));
    }

    @Test
    public void removeAtAbcc() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.removeAt(2);
        assertThat(list.toString(), equalTo("a b"));
    }

    @Test
    public void removeAtAbcd() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.removeAt(3);
        assertThat(list.toString(), equalTo("a b c"));
    }
}