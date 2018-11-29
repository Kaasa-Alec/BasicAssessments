package com.example.basicassessments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Reads database
 *
 * <p>A simple {@link Fragment} subclass.</p>
 *
 * @author Alec Kaasa
 * @version 11.28
 */
public class ReadStudentFragment extends Fragment {

    /**
     * Access to the UI text area.
     */
    private TextView TxtInfo;

    /**
     * This is a required empty constructor for the fragment
     *
     * <p>This constructor remains empty.</p>
     */
    public ReadStudentFragment() {
        // Required empty public constructor
    }

    /**
     * Displays the fragment view.
     *
     * <p>Apparently fragments must be inflated to be visible. This methods handle the inflation of
     * the view.</p>
     *
     * <p>Also, links UI elements values to members values and reads the database into
     * local list that sent to the UI text area.</p>
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
        View view = inflater.inflate(R.layout.fragment_read_student, container, false);

        TxtInfo = view.findViewById(R.id.txt_display_info);

        List<Student> students = MainActivity.myAppDatabase.myDao().getStudents();

        String info = "";

        for(Student i : students)
        {
            int id = i.getId();
            String name = i.getName();

            info = info + "Name : " + name + "\nID : " + id + "\n\n";
        }

        TxtInfo.setText(info);

        return view;
    }

}
