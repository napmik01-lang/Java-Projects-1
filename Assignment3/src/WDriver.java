
/*
 * CS 311 - Data Structures
 * Assignment 3 - Part 1
 *
 * File: WDriver.java
 * Author: Noah Kimpan
 * Due date:  9/27/26
 *  *
 * Objective:
 * Create a driver program for the WQueue class.
 * The program allows the user to enqueue and dequeue
 * words, print the queue, display the number of words,
 * and quit the application.

 */

import java.util.Scanner;

public class WDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//declare the input
        WQueue w = new WQueue();// declare the queue

        String choice; // declare variables
        String word;

        while (true) {
            menu(); // print the menue
            choice = input.next(); // start taking input

            if (choice.equalsIgnoreCase("E")) { // add to the queue
                System.out.print("Enter a word: ");
                word = input.next(); // take inpit

                w.enqueue(word); //  and add it to the queue.
            }
            else if (choice.equalsIgnoreCase("D")) { // remove from the queue
                w.dequeue();
            }
            else if (choice.equalsIgnoreCase("P")) { // print the queue
                System.out.println("Word queue:");
                System.out.println(w);
            }
            else if (choice.equalsIgnoreCase("N")) { // print the length of the list
                System.out.println("Number of words: " + w.getLength());
            }
            else if (choice.equalsIgnoreCase("Q")) {  // exit condition
                break;
            }
            else { // Incorect input catch case
                System.out.println("Wrong input. Try again.");
            }
        }

        System.out.println("Bye."); // end
        input.close(); // end input
    }

    public static void menu() { // Print out the menue
        System.out.println();
        System.out.println("========== Word Queue ==========");
        System.out.println("E - Enqueue a word");
        System.out.println("D - Dequeue a word");
        System.out.println("P - Print the word queue");
        System.out.println("N - Display the number of words");
        System.out.println("Q - Quit the application");
        System.out.println("================================");
        System.out.print("User's input: ");
    }
}