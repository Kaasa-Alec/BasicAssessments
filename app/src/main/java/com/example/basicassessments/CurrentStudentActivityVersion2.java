package com.example.basicassessments;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Fired: ", "line 21");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_student_recycler_view_activity);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        activityList = new ArrayList<CurrentStudentListItems>();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

        }

        for(int i = 0; i < 10; i++) {

            CurrentStudentListItems item = new CurrentStudentListItems(
                    "Student " + (i + 1), "Lunch Number: 8237"+i);

            activityList.add(item);
        }
        adapter = new CurrentStudentViewAdapter(activityList, this);

        recyclerView.setAdapter(adapter);

    }
}
