package com.example.basicassessments;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


/**
 * Main activity and root for fragments.
 *
 * @author Alec Kaasa
 * @version 11.28
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Obligatory fragment manager.
     */
    public static FragmentManager fragmentManager;

    /**
     * Access to the database.
     */
    public static MyAppDatabase myAppDatabase;

    /**
     * Creates the Main activity view.
     *
     * <p>Contains additional logic to produce the main activity and its dependant fragments.</p>
     *
     * @param savedInstanceState Contains the state of the view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Fired: ", "line 40");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"studentdb").allowMainThreadQueries().build();



        if(findViewById(R.id.fragment_container) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragment_container,
                    new HomeFragment()).commit();
        }



    }

    private void intention(){
        Log.i("Fired: ", "line 43");
        Intent intent = new Intent(this, CurrentStudentActivityVersion2.class);
        Log.i("Fired: ", "line 45");
        startActivity(intent);
        Log.i("Fired: ", "line 47");
    }
}

