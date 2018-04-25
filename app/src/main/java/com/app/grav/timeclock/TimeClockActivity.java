package com.app.grav.timeclock;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.app.grav.timeclock.core.TimeClockContract;
import com.app.grav.timeclock.core.TimeClockView;
import com.app.grav.timeclock.di.DaggerTimeClockComponent;
import com.app.grav.timeclock.di.TimeClockModule;
import com.app.grav.util.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;

public class TimeClockActivity  extends AppCompatActivity implements TimeClockContract.View {

  @Inject
  TimeClockContract.Presenter presenter;

  @Inject TimeClockView view;

  private String selectedDate;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerTimeClockComponent.builder()
        .timeClockModule(new TimeClockModule(this))
        .build()
        .inject(this);

    setContentView(view.view());
    selectedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

  }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK && requestCode == Constants.CAMERA_PIC_REQUEST) {
      presenter.saveTimeClock(this.selectedDate, (Bitmap) data.getExtras().get("data"));
    }
  }


  @Override protected void onDestroy() {
    presenter.destroy();
    super.onDestroy();
  }

  public void selectedDate(String date) {
    this.selectedDate = date;
  }
}
