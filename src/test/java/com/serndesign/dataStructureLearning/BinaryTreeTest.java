package com.serndesign.dataStructureLearning;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void addRootOnly() {

        BinaryTree<String> tree = new BinaryTree<>();

        tree.add("a");

        String expected = "\na\n";
        String actual = tree.toDebugString();

        System.out.println(actual);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void addBac() {

        BinaryTree<String> tree = new BinaryTree<>();

        tree.add("b");
        tree.add("a");
        tree.add("c");

        String expected = "\n  b  \na   c\n";
        String actual = tree.toDebugString();

        System.out.println(actual);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void addDbfaceg() {

        BinaryTree<String> tree = new BinaryTree<>();


        tree.add("d");
        tree.add("b");
        tree.add("f");
        tree.add("a");
        tree.add("c");
        tree.add("e");
        tree.add("g");

/*
      d
  b       f
a   c   e   g
*/
        String expected = "\nd\nbf\naceg\n";
        String actual = tree.toDebugString().replace(" ", "");
        System.out.println("ACTUAL");
        System.out.println(actual);
        System.out.println("EXPECTED");
        System.out.println(expected);

        assertThat(actual, equalTo(expected));
    }
}