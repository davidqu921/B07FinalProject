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

public final class ActivityPostsRequireMinorBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button16;

  @NonNull
  public final Button button7;

  @NonNull
  public final Button button8;

  @NonNull
  public final EditText editTextTextMultiLine;

  private ActivityPostsRequireMinorBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button button16, @NonNull Button button7, @NonNull Button button8,
      @NonNull EditText editTextTextMultiLine) {
    this.rootView = rootView;
    this.button16 = button16;
    this.button7 = button7;
    this.button8 = button8;
    this.editTextTextMultiLine = editTextTextMultiLine;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPostsRequireMinorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPostsRequireMinorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_posts_require_minor, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPostsRequireMinorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button16;
      Button button16 = ViewBindings.findChildViewById(rootView, id);
      if (button16 == null) {
        break missingId;
      }

      id = R.id.button7;
      Button button7 = ViewBindings.findChildViewById(rootView, id);
      if (button7 == null) {
        break missingId;
      }

      id = R.id.button8;
      Button button8 = ViewBindings.findChildViewById(rootView, id);
      if (button8 == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine;
      EditText editTextTextMultiLine = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine == null) {
        break missingId;
      }

      return new ActivityPostsRequireMinorBinding((ConstraintLayout) rootView, button16, button7,
          button8, editTextTextMultiLine);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}