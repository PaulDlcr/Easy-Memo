// Generated by view binder compiler. Do not edit!
package fr.BDST.easymemo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fr.BDST.easymemo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NewTasksBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button newTaskButton;

  @NonNull
  public final EditText newTaskText;

  @NonNull
  public final TextView setDueTv;

  private NewTasksBinding(@NonNull RelativeLayout rootView, @NonNull Button newTaskButton,
      @NonNull EditText newTaskText, @NonNull TextView setDueTv) {
    this.rootView = rootView;
    this.newTaskButton = newTaskButton;
    this.newTaskText = newTaskText;
    this.setDueTv = setDueTv;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NewTasksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NewTasksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.new_tasks, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NewTasksBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.newTaskButton;
      Button newTaskButton = ViewBindings.findChildViewById(rootView, id);
      if (newTaskButton == null) {
        break missingId;
      }

      id = R.id.newTaskText;
      EditText newTaskText = ViewBindings.findChildViewById(rootView, id);
      if (newTaskText == null) {
        break missingId;
      }

      id = R.id.set_due_tv;
      TextView setDueTv = ViewBindings.findChildViewById(rootView, id);
      if (setDueTv == null) {
        break missingId;
      }

      return new NewTasksBinding((RelativeLayout) rootView, newTaskButton, newTaskText, setDueTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
