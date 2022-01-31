package com.gl.labsession;

import java.util.ArrayList;

public class LongestPathInBinaryTree {

    static class Node {
        int data;
        Node left, right;
    };

    static Node newNode(int nodeData) {
        Node temp = new Node();
        temp.data = nodeData;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    private static ArrayList<Integer> findLongestPath(Node root) {
        // reach the leaf node
        if(root==null) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            return output;
        }
        // the path on the left subtree (root.left) store it an arraylist L
        ArrayList<Integer> leftNode = findLongestPath(root.left);
        // the path on the right subtree and store in arraylist R
        ArrayList<Integer> rightNode = findLongestPath(root.right);
        // Compare the sizes of thse two lists L& R
        if(rightNode.size()<leftNode.size()) {
            leftNode.add(root.data);
        }else {
            rightNode.add(root.data);
        }

        //pick the longest path and the add the root to that list

        //return list

        return (leftNode.size()> rightNode.size() ? leftNode : rightNode);
    }

    // Driver code
    public static void main(String[] args) {

        Node root = newNode(100);
        root.left = newNode(20);
        root.right = newNode(130);
        root.left.left = newNode(10);
        root.left.right = newNode(50);
        root.right.left = newNode(110);
        root.right.right = newNode(140);
        root.left.left.left = newNode(5);

        ArrayList<Integer> output = findLongestPath(root);

        int size= output.size();

        for(int i= size-1; i>=0; i--) {
            System.out.print("-> " + output.get(i));
        }

    }

}