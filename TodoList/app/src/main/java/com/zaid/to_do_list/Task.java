package com.zaid.to_do_list;

public class Task {
    private int id;
    private String taskName;
    private boolean completed;

    public Task(int id, String taskName, String completed)
    {
        this.id = id;
        this.taskName = taskName;
        this.taskName = completed;
    }

    public int getId(){return id;}
    public void setId(int id) {this.id = id; }
    public String getTaskName() {return taskName;}
    public boolean isCompleted(){return completed;}
    public void setTaskName(String taskName){this.taskName = taskName;}

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }
}
