// Generated by view binder compiler. Do not edit!
package com.example.dwm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dwm.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChoicetransportBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final CardView first;

  @NonNull
  public final FrameLayout framelayout;

  @NonNull
  public final CardView second;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final CardView third;

  private FragmentChoicetransportBinding(@NonNull FrameLayout rootView, @NonNull CardView first,
      @NonNull FrameLayout framelayout, @NonNull CardView second, @NonNull TextView textView,
      @NonNull TextView textView1, @NonNull TextView textView2, @NonNull CardView third) {
    this.rootView = rootView;
    this.first = first;
    this.framelayout = framelayout;
    this.second = second;
    this.textView = textView;
    this.textView1 = textView1;
    this.textView2 = textView2;
    this.third = third;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChoicetransportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChoicetransportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_choicetransport, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChoicetransportBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.first;
      CardView first = ViewBindings.findChildViewById(rootView, id);
      if (first == null) {
        break missingId;
      }

      FrameLayout framelayout = (FrameLayout) rootView;

      id = R.id.second;
      CardView second = ViewBindings.findChildViewById(rootView, id);
      if (second == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView1;
      TextView textView1 = ViewBindings.findChildViewById(rootView, id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.third;
      CardView third = ViewBindings.findChildViewById(rootView, id);
      if (third == null) {
        break missingId;
      }

      return new FragmentChoicetransportBinding((FrameLayout) rootView, first, framelayout, second,
          textView, textView1, textView2, third);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
