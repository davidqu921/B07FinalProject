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

public final class ActivityAdminAddEventBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button11;

  @NonNull
  public final Button datePickerButton;

  @NonNull
  public final EditText editTextNumber2;

  @NonNull
  public final EditText editTextStudentComplaint2;

  @NonNull
  public final EditText editTextText;

  @NonNull
  public final EditText editTextText2;

  @NonNull
  public final TextView textView10;

  private ActivityAdminAddEventBinding(@NonNull ConstraintLayout rootView, @NonNull Button button11,
      @NonNull Button datePickerButton, @NonNull EditText editTextNumber2,
      @NonNull EditText editTextStudentComplaint2, @NonNull EditText editTextText,
      @NonNull EditText editTextText2, @NonNull TextView textView10) {
    this.rootView = rootView;
    this.button11 = button11;
    this.datePickerButton = datePickerButton;
    this.editTextNumber2 = editTextNumber2;
    this.editTextStudentComplaint2 = editTextStudentComplaint2;
    this.editTextText = editTextText;
    this.editTextText2 = editTextText2;
    this.textView10 = textView10;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminAddEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminAddEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin_add_event, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminAddEventBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button11;
      Button button11 = ViewBindings.findChildViewById(rootView, id);
      if (button11 == null) {
        break missingId;
      }

      id = R.id.datePickerButton;
      Button datePickerButton = ViewBindings.findChildViewById(rootView, id);
      if (datePickerButton == null) {
        break missingId;
      }

      id = R.id.editTextNumber2;
      EditText editTextNumber2 = ViewBindings.findChildViewById(rootView, id);
      if (editTextNumber2 == null) {
        break missingId;
      }

      id = R.id.editTextStudentComplaint2;
      EditText editTextStudentComplaint2 = ViewBindings.findChildViewById(rootView, id);
      if (editTextStudentComplaint2 == null) {
        break missingId;
      }

      id = R.id.editTextText;
      EditText editTextText = ViewBindings.findChildViewById(rootView, id);
      if (editTextText == null) {
        break missingId;
      }

      id = R.id.editTextText2;
      EditText editTextText2 = ViewBindings.findChildViewById(rootView, id);
      if (editTextText2 == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      return new ActivityAdminAddEventBinding((ConstraintLayout) rootView, button11,
          datePickerButton, editTextNumber2, editTextStudentComplaint2, editTextText, editTextText2,
          textView10);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
