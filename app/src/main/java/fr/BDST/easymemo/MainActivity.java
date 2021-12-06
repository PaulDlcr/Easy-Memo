package fr.BDST.easymemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.BDST.easymemo.Adapter.ToDoAdapter;
import fr.BDST.easymemo.Model.ToDoModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView tasksRecyclerView;
    private ToDoAdapter tasksAdapter;
    private FloatingActionButton fab;
    private FirebaseFirestore firestore;
    private List<ToDoModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        fab = findViewById(R.id.fab);
        firestore = FirebaseFirestore.getInstance();

        tasksRecyclerView.setHasFixedSize(true);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });

        taskList = new ArrayList<>();
        tasksAdapter = new ToDoAdapter(MainActivity.this, taskList);

        tasksRecyclerView.setAdapter(tasksAdapter);
    }
    private void showData(){
        firestore.collection("task").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for (DocumentChange documentChange : value.getDocumentChanges()){
                    if (documentChange.getType() == DocumentChange.Type.ADDED){
                        String id = documentChange.getDocument().getId();
                        ToDoModel toDoModel = documentChange.getDocument().toObject(ToDoModel.class).withID(id);
                        taskList.add(toDoModel);
                        tasksAdapter.notifyDataSetChanged();
                    }
                }
                Collections.reverse(taskList);
            }
        });
    }
}


