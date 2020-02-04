package com.serndesign.dataStructureLearning;

public class LinkedList<T> {

    Node root;
    Node last;

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

        return this;
    }

    public LinkedList<T> remove() {
        if (root == null) {
            return this;
        }

        if (root.next == null) {
            root = last = null;
            return this;
        }

        Node prev = root;
        while (prev.next != last) {
            prev = prev.next;
        }
        prev.next = null;
        last = prev;
        return this;
    }

    public LinkedList<T> insert(T value, int position) {

        if (root == null) {
            return add(value);
        }

        Node node = new Node();
        node.value = value;

        if (position == 0) {
            node.next = root;
            root = node;
            return this;
        }

        Node prev = root;

        for(int i=1; i<position && prev != null; i++) {
            prev = prev.next;
        }

        if (prev == null) {
            return add(value);
        }

        node.next = prev.next;
        prev.next = node;

        if (node.next == null) {
            last = node;
        }

        return this;
    }

    public LinkedList<T> removeAt(int position) {
        if (root == null) {
            return this;
        }

        if (position == 0) {
            Node oldRoot = root;
            root = root.next;
            if (last == oldRoot) {
                last = root;
            }
            return this;
        }

        Node prev = root;
        Node target = root.next;

        for(int i=1; i<position && prev != null; i++) {
            prev = target;
            target = prev.next;
        }

        if (target == null) {
            return this;
        }

        if (prev == null) {
            root = target.next;
        } else {
            prev.next = target.next;
        }
        if (target.next == null) {
            last = prev;
        }

        return this;
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