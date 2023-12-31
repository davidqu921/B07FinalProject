// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07projectapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ComplaintBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView txtAbout;

  @NonNull
  public final TextView txtComplainTime;

  @NonNull
  public final TextView txtComplaintDescription;

  @NonNull
  public final TextView txtSubmitBy;

  private ComplaintBinding(@NonNull CardView rootView, @NonNull TextView txtAbout,
      @NonNull TextView txtComplainTime, @NonNull TextView txtComplaintDescription,
      @NonNull TextView txtSubmitBy) {
    this.rootView = rootView;
    this.txtAbout = txtAbout;
    this.txtComplainTime = txtComplainTime;
    this.txtComplaintDescription = txtComplaintDescription;
    this.txtSubmitBy = txtSubmitBy;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ComplaintBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ComplaintBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.complaint, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ComplaintBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.txtAbout;
      TextView txtAbout = ViewBindings.findChildViewById(rootView, id);
      if (txtAbout == null) {
        break missingId;
      }

      id = R.id.txtComplainTime;
      TextView txtComplainTime = ViewBindings.findChildViewById(rootView, id);
      if (txtComplainTime == null) {
        break missingId;
      }

      id = R.id.txtComplaintDescription;
      TextView txtComplaintDescription = ViewBindings.findChildViewById(rootView, id);
      if (txtComplaintDescription == null) {
        break missingId;
      }

      id = R.id.txtSubmitBy;
      TextView txtSubmitBy = ViewBindings.findChildViewById(rootView, id);
      if (txtSubmitBy == null) {
        break missingId;
      }

      return new ComplaintBinding((CardView) rootView, txtAbout, txtComplainTime,
          txtComplaintDescription, txtSubmitBy);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
