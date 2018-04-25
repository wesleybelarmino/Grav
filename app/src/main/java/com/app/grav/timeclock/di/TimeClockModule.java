package com.app.grav.timeclock.di;

import com.app.grav.timeclock.TimeClockActivity;
import com.app.grav.timeclock.core.TimeClockContract;
import com.app.grav.timeclock.core.TimeClockPresenter;
import com.app.grav.timeclock.core.TimeClockView;
import dagger.Module;
import dagger.Provides;

@Module
public class TimeClockModule {

  private TimeClockActivity timeClockActivity;

  public TimeClockModule(TimeClockActivity context){
    this.timeClockActivity = context;
  }


  @Provides
  TimeClockView providesTimeClockView(){return new TimeClockView(timeClockActivity);}

  @Provides
  TimeClockContract.Presenter providesPresenter(){
    return new TimeClockPresenter(timeClockActivity);
  }

}
