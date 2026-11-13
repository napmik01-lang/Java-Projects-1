

/*
 * CS 311 - Data Structures
 * Assignment 2 - Part 2
 *
 * File: StuStackDriver.java
 * Author: Noah Kimpan
 */

import java.util.Scanner;

public class StuStackDriver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // Initialise input/scanner
        StuStack s = new StuStack(); // Initalise STack

        String choice; // Choice input

        String studentName; // Name input
        String studentGrade;// Grade input

        while (true) { // Do this until quit
            menu(); //calle menue
            choice = scnr.next(); // Choice input

            if (choice.equalsIgnoreCase("U")) { //U - Push a student record
                scnr.nextLine();

                System.out.print("Enter student name: "); // Get name
                studentName = scnr.nextLine();

                System.out.print("Enter student grade: "); // Get Grade.
                studentGrade = scnr.nextLine();

                s.push(studentName, studentGrade); // Push inputs to stack
            }
            else if (choice.equalsIgnoreCase("O")) { //O - Pop a student from the stack
                s.pop();
            }
            else if (choice.equalsIgnoreCase("P")) { //P - Print the student stack
                System.out.println("Student Stack:");
                System.out.println(s);
            }
            else if (choice.equalsIgnoreCase("N")) { //N - Display the number of students
                System.out.println("Number of Students: " + s.getLength());
            }
            else if (choice.equalsIgnoreCase("Q")) { // Quit
                break;
            }
            else { // Invalud input
                System.out.println("Wrong input. Try again.");
            }
        }

        System.out.println("Bye."); //Ending output
        scnr.close();// Stop searching for input
    }

    public static void menu() { // print the menu
        System.out.println();
        System.out.println("========== Student Stack ==========");
        System.out.println("U - Push a student record");
        System.out.println("O - Pop a student from the stack");
        System.out.println("P - Print the student stack");
        System.out.println("N - Display the number of students");
        System.out.println("Q - Quit the application");
        System.out.println("===================================");
        System.out.print("User's input: ");
    }
}