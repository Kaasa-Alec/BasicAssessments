package com.example.basicassessments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class CurrentStudentActivityVersion2 extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<CurrentStudentListItems> activityList;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Fired: ", "line 21");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_student_recycler_view_activity);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        activityList = new ArrayList<>();

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"studentdb").allowMainThreadQueries().build();

        List<Student> students = students = MainActivity.myAppDatabase.myDao().getStudents();

        for(Student i : students)
        {
            String id= ""+i.getId();
            String name = i.getName();

            CurrentStudentListItems nStudent = new CurrentStudentListItems(name,id);
            activityList.add(nStudent);

            adapter = new CurrentStudentViewAdapter(activityList, this);

            recyclerView.setAdapter(adapter);


        }
    }
}
