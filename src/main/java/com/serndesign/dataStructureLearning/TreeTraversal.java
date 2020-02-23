package com.serndesign.dataStructureLearning;

import java.util.*;

// https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
// https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
// https://www.hackerrank.com/challenges/tree-inorder-traversal/problem

public class TreeTraversal {

    public static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "N(" + data + ")";
        }
    }

    public static void preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        System.out.println(
                list.stream()
                        .map(Object::toString)
                        .collect(java.util.stream.Collectors.joining(" ")));
    }

    public static void preOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public static void postOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        System.out.println(
                list.stream()
                        .map(Object::toString)
                        .collect(java.util.stream.Collectors.joining(" ")));
    }

    public static void postOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.data);
    }
    
    public static void inOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        System.out.println(
                list.stream()
                        .map(Object::toString)
                        .collect(java.util.stream.Collectors.joining(" ")));
    }

    public static void inOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
    
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
