

/*
 * CS 311 - Data Structures
 * Assignment 3 - Part 1
 *
 * File: WQueue.java
 * Author: Noah Kimpan
 * Due Date:  9/27/26
 *  *
 * Objective:
 * Create an array-based queue that stores words.
 * The queue will provide methods to enqueue and dequeue
 * words, get the number of words, and print the queue.

 */

public class WQueue {
    private int length = 0;
    final int MAX = 50;

    private String[] word = new String[MAX];

    public void enqueue(String w) { // add items to the list
        if (length < MAX) { //  check to make sure queue is not full
            word[length] = w; // add item to the end of the list
            length++; // make sure the length is set to an unoccupied slot for next item
        }
    }

    public void dequeue() { // remove items from list
        if (length > 0) { // If the list is not empty
            String temp = word[0]; // save the first item to temp

            for (int i = 0; i < length - 1; i++) { //then, for each index in the queue
                word[i] = word[i + 1]; // move each item down by one
            }

            length--; // decrement length

            System.out.println("Dequeue info: " + temp); // print out the removed item
        }
        else { // if queue empty
            System.out.println("Queue is empty.");
        }
    }

    public int getLength() { // return the length of the queue
        return length;
    }

    public String toString() { // Operations involving formating the queue for printing
        String temp = "Queue size: " + length + "\n"; // size
        temp += "<Front>\n"; // add the front format

        for (int i = 0; i < length; i++) {// for each item

            temp += word[i] + "\n"; // add the item plus a space
        }

        temp += "<Rear>\n"; // add the end

        return temp; // return
    }
}