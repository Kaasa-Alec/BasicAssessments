package com.example.basicassessments;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Defines the students table.
 *
 * <p>Set lunch number to primary key and student names as a column</p>
 *
 * @author Alec Kaasa
 * @version 11.28
 */
@Entity(tableName = "students")
public class Student {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "student_name")
    private String name;

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
