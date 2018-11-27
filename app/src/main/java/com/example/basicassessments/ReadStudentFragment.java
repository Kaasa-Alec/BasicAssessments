package com.example.basicassessments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadStudentFragment extends Fragment {

    private TextView TxtInfo;

    public ReadStudentFragment() {
        // Required empty public constructor
    }


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
