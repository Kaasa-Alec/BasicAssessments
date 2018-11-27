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
public class DeleteStudentFragment extends Fragment {

    private EditText TxtStudentId;
    private Button DeleteButton;


    public DeleteStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_student, container, false);

        TxtStudentId = view.findViewById(R.id.student_id);
        DeleteButton = view.findViewById(R.id.button_delete);

        DeleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(TxtStudentId.getText().toString());
                Student student = new Student();
                student.setId(id);
                MainActivity.myAppDatabase.myDao().deleteStudent(student);

                Toast.makeText(getActivity(),"Student successfully removed.",
                        Toast.LENGTH_SHORT).show();

                TxtStudentId.setText("");
            }


        });

        return view;
    }

}
