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

public final class ActivityPostsRequireInsideCmsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button11;

  @NonNull
  public final Button button12;

  @NonNull
  public final Button button18;

  @NonNull
  public final EditText editTextTextMultiLine3;

  @NonNull
  public final EditText editTextTextMultiLine4;

  @NonNull
  public final EditText editTextTextMultiLine5;

  @NonNull
  public final TextView textView6;

  private ActivityPostsRequireInsideCmsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button button11, @NonNull Button button12, @NonNull Button button18,
      @NonNull EditText editTextTextMultiLine3, @NonNull EditText editTextTextMultiLine4,
      @NonNull EditText editTextTextMultiLine5, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.button11 = button11;
    this.button12 = button12;
    this.button18 = button18;
    this.editTextTextMultiLine3 = editTextTextMultiLine3;
    this.editTextTextMultiLine4 = editTextTextMultiLine4;
    this.editTextTextMultiLine5 = editTextTextMultiLine5;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPostsRequireInsideCmsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPostsRequireInsideCmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_posts_require_inside_cms, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPostsRequireInsideCmsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button11;
      Button button11 = ViewBindings.findChildViewById(rootView, id);
      if (button11 == null) {
        break missingId;
      }

      id = R.id.button12;
      Button button12 = ViewBindings.findChildViewById(rootView, id);
      if (button12 == null) {
        break missingId;
      }

      id = R.id.button18;
      Button button18 = ViewBindings.findChildViewById(rootView, id);
      if (button18 == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine3;
      EditText editTextTextMultiLine3 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine3 == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine4;
      EditText editTextTextMultiLine4 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine4 == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine5;
      EditText editTextTextMultiLine5 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivityPostsRequireInsideCmsBinding((ConstraintLayout) rootView, button11,
          button12, button18, editTextTextMultiLine3, editTextTextMultiLine4,
          editTextTextMultiLine5, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}