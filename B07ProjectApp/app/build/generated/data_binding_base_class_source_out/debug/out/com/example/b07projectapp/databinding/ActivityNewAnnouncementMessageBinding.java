// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityNewAnnouncementMessageBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button BtnClose;

  @NonNull
  public final TextView PstAnnounInfo;

  @NonNull
  public final TextView PstName;

  @NonNull
  public final TextView PstTime;

  @NonNull
  public final TextView PstTitle;

  private ActivityNewAnnouncementMessageBinding(@NonNull CardView rootView,
      @NonNull Button BtnClose, @NonNull TextView PstAnnounInfo, @NonNull TextView PstName,
      @NonNull TextView PstTime, @NonNull TextView PstTitle) {
    this.rootView = rootView;
    this.BtnClose = BtnClose;
    this.PstAnnounInfo = PstAnnounInfo;
    this.PstName = PstName;
    this.PstTime = PstTime;
    this.PstTitle = PstTitle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityNewAnnouncementMessageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityNewAnnouncementMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_new_announcement_message, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityNewAnnouncementMessageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.BtnClose;
      Button BtnClose = ViewBindings.findChildViewById(rootView, id);
      if (BtnClose == null) {
        break missingId;
      }

      id = R.id.PstAnnounInfo;
      TextView PstAnnounInfo = ViewBindings.findChildViewById(rootView, id);
      if (PstAnnounInfo == null) {
        break missingId;
      }

      id = R.id.PstName;
      TextView PstName = ViewBindings.findChildViewById(rootView, id);
      if (PstName == null) {
        break missingId;
      }

      id = R.id.PstTime;
      TextView PstTime = ViewBindings.findChildViewById(rootView, id);
      if (PstTime == null) {
        break missingId;
      }

      id = R.id.PstTitle;
      TextView PstTitle = ViewBindings.findChildViewById(rootView, id);
      if (PstTitle == null) {
        break missingId;
      }

      return new ActivityNewAnnouncementMessageBinding((CardView) rootView, BtnClose, PstAnnounInfo,
          PstName, PstTime, PstTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
