
/*
 * CS 311 - Data Structures
 * Assignment 2 - Part 2
 *
 * File: StuStack.java
 * Author: Noah Kimpan

 */

public class StuStack {
    private int length = 0; // length of list initial
    final int MAX = 50; // Max size

    private String[] name = new String[MAX]; //Name list
    private String[] grade = new String[MAX]; // Grade list

    public void push(String na, String gr) { // Push items to stack

        name[length] = na;
        grade[length] = gr;
        length++;
    }

    public void pop() { // Pop item off the stack
        if (length > 0) { // make sure stack not empty
            String temp1 = name[length - 1]; //temp vars
            String temp2 = grade[length - 1];

            length--;//deincrement

            System.out.println("Pop info: " + temp1 + ", " + temp2); // output temps
        }
        else  {// Catch case in case stack is already empty
            System.out.println("Stack is empty.");
        }
    }

    public int getLength() { // Check length of stack
        return length;
    }

    public String toString() { // Print the stack
        String temp = "Stack size: " + length + "\n";
        temp += "<Top>\n"; // formating1

        for (int i = length - 1; i >= 0; i--) { // For each item In the stack
            temp += name[i] + ", " + grade[i] + "\n"; //put name and grade into telp
        }

        temp += "<Bottom>\n";// formating 2

        return temp; //return the temp
    }
}