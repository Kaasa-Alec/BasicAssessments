package com.example.basicassessments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

    private String TAG = "AssessmentActivity";
    private String studentName = "";
    private String id = "";
    private String quarterSelection = "q1";
    private String assessmentSelection = "shapes";
    int idNum = 0;
    private TextView questionCount;
    private TextView carrotTrailHeader;
    private Quarter quarter;
    private Assessment assessment;
    private Question question;

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
        getIncomingIntent();

        assessment = quarter.getAssessmenrt(assessmentSelection);
        //question = assessment.getQuestions()
        //setQuestionCount();
    }

    private void setQuestionCount() {
        questionCount.findViewById(R.id.question_count);
        int totCount = assessment.getQuestions().size();
        int currentCount = assessment.getQuestions().indexOf(question);



    }

    private void getIncomingIntent(){
        Log.i(TAG, "getIncomingIntent in");

        if(getIntent().hasExtra("name") && getIntent().hasExtra("id")){
            Log.i(TAG, "Extras found");

            studentName = getIntent().getStringExtra("name");
            id = getIntent().getStringExtra("id");
            assessmentSelection = getIntent().getStringExtra("assessmentSelection");
            quarterSelection = getIntent().getStringExtra("quarterSelection");

            Log.i(TAG, "Student Name: "+ studentName);
            Log.i(TAG, "Student ID: "+ id);

            carrotTrailHeader = findViewById(R.id.carrot_trail_assessment);
            carrotTrailHeader.setText(getString(R.string.carrot_trail)+" "+id+"> "+assessmentSelection);

            idNum = Integer.parseInt(id);
            Log.i(TAG, "ID parsed as: "+idNum);
            Log.i(TAG, "getIncomingIntent out");
        }
    }
}