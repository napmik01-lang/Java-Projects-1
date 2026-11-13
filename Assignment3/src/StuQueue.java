
/*
 * CS 311 - Data Structures
 * Assignment 3 - Part 2
 *
 * File: StuQueue.java
 * Author: Noah Kimpan
 * Due date:  9/27/26
 *  *
 * Objective:
 * Create an array-based queue that stores student names
 * and their average scores. The queue provides methods
 * to enqueue and dequeue student records, display the
 * number of students, and print the queue.
 */
 */

public class StuQueue {
    private int length = 0;
    final int MAX = 100;

    private String[] name = new String[MAX]; // declare the array
    private double[] avg = new double[MAX]; // declare the array

    public void enqueue(String na, double av) { // add items to the list
        if (length < MAX) {//  check to make sure queue is not full
            name[length] = na;// add item to the end of the list
            avg[length] = av;// add item to the end of the list
            length++; // make sure the length is set to an unoccupied slot for next item
        }
    }

    public void dequeue() {// remove items from list
        if (length > 0) { // If the list is not empty
            String tempName = name[0];// save the first item to temp
            double tempAvg = avg[0];// save the first item to temp

            for (int i = 0; i < length - 1; i++) {//then, for each index in the queue
                name[i] = name[i + 1];// move each item down by one
                avg[i] = avg[i + 1];// move each item down by one
            }

            length--; // decrement length

            System.out.printf("Dequeue info: %-25s %5.1f%n", tempName, tempAvg);// print out the removed item
        }
        else {// if queue empty
            System.out.println("Queue is empty.");
        }
    }

    public int getLength() {// return the length of the queue
        return length;
    }

    public String toString() {// Operations involving formating the queue for printing
        String temp = "Queue size: " + length + "\n";
        temp += "<Front>\n"; // add the front format
        temp += String.format("%-25s %s%n", "Name", "Average"); // formating for headdings

        for (int i = 0; i < length; i++) {// for each item
            temp += String.format("%-25s %5.1f%n", name[i], avg[i]); // add the item plus a space
        }

        temp += "<Rear>\n";// add the end

        return temp;//return
    }
}