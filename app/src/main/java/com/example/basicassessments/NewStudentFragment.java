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
 * A view to create new {@link Student}s.
 *
 * <p>A simple {@link Fragment} subclass.</p>
 *
 * <h2>User Interaction</h2>
 *
 * <p>Teacher adds a {@link Student} name and lunch number in separate text fields and a submit button that
 * allows that information to create a new row in the database</p>
 *
 * @author Alec Kaasa
 * @version 11.28
 */
public class NewStudentFragment extends Fragment {

    /**
     * Access to the UI text field for Student Name.
     */
    private EditText StudentName;

    /**
     * Access to the UI text field for Student ID.
     */
    private EditText StudentID;

    /**
     * Access ti the UI save button
     */
    private Button BtnSave;


    /**
     * This is a required empty constructor for the fragment
     *
     * <p>This constructor remains empty.</p>
     */
    public NewStudentFragment() {
        // Required empty public constructor
    }


    /**
     * Displays the fragment view.
     *
     * <p>Apparently fragments must be inflated to be visible. This methods handle the inflation of
     * the view.</p>
     *
     * <p>Also, links UI elements values to members values and defines an event listener to the save
     * button</p>
     *
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
        View view = inflater.inflate(R.layout.fragment_new_student, container, false);

        StudentName = view.findViewById(R.id.student_name);
        StudentID = view.findViewById(R.id.student_id);

        BtnSave = view.findViewById(R.id.button_save);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            /**
             * Event lister to save {@link Student} to the the database.
             *
             * <p>Converts text field values to strings. Construct {@link Student} with those
             * strings. Calls the {@link MyDao} andName(Student) method to add Student to the
             * database.</p>
             *
             * @param view Access to the view.
             */
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
