package com.serndesign.dataStructureLearning;

public class LinkedList<T> {

    Node root;
    Node last;
    int count = 0;

    private class Node {
        T value;
        Node next;
    }

    public LinkedList<T> add(T value) {
        Node node = new Node();
        node.value = value;

        if (root == null) {
            root = last = node;
        } else {
            last.next = node;
            last = node;
        }

        count++;
        return this;
    }

    public LinkedList<T> insert(T value, int at) {
        if (count < at) {
            throw new IllegalArgumentException(
                    String.format(
                        "Cannot insert at position %s for list with only %s items",
                        at,
                        count));
        }

        Node current = root;

        for(int i=1; i<at && current != null; i++) {
            current = current.next;
        }

        Node node = new Node();
        node.value = value;

        Node nextNode = current.next;

        current.next = node;
        node.next = nextNode;
        count++;
        return this;
//
//        if (root == null) {
//            return add(value);
//        }
//
//        Node node = new Node();
//        node.value = value;
//
//        if (at == 0) {
//            node.next = root;
//            root = node;
//            count++;
//            return this;
//        }
//
//        Node prev = root;
//
//        for(int i=1; i<at && prev != null; i++) {
//            prev = prev.next;
//        }
//
//        if (prev == null) {
//            return add(value);
//        }
//
//        node.next = prev.next;
//        prev.next = node;
//
//        if (node.next == null) {
//            last = node;
//        }
//
//        count++;
//        return this;
    }

    @Override
    public String toString() {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Node node = root;
        for(;;) {
            sb.append(node.value);
            node = node.next;
            if (node == null) {
                break;
            }
            sb.append(" ");
        }

        return sb.toString();
    }
}