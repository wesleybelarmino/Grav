package com.app.grav.timeclock.di;

import com.app.grav.timeclock.TimeClockActivity;
import dagger.Component;

@Component(modules = TimeClockModule.class)
public interface TimeClockComponent {
  void inject(TimeClockActivity activity);
}
