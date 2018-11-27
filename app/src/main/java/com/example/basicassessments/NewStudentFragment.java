package com.example.basicassessments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewStudentFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "NewStudentFrag";
    private EditText StudentName;
    private EditText StudentID;
    private Button button_save;
    private Button button_cancel;

    public NewStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_student, container, false);

        StudentName = view.findViewById(R.id.student_name);
        StudentID = view.findViewById(R.id.student_id);

        button_save = view.findViewById(R.id.button_save);

        button_save.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        int studentID = Integer.parseInt(StudentID.getText().toString());

        String studentName = StudentName.getText().toString();

        Student student = new Student();
        student.setId(studentID);
        student.setName(studentName);

        newStudentActivity.myAppDatabase.myDao().addName(student);
        Log.i(TAG,"New Student added.");
        Toast.makeText(getActivity(), "Student added successfully", Toast.LENGTH_SHORT).show();


        StudentName.setText("");
        StudentID.setText("");

    }
}
