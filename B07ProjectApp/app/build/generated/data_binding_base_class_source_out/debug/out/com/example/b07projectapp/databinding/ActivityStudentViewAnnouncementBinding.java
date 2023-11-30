// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityStudentViewAnnouncementBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button SABtn;

  @NonNull
  public final RecyclerView StudentViewAnnouncement;

  @NonNull
  public final TextView textViewSA;

  private ActivityStudentViewAnnouncementBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button SABtn, @NonNull RecyclerView StudentViewAnnouncement,
      @NonNull TextView textViewSA) {
    this.rootView = rootView;
    this.SABtn = SABtn;
    this.StudentViewAnnouncement = StudentViewAnnouncement;
    this.textViewSA = textViewSA;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStudentViewAnnouncementBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStudentViewAnnouncementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_student_view_announcement, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStudentViewAnnouncementBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.SABtn;
      Button SABtn = ViewBindings.findChildViewById(rootView, id);
      if (SABtn == null) {
        break missingId;
      }

      id = R.id.StudentViewAnnouncement;
      RecyclerView StudentViewAnnouncement = ViewBindings.findChildViewById(rootView, id);
      if (StudentViewAnnouncement == null) {
        break missingId;
      }

      id = R.id.textViewSA;
      TextView textViewSA = ViewBindings.findChildViewById(rootView, id);
      if (textViewSA == null) {
        break missingId;
      }

      return new ActivityStudentViewAnnouncementBinding((ConstraintLayout) rootView, SABtn,
          StudentViewAnnouncement, textViewSA);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
