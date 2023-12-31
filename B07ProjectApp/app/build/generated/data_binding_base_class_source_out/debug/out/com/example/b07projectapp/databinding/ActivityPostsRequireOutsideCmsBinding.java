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

public final class ActivityPostsRequireOutsideCmsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button back5Btn;

  @NonNull
  public final EditText editTextTextMultiLine6;

  @NonNull
  public final EditText editTextTextMultiLine7;

  @NonNull
  public final Button no4Btn;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final Button yes4Btn;

  private ActivityPostsRequireOutsideCmsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button back5Btn, @NonNull EditText editTextTextMultiLine6,
      @NonNull EditText editTextTextMultiLine7, @NonNull Button no4Btn, @NonNull TextView textView5,
      @NonNull Button yes4Btn) {
    this.rootView = rootView;
    this.back5Btn = back5Btn;
    this.editTextTextMultiLine6 = editTextTextMultiLine6;
    this.editTextTextMultiLine7 = editTextTextMultiLine7;
    this.no4Btn = no4Btn;
    this.textView5 = textView5;
    this.yes4Btn = yes4Btn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPostsRequireOutsideCmsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPostsRequireOutsideCmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_posts_require_outside_cms, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPostsRequireOutsideCmsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back5Btn;
      Button back5Btn = ViewBindings.findChildViewById(rootView, id);
      if (back5Btn == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine6;
      EditText editTextTextMultiLine6 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine6 == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine7;
      EditText editTextTextMultiLine7 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine7 == null) {
        break missingId;
      }

      id = R.id.no4Btn;
      Button no4Btn = ViewBindings.findChildViewById(rootView, id);
      if (no4Btn == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.yes4Btn;
      Button yes4Btn = ViewBindings.findChildViewById(rootView, id);
      if (yes4Btn == null) {
        break missingId;
      }

      return new ActivityPostsRequireOutsideCmsBinding((ConstraintLayout) rootView, back5Btn,
          editTextTextMultiLine6, editTextTextMultiLine7, no4Btn, textView5, yes4Btn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
