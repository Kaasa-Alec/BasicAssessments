package com.example.basicassessments;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Holds the data for all the assessments and generates a report.
 *
 * <p>Each student has four quarters for the year. The quarters have five tests or assessments each.
 * Four of the assessments are instances of the Assessment class and are composed in this class with
 * the build[subject]Assessment() method (each of which is called in the constructor), and the
 * other is simply an int that stores the highest number a student can count to without messing up,
 * up to 100. This class also contains a generateReport() method which returns a PDF outlining of
 * the correct and incorrect questions</p>
 *
 * @author Cory Hadden
 * @version 12.1
 */
public class Quarter {

//    private ArrayList<Assessment> assessments;

    private String TAG = "Quarter";
    private Assessment shapeAssessment;
    private Assessment numberAssessment;
    private Assessment letterAssessment;
    private Assessment soundAssessment;
    private int highestCount;

    public Quarter() {
        shapeAssessment = buildShapeAssessment();
        numberAssessment = buildNumberAssessment();
        letterAssessment = buildLetterAssessment();
        soundAssessment = buildSoundAssessment();


    }

    public Assessment getAssessment(String type) {
        Log.i(TAG, "Line 54 Fired");
        Assessment selection = buildShapeAssessment();

        switch (type)
        {
            case "shapes":
                break;
            case "numbers":
                selection = buildNumberAssessment();
                break;
            case "letters":
                selection = buildLetterAssessment();
                break;
            case "sounds":
                selection = buildSoundAssessment();
                break;
        }

        return selection;

    }

    public Assessment getShapeAssessment() {
        return shapeAssessment;
    }

    public void setShapeAssessment(Assessment shapeAssessment) {
        this.shapeAssessment = shapeAssessment;
    }

    public Assessment getNumberAssessment() {
        return numberAssessment;
    }

    public void setNumberAssessment(Assessment numberAssessment) {
        this.numberAssessment = numberAssessment;
    }

    public Assessment getLetterAssessment() {
        return letterAssessment;
    }

    public void setLetterAssessment(Assessment letterAssessment) {
        this.letterAssessment = letterAssessment;
    }

    public Assessment getSoundAssessment() {
        return soundAssessment;
    }

    public void setSoundAssessment(Assessment soundAssessment) {
        this.soundAssessment = soundAssessment;
    }

    public int getHighestCount() {
        return highestCount;
    }

    public void setHighestCount(int highestCount) { //TODO add validation.
        this.highestCount = highestCount;
    }


//    private QuarterlyReport report;

//    public Quarter() {
//        assessments.add(buildShapeAssessment());
//        assessments.add(buildNumberAssessment());
//        assessments.add(buildLetterAssessment());
//        assessments.add(buildShapeAssessment());//TODO replace with sound assessment in.
//        setHighestCount(0);
//    }

//    public ArrayList<Assessment> getAssessments() {
//        return assessments;
//    }
//
//    public void setAssessments(ArrayList<Assessment> assessments) {
//        this.assessments = assessments;
//    }


//    public QuarterlyReport getReport() {
//        return report;
//    }
//
//    public void setReport(QuarterlyReport report) {
//        this.report = report;
//    }

//    public Quarter(ArrayList<Assessment> assessments) {
//        this.assessments = assessments;
//    }

    /**
     * Builds the shape assessment.
     *
     * <p>First build the 9 shape questions, packs them into a array, and constructs an Assessment
     * out of the array</p>
     *
     * @return a Assessment test of 9 shapes
     */
    private Assessment buildShapeAssessment(){


        int img = R.drawable.shape_square;
        Question q0 = new Question("Shapes", "Square", img);
        img = R.drawable.shape_triangle;
        Question q1 = new Question("Shapes", "Triangle", img);
        img = R.drawable.shape_circle;
        Question q2 = new Question("Shapes", "Circle", img);
        img = R.drawable.shape_rectangle;
        Question q3 = new Question("Shapes", "Rectangle", img);
        img = R.drawable.shape_hexagon;
        Question q4 = new Question("Shapes", "Hexagon", img);
        img = R.drawable.shape_sphere;
        Question q5 = new Question("Shapes", "Sphere", img);
        img = R.drawable.shape_cone;
        Question q6 = new Question("Shapes", "Cone", img);
        img = R.drawable.shape_cylinder;
        Question q7 = new Question("Shapes", "Cylinder", img);
        img = R.drawable.shape_cube;
        Question q8 = new Question("Shapes", "Cube", img);

        //Pack questions into a list.
        ArrayList<Question> questions= new ArrayList<Question>();
        questions.add(q0);
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);

        //Build Assessment.
        Assessment shapeAssessment = new Assessment(questions);
        return shapeAssessment;
    }

    /**
     * Builds the shape assessment.
     *
     * <p>Build the 20 number identification questions, packs them into a array, and constructs an
     * Assessment out of the array</p>
     *
     * @return a Assessment test of number 1-20
     */
    private Assessment buildNumberAssessment(){

        ArrayList<Question> questions= new ArrayList<Question>();

        int img = R.drawable.number_01;

        //Build questions & add to an array.
        for (int i = 0; i < 20; i++) {
            if (i != 0) {
                img++;
            }
            String countStr = Integer.toString(i); //Annoying java int to string conversion.
            Question q = new Question("Numbers", countStr, img);
            questions.add(q);
        }

        Assessment numberAssessment = new Assessment(questions);
        return numberAssessment;
    }

    /**
     * Builds the shape assessment.
     *
     * <p>Build the 52(26 uppercase and 26 lowercase) letter identification questions, packs them
     * into a array, and constructs an Assessment out of the array. This uses Ascii values as an
     * incrementing index and converts it first to a char and then string</p>
     *
     * @return a Assessment test of all uppercase and lowercase letters.
     */
    private Assessment buildLetterAssessment(){
        ArrayList<Question> questions= new ArrayList<Question>();
        Assessment letterAssessment = new Assessment(questions);

        int img = R.drawable.uppercase_a;
        int asciiCode = 65; //Set to "uppercase_a";
        for (int i = 0; i < 26; i++) { //Only capital letters in this loop.
            if (i != 0) {
                img++;
            }
            char letter = (char) asciiCode; //Annoying java int to char conversion.
            String letterStr = String.valueOf(letter); //Yet annoying java conversion.
            Question q = new Question("Letters", letterStr, img);
            questions.add(q);
            asciiCode++;//Move on to the next letter.
        }

        img = R.drawable.lowercase_a;
        asciiCode = 97; //Set to "a"
        for (int i = 0; i < 26; i++) {//Only lowercase letters in this loop.
            if (i != 0) {
                img++;
            }
            char letter = (char) asciiCode;//Annoying java int to char conversion.
            String letterStr = String.valueOf(letter);//Yet annoying java conversion.
            Question q = new Question("Letters", letterStr, img);
            questions.add(q);
            asciiCode++;//Move on to the next letter.
        }

        return letterAssessment;
    }

    private Assessment buildSoundAssessment() {
        soundAssessment = buildShapeAssessment();//TODO write buildSoundAssignment()
        return soundAssessment;
    }

    //TODO write generateReport()

}


