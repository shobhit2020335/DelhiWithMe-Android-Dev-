// Generated by view binder compiler. Do not edit!
package com.example.dwm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dwm.R;
import com.google.android.gms.ads.AdView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMainpageAirportBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AdView adView;

  @NonNull
  public final RecyclerView airportlist;

  @NonNull
  public final TextView chooseplace;

  private FragmentMainpageAirportBinding(@NonNull FrameLayout rootView, @NonNull AdView adView,
      @NonNull RecyclerView airportlist, @NonNull TextView chooseplace) {
    this.rootView = rootView;
    this.adView = adView;
    this.airportlist = airportlist;
    this.chooseplace = chooseplace;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMainpageAirportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMainpageAirportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_mainpage_airport, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMainpageAirportBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adView;
      AdView adView = ViewBindings.findChildViewById(rootView, id);
      if (adView == null) {
        break missingId;
      }

      id = R.id.airportlist;
      RecyclerView airportlist = ViewBindings.findChildViewById(rootView, id);
      if (airportlist == null) {
        break missingId;
      }

      id = R.id.chooseplace;
      TextView chooseplace = ViewBindings.findChildViewById(rootView, id);
      if (chooseplace == null) {
        break missingId;
      }

      return new FragmentMainpageAirportBinding((FrameLayout) rootView, adView, airportlist,
          chooseplace);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
