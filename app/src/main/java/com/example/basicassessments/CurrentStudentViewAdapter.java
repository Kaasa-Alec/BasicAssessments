package com.example.basicassessments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        CurrentStudentListItems listItem = listItems.get(position);

        viewHolder.textViewHeading.setText(listItem.getStudentName());
        viewHolder.textViewLunchNumber.setText(listItem.getLunchNumber());
        Log.i(TAG, "OnBindViewHolder() out.");
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount() in/out.");
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewHeading;
        public TextView textViewLunchNumber;
        private String TAG2= "CurrentStudentViewAdapter/ViewHolder";


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG2, "ViewHolder() in.");
            textViewHeading = (TextView) itemView.findViewById(R.id.text_view_student);
            textViewLunchNumber = (TextView) itemView.findViewById(R.id.text_view_lunch_number);
            Log.i(TAG2, "ViewHolder() out.");
        }
    }
}

