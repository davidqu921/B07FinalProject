// Generated by view binder compiler. Do not edit!
package com.example.b07projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.b07projectapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdminLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView AdminCenter;

  @NonNull
  public final AppCompatButton adminLoginBtn;

  @NonNull
  public final EditText adminPassword;

  @NonNull
  public final EditText adminUsername;

  @NonNull
  public final TextView registerBtn;

  private ActivityAdminLoginBinding(@NonNull LinearLayout rootView, @NonNull TextView AdminCenter,
      @NonNull AppCompatButton adminLoginBtn, @NonNull EditText adminPassword,
      @NonNull EditText adminUsername, @NonNull TextView registerBtn) {
    this.rootView = rootView;
    this.AdminCenter = AdminCenter;
    this.adminLoginBtn = adminLoginBtn;
    this.adminPassword = adminPassword;
    this.adminUsername = adminUsername;
    this.registerBtn = registerBtn;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AdminCenter;
      TextView AdminCenter = ViewBindings.findChildViewById(rootView, id);
      if (AdminCenter == null) {
        break missingId;
      }

      id = R.id.adminLoginBtn;
      AppCompatButton adminLoginBtn = ViewBindings.findChildViewById(rootView, id);
      if (adminLoginBtn == null) {
        break missingId;
      }

      id = R.id.adminPassword;
      EditText adminPassword = ViewBindings.findChildViewById(rootView, id);
      if (adminPassword == null) {
        break missingId;
      }

      id = R.id.adminUsername;
      EditText adminUsername = ViewBindings.findChildViewById(rootView, id);
      if (adminUsername == null) {
        break missingId;
      }

      id = R.id.registerBtn;
      TextView registerBtn = ViewBindings.findChildViewById(rootView, id);
      if (registerBtn == null) {
        break missingId;
      }

      return new ActivityAdminLoginBinding((LinearLayout) rootView, AdminCenter, adminLoginBtn,
          adminPassword, adminUsername, registerBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
