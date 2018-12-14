package com.example.basicassessments;

import android.util.Log;

public class CurrentStudentListItems {
    private String studentName;
    private String lunchNumber;
    private String TAG = "CurrentStudentListItems";

    public CurrentStudentListItems(String studentName, String lunchNumber) {
        Log.i(TAG, "CurrentStudentListItem() in");
        setStudentName(studentName);
        setLunchNumber(lunchNumber);
        Log.i(TAG, "CurrentStudentListItem() out");
    }

    public String getStudentName() {
        Log.i(TAG, "getStudentName() ping");
        return studentName;
    }

    public void setStudentName(String heading) {
        Log.i(TAG, "setStudentName() ping");
        this.studentName = heading;
    }

    public String getLunchNumber() {
        Log.i(TAG, "getLunchNumber() ping");
        return lunchNumber;
    }

    public void setLunchNumber(String lunchNumber) {
        Log.i(TAG, "setLunchNumber() ping");
        this.lunchNumber = lunchNumber;
    }
}


