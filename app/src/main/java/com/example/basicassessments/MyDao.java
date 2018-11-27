package com.example.basicassessments;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addName(Student student);

    @Query("select * from students")
    public List<Student> getStudents();

    @Delete
    public void deleteStudent(Student student);



}
