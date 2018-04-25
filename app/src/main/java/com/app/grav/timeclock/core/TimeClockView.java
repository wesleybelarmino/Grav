package com.app.grav.timeclock.core;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.grav.R;
import com.app.grav.timeclock.TimeClockActivity;
import com.app.grav.util.Utils;
import com.tbruyelle.rxpermissions2.RxPermissions;
import me.nlmartian.silkcal.DatePickerController;
import me.nlmartian.silkcal.DayPickerView;
import me.nlmartian.silkcal.SimpleMonthAdapter;

import static com.app.grav.util.Constants.CAMERA_PIC_REQUEST;

public class TimeClockView implements DatePickerController {

  private View view;
  private TimeClockActivity timeClockActivity;

  @BindView(R.id.time_clock_top_year) TextView topYear;
  @BindView(R.id.time_clock_top_month) TextView topMonth;
  @BindView(R.id.time_clock_calendar_view) DayPickerView calendarView;
  @BindView(R.id.time_clock_list) RecyclerView listView;


  public TimeClockView(TimeClockActivity context){
    this.timeClockActivity = context;

    FrameLayout parent = new FrameLayout(context);
    parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, true);

    ButterKnife.bind(this, view);

    calendarView.setController(this);
    calendarView.scrollToToday();

    listView.setHasFixedSize(true);
    listView.setItemAnimator(new DefaultItemAnimator());
    listView.setLayoutManager(new GridLayoutManager(context, 2));

  }

  public View view() {
    return view;
  }

  @SuppressLint("CheckResult")
  @OnClick(R.id.time_clock_calendar_add)
  public void openCamera(){
    RxPermissions rxPermissions = new RxPermissions(this.timeClockActivity);
    rxPermissions
        .request(Manifest.permission.CAMERA)
        .subscribe(granted -> {
          if (granted) { // Always true pre-M
            // I can control the camera now
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            this.timeClockActivity.startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);

          } else {
            Toast.makeText(this.timeClockActivity, "Permission denied, can't enable the Camera",
                Toast.LENGTH_SHORT).show();
          }
        });
  }

  @Override
  public int getMaxYear() {
    return 0;
  }

  @Override
  public void onDayOfMonthSelected(int year, int month, int day) {
    topMonth.setText(Utils.monthByNumber(month));
    topYear.setText(year+"");

    this.timeClockActivity.selectedDate(year+"-"+month+"-"+day);
  }

  @Override
  public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays) {}


}
