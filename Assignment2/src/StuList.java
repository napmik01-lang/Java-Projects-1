

/*
 * CS 311 - Data Structures
 * Assignment 2
 *
 * File: StuList.java
 * Author: Noah Kimpan
 */

public class StuList {
    private final int MAX = 100;

    private String[] name;
    private double[] average;
    private int length;


    public StuList() { // Constructor
        length = 0;
        name = new String[MAX];
        average = new double[MAX];
    }

    // Checks if the list is full
    public boolean IsFull() {
        return length == MAX;
    }

    // Inserts a student's name and average
    public void Insert(String na, double avg) {
        if (!IsFull()) {
            name[length] = na;
            average[length] = avg;
            length++;
        }
    }

    // Prints the list
    public void Print() {
        for (int i = 0; i < length; i++) {
            System.out.printf("%-25s %.1f%n", name[i], average[i]);
        }
    }

    // Sorts alphabetically by student name  using selection sort
    //
    public void SortName() {
        String tempName;
        double tempAverage;
        int minIndex;

        for (int passCount = 0; passCount < length - 1; passCount++) {
            minIndex = passCount;

            for (int k = passCount + 1; k < length; k++) {
                if (name[k].compareToIgnoreCase(name[minIndex]) < 0) {
                    minIndex = k;
                }
            }

            // Swap names
            tempName = name[minIndex];
            name[minIndex] = name[passCount];
            name[passCount] = tempName;

            // Swap corresponding avgs
            tempAverage = average[minIndex];
            average[minIndex] = average[passCount];
            average[passCount] = tempAverage;
        }
    }


    public void SortAverage() { // Sorts by average in descending order

        String tempName;
        double tempAverage;
        int maxIndex;

        for (int passCount = 0; passCount < length - 1; passCount++) {
            maxIndex = passCount;

            for (int k = passCount + 1; k < length; k++) {
                if (average[k] > average[maxIndex]) {
                    maxIndex = k;
                }
            }

            // Swap averages
            tempAverage = average[maxIndex];
            average[maxIndex] = average[passCount];
            average[passCount] = tempAverage;

            // Swap corresponding names
            tempName = name[maxIndex];
            name[maxIndex] = name[passCount];
            name[passCount] = tempName;
        }
    }
}

