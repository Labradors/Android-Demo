package org.jiangtao.android_useful_utils.view.widget.utils;

/**
 * Created by kevin on 16-6-4.
 */
public class AndroidWidgetUtils {

  public static float density = 1;

  static {
    density = AndroidApplication.appResources().getDisplayMetrics().density;
  }

  public static int dp(float value) {
    if (value == 0) {
      return 0;
    }
    return (int) Math.ceil(density * value);
  }
}
