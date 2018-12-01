package com.example.basicassessments;

import java.util.ArrayList;


/**
 * Individual tests a child would take as part of their quarterly assessment.
 *
 * <p>Each Assessment is built with three lists: a list of questions, a list of question missed, and a
 * list of question answered correctly. It also calculates a score as a percentage</p>
 *
 * @author Cory Hassen
 * @version 12.1
 */
public class Assessment {

    /**
     * Holds all the questions on the test.
     */
    private ArrayList<Question> questions;

    /**
     * Holds all the missed questions.
     */
    private ArrayList<Question> missedList;

    /**
     * Holds all the questions answered correctly.
     */
    private ArrayList<Question> correctList;

    /**
     * Holds a score as a percentage.
     */
    private double score;


    public Assessment(ArrayList<Question> questions) {
        this.questions = questions;
        score = 0.0;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question q){//TODO Add validation test.
        questions.add(q);
    };

    public ArrayList<Question> getMissedList() {
        return missedList;
    }

    public void setMissedList(ArrayList<Question> missedList) {
        this.missedList = missedList;
    }

    public ArrayList<Question> getCorrectList() {
        return correctList;
    }

    public void setCorrectList(ArrayList<Question> correctList) {
        this.correctList = correctList;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Calculates Score as percentage.
     *
     * <p> Formula X% = (Y*100)/X</p>
     */
    public void calculateScore(){
        int totCorrect = correctList.size(); //Calculate score.
        int totQuestions = questions.size();
        score = (totCorrect*100)/totQuestions;
    }

    /**
     * Refreshes missedList, correctList, score with most current data.
     *
     * <p>Runs through every question in the questions list and checks if it the student answered
     * correctly or not. If correct, the question is added to the correctList and checked to see if
     * it needs to be removed from the missed list just in case the assessment was already taken. If
     * wrong it is added to missedList and removed from correctList. After this, it sets the score
     * to the size correctList.</p>
     */
    public void refreshAssessmentList(){

        for (Question q:questions) { //Run through questions, sort out which are right and wrong.
            if(q.isAnsweredCorrect()) { //If right, add to correctList. If on missedList remove.
                correctList.add(q);

                if(missedList.contains(q)){
                    missedList.remove(q);
                }
            } else { //Inverse operation: If wrong, add to missedList. If on correct List remove.
                if(!q.isAnsweredCorrect()){
                    missedList.add(q);

                    if (correctList.contains(q)) {
                        correctList.remove(q);
                    }

                }

            }

        }

        calculateScore(); //Adjust the score based on new data.
    }

}
