package com.example.basicassessments;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class currentStudentsActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    public static MyAppDatabase myAppDatabase;


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
