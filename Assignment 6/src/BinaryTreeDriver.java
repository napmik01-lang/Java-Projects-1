/*
 * CS 311 - Data Structures
 * Assignment 6
 *
 * File: BinaryTreeDriver.java
 * Author: Noah Kimpan
 * Due Date: 11/1/2026
 *
 * Objectives:
 * Test the BinaryTree class using a menu.
 * Allow the user to insert and search for words,
 * display the far-left and far-right words,
 * print all words, display the number of words,
 * and quit the application.
 */

import java.util.Scanner;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // initiale scnr
        BinaryTree tree = new BinaryTree(); // create tree

        String choice; // declare vars
        String word;

        do {
            System.out.println("\nI - Insert a word to the tree");
            System.out.println("S - Search for a word");
            System.out.println("L - Display the far-left word");
            System.out.println("R - Display the far-right word");
            System.out.println("P - Print the words in the tree");
            System.out.println("N - Display the number of words");
            System.out.println("Q - Quit the application");
            System.out.print("User's input: ");
            // output menue
            choice = scnr.nextLine().trim(); // Get input for choice

            if (choice.equalsIgnoreCase("I")) { // If Insert
                System.out.print("Enter a word: "); // Ask for
                word = scnr.nextLine().trim(); // and set word

                if (!word.isEmpty()) { // if line has text
                    tree.insert(word); // inser the word into tree
                    System.out.println("Word inserted.");
                }
                else { // if line empty
                    System.out.println("Word cannot be empty.");
                }
            }
            else if (choice.equalsIgnoreCase("S")) { // If Search
                System.out.print("Enter a word to search: ");
                word = scnr.nextLine().trim(); // get word

                if (tree.search(word)) { // Search method with word
                    System.out.println(word + " is in the tree."); // if in tree
                }
                else { // if not in
                    System.out.println(word + " is not in the tree.");
                }
            }
            else if (choice.equalsIgnoreCase("L")) { // Display left
                word = tree.getLeftmost(); // Get left most

                if (word == null) { // unless it's empty
                    System.out.println("Tree is empty.");
                }
                else { // if it exsists
                    System.out.println("Far-left word: " + word);
                }
            }
            else if (choice.equalsIgnoreCase("R")) { // Display right
                word = tree.getRightmost(); // get rightmost

                if (word == null) { // if empty
                    System.out.println("Tree is empty.");
                }
                else { // is it exsist
                    System.out.println("Far-right word: " + word);
                }
            }
            else if (choice.equalsIgnoreCase("P")) { // if print
                System.out.println("Words in the tree:");
                tree.print();// call print
            }
            else if (choice.equalsIgnoreCase("N")) { // if length
                System.out.println("Number of words: " + tree.length()); // get length
            }
            else if (choice.equalsIgnoreCase("Q")) { // if quit
                System.out.println("Application ended."); // end message
            }
            else { // invalid input
                System.out.println("Invalid choice. Try again.");
            }

        } while (!choice.equalsIgnoreCase("Q")); // If we got q, then stop the loop

        scnr.close();
    }
}