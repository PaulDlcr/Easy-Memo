package fr.BDST.easymemo.Model;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.Exclude;

public class TaskId {
    @Exclude
    public String TaskId;

    public <T extends TaskId> T withID(@NonNull final String id){
        this.TaskId = id;
        return  (T) this;
    }
}
