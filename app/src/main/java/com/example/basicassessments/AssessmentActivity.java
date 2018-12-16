package com.example.basicassessments;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
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
        setQuestionCount();


        for (Question qs : assessment.getQuestions()) {
            Log.i(TAG, qs.getIdentity());
        }

        nextBtn = findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                askNextQuestion();
            }
        });

        // Check box listener for correct answer
        FloatingActionButton checkBox = findViewById(R.id.box_correct);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "check pushed");
                question.setAnsweredCorrect(true);
            }
        });

        // X box listener for incorrect answer
        FloatingActionButton xBox = findViewById(R.id.box_wrong);
        xBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "X pushed");
                question.setAnsweredCorrect(false);
            }
        });
    }


    private void askNextQuestion() {
        answeredQuestions.add(question);

        if ((currentQuestion + 1) < assessment.getQuestions().size()) {//till we reach the end
            Log.i(TAG, "Current: " + currentQuestion + ", Size: " + assessment.getQuestions().size());
            currentQuestion++;
            question = assessment.getQuestions().get(currentQuestion);
            setImage();
            setQuestionCount();
        } else {
            Log.i(TAG, "Assessment Finished");
            Toast t = Toast.makeText(getApplicationContext(), "Assessment Finished", Toast.LENGTH_LONG);
            t.show();
            assessment.setQuestions(answeredQuestions);
            Log.i(TAG, assessment.getReport());

            Student nStudent = new Student();
            idNum = Integer.parseInt(id);

            // studentName = nStudent.getName();
            // nStudent.setName(studentName);
            // nStudent.setId(idNum);

            nStudent.setQ1ShapeReport(assessment.getReport());
            MainActivity.myAppDatabase.myDao().updateStudent(nStudent);

            // Print Report in the TextView box by the assessment selection.

            // ViewPager reportString = findViewById(R.id.reportView);
            // reportString.text(nStudent.getQ1ShapeReport());
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

    private void setImage() {
        Log.i(TAG, "setImage in");
        questionImage.setImageResource(question.getDrawable());
    }

    private void setQuestionCount() {
        questionCount = findViewById(R.id.question_count);
        int totCount = assessment.getQuestions().size();
        int currentCount = (currentQuestion + 1);
        questionCount = findViewById(R.id.question_count);
        questionCount.setText("Question " + currentCount + " of " + totCount);
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

    /*private void displayReport(View v) {

        reportString = assessment.getReport();

        TextView report = findViewById(R.id.reportView);

        report.setText(reportString);

    }*/
}