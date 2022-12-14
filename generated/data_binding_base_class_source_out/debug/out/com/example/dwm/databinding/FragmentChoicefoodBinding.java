// Generated by view binder compiler. Do not edit!
package com.example.dwm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dwm.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChoicefoodBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final CardView first;

  @NonNull
  public final FrameLayout framelayout;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final CircleImageView localfoodimg;

  @NonNull
  public final LinearLayout locallayout;

  @NonNull
  public final CircleImageView restaurantimg;

  @NonNull
  public final LinearLayout restlayout;

  @NonNull
  public final CardView second;

  @NonNull
  public final TextView select;

  @NonNull
  public final TextView selectlocalfood;

  private FragmentChoicefoodBinding(@NonNull FrameLayout rootView, @NonNull CardView first,
      @NonNull FrameLayout framelayout, @NonNull ImageView imageView2,
      @NonNull ImageView imageView3, @NonNull CircleImageView localfoodimg,
      @NonNull LinearLayout locallayout, @NonNull CircleImageView restaurantimg,
      @NonNull LinearLayout restlayout, @NonNull CardView second, @NonNull TextView select,
      @NonNull TextView selectlocalfood) {
    this.rootView = rootView;
    this.first = first;
    this.framelayout = framelayout;
    this.imageView2 = imageView2;
    this.imageView3 = imageView3;
    this.localfoodimg = localfoodimg;
    this.locallayout = locallayout;
    this.restaurantimg = restaurantimg;
    this.restlayout = restlayout;
    this.second = second;
    this.select = select;
    this.selectlocalfood = selectlocalfood;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChoicefoodBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChoicefoodBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_choicefood, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChoicefoodBinding bind(@NonNull View rootView) {
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

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.localfoodimg;
      CircleImageView localfoodimg = ViewBindings.findChildViewById(rootView, id);
      if (localfoodimg == null) {
        break missingId;
      }

      id = R.id.locallayout;
      LinearLayout locallayout = ViewBindings.findChildViewById(rootView, id);
      if (locallayout == null) {
        break missingId;
      }

      id = R.id.restaurantimg;
      CircleImageView restaurantimg = ViewBindings.findChildViewById(rootView, id);
      if (restaurantimg == null) {
        break missingId;
      }

      id = R.id.restlayout;
      LinearLayout restlayout = ViewBindings.findChildViewById(rootView, id);
      if (restlayout == null) {
        break missingId;
      }

      id = R.id.second;
      CardView second = ViewBindings.findChildViewById(rootView, id);
      if (second == null) {
        break missingId;
      }

      id = R.id.select;
      TextView select = ViewBindings.findChildViewById(rootView, id);
      if (select == null) {
        break missingId;
      }

      id = R.id.selectlocalfood;
      TextView selectlocalfood = ViewBindings.findChildViewById(rootView, id);
      if (selectlocalfood == null) {
        break missingId;
      }

      return new FragmentChoicefoodBinding((FrameLayout) rootView, first, framelayout, imageView2,
          imageView3, localfoodimg, locallayout, restaurantimg, restlayout, second, select,
          selectlocalfood);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
