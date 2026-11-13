package Chapter_4;

/*
 * CS 311 - Data Structures
 * Assignment 3 - Part 1
 *
 * File: StuStack2Driver.java
 * Author: Noah Kimpan
 * Due Date: 10/13/2026
 *
 * Objective:
 * Test the linked-list-based StuStack2 class.
 * Allow the user to push student records, pop students,
 * print the stack, display its length, and quit.
 */

import java.util.Scanner;

public class StuStack2Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // declare input SCNR
        StuStack2 stack = new StuStack2(); // Declare stack

        // Declare vairables
        String choice;
        String name;
        String grade;

        do { // while input is not q
            System.out.println(); // Print out the menu
            System.out.println("U - Push a student record");
            System.out.println("O - Pop a student from the stack");
            System.out.println("P - Print the student stack");
            System.out.println("N - Display number of students");
            System.out.println("Q - Quit the application");
            System.out.print("User's input: ");

            choice = scnr.nextLine().trim(); // trim out chars in input

            if (choice.equalsIgnoreCase("U")) { // If push
                System.out.print("Enter student name: ");
                name = scnr.nextLine(); // Add name to item

                System.out.print("Enter student grade: ");
                grade = scnr.nextLine().trim().toUpperCase(); // add grade to item

                stack.push(name, grade); // Push to stack
                System.out.println("Student added to the stack.");
            }
            else if (choice.equalsIgnoreCase("O")) {
                stack.pop(); // Pop from stack
            }
            else if (choice.equalsIgnoreCase("P")) {
                System.out.println(stack); // print the stack
            }
            else if (choice.equalsIgnoreCase("N")) {
                System.out.println("Number of students: " + stack.getLength()); // Print length of stack
            }
            else if (choice.equalsIgnoreCase("Q")) {
                continue; // Quit condition to bypass invalid choice.
            }
            else {  // invalid
                System.out.println("Invalid choice. Try again.");
            }

        } while (!choice.equalsIgnoreCase("Q")); // Quit

        System.out.println("Application ended."); // Quit
        scnr.close(); // stop  input
    }
}