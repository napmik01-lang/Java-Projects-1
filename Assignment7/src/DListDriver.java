/*
 * Assignment: LAB 2 - Doubly Linked List
 * Class: CS 311 - Data Structures
 * Author: Noah Kimpan
 * Due Date: 11/15/2026
 *
 * Objective:
 * Create a menu-driven program to manage student records
 * using a doubly linked list.
 *
 * Menu operations:
 * I - Insert a student at the front
 * E - Insert a student at the end
 * S - Search for a student
 * R - Remove a student by name
 * F - Remove the front node
 * D - Remove the end node
 * P - Print the list
 * N - Display the number of nodes
 * Q - Quit
 */

import java.util.Scanner;

public class DListDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DList students = new DList();

        String cmnd;
        String name;
        String grade;

        do {
            System.out.println("\n========== STUDENT LIST MENU ==========");
            System.out.println("I - Insert a student at the front");
            System.out.println("E - Insert a student at the end");
            System.out.println("S - Search for a student");
            System.out.println("R - Remove a student by name");
            System.out.println("F - Remove the front node");
            System.out.println("D - Remove the end node");
            System.out.println("P - Print the list");
            System.out.println("N - Display number of nodes");
            System.out.println("Q - Quit");
            System.out.println("=======================================");

            System.out.print("User's input: ");
            cmnd = input.nextLine().trim().toLowerCase();

            switch (cmnd) {
                // Insert a student at the front of the list
                case "i":
                    System.out.print("Enter student's full name: ");
                    name = input.nextLine();

                    System.out.print("Enter student's grade: ");
                    grade = input.nextLine();

                    students.insertFront(name, grade);

                    System.out.println("Student inserted at the front.");
                    break;

                // Insert a student at the end of the list
                case "e":
                    System.out.print("Enter student's full name: ");
                    name = input.nextLine();

                    System.out.print("Enter student's grade: ");
                    grade = input.nextLine();

                    students.insertEnd(name, grade);

                    System.out.println("Student inserted at the end.");
                    break;

                // Search for a student by name
                case "s":
                    System.out.print("Enter student's full name to search: ");
                    name = input.nextLine();

                    DListNode found = students.search(name);

                    if (found != null) {
                        System.out.println("Student found:");
                        System.out.printf("%-30s %-10s%n",
                                found.getName(), found.getGrade());
                    }
                    else {
                        System.out.println("Student not found.");
                    }
                    break;

                // Remove a student by name
                case "r":
                    System.out.print("Enter student's full name to remove: ");
                    name = input.nextLine();

                    if (students.remove(name)) {
                        System.out.println("Student record removed.");
                    }
                    else {
                        System.out.println("Student not found.");
                    }
                    break;

                // Remove the front node from the list
                case "f":
                    if (students.removeFront()) {
                        System.out.println("Front student removed.");
                    }
                    else {
                        System.out.println("The list is empty.");
                    }
                    break;

                // Remove the end node from the list
                case "d":
                    if (students.removeEnd()) {
                        System.out.println("End student removed.");
                    }
                    else {
                        System.out.println("The list is empty.");
                    }
                    break;

                // Print all students in the list
                case "p":
                    students.printList();
                    break;

                // Display the number of students in the list
                case "n":
                    System.out.println("Number of students: " + students.getSize());
                    break;

                // Quit the program
                case "q":
                    System.out.println("Exiting program.");
                    break;

                // Handle invalid input
                default:
                    System.out.println("Invalid Command. Please try again.");
            }

        } while (!cmnd.equals("q"));

        input.close();
    }
}