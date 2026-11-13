package Chapter_4;

/*
 * CS 311 - Data Structures
 * Assignment 3 - Part 1
 *
 * File: StuStack2.java
 * Author: Noah Kimpan
 * Due Date: 10/13/2026
 *
 * Objective:
 * Implement a linked-list-based stack of student records
 * using the StuNode class. Provide methods to push and pop
 * students, return the stack length, and display the stack.
 */

public class StuStack2 {
    private StuNode top; // declare top
    private int length; // and length

    public StuStack2() { // Declare initial conditions for top and length
        top = null;
        length = 0;
    }

    public void push(String name, String grade) { // Push item to stack
        StuNode newNode = new StuNode(); // declare a new node

        newNode.setName(name); // set name
        newNode.setGrade(grade); // set grade
        newNode.setLink(top); // link item to exsisting top of stack

        top = newNode; // make new node the new top
        length++; // inc length
    }

    public void pop() {
        if (top != null) { // If there is a top of the stack
            System.out.println("Removed student: " + top.getName() + "  " + top.getGrade()); // Print the top

            top = top.getLink(); // Move the top down one link
            length--; // Lower the link
        }
        else { // If stack empty
            System.out.println("Stack is empty."); //report empty
        }
    }

    public int getLength() { // Get the length of the stack
        return length;
    }

    public String toString() { // return the Stack
        String temp = "Stack size: " + length + "\n"; // size lable
        temp += "<Top>\n";
        temp += String.format("%-25s %s%n", "Name", "Grade"); // titles lables

        StuNode current = top; // get current top item in stack

        while (current != null) {
            temp += String.format("%-25s %s%n", current.getName(), current.getGrade());
            // add name and grade of current item in stack
            current = current.getLink(); // move current down stack
        }

        temp += "<Bottom>\n"; // finish output

        return temp;// and return
    }
}