package com.example.basicassessments;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

/**
 * Defines the students table.
 *
 * <p>Set lunch number to primary key and student names as a column</p>
 *
 * @author Alec Kaasa
 * @version 12.1
 */
@Entity(tableName = "students")
public class Student {

    @PrimaryKey
    private int id;

    public Student() {
        setName("*slave labor*");
    }

    @ColumnInfo(name = "student_name")
    private String name;

    /**
     * Holds all quarters and their assessments.
     */
    @ColumnInfo(name = "student_quarters")
    private ArrayList<Quarter> quarters = new ArrayList<>();

    /**
     * Non-Default constructor that takes a lunch id and student name and populates all their
     * quarters.
     *
     * @param id Lunch number of student.
     * @param name Student name.
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;

        Quarter q0 = new Quarter();
        Quarter q1 = new Quarter();
        Quarter q2 = new Quarter();
        Quarter q3 = new Quarter();

        quarters.add(q0);
        quarters.add(q1);
        quarters.add(q2);
        quarters.add(q3);
    }


    // ID Get/Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Student Name Get/Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
