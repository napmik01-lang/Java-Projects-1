
/*
 * CS 311 - Data Structures
 * Assignment 2
 *
 * File: StuListDriver.java
 * Author: Noah Kimpan
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StuListDriver {
    public static void main(String[] args)
            throws FileNotFoundException
    {

        StuList sList = new StuList(); // Create the StuList object


        Scanner input = new Scanner(new File("stuScores.txt"));// Open the input file

        // Read the student records
        while (input.hasNextLine()) { //

            String studentName = input.nextLine().trim(); // Read the student's entire name

            // Read the line containing the three scores
            if (input.hasNextLine()) {
                String scoreLine = input.nextLine();

                Scanner scoreInput = new Scanner(scoreLine);

                int score1 = scoreInput.nextInt();
                int score2 = scoreInput.nextInt();
                int score3 = scoreInput.nextInt();


                double average = (score1 + score2 + score3) / 3.0; // Calc the average


                sList.Insert(studentName, average); // Store  name and average

                scoreInput.close();
            }
        }

        input.close();

        // Sort alphabetically by name
        System.out.println("Students Sorted Alphabetically");
        System.out.println("--------------------------------");

        sList.SortName();
        sList.Print();

        // Separate outputs
        System.out.println();
        System.out.println("Students Sorted by Average - Descending");
        System.out.println("----------------------------------------");

        // Sort by avg in descending order
        sList.SortAverage();
        sList.Print();
    }
}

