package com.example.basicassessments;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the reusable view for most of the tests.
 *
 *  <p>This view will display the shape, letters, numbers, & sounds assessments</p>
 *
 *  <h2>User Interaction</h2>
 *
 *  <p>The image viewer displays a series of images that include a test question. uppercase_a teacher reads
 *  the question to the child. If he or she answers correctly, the teacher presses the check mark
 *  button and the appropriate value is stored in the program. If the child answers wrong an 'X'
 *  button is pressed and the appropriate value is stored. The values stored are used later to
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
    int currentQuestion = 0;
    private TextView questionCount;
    private TextView carrotTrailHeader;
    private ImageView questionImage;
    private Quarter quarter = new Quarter();
    private Assessment assessment = quarter.getShapeAssessment();
    private Question question;
    private ArrayList<Question> answeredQuestions = new ArrayList<>();

    private Button nextBtn;

    //TODO store right or wrong.
    public Boolean answer = false;


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


        Log.i(TAG, "Line 54 Fired with : " + assessmentSelection);

        assessment = quarter.getAssessment(assessmentSelection);
        question = assessment.getQuestions().get(currentQuestion);
        Log.i(TAG, question.getIdentity());
        questionImage = findViewById(R.id.question_image);
        setImage();//temp


        for (Question qs : assessment.getQuestions()) {
            Log.i(TAG, qs.getIdentity());
        }
        //TODO add for every question in assessment askQuestion loop when askQuestion is stable.
        //TODO add next button event listener
        nextBtn = findViewById(R.id.btn_next);

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                answeredQuestions.add(question);

                if ((currentQuestion + 1) < assessment.getQuestions().size()) {
                    Log.i(TAG, "Current: " + currentQuestion + ", Size: " + assessment.getQuestions().size());
                    currentQuestion++;
                    question = assessment.getQuestions().get(currentQuestion);
                    setImage();
                } else {
                    Log.i(TAG, "Assessment Finished");
                    Toast t = Toast.makeText(getApplicationContext(), "Assessment Finished", Toast.LENGTH_LONG);
                    t.show();
                    //assessment.setQuestions(answeredQuestions);
                }

                String q = "";
                int count = 0;
                Log.i(TAG, "Question: subject: " + question.getSubject() + ", ID: " + question.getIdentity());
                for (Question qs : answeredQuestions) {
                    count++;
                    q = count + ". 1d: " + qs.getIdentity() + ", isCorrect: " + qs.isAnsweredCorrect();
                }
                Log.i(TAG, "Answered questions: " + q);
            }
        });

        // Check box listener for correct answer
        FloatingActionButton checkBox = findViewById(R.id.box_correct);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setAnsweredCorrect(true);
            }
        });

        // X box listener for incorrect answer
        FloatingActionButton xBox = findViewById(R.id.box_correct);
        xBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setAnsweredCorrect(false);
            }
        });
    }


    private void askQuestion() {
        setQuestionCount();//unstable
        setImage();

        //TODO advance question to the next assessment index.
    }

    private void setImage() {
        //TODO set interface image to filename with following method
        Log.i(TAG, "setImage in");
        questionImage.setImageResource(question.getDrawable());
    }

    private void setQuestionCount() {
        questionCount.findViewById(R.id.question_count);
        int totCount = assessment.getQuestions().size();
        int currentCount = (assessment.getQuestions().indexOf(question) + 1);
        //TODO unstable

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