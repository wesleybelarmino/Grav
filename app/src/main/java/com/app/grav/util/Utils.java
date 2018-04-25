package com.app.grav.util;

import android.content.res.Resources;
import com.app.grav.R;

public class Utils {

  public static int monthByNumber(int number){
    int month;

    switch (number + 1){
      case 1:  month = R.string.january;
        break;
      case 2:  month = R.string.february;
        break;
      case 3:  month = R.string.march;
        break;
      case 4:  month = R.string.april;
        break;
      case 5:  month = R.string.may;
        break;
      case 6:  month = R.string.june;
        break;
      case 7:  month = R.string.july;
        break;
      case 8:  month = R.string.august;
        break;
      case 9:  month = R.string.september;
        break;
      case 10: month = R.string.october;
        break;
      case 11: month = R.string.november;
        break;
      case 12: month = R.string.december;
        break;
      default: month = R.string.december;
        break;
    }

    return month;
  }
}
