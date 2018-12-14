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
