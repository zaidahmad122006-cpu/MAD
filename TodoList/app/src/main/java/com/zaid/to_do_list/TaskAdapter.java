package com.zaid.to_do_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final ArrayList<Task> taskList;
    private final OnTaskActionListener listener;


    public interface OnTaskActionListener
    {
        void onTaskDelete(int position);
        void onTaskStatusChange(int position, boolean isCompleted);
        void onTaskAdit(int position);
    }

    public TaskAdapter(ArrayList<Task> taskList, OnTaskActionListener listener) {
        this.taskList = taskList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_items, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);

        holder.checkBoxTask.setOnCheckedChangeListener(null);
        holder.checkBoxTask.setText(task.getTaskName());
        holder.checkBoxTask.setChecked(task.isCompleted());

        holder.checkBoxTask.setOnCheckedChangeListener((buttonview,  ));
        if (listener != null)
        {
            boolean isChecked = false;
            listener.onTaskStatusChange(position,isChecked);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public CompoundButton checkBoxTask;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
