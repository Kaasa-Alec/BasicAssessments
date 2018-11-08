package com.example.basicassessments;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    String input = "Bugs Bunny";

    int scoreInput = 6;

    String question = "Can I have something to eat?";


    @Test
    public void addition_isCorrect() { assertEquals(4, 2 + 2); }

    @Test
    public void addStudentTest() { assertEquals("Bugs Bunny", input); }

    @Test
    public void checkScoreTest() { assertTrue(scoreInput >= 0 && scoreInput < 10); }

    @Test
    public void checkQuestionIsString() { assertTrue(question instanceof String); }

}