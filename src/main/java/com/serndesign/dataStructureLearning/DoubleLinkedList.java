package com.serndesign.dataStructureLearning;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    Node first;
    Node last;
    long version = 0;

    public DoubleLinkedList<T> add(T value) {
        version++;
        Node newNode = new Node();
        newNode.value = value;

        if (first == null) {
            first = last = newNode;
            return this;
        }

        newNode.prev = last;
        last.next = newNode;
        last = newNode;
        return this;
    }

    public DoubleLinkedList<T> remove() {
        version++;

        if (last == null) {
            return this;
        }

        if (first == last) {
            first = last = null;
            return this;
        }

        Node oldLast = last;
        last = last.prev;
        last.next = null;
        oldLast.prev = null;
        return this;
    }

    public DoubleLinkedList<T> insertAt(T value, int position) {
        version++;

        Node newNode = new Node();
        newNode.value = value;

        if (first == null) {
            first = last = newNode;
            return this;
        }

        if (position < 1) {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            return this;
        }

        Node target = first;
        for (int i=0; i<position && target != null; i++) {
            target = target.next;
        }

        // are we inserting at end?
        if (target == null) {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            return this;
        }

        newNode.prev = target.prev;
        newNode.next = target;
        newNode.prev.next = newNode;

        target.prev = newNode;

        return this;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public DoubleLinkedList<T> removeAt(int position) {
        version++;
        if (first == null) {
            return this;
        }

        if (position < 1) {
            if (first == last) {
                first = last = null;
                return this;
            }
            first = first.next;
            first.prev = null;
            return this;
        }

        Node target = first;
        for (int i=0; i<position && target != null; i++) {
            target = target.next;
        }

        // asking to remove after end of list?
        if (target == null) {
            return this;
        }

        Node prev = target.prev;
        Node next = target.next;

        prev.next = next;
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        return this;
    }

    @Override
    public String toString() {

        if (first == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Node node = first;
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

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator(this);
    }

    private class Node {
        T value;
        Node prev;
        Node next;
    }
    
    private class DoubleLinkedListIterator implements Iterator<T> {

        private final DoubleLinkedList<T> list;
        private final long version;
        private DoubleLinkedList<T>.Node next;

        DoubleLinkedListIterator(DoubleLinkedList<T> list) {
            this.list = list;
            this.version = list.version;
            next = list.first;
        }
        
        @Override
        public boolean hasNext() {
            if (list.version != version) {
                throw new IllegalStateException("Collection modified during iteration.");
            }

            return next != null;
        }

        @Override
        public T next() {
            if (next == null) {
                throw new IllegalStateException("Cannot move to next after end of list.");
            }

            if (list.version != version) {
                throw new IllegalStateException("Collection modified during iteration.");
            }

            DoubleLinkedList<T>.Node current = next;
            next = next.next;
            return current.value;
        }
    }
}
