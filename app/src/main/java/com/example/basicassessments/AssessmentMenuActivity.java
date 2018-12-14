package com.example.basicassessments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Assessment menu
 *
 * <p>This menu is based on the selection from the {@link NewStudentFragment}. For the student
 * selected, there are 4 quarter, each are selectable with the top tab bar. For each quarter there
 * are five assessments are shown. An independent start button allows teachers to enter the
 * {@link AssessmentActivity} for that assessment. This view also has a floating download button
 * that allows the teacher to download the assessment report as a PDF.</p>
 *
 * @author Cory Hadden & Alec Kaasa
 * @version 11.28
 */
public class AssessmentMenuActivity extends AppCompatActivity {

    /**
     * Creates the Assessment Menu activity view.
     *
     * <p>Contains additional logic to produce the Assessment Menu activity</p>
     *
     * @param savedInstanceState Contains the state of the view.
     */
    private String TAG = "AssessmentMenuActivity";
    private String studentName = "";
    private String id = "";
    private TextView studentNameHeader;
    private TextView carrotTrailHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_menu);
        getIncomingIntent();
    }


    private void getIncomingIntent(){
        Log.i(TAG, "getIncomingIntent in");
        if(getIntent().hasExtra("name"))// && getIntent().hasExtra("id")){
            Log.i(TAG, "Extras found");
            studentName = getIntent().getStringExtra("name");
            Log.i(TAG, "Student Name: "+ studentName);
             studentNameHeader = findViewById(R.id.student_name_header);
             carrotTrailHeader = findViewById(R.id.carrot_trail);
            id = getIntent().getStringExtra("id");
        Log.i(TAG, "Student ID: "+ studentName);
            studentNameHeader.setText(studentName);
            carrotTrailHeader.setText(getString(R.string.carrot_trail)+id);
            int idNum = Integer.parseInt(id);
            Log.i(TAG, "ID parsed as: "+idNum); 
        }
    }

