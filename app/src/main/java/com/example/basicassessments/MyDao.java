package com.example.basicassessments;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**?
 * Interface for database transaction methods
 *
 * <p>Interface defines the Insert, Delete, and Query database functions.</p>
 *
 * @author Alec Kaasa
 * @version 11.28
 */
@Dao
public interface MyDao {

    @Insert
    public void addName(Student student);

    @Query("select * from students")
    public List<Student> getStudents();

    @Query("select q1_shape_report from students where id = :studentId")
    public int[] getShapeReport(int studentId);

    @Delete
    public void deleteStudent(Student student);

    @Update
    void updateStudent(Student student);


    //TODO Add more queries



}
