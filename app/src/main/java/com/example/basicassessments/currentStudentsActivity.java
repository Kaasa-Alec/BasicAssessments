package com.example.basicassessments;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Displays a list of the students in the database.
 *
 * <h2>User Interaction</h2>
 *
 * <p>Teacher's can click on the names of student and it takes them to that students
 * {@link AssessmentMenuActivity} view.</p>
 *
 *  @author  Alec Kaasa & Cory Hadden
 *  @version 11.28
 */
public class currentStudentsActivity extends AppCompatActivity {
    /**
     * Obligatory fragment manager
     */
    public static FragmentManager fragmentManager;

    /**
     *
     */
    public static MyAppDatabase myAppDatabase;

    /**
     * Creates Student Activity view.
     *
     * <p>Populates student list from database.</p>
     *
     * @param savedInstanceState Contains the state of the view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_students);
        fragmentManager = getSupportFragmentManager();

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "student_db").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container) != null)
        {
            if (savedInstanceState != null)
            {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragment_container, new ReadStudentFragment()).commit();
        }

    }
}
