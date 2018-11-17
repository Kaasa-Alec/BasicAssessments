package com.example.basicassessments;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface MyDao {

    @Insert
    public void addName(Student student);




}
