package com.example.basicassessments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewStudentFragment extends Fragment {

    private EditText StudentName;
    private EditText StudentID;
    private Button BtnSave;

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

        BtnSave = view.findViewById(R.id.button_save);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int studentID = Integer.parseInt(StudentID.getText().toString());

                String studentName = StudentName.getText().toString();

                Student student = new Student();
                student.setId(studentID);
                student.setName(studentName);

                MainActivity.myAppDatabase.myDao().addName(student);
                Toast.makeText(getActivity(), "Student added successfully", Toast.LENGTH_SHORT).show();

                StudentName.setText("");
                StudentID.setText("");
            }

        });

        return view;
    }

}
