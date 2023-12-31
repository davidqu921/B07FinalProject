// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07projectapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStudentEventListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button StudentEventBack;

  @NonNull
  public final RecyclerView StudentEventList;

  @NonNull
  public final SearchView searchView;

  @NonNull
  public final TextView textView5;

  private ActivityStudentEventListBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button StudentEventBack, @NonNull RecyclerView StudentEventList,
      @NonNull SearchView searchView, @NonNull TextView textView5) {
    this.rootView = rootView;
    this.StudentEventBack = StudentEventBack;
    this.StudentEventList = StudentEventList;
    this.searchView = searchView;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStudentEventListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStudentEventListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_student_event_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStudentEventListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.StudentEventBack;
      Button StudentEventBack = ViewBindings.findChildViewById(rootView, id);
      if (StudentEventBack == null) {
        break missingId;
      }

      id = R.id.StudentEventList;
      RecyclerView StudentEventList = ViewBindings.findChildViewById(rootView, id);
      if (StudentEventList == null) {
        break missingId;
      }

      id = R.id.searchView;
      SearchView searchView = ViewBindings.findChildViewById(rootView, id);
      if (searchView == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new ActivityStudentEventListBinding((ConstraintLayout) rootView, StudentEventBack,
          StudentEventList, searchView, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
