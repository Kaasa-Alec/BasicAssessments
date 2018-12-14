package com.example.basicassessments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CurrentStudentViewAdapter extends RecyclerView.Adapter<CurrentStudentViewAdapter.ViewHolder> {
    private String TAG= "CurrentStudentViewAdapter";

    public CurrentStudentViewAdapter(List<CurrentStudentListItems> listItems, Context context) {
        Log.i(TAG, "CurrentStudentViewAdapter() in.");
        this.listItems = listItems;
        this.context = context;
        Log.i(TAG, "CurrentStudentViewAdapter() out.");
    }

    private List<CurrentStudentListItems> listItems;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Log.i(TAG, "OnCreateViewHolder() in.");
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.current_student_list_items, parent, false);
        Log.i(TAG, "OnCreateViewHolder() out.");
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.i(TAG, "OnBindViewHolder() in.");
        final CurrentStudentListItems listItem = listItems.get(position);

        viewHolder.textViewHeading.setText(listItem.getStudentName());
        viewHolder.textViewLunchNumber.setText(listItem.getLunchNumber());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, listItem.getStudentName() + " Clicked");
                Intent i = new Intent(context, AssessmentMenuActivity.class);
                i.putExtra("name",listItem.getStudentName());
                i.putExtra("id", listItem.getLunchNumber());
                context.startActivity(i);
            }
        });
        Log.i(TAG, "OnBindViewHolder() out.");
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount() in/out.");
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private String TAG2= "CurrentStudentViewAdapter/ViewHolder";
        public TextView textViewHeading;
        public TextView textViewLunchNumber;
        public LinearLayout linearLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG2, "ViewHolder() in.");
            textViewHeading = (TextView) itemView.findViewById(R.id.text_view_student);
            textViewLunchNumber = (TextView) itemView.findViewById(R.id.text_view_lunch_number);
            linearLayout = itemView.findViewById(R.id.curnt_stdnt_linear_layout);
            Log.i(TAG2, "ViewHolder() out.");
        }


    }


}

