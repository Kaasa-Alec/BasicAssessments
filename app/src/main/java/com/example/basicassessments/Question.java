package com.example.basicassessments;

import android.graphics.drawable.BitmapDrawable;


/**
 * Holds attributes of a question.
 *
 * <p>Each question is has a .png file that ask the question content. The .png is displayed on a
 * screen and is marked right or wrong when by the teach, setting the answeredCorrect to either true
 * or false. Question are organized by two IDs: the subject, indicates which assessment it comes
 * from(shapes, letters, numbers, etc.), and the identity, which indicates what the question asked
 * (Circle? 13? uppercase_a? a?) this will be used to generate the report.</p>
 *
 * @author Cory Hadden
 * @version 12.1
 */

public class Question {
    /**
     * Contains a assessment tag like shapes, numbers, sounds, etc....
     */
    private String subject;

    /**
     * Contains a way to identify the question being asked, for example Circle, Rectangle, 15, 19,
     * long_A, short_U
     */
    private String identity;

    /**
     * Indicates if the question was answered correctly or not. Correct Answer == TRUE.
     */
    private boolean answeredCorrect;

    /**
     * File path to the question .png: .../res->questions->[subject]->[drawable].png.
     */
    private int drawable;

    public Question(String subject, String identity, int drawable) {
        setSubject(subject);
        setIdentity(identity);
        this.answeredCorrect = false;
        this.drawable = drawable;

    }

    public Question() {
        this.subject = "unassigned";
        this.identity = "unassigned";
        this.answeredCorrect = false;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) { //TODO validate data.
        this.subject = subject;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) { //TODO validate data.
        this.identity = identity;
    }

    public boolean isAnsweredCorrect() {
        return answeredCorrect;
    }

    public void setAnsweredCorrect(boolean answeredCorrect) {
        this.answeredCorrect = answeredCorrect;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }


}


