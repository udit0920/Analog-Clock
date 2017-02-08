package com.example.uditsetia.udit_clock_assignment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by uditsetia on 08/02/17.
 */

public class FragmentClock extends Fragment {
  private static final String TAG = "FragmentClock";
  private ImageView mIvHourHand;
  private ImageView mIvMinHand;
  private ImageView mIvSecHand;
  private Handler mHandler;

  @Override
  public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_clock, container, false);
    mIvHourHand = (ImageView) view.findViewById(R.id.hour_hand);
    mIvMinHand = (ImageView) view.findViewById(R.id.min_hand);
    mIvSecHand = (ImageView) view.findViewById(R.id.sec_hand);
    mHandler = new Handler();
    updateView();
    return view;
  }

  @Override
  public void onStart () {
    super.onStart();
    autoUpdateTime();

  }

  private void autoUpdateTime () {
    mHandler.postDelayed(new Runnable() {
      @Override
      public void run () {
        updateView();
      }


    }, 1000);
  }

  private void updateView () {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
    mIvHourHand.setRotation(Util.getHourAngle(calendar));
    mIvMinHand.setRotation(Util.getMinAngle(calendar));
    mIvSecHand.setRotation(Util.getSecAngle(calendar));
    autoUpdateTime();
  }
}
