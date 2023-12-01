// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
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

public final class ActivityStudentEventsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button21;

  @NonNull
  public final Button button8;

  @NonNull
  public final RatingBar ratingBar;

  @NonNull
  public final Button studentEventBack;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView9;

  private ActivityStudentEventsBinding(@NonNull ConstraintLayout rootView, @NonNull Button button21,
      @NonNull Button button8, @NonNull RatingBar ratingBar, @NonNull Button studentEventBack,
      @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14,
      @NonNull TextView textView15, @NonNull TextView textView16, @NonNull TextView textView17,
      @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView7,
      @NonNull TextView textView9) {
    this.rootView = rootView;
    this.button21 = button21;
    this.button8 = button8;
    this.ratingBar = ratingBar;
    this.studentEventBack = studentEventBack;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView14 = textView14;
    this.textView15 = textView15;
    this.textView16 = textView16;
    this.textView17 = textView17;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView7 = textView7;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStudentEventsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStudentEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_student_events, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStudentEventsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button21;
      Button button21 = ViewBindings.findChildViewById(rootView, id);
      if (button21 == null) {
        break missingId;
      }

      id = R.id.button8;
      Button button8 = ViewBindings.findChildViewById(rootView, id);
      if (button8 == null) {
        break missingId;
      }

      id = R.id.ratingBar;
      RatingBar ratingBar = ViewBindings.findChildViewById(rootView, id);
      if (ratingBar == null) {
        break missingId;
      }

      id = R.id.studentEventBack;
      Button studentEventBack = ViewBindings.findChildViewById(rootView, id);
      if (studentEventBack == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = ViewBindings.findChildViewById(rootView, id);
      if (textView14 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityStudentEventsBinding((ConstraintLayout) rootView, button21, button8,
          ratingBar, studentEventBack, textView12, textView13, textView14, textView15, textView16,
          textView17, textView4, textView5, textView7, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
