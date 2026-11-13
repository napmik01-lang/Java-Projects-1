/*
 * CS311 - Data Structures
 * Assignment 5
 *
 * File: QueueDriver1.java
 * Author: Noah Kimpan
 * Due Date: 10/25/2026
 *
 * Objective:
 * Read student names and three scores each from data5.txt.
 * Calculate each student's average and enqueue the record.
 * Process D commands by dequeuing and displaying the
 * removed record. Process P commands by printing the
 * entire queue to the IDE console.
 */

import java.io.File;//Imports
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueueDriver1 {
    public static void main(String[] args) throws FileNotFoundException {
        // Main + make sure their is a file
        Queue queue = new Queue(); // Setup Queue
        Scanner input = new Scanner(new File("data5.txt")); // Setup Input

        while (input.hasNextLine()) { // while there are still lines in data5
            String line = input.nextLine().trim(); // Trim the text

            if (line.length() == 0) { // bypass any blanks
                continue;
            }

            if (line.equalsIgnoreCase("D")) { // If D
                System.out.println(queue.dequeue()); // Run dequeue
            }
            else if (line.equalsIgnoreCase("P")) {// If print
                System.out.println(queue); // Print the queue
            }
            else { // Otherwise
                String name = line; // First line is the name

                if (input.hasNextLine()) { // if the next is there
                    String scoreLine = input.nextLine().trim(); // Trim any extra spaces
                    String[] scores = scoreLine.split("\\s+"); // Split the line by spaces into array

                    if (scores.length == 3) { // Check that there is 3
                        double score1 = Double.parseDouble(scores[0]); //Item1
                        double score2 = Double.parseDouble(scores[1]);//Item2
                        double score3 = Double.parseDouble(scores[2]);//Item3

                        double average = (score1 + score2 + score3) / 3.0; // Get avg

                        queue.enqueue(name, average); //Put name and avg into the queue
                    }
                }
            }
        }

        input.close();
    }
}