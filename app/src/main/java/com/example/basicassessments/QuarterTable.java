package com.example.basicassessments;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Student.class,
        parentColumns = "quarter",
        childColumns = "id",
        onDelete = CASCADE,
        onUpdate = CASCADE))
public class QuarterTable {

    @PrimaryKey
    private int quarter;

    @ColumnInfo(name = "student_id")
    private int id;

    @ColumnInfo(name = "shape_report")
    private String shapeReport;

    @ColumnInfo(name = "number_report")
    private String numberReport;

    @ColumnInfo(name = "letter_report")
    private String letterReport;

    @ColumnInfo(name = "sound_report")
    private String soundReport;

    @ColumnInfo(name = "count_report")
    private String countReport;

    @ColumnInfo(name = "full_report")
    private String fullReport;

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public String getShapeReport() {
        return shapeReport;
    }

    public void setShapeReport(String shapeReport) {
        this.shapeReport = shapeReport;
    }

    public String getNumberReport() {
        return numberReport;
    }

    public void setNumberReport(String numberReport) {
        this.numberReport = numberReport;
    }

    public String getLetterReport() {
        return letterReport;
    }

    public void setLetterReport(String letterReport) {
        this.letterReport = letterReport;
    }

    public String getSoundReport() {
        return soundReport;
    }

    public void setSoundReport(String soundReport) {
        this.soundReport = soundReport;
    }

    public String getCountReport() {
        return countReport;
    }

    public void setCountReport(String countReport) {
        this.countReport = countReport;
    }

    public String getFullReport() {
        return fullReport;
    }

    public void setFullReport(String fullReport) {
        this.fullReport = fullReport;
    }


    public QuarterTable(int quarter) {
        this.quarter = quarter;
    }
}
