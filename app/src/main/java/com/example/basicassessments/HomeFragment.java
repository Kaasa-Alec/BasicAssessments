package com.example.basicassessments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button BtnNewStudent;
    private Button BtnCurrentStudents;
    private Button BtnDeleteStudent;

    public HomeFragment() {
        // Required empty public constructor
    }

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

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_new_student:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new NewStudentFragment()).addToBackStack(null).commit();

                break;

            case R.id.btn_current_students:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new ReadStudentFragment()).addToBackStack(null).commit();

                break;

            case R.id.btn_delete_student:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new DeleteStudentFragment()).addToBackStack(null).commit();

                break;

        }

    }
}
