package com.app.grav.timeclock.core;

import android.graphics.Bitmap;

public class TimeClockPresenter implements TimeClockContract.Presenter {

  private TimeClockContract.View timeClockView;


  public TimeClockPresenter(TimeClockContract.View view){
    this.timeClockView = view;
  }


  @Override public void destroy() {

  }

  @Override public void saveTimeClock(String selectedDate, Bitmap bitmap) {

  }
}
