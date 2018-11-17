package com.example.basicassessments;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

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
