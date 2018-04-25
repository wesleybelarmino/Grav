package com.app.grav.timeclock.core;

import android.graphics.Bitmap;
import com.app.grav.domain.BasePresenter;

public interface TimeClockContract {
  interface  View{

  }

  interface Presenter extends BasePresenter {
    void saveTimeClock(String selectedDate, Bitmap bitmap);

  }
}
