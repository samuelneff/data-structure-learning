package com.serndesign.dataStructureLearning;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LinkedListTest {

    LinkedList<String> list;

    @Before
    public void beforeEach() {
        list = new LinkedList<>();
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
    public void insertA() {
        list.insert("a", 0);
        assertThat(list.toString(), equalTo("a"));
    }

    @Test
    public void insertAb() {
        list.insert("a", 0).insert("b", 1);
        assertThat(list.toString(), equalTo("a b"));
    }

    @Test
    public void insertBa() {
        list.insert("b", 0).insert("a", 0);
        assertThat(list.toString(), equalTo("a b"));
    }

    @Test
    public void insertAbc() {
        list.insert("a", 0).insert("b", 1).insert("c", 2);
        assertThat(list.toString(), equalTo("a b c"));
    }

    @Test
    public void insertAcb() {
        list.insert("a", 0);
        list.insert("c", 1);
        list.insert("b", 1);

        assertThat(list.toString(), equalTo("a b c"));
    }

    @Test
    public void insertAbdec() {
        list.add("a");
        list.add("b");
        list.add("d");
        list.add("e");

        list.insert("c", 2);

        assertThat(list.toString(), equalTo("a b c d e"));
    }
    @Test
    public void insertCab() {
        list.insert("c", 0).insert("a", 0).insert("b", 1);
        assertThat(list.toString(), equalTo("a b c"));
    }
}