// Generated by view binder compiler. Do not edit!
package com.example.dwm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dwm.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDevotionalBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final TextView address;

  @NonNull
  public final TextView cmmntCOUNT;

  @NonNull
  public final RecyclerView cmmntRV;

  @NonNull
  public final ImageView commentBTN;

  @NonNull
  public final EditText commentET;

  @NonNull
  public final TextView description;

  @NonNull
  public final TextView heading;

  @NonNull
  public final HorizontalScrollView horizontalScrollView1;

  @NonNull
  public final ImageView i1;

  @NonNull
  public final ImageView i2;

  @NonNull
  public final ImageView i3;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final TextView nearestmetro;

  @NonNull
  public final ScrollView scrollView3;

  @NonNull
  public final LinearLayout shapeLayout;

  @NonNull
  public final TextView sname;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView9;

  private ActivityDevotionalBinding(@NonNull LinearLayoutCompat rootView, @NonNull TextView address,
      @NonNull TextView cmmntCOUNT, @NonNull RecyclerView cmmntRV, @NonNull ImageView commentBTN,
      @NonNull EditText commentET, @NonNull TextView description, @NonNull TextView heading,
      @NonNull HorizontalScrollView horizontalScrollView1, @NonNull ImageView i1,
      @NonNull ImageView i2, @NonNull ImageView i3, @NonNull ImageView imageView,
      @NonNull ImageView imageView4, @NonNull TextView nearestmetro,
      @NonNull ScrollView scrollView3, @NonNull LinearLayout shapeLayout, @NonNull TextView sname,
      @NonNull TextView textView2, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.address = address;
    this.cmmntCOUNT = cmmntCOUNT;
    this.cmmntRV = cmmntRV;
    this.commentBTN = commentBTN;
    this.commentET = commentET;
    this.description = description;
    this.heading = heading;
    this.horizontalScrollView1 = horizontalScrollView1;
    this.i1 = i1;
    this.i2 = i2;
    this.i3 = i3;
    this.imageView = imageView;
    this.imageView4 = imageView4;
    this.nearestmetro = nearestmetro;
    this.scrollView3 = scrollView3;
    this.shapeLayout = shapeLayout;
    this.sname = sname;
    this.textView2 = textView2;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDevotionalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDevotionalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_devotional, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDevotionalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.address;
      TextView address = ViewBindings.findChildViewById(rootView, id);
      if (address == null) {
        break missingId;
      }

      id = R.id.cmmntCOUNT;
      TextView cmmntCOUNT = ViewBindings.findChildViewById(rootView, id);
      if (cmmntCOUNT == null) {
        break missingId;
      }

      id = R.id.cmmntRV;
      RecyclerView cmmntRV = ViewBindings.findChildViewById(rootView, id);
      if (cmmntRV == null) {
        break missingId;
      }

      id = R.id.commentBTN;
      ImageView commentBTN = ViewBindings.findChildViewById(rootView, id);
      if (commentBTN == null) {
        break missingId;
      }

      id = R.id.commentET;
      EditText commentET = ViewBindings.findChildViewById(rootView, id);
      if (commentET == null) {
        break missingId;
      }

      id = R.id.description;
      TextView description = ViewBindings.findChildViewById(rootView, id);
      if (description == null) {
        break missingId;
      }

      id = R.id.heading;
      TextView heading = ViewBindings.findChildViewById(rootView, id);
      if (heading == null) {
        break missingId;
      }

      id = R.id.horizontalScrollView1;
      HorizontalScrollView horizontalScrollView1 = ViewBindings.findChildViewById(rootView, id);
      if (horizontalScrollView1 == null) {
        break missingId;
      }

      id = R.id.i1;
      ImageView i1 = ViewBindings.findChildViewById(rootView, id);
      if (i1 == null) {
        break missingId;
      }

      id = R.id.i2;
      ImageView i2 = ViewBindings.findChildViewById(rootView, id);
      if (i2 == null) {
        break missingId;
      }

      id = R.id.i3;
      ImageView i3 = ViewBindings.findChildViewById(rootView, id);
      if (i3 == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.nearestmetro;
      TextView nearestmetro = ViewBindings.findChildViewById(rootView, id);
      if (nearestmetro == null) {
        break missingId;
      }

      id = R.id.scrollView3;
      ScrollView scrollView3 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView3 == null) {
        break missingId;
      }

      id = R.id.shapeLayout;
      LinearLayout shapeLayout = ViewBindings.findChildViewById(rootView, id);
      if (shapeLayout == null) {
        break missingId;
      }

      id = R.id.sname;
      TextView sname = ViewBindings.findChildViewById(rootView, id);
      if (sname == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityDevotionalBinding((LinearLayoutCompat) rootView, address, cmmntCOUNT,
          cmmntRV, commentBTN, commentET, description, heading, horizontalScrollView1, i1, i2, i3,
          imageView, imageView4, nearestmetro, scrollView3, shapeLayout, sname, textView2,
          textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
