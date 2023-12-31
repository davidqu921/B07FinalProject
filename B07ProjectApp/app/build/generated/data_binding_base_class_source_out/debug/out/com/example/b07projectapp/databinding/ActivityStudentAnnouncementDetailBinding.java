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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07projectapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStudentAnnouncementDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView StdContent;

  @NonNull
  public final TextView StdPoster;

  @NonNull
  public final TextView StdTimePost;

  @NonNull
  public final TextView StdTitleAnnounce;

  @NonNull
  public final Button Stdbutton14;

  @NonNull
  public final TextView StdtextView;

  private ActivityStudentAnnouncementDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView StdContent, @NonNull TextView StdPoster, @NonNull TextView StdTimePost,
      @NonNull TextView StdTitleAnnounce, @NonNull Button Stdbutton14,
      @NonNull TextView StdtextView) {
    this.rootView = rootView;
    this.StdContent = StdContent;
    this.StdPoster = StdPoster;
    this.StdTimePost = StdTimePost;
    this.StdTitleAnnounce = StdTitleAnnounce;
    this.Stdbutton14 = Stdbutton14;
    this.StdtextView = StdtextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStudentAnnouncementDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStudentAnnouncementDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_student_announcement_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStudentAnnouncementDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.StdContent;
      TextView StdContent = ViewBindings.findChildViewById(rootView, id);
      if (StdContent == null) {
        break missingId;
      }

      id = R.id.StdPoster;
      TextView StdPoster = ViewBindings.findChildViewById(rootView, id);
      if (StdPoster == null) {
        break missingId;
      }

      id = R.id.StdTimePost;
      TextView StdTimePost = ViewBindings.findChildViewById(rootView, id);
      if (StdTimePost == null) {
        break missingId;
      }

      id = R.id.StdTitleAnnounce;
      TextView StdTitleAnnounce = ViewBindings.findChildViewById(rootView, id);
      if (StdTitleAnnounce == null) {
        break missingId;
      }

      id = R.id.Stdbutton14;
      Button Stdbutton14 = ViewBindings.findChildViewById(rootView, id);
      if (Stdbutton14 == null) {
        break missingId;
      }

      id = R.id.StdtextView;
      TextView StdtextView = ViewBindings.findChildViewById(rootView, id);
      if (StdtextView == null) {
        break missingId;
      }

      return new ActivityStudentAnnouncementDetailBinding((ConstraintLayout) rootView, StdContent,
          StdPoster, StdTimePost, StdTitleAnnounce, Stdbutton14, StdtextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
