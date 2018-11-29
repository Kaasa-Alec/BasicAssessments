package com.example.basicassessments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_menu);
    }
}
