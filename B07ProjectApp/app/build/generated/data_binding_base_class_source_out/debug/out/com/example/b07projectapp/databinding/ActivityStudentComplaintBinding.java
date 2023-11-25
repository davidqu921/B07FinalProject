// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07projectapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStudentComplaintBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button2;

  @NonNull
  public final EditText editTextComplaintStuName;

  @NonNull
  public final EditText editTextComplaintTopic;

  @NonNull
  public final EditText editTextStudentComplaint;

  @NonNull
  public final Button studentComplaintBtn;

  @NonNull
  public final TextView textView3;

  private ActivityStudentComplaintBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button button2, @NonNull EditText editTextComplaintStuName,
      @NonNull EditText editTextComplaintTopic, @NonNull EditText editTextStudentComplaint,
      @NonNull Button studentComplaintBtn, @NonNull TextView textView3) {
    this.rootView = rootView;
    this.button2 = button2;
    this.editTextComplaintStuName = editTextComplaintStuName;
    this.editTextComplaintTopic = editTextComplaintTopic;
    this.editTextStudentComplaint = editTextStudentComplaint;
    this.studentComplaintBtn = studentComplaintBtn;
    this.textView3 = textView3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStudentComplaintBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStudentComplaintBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_student_complaint, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStudentComplaintBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button2;
      Button button2 = ViewBindings.findChildViewById(rootView, id);
      if (button2 == null) {
        break missingId;
      }

      id = R.id.editTextComplaintStuName;
      EditText editTextComplaintStuName = ViewBindings.findChildViewById(rootView, id);
      if (editTextComplaintStuName == null) {
        break missingId;
      }

      id = R.id.editTextComplaintTopic;
      EditText editTextComplaintTopic = ViewBindings.findChildViewById(rootView, id);
      if (editTextComplaintTopic == null) {
        break missingId;
      }

      id = R.id.editTextStudentComplaint;
      EditText editTextStudentComplaint = ViewBindings.findChildViewById(rootView, id);
      if (editTextStudentComplaint == null) {
        break missingId;
      }

      id = R.id.studentComplaintBtn;
      Button studentComplaintBtn = ViewBindings.findChildViewById(rootView, id);
      if (studentComplaintBtn == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      return new ActivityStudentComplaintBinding((ConstraintLayout) rootView, button2,
          editTextComplaintStuName, editTextComplaintTopic, editTextStudentComplaint,
          studentComplaintBtn, textView3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
