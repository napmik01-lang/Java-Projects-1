package Chapter_4;

/*
 * CS 311 - Data Structures
 * Assignment 3 - Part 1
 *
 * File: StuNode.java
 * Author: Noah Kimpan
 * Due Date: 10/13/2026
 *
 * Objective:
 * Create a linked-list node that stores a student's
 * name, grade, and link to the next node.
 * This code was provided in the assignment
 */

public class StuNode {
    private String name;
    private String grade;
    private StuNode link;
    public void setName(String na)
    {	name = na;	}
    public void setGrade(String gr)
    {	grade = gr;	}
    public void setLink(StuNode li)
    {	link = li;	}
    public String getName()
    {	return name;	}
    public String getGrade()
    {	return grade;	}
    public StuNode getLink()
    {	return link;	}
}
