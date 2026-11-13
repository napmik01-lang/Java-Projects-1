/*
 * CS311 - Data Structures
 * Assignment 5
 *
 * File: Queue.java
 * Author: Noah Kimpan
 * Due Date: 10/25/2026
 *
 * Objective:
 * Implement a linked-list-based queue of student names
 * and average scores using the ListNode class. Provide
 * methods to enqueue, dequeue, return the queue length,
 * and display the queue.
 */

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue() { // Initialise queue
        front = null;
        rear = null;
        length = 0;
    }

    public void enqueue(String name, double avg) { // Add an item to queue by
        ListNode newNode = new ListNode(); // Defining node in queue

        newNode.setName(name); // Set node name
        newNode.setAvg(avg); // Set node avg
        newNode.setLink(null); // Set link to null

        if (front == null) { // If at front of queue
            front = newNode; // Define as front node
            rear = newNode; // and as end queue node
        }
        else {// Otherwise
            rear.setLink(newNode);//link prev rear node to this one
            rear = newNode; // set as next real
        }

        length++; // increment leng
    }

    public String dequeue() { // Remove item from queue
        if (front == null) { // If queue empty
            return "Queue is empty."; // return string
        }

        String message = String.format("Dequeue info: %s  %.1f", front.getName(), front.getAvg());
            //Format the node information into it's eventual output
        front = front.getLink(); // link front to the next item down
        length--;//decrement leng

        if (front == null) { // If queue empty
            rear = null; // rear end
        }

        return message; // return
    }

    public int getLength() { // Return the length
        return length;
    }

    public String toString() { // Output the queue
        String temp = "Queue size: " + length + "\n"; // Start the output with length
        temp += "<Front>\n"; // add the front note
        temp += String.format("%-30s %7s%n", "Name", "Average"); // Add the titles

        ListNode current = front; // set current to the front

        while (current != null) {// While curr is not null
            temp += String.format("%-30s %7.1f%n", current.getName(), current.getAvg());
                //Add each item in queue to temp
            current = current.getLink();// and push current down the queue
        }

        temp += "<Rear>\n";// add the rear note

        return temp; // Return all the previous text put in temp
    }
}