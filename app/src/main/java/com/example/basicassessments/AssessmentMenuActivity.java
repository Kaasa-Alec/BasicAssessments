package com.example.basicassessments;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private String quarterSelection = "q1";
    private String assessmentSelection = "shapes";
    private Button shapeBtn;
    private Button letterBtn;
    private Button numberBtn;
    private Button soundBtn;
    private Button countBtn;
    private Button startBtn;
    private TabItem q1;
    private TabItem q2;
    private TabItem q3;
    private TabItem q4;
    private TextView studentNameHeader;
    private TextView carrotTrailHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_menu);
        getIncomingIntent();

        shapeBtn = findViewById(R.id.shapes);
        letterBtn = findViewById(R.id.letters);
        numberBtn = findViewById(R.id.numbers);
        soundBtn = findViewById(R.id.sounds);
        countBtn = findViewById(R.id.count);
        startBtn = findViewById(R.id.startbtn);
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);

        shapeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                assessmentSelection = "shapes";
                Log.i(TAG, "Assessment selected: " + assessmentSelection);
        }});

        letterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                assessmentSelection = "letters";
                Log.i(TAG, "Assessment selected: " + assessmentSelection);
            }});

        numberBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                assessmentSelection = "numbers";
                Log.i(TAG, "Assessment selected: " + assessmentSelection);
            }});

        soundBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                assessmentSelection = "sounds";
                Log.i(TAG, "Assessment selected: " + assessmentSelection);
            }});

        countBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                assessmentSelection = "count";
                Log.i(TAG, "Assessment selected: " + assessmentSelection);
            }});

        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Start selected");
                Intent i =new Intent(AssessmentMenuActivity.this, AssessmentActivity.class);
                i.putExtra("name",studentName);
                i.putExtra("id", id);
                i.putExtra("assessmentSelection", assessmentSelection);
                i.putExtra("quarterSelection", quarterSelection);
                startActivity(i);
            }});

        //TODO figure out how to make these selectors work.
//        q1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                quarterSelection = "q1";
//                Log.i(TAG, "Quarter selected: " + quarterSelection);
//            }});
//
//        q2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                quarterSelection = "q2";
//                Log.i(TAG, "Quarter selected: " + quarterSelection);
//            }});
//
//        q3.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                quarterSelection = "q3";
//                Log.i(TAG, "Quarter selected: " + quarterSelection);
//            }});
//
//        q4.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                quarterSelection = "q4";
//                Log.i(TAG, "Quarter selected: " + quarterSelection);
//            }});

    }


    private void getIncomingIntent(){
        Log.i(TAG, "getIncomingIntent in");

        if(getIntent().hasExtra("name") && getIntent().hasExtra("id")){
            Log.i(TAG, "Extras found");

            studentName = getIntent().getStringExtra("name");
            Log.i(TAG, "Student Name: "+ studentName);

            studentNameHeader = findViewById(R.id.student_name_header);
            carrotTrailHeader = findViewById(R.id.carrot_trail);

            id = getIntent().getStringExtra("id");
            studentNameHeader.setText(studentName);
            Log.i(TAG, "Student ID: "+ id);

            carrotTrailHeader.setText(getString(R.string.carrot_trail)+id);
        }


    }
}

