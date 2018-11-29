package com.example.basicassessments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This is the reusable view for most of the tests.
 *
 *  <p>This view will display the shape, letters, numbers, & sounds assessments</p>
 *
 *  <h2>User Interaction</h2>
 *
 *  <p>The image viewer displays a series of images that include a test question. A teacher reads
 *  the question to the child. If he or she answers correctly, the teach presses the a check mark
 *  button and at the appropriate value is stored in the program. If the child answers wrong an 'X'
 *  button is pressed and the appropriate value is stored. The values stored is used later to
 *  generate student reports</p>
 *
 *  <p>
 *      More documentation to come.
 *  </p>
 *
 *  @author Cory Hadden & Alec Kaasa
 *  @version 11.28
 */
public class AssessmentActivity extends AppCompatActivity {

    /**
     * Creates the Assessment activity view.
     *
     * <p>Contains additional logic to produce the Assessment activity</p>
     *
     * @param savedInstanceState Contains the state of the view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
    }

}