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

    @ColumnInfo(name = "q1_shape_report")
    private String q1ShapeReport;
//
//    @ColumnInfo(name = "q1_letter_report")
//    private String q1LetterReport;
//
//    @ColumnInfo(name = "q1_number_report")
//    private String q1NumberReport;
//
//    @ColumnInfo(name = "q1_sound_report")
//    private String q1SoundReport;
//
//    @ColumnInfo(name = "q1_count_report")
//    private String q1CountReport;
//
//    @ColumnInfo(name = "q2_shape_report")
//    private String q2ShapeReport;
//
//    @ColumnInfo(name = "q2_letter_report")
//    private String q2LetterReport;
//
//    @ColumnInfo(name = "q2_number_report")
//    private String q2NumberReport;
//
//    @ColumnInfo(name = "q2_sound_report")
//    private String q2SoundReport;
//
//    @ColumnInfo(name = "q2_count_report")
//    private String q2CountReport;
//
//    @ColumnInfo(name = "q3_shape_report")
//    private String q3ShapeReport;
//
//    @ColumnInfo(name = "q3_letter_report")
//    private String q3LetterReport;
//
//    @ColumnInfo(name = "q3_number_report")
//    private String q3NumberReport;
//
//    @ColumnInfo(name = "q3_sound_report")
//    private String q3SoundReport;
//
//    @ColumnInfo(name = "q3_count_report")
//    private String q3CountReport;
//
//    @ColumnInfo(name = "q4_shape_report")
//    private String q4ShapeReport;
//
//    @ColumnInfo(name = "q4_letter_report")
//    private String q4LetterReport;
//
//    @ColumnInfo(name = "q4_number_report")
//    private String q4NumberReport;
//
//    @ColumnInfo(name = "q4_sound_report")
//    private String q4SoundReport;
//
//    @ColumnInfo(name = "q4_count_report")
//    private String q4CountReport;




    public int getId() {
        return id;
    }

    //TODO connect to QuarterTable as a one to many relationship

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

    public String getQ1ShapeReport() {
        return q1ShapeReport;
    }

    public void setQ1ShapeReport(String q1ShapeReport) {
        this.q1ShapeReport = q1ShapeReport;
    }
//
//    public String getQ1LetterReport() {
//        return q1LetterReport;
//    }
//
//    public void setQ1LetterReport(String q1LetterReport) {
//        this.q1LetterReport = q1LetterReport;
//    }
//
//    public String getQ1NumberReport() {
//        return q1NumberReport;
//    }
//
//    public void setQ1NumberReport(String q1NumberReport) {
//        this.q1NumberReport = q1NumberReport;
//    }
//
//    public String getQ1SoundReport() {
//        return q1SoundReport;
//    }
//
//    public void setQ1SoundReport(String q1SoundReport) {
//        this.q1SoundReport = q1SoundReport;
//    }
//
//    public String getQ1CountReport() {
//        return q1CountReport;
//    }
//
//    public void setQ1CountReport(String q1CountReport) {
//        this.q1CountReport = q1CountReport;
//    }
//
//    public String getQ2ShapeReport() {
//        return q2ShapeReport;
//    }
//
//    public void setQ2ShapeReport(String q2ShapeReport) {
//        this.q2ShapeReport = q2ShapeReport;
//    }
//
//    public String getQ2LetterReport() {
//        return q2LetterReport;
//    }
//
//    public void setQ2LetterReport(String q2LetterReport) {
//        this.q2LetterReport = q2LetterReport;
//    }
//
//    public String getQ2NumberReport() {
//        return q2NumberReport;
//    }
//
//    public void setQ2NumberReport(String q2NumberReport) {
//        this.q2NumberReport = q2NumberReport;
//    }
//
//    public String getQ2SoundReport() {
//        return q2SoundReport;
//    }
//
//    public void setQ2SoundReport(String q2SoundReport) {
//        this.q2SoundReport = q2SoundReport;
//    }
//
//    public String getQ2CountReport() {
//        return q2CountReport;
//    }
//
//    public void setQ2CountReport(String q2CountReport) {
//        this.q2CountReport = q2CountReport;
//    }
//
//    public String getQ3ShapeReport() {
//        return q3ShapeReport;
//    }
//
//    public void setQ3ShapeReport(String q3ShapeReport) {
//        this.q3ShapeReport = q3ShapeReport;
//    }
//
//    public String getQ3LettereReport() {
//        return q3LettereReport;
//    }
//
//    public void setQ3LettereReport(String q3LettereReport) {
//        this.q3LettereReport = q3LettereReport;
//    }
//
//    public String getQ3NumberReport() {
//        return q3NumberReport;
//    }
//
//    public void setQ3NumberReport(String q3NumberReport) {
//        this.q3NumberReport = q3NumberReport;
//    }
//
//    public String getQ3SoundReport() {
//        return q3SoundReport;
//    }
//
//    public void setQ3SoundReport(String q3SoundReport) {
//        this.q3SoundReport = q3SoundReport;
//    }
//
//    public String getQ3CountReport() {
//        return q3CountReport;
//    }
//
//    public void setQ3CountReport(String q3CountReport) {
//        this.q3CountReport = q3CountReport;
//    }
//
//    public String getQ4ShapeReport() {
//        return q4ShapeReport;
//    }
//
//    public void setQ4ShapeReport(String q4ShapeReport) {
//        this.q4ShapeReport = q4ShapeReport;
//    }
//
//    public String getQ4LetterReport() {
//        return q4LetterReport;
//    }
//
//    public void setQ4LetterReport(String q4LetterReport) {
//        this.q4LetterReport = q4LetterReport;
//    }
//
//    public String getQ4NumberReport() {
//        return q4NumberReport;
//    }
//
//    public void setQ4NumberReport(String q4NumberReport) {
//        this.q4NumberReport = q4NumberReport;
//    }
//
//    public String getQ4SoundReport() {
//        return q4SoundReport;
//    }
//
//    public void setQ4SoundReport(String q4SoundReport) {
//        this.q4SoundReport = q4SoundReport;
//    }
//
//    public String getQ4CountReport() {
//        return q4CountReport;
//    }
//
//    public void setQ4CountReport(String q4CountReport) {
//        this.q4CountReport = q4CountReport;
//    }
}
