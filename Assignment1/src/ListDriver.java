
/*
 * CS 311 - Data Structures
 * Assignment 1
 *
 * File: ListDriver.java
 * Author: Noah Kimpan
 *
 * Objective:
 * Read student names from stu.txt, store the names in a List
 * object, sort the names alphabetically, and allow the user
 * to search for a student name.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListDriver {
    public static void main(String[] args)
            throws FileNotFoundException {
        List nList = new List(); // Create the List object

        Scanner input = new Scanner(new File("stu.txt")); // Open the student data file


        while (input.hasNextLine()) { // Read all names from the file
            String name = input.nextLine().trim();

            if (!name.isEmpty()) {
                nList.Insert(name);
            }
        }

        input.close();

        // Sort and display the names
        System.out.println("Student Names in Alphabetical Order:");
        System.out.println("------------------------------------");

        nList.Sort();
        nList.Print();


        Scanner keyboard = new Scanner(System.in); // Search for a student name

        System.out.println();
        System.out.print("Enter a student name to search: ");

        String searchName = keyboard.nextLine();

        if (nList.Search(searchName)) {
            System.out.println(searchName + " is found");
        }
        else {
            System.out.println(searchName + " is not found");
        }

        keyboard.close();
    }
}

