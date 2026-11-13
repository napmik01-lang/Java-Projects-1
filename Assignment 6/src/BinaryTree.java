/*
 * CS 311 - Data Structures
 * Assignment 6
 *
 * File: BinaryTree.java
 * Author: Noah Kimpan
 * Due Date: 11/1/2026
 *
 * Objectives:
 * Create a binary search tree that stores strings.
 * Insert and search for words, display the far-left
 * and far-right words, print the words in order,
 * and display the total number of words.
 */

public class BinaryTree {
    private class Node { // Declare nodes left right and data
        private Node left;
        private String data;
        private Node right;

        private Node(String Data) {
            data = Data;
        }
    }

    private Node root;

    private Node insert(Node node, String item) { // Inset an ite,
        if (node == null) { // If null
            return new Node(item); // Start from scratch
        }
        else { // otherwise
            if (item.compareToIgnoreCase(node.data) <= 0) { // Check if value is less then current data
                node.left = insert(node.left, item); // if so go left
            }
            else {
                node.right = insert(node.right, item); // otherwise go right
            }

            return node;
        }
    }

    public void insert(String item) { // Takes insert call from driver and
        root = insert(root, item); // attaches the data to a node
    }

    public boolean search(String item) { //search
        Node current = root; // start at root

        while (current != null) {
            int result = item.compareToIgnoreCase(current.data); // Check if current is search item

            if (result == 0) { // Is yes
                return true; // return yes
            }
            else if (result < 0) { // If less then,
                current = current.left; // check the left node
            }
            else { // if more then
                current = current.right; // check right node and repeat
            }
        }

        return false; // otherwise return no
    }

    public String getLeftmost() { // Check left
        if (root == null) { //  make sure tree exists
            return null;
        }

        Node current = root; // start at root

        while (current.left != null) { // while left node exists
            current = current.left; // go to left
        }

        return current.data; // then return
    }

    public String getRightmost() { // same as left
        if (root == null) {//  make sure tree exists
            return null;
        }

        Node current = root;// start at root

        while (current.right != null) { // while  Right node exists
            current = current.right; // go right
        }

        return current.data; /// return
    }

    private void print(Node node) { // print node
        if (node != null) { // if node exsists
            print(node.left); //  Repeat for all items in left
            System.out.print(node.data + "\t"); // center + formating
            print(node.right); //repeat for all items in right recurisvly
        }
    }

    public void print() { // Print call from Driver
        if (root == null) { // Make sure tree exsists with items
            System.out.println("Tree is empty.");
        }
        else { //  if so
            print(root); // Call node printing funct
            System.out.println();
        }
    }

    public int length() { // Driver length call
        return getLength(root); // Calling node method
    }

    private int getLength(Node node) { // Length node method
        if (node == null) {// if empty
            return 0;
        }
        else { // if items exsist
            return getLength(node.left) + 1 + getLength(node.right);
            // Recursivly add up number of all items, left and right + center node
        }
    }
}