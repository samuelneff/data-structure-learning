package com.serndesign.dataStructureLearning;

public class HashDictionary<TKey, TValue> {

    private DoubleLinkedList<Node>[] buckets;
    private int capacity;

    public HashDictionary() {
        this(17);
    }

    public HashDictionary(int capacity) {
        if (capacity < 3) {
            capacity = 3;
        }
        this.capacity = capacity;
        buckets = new DoubleLinkedList[capacity];
    }

    public TValue get(TKey key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }

        int hash = key.hashCode();
        DoubleLinkedList<Node> bucket = getBucket(hash);

        for(Node node : bucket) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }

        return null;
    }

    public void put(TKey key, TValue value) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }

        int hash = key.hashCode();
        DoubleLinkedList<Node> bucket = getBucket(hash);

        for(Node node : bucket) {
            if (key.equals(node.key)) {
                node.value = value;
            }
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        bucket.add(newNode);
    }

    private DoubleLinkedList<Node> getBucket(int hash) {
        int index = hash % capacity;
        DoubleLinkedList<Node> bucket = buckets[index];
        if (bucket == null) {
            buckets[index] = bucket = new DoubleLinkedList<>();
        }
        return bucket;
    }

    private class Node {
        TKey key;
        TValue value;
    }
}
