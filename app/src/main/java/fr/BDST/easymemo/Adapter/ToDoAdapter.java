package fr.BDST.easymemo.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import fr.BDST.easymemo.AddNewTask;
import fr.BDST.easymemo.MainActivity;
import fr.BDST.easymemo.Model.ToDoModel;
import fr.BDST.easymemo.R;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {
    private List<ToDoModel> todoList;
    private MainActivity activity;
    private FirebaseFirestore firestore;

    public ToDoAdapter(MainActivity mainActivity, List<ToDoModel> todoList){
        this.todoList = todoList;
        activity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.task_layout, parent, false);
        firestore = FirebaseFirestore.getInstance();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ToDoModel toDoModel = todoList.get(position);
        holder.mCheckbox.setText(toDoModel.getTask());
        holder.mDueDateTv.setText("A faire le " + toDoModel.getDue());

        holder.mCheckbox.setChecked(toBoolean(toDoModel.getStatus()));
        holder.mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    firestore.collection("task").document(toDoModel.TaskId).update("status", 1);
                }else{
                    firestore.collection("task").document(toDoModel.TaskId).update("status", 0);
                }
            }
        });
    }

    private boolean toBoolean(int status){
        return status != 0;
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mDueDateTv;
        CheckBox mCheckbox;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            mDueDateTv = itemView.findViewById(R.id.set_due_tv);
            mCheckbox = itemView.findViewById(R.id.mcheckbox);
        }
    }
}