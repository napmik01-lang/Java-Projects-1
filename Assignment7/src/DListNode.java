/*
 * Assignment: LAB 2 - Doubly Linked List
 * Class: CS 311 - Data Structures
 * Author: Noah Kimpan
 * Due Date: 11/15/2026
 *
 * Objective:
 * Create a doubly linked node that stores a student's
 * full name and grade. Each node contains references
 * to the next and previous nodes in the list.
 */


public class DListNode {
    private String name;
    private String grade;
    private DListNode next;
    private DListNode back;

    // Set the student's full name
    public void setName(String name) {
        this.name = name;
    }

    // Set the student's grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Set the next node
    public void setNext(DListNode next) {
        this.next = next;
    }

    // Set the previous node
    public void setBack(DListNode back) {
        this.back = back;
    }

    // Return the student's name
    public String getName() {
        return name;
    }

    // Return the student's grade
    public String getGrade() {
        return grade;
    }

    // Return the next node
    public DListNode getNext() {
        return next;
    }

    // Return the previous node
    public DListNode getBack() {
        return back;
    }
}