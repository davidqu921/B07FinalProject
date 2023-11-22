// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07projectapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPostsRequireSpecialistMajorBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button10;

  @NonNull
  public final Button button17;

  @NonNull
  public final Button button9;

  @NonNull
  public final EditText editTextTextMultiLine2;

  private ActivityPostsRequireSpecialistMajorBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button button10, @NonNull Button button17, @NonNull Button button9,
      @NonNull EditText editTextTextMultiLine2) {
    this.rootView = rootView;
    this.button10 = button10;
    this.button17 = button17;
    this.button9 = button9;
    this.editTextTextMultiLine2 = editTextTextMultiLine2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPostsRequireSpecialistMajorBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPostsRequireSpecialistMajorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_posts_require_specialist_major, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPostsRequireSpecialistMajorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button10;
      Button button10 = ViewBindings.findChildViewById(rootView, id);
      if (button10 == null) {
        break missingId;
      }

      id = R.id.button17;
      Button button17 = ViewBindings.findChildViewById(rootView, id);
      if (button17 == null) {
        break missingId;
      }

      id = R.id.button9;
      Button button9 = ViewBindings.findChildViewById(rootView, id);
      if (button9 == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine2;
      EditText editTextTextMultiLine2 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine2 == null) {
        break missingId;
      }

      return new ActivityPostsRequireSpecialistMajorBinding((ConstraintLayout) rootView, button10,
          button17, button9, editTextTextMultiLine2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
