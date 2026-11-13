
/*
 * CS 311 - Data Structures
 * Assignment 1
 *
 * File: List.java
 * Author: Noah Kimpan
 *
 * Objective:
 * Create a List class that can store, print, sort, and search
 * a list of student names.
 *
 * The list contains < 100 students.
 */

public class List {
    private final int MAX = 100;
    private String[] info;
    private int length;

    // Constructor
    public List() {
        length = 0;
        info = new String[MAX];
    }

    // Checks if list full
    public boolean IsFull() {
        return length == MAX;
    }

    // Insert a name into list
    public void Insert(String item) {
        if (!IsFull())
        {
            info[length] = item;
            length++;
        }
    }

    // Returns the num of names in the list
    public int getLength() {
        return length;
    }

    // Prints The names in the list
    public void Print() {
        for (int i = 0; i < length; i++) {
            System.out.println(info[i]);
        }
    }

    // Sorts names alphabetically by first name, using selection sort.
    public void Sort() {
        String temp;
        int minIndex;

        for (int passCount = 0; passCount < length - 1; passCount++) {
            minIndex = passCount;

            for (int k = passCount + 1; k < length; k++) {
                if (info[k].compareToIgnoreCase(info[minIndex]) < 0) {
                    minIndex = k;
                }
            }

            temp = info[minIndex];
            info[minIndex] = info[passCount];
            info[passCount] = temp;
        }
    }

    // Searches for a name in the list.
    // not case-sensitive.
    public boolean Search(String item) {
        for (int i = 0; i < length; i++) {
            if (info[i].equalsIgnoreCase(item)) {
                return true;
            }
        }

        return false;
    }
}

