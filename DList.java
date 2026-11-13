/*
 * Assignment: LAB 2 - Doubly Linked List
 * Class: CS 311 - Data Structures
 * Author: Noah Kimpan
 * Due Date: 11/15/2026
 *
 * Objective:
 * Implement a doubly linked list of student records.
 * The list supports insertion at the front and end,
 * searching, removing records, printing, and counting.
 */



public class DList {
    private DListNode head;
    private DListNode end;
    private int size;

    // Constructor
    public DList() {
        head = null;
        end = null;
        size = 0;
    }

    // Insert a student at the front of the list
    public void insertFront(String name, String grade) {
        DListNode temp = new DListNode();

        temp.setName(name);
        temp.setGrade(grade);

        temp.setNext(head);
        temp.setBack(null);

        if (head != null) {
            head.setBack(temp);
        }
        else {
            end = temp;
        }

        head = temp;
        size++;
    }

    // Insert a student at the end of the list
    public void insertEnd(String name, String grade) {
        DListNode temp = new DListNode();

        temp.setName(name);
        temp.setGrade(grade);

        temp.setNext(null);
        temp.setBack(end);

        if (end != null) {
            end.setNext(temp);
        }
        else {
            head = temp;
        }

        end = temp;
        size++;
    }

    // Search for a student by full name
    public DListNode search(String name) {
        DListNode current = head;

        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                return current;
            }

            current = current.getNext();
        }

        return null;
    }

    // Remove a student based on full name
    public boolean remove(String name) {
        DListNode current = search(name);

        if (current == null) {
            return false;
        }

        if (current == head) {
            head = current.getNext();
        }
        else {
            current.getBack().setNext(current.getNext());
        }

        if (current == end) {
            end = current.getBack();
        }
        else {
            current.getNext().setBack(current.getBack());
        }

        size--;

        if (size == 0) {
            head = null;
            end = null;
        }

        return true;
    }

    // Remove the front node
    public boolean removeFront() {
        if (head == null) {
            return false;
        }

        head = head.getNext();
        size--;

        if (head == null) {
            end = null;
        }
        else {
            head.setBack(null);
        }

        return true;
    }

    // Remove the end node
    public boolean removeEnd() {
        if (end == null) {
            return false;
        }

        end = end.getBack();
        size--;

        if (end == null) {
            head = null;
        }
        else {
            end.setNext(null);
        }

        return true;
    }

    // Print the list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.printf("%-30s %-10s%n", "Student Name", "Grade");
        System.out.println("------------------------------------------");

        DListNode current = head;

        while (current != null) {
            if (current == head) {
                System.out.print("FRONT -> ");
            }
            else {
                System.out.print("         ");
            }

            System.out.printf("%-30s %-10s",
                    current.getName(), current.getGrade());

            if (current == end) {
                System.out.print(" <- END");
            }

            System.out.println();

            current = current.getNext();
        }
    }

    // Return the number of nodes
    public int getSize() {
        return size;
    }
}