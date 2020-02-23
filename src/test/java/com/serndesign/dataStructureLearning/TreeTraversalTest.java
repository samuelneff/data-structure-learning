package com.serndesign.dataStructureLearning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class TreeTraversalTest {

    @Test
    public void preOrder1() {
        String input =  "1 2 5 3 6 4";
        String expected = "1 2 5 3 4 6";

        TreeTraversal.Node root = createTree(input);
        List<Integer> list = new ArrayList<>();
        TreeTraversal.preOrder(root, list);
        String actual = listToString(list);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void postOrder1() {
        String input =  "1 2 5 3 6 4";
        String expected = "4 3 6 5 2 1";

        TreeTraversal.Node root = createTree(input);
        List<Integer> list = new ArrayList<>();
        TreeTraversal.postOrder(root, list);
        String actual = listToString(list);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void inOrder1() {
        String input =  "1 2 5 3 6 4";
        String expected = "1 2 3 4 5 6";

        TreeTraversal.Node root = createTree(input);
        List<Integer> list = new ArrayList<>();
        TreeTraversal.inOrder(root, list);
        String actual = listToString(list);
        assertThat(actual, equalTo(expected));
    }

    private TreeTraversal.Node createTree(String input) {
        TreeTraversal.Node root = null;
        String[] inputNums = input.split(" ");
        for(int i=0; i<inputNums.length; i++) {
            int data = Integer.parseInt(inputNums[i]);
            root = TreeTraversal.insert(root, data);
        }
        return root;
    }

    private String listToString(List<Integer> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}