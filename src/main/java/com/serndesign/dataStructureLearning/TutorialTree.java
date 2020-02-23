package com.serndesign.dataStructureLearning;

/**
 * Transcribed SimpleTree class from https://app.pluralsight.com/library/courses/java-data-structures-implementing-understanding
 *
 * @param <T>
 */
public class TutorialTree<T extends Comparable<T>> {

    private Node root;
    private int size;

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null to tree.");
        }

        Node newNode = new Node(item);

        if (root == null) {
            root = newNode;
            this.size++;
            return;
        }

        insert(root, newNode);
    }

    public boolean contains(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot check for contains null.");
        }

        Node found = find(item, root);
        return found != null;
    }

    public boolean delete(T item) {
        Node found = find(item, root);
        if (found == null) {
            return false;
        }


    }
    public int size() {
        return size;
    }

    private Node find(T item, Node parent) {
        if (parent == null) {
            return null;
        }
        T parentItem = parent.getItem();
        int compared = item.compareTo(parentItem);
        if (compared == 0) {
            return parent;
        }

        Node next = compared < 0 ? parent.getLeft() : parent.getRight();
        return find(item, next);
    }

    private void insert(Node parent, Node child) {
        int compared = child.getItem().compareTo(parent.getItem());
        if (compared < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (compared > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }
        }
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private T item;

        public Node(T item) {
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
}
