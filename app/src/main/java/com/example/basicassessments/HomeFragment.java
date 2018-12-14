package com.example.basicassessments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Dashboard menu view for the app.
 *
 *  A simple {@link Fragment} subclass.
 *
 *  <h2>User Interaction</h2>
 *
 *  <p>3 buttons allow teachers to enter the {@link NewStudentFragment},
 *  {@link currentStudentsActivity}, or {@link DeleteStudentFragment} views</p>
 *
 * @author Alec Kaasa
 * @version 11.28
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    /**
     * Access to the UI button to enter the {@link NewStudentFragment}.
     */
    private Button BtnNewStudent;

    /**
     * Access to the UI button to enter the {@link currentStudentsActivity}.
     */
    private Button BtnCurrentStudents;

    /**
     * Access to the UI button to enter the {@link DeleteStudentFragment}.
     */
    private Button BtnDeleteStudent;

    /**
     * This is a required empty constructor for the fragment
     *
     * <p>This constructor remains empty.</p>
     */
    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        BtnNewStudent = view.findViewById(R.id.btn_new_student);
        BtnNewStudent.setOnClickListener(this);

        BtnCurrentStudents = view.findViewById(R.id.btn_current_students);
        BtnCurrentStudents.setOnClickListener(this);

        BtnDeleteStudent = view.findViewById(R.id.btn_delete_student);
        BtnDeleteStudent.setOnClickListener(this);

        return view;
    }

    /**
     * Controls UI button clicks.
     *
     * <p>Redirect the user to the {@link NewStudentFragment},
     *  *  {@link currentStudentsActivity}, or {@link DeleteStudentFragment} view when they click
     *  the respective button</p>
     *
     * @param view Access to the view.
     */
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_new_student:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new NewStudentFragment()).addToBackStack(null).commit();

                break;

            case R.id.btn_current_students:
                Intent intent = new Intent(getActivity(), CurrentStudentActivityVersion2.class);
                startActivity(intent);

                break;

            case R.id.btn_delete_student:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new DeleteStudentFragment()).addToBackStack(null).commit();

                break;

        }

    }
}
