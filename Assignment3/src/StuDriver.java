
/*
 * CS 311 - Data Structures
 * Assignment 3 - Part 2
 *
 * File: StuDriver.java
 * Author: Noah Kimpan
 * Due Date:  9/27/26
 *  *
 * Objective:
 * Read student names and three scores from scores.txt.
 * Calculate each student's average and enqueue the student
 * and average into a queue. When a D command is encountered,
 * dequeue a student and display the queue. After the entire
 * file has been processed, display the final queue.
 */

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class StuDriver {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        // Initialise and error handling in cases that there is no file
        StuQueue s = new StuQueue();

        Scanner input = new Scanner(new File("scores.txt")); //declare the input
        PrintWriter out3 = new PrintWriter("out3.txt"); //declare the input2

        String line;
        String studentName;
        int score1;
        int score2;
        int score3;
        double average;

        while (input.hasNextLine()) {//While there are still items in the queue
            line = input.nextLine().trim();  // get and format the item

            if (line.equalsIgnoreCase("D")) { // If it is a "D" cease formating the queue
                s.dequeue(); // remove item

                System.out.println(s);//and print
                out3.println(s);}
            else if (!line.equals("")) { // If the line is not empty but does exsist
                studentName = line; // store the line

                if (input.hasNextLine()) {
                    String scores = input.nextLine().trim(); // get the scores
                    String[] parts = scores.split("\\s+"); // split the scores into three parts of an array

                    score1 = Integer.parseInt(parts[0]); // put the parts array scores into vars
                    score2 = Integer.parseInt(parts[1]);
                    score3 = Integer.parseInt(parts[2]);

                    average = (score1 + score2 + score3) / 3.0; // take average

                    s.enqueue(studentName, average); // add name and avg to queue
                }
            }
        }

        System.out.println("Final Queue:"); // Print the queue
        System.out.println(s);

        out3.println("Final Queue:"); // Print the queue
        out3.println(s);

        input.close(); // close inputs
        out3.close();
    }
}