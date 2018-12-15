package com.example.basicassessments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * uppercase_a view to create new {@link Student}s.
 *
 * <p>uppercase_a simple {@link Fragment} subclass.</p>
 *
 * <h2>User Interaction</h2>
 *
 * <p>Teacher adds a student name and lunch number in separate text fields and a submit button that
 * allows that information to create a new row in the database</p>
 *
 * @author Alec Kaasa
 * @version 11.28
 */
public class AddStudentFragment extends Fragment {

    /**
     * This is a required empty constructor for the fragment
     *
     * <p>This constructor remains empty.</p>
     */
    public AddStudentFragment() {
        // Required empty public constructor
    }

    /**
     * Displays the fragment view.
     *
     * <p>Apparently fragments must be inflated to be visible. This methods handle the inflation of
     * the view.</p>
     *
     * @param inflater I'm going to be completely honest, I have no clue what this is.
     * @param container Where the fragment is displayed.
     * @param savedInstanceState The current state of the fragment.
     * @return Inflated fragment view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }

}
