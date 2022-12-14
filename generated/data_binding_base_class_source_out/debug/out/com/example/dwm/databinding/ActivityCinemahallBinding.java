// Generated by view binder compiler. Do not edit!
package com.example.dwm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dwm.R;
import com.google.android.gms.ads.AdView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCinemahallBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final AdView adView;

  @NonNull
  public final RecyclerView cinemahallList;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final ConstraintLayout wrapper;

  private ActivityCinemahallBinding(@NonNull LinearLayoutCompat rootView, @NonNull AdView adView,
      @NonNull RecyclerView cinemahallList, @NonNull TextView textView3,
      @NonNull ConstraintLayout wrapper) {
    this.rootView = rootView;
    this.adView = adView;
    this.cinemahallList = cinemahallList;
    this.textView3 = textView3;
    this.wrapper = wrapper;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCinemahallBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCinemahallBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_cinemahall, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCinemahallBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adView;
      AdView adView = ViewBindings.findChildViewById(rootView, id);
      if (adView == null) {
        break missingId;
      }

      id = R.id.cinemahall_list;
      RecyclerView cinemahallList = ViewBindings.findChildViewById(rootView, id);
      if (cinemahallList == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.wrapper;
      ConstraintLayout wrapper = ViewBindings.findChildViewById(rootView, id);
      if (wrapper == null) {
        break missingId;
      }

      return new ActivityCinemahallBinding((LinearLayoutCompat) rootView, adView, cinemahallList,
          textView3, wrapper);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
