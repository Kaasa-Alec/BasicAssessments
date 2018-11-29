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
 * Screen to delete student from {@link MyDao} database.
 *
 * <p>A simple {@link Fragment} subclass.</p>
 *
 * <h2>User Interaction</h2>
 *
 * <p>Teachers enter a lunch number in the text field and a delete button deletes the {@link MyDao}
 * database row at that key</p>
 *
 * @author Alec Kaasa
 * @version 11.28
 */
public class DeleteStudentFragment extends Fragment {

    /**
     * Holds student lunch number.
     */
    private EditText TxtStudentId;

    /**
     * Access the UI button Delete
     */
    private Button BtnDelete;


    /**
     * This is a required empty constructor for the fragment
     *
     * <p>This constructor remains empty.</p>
     */
    public DeleteStudentFragment() {
        // Required empty public constructor
    }

    /**
     * Displays the fragment view.
     *
     * <p>Apparently fragments must be inflated to be visible. This methods handle the inflation of
     * the view.</p>
     *
     * <p>Also, links UI elements values to members values</p>
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
        View view = inflater.inflate(R.layout.fragment_delete_student, container, false);

        TxtStudentId = view.findViewById(R.id.student_id);
        BtnDelete = view.findViewById(R.id.button_delete);

        BtnDelete.setOnClickListener(new View.OnClickListener() {

            /**
             * Converts text field values to Student and removes any matching Students from the
             * database.
             *
             * <p>Converts value from UI student number text field to string. Constructs a Student
             * and calls the {@link MyDao} delete method with that student. If matching Student is
             * found, it is removed from the database.</p>
             *
             * @param view Inflated fragment view.
             */
            @Override
            public void onClick(View view) {

                try {

                    int id = Integer.parseInt(TxtStudentId.getText().toString());
                    Student student = new Student();
                    student.setId(id);
                    MainActivity.myAppDatabase.myDao().deleteStudent(student);

                    Toast.makeText(getActivity(), "Student successfully removed.",
                            Toast.LENGTH_SHORT).show();

                    TxtStudentId.setText("");

                } catch (Exception e) {

                    Toast.makeText(getActivity(), "That lunch number does not exist.", Toast.LENGTH_SHORT).show();
                    TxtStudentId.setText("");
                }
            }


        });

        return view;
    }

}
