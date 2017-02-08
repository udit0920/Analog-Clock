package com.example.uditsetia.udit_clock_assignment;

import android.util.Log;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by uditsetia on 08/02/17.
 */

public class Util {
  private static final String TAG = "Util";
  private static int sHour;
  private static int sMin;
  private static int sSec;
  //Setting the rotation angle of drawables to 0 i.e 12 O'clock
  private final static int sInitailResetHourAngle = -134;
  private final static int sInitailResetMinAngle = -90;
  private final static int sInitailResetSecAngle = -45;


  public static float getHourAngle (Calendar calendar) {
    setHourMinSec(calendar);
    return ((12 + sHour) / 12.0f * 360) % 360 + (sMin / 60.0f) * 360 / 12.0f + sInitailResetHourAngle;
  }

  public static float getMinAngle (Calendar calendar) {
    setHourMinSec(calendar);
    return (sMin / 60.0f) * 360 + ((sSec / 60.0f) * 360 / 60.0f) + sInitailResetMinAngle;
  }

  public static float getSecAngle (Calendar calendar) {
    setHourMinSec(calendar);
    return (sSec / 60.0f) * 360 + sInitailResetSecAngle;
  }

  private static void setHourMinSec (Calendar calendar) {
    sHour = calendar.get(Calendar.HOUR_OF_DAY);
    sMin = calendar.get(Calendar.MINUTE);
    sSec = calendar.get(Calendar.SECOND);
    Log.d(TAG, "setHourMinSec: " + sSec);
  }
}
