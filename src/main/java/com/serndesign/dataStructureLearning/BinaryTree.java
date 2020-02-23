package com.serndesign.dataStructureLearning;

import com.serndesign.dataStructureLearning.utils.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinaryTree<T extends Comparable<T>> {

    private Node root;

    public BinaryTree<T> add(T value) {

        if (value == null) {
            throw new IllegalArgumentException("Cannot add null value to BinaryTree.");
        }

        if (root == null) {
            root = new Node(value);
            return this;
        }

        addUnder(value, root);

        return this;
    }

    private void addUnder(T value, Node parent) {

        int relative = value.compareTo(parent.value);

        if (relative == 0) {
            throw new IllegalArgumentException("Cannot add duplicate value '" + value + "' to BinaryTree.");
        }

        if (relative < 0) {
            if (parent.before == null) {
                parent.before = new Node(value);
            } else {
                addUnder(value, parent.before);
            }
            return;
        }

        if (parent.after == null) {
            parent.after = new Node(value);
        } else {
            addUnder(value, parent.after);
        }
    }

    public String toDebugString() {
        final String PADDING = "   ";
        final int PADDING_LENGTH = PADDING.length();

        List<List<T>> rows = toLists();
        List<List<String>> strings =
                rows.stream()
                        .map(list -> list
                            .stream()
                            .map(v -> v == null ? "null" : v.toString())
                            .collect(Collectors.toList()))
                .collect(Collectors.toList());

        int maxLength = strings
                .stream()
                .map(
                        row -> row
                                .stream()
                                .map(s -> s.length())
                                .max(Integer::compare)
                                .get()
                )
                .max(Integer::compare)
                .get();

        int lastCount = rows.get(rows.size() - 1).size();
        int lastLength = lastCount * maxLength + (lastCount - 1) * PADDING_LENGTH;

        String[] rowStrings = new String[rows.size()];

        for(int i = rows.size() - 1; i >= 0; i--) {
            List<String> thisRowStrings = strings.get(i);

            String[] thisRowCenteredStrings = new String[thisRowStrings.size()];
            for(int j = 0; j < thisRowCenteredStrings.length; j++) {
                thisRowCenteredStrings[j] = Strings.center(
                                thisRowStrings.get(j),
                                maxLength,
                                (j & 1) == 1 ? Strings.Lean.START : Strings.Lean.END);
            }

            rowStrings[i] = Strings.center(
                    String.join(PADDING, thisRowCenteredStrings),
                    lastLength,
                    Strings.Lean.START);
        }

        return "\n" + String.join("\n", rowStrings) + "\n";
    }



    public List<List<T>> toLists() {
        List<List<T>> rows = new ArrayList<>();
        List<T> rootRow = new ArrayList<>(1);
        rows.add(rootRow);

        if (root == null) {
            return rows;
        }

        rootRow.add(root.value);

        toList(rows, Arrays.asList(root.before, root.after));

        return rows;
    }

    private void toList(List<List<T>> rows, List<Node> nodesAtLevel) {

        if (nodesAtLevel.stream().allMatch(Objects::isNull)) {
            return;
        }

        rows.add(
                nodesAtLevel
                        .stream()
                        .map(n -> n == null ? null : n.value)
                        .collect(Collectors.toList()));

        List<Node> nodesNextLevel = new ArrayList(nodesAtLevel.size() * 2);

        for (Node node : nodesAtLevel) {
            if (node == null) {
                nodesNextLevel.add(null);
                nodesNextLevel.add(null);
            } else {
                nodesNextLevel.add(node.before);
                nodesNextLevel.add(node.after);
            }
        }

        toList(rows, nodesNextLevel);
    }

    private class Node {
        T value;
        Node before;
        Node after;

        Node(T value) {
            this.value = value;
        }
    }
}
