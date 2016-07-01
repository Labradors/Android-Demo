package org.jiangtao.android_useful_utils.view.widget.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

/**
 * Created by kevin on 16-6-4.
 */
public abstract class AndroidApplication extends Application {

  private static volatile Context sAppContext;

  @Override public void onCreate() {
    super.onCreate();
    initialize();
  }

  private void initialize() {
    sAppContext = this;
  }

  /**
   * @return application context
   */
  public static Context appContext() {
    return sAppContext;
  }

  /**
   * @return application resource
   */
  public static Resources appResources() {
    return appContext().getResources();
  }

  /**
   * @return Resource dimension value multiplied by the appropriate metric.
   */
  public static float dimen(@DimenRes int dimenRes) {
    return appResources().getDimension(dimenRes);
  }

  public static int color(@ColorRes int colorRes) {
    return ContextCompat.getColor(appContext(), colorRes);
  }

  public static Drawable drawable(@DrawableRes int drawableRes) {
    return ContextCompat.getDrawable(appContext(), drawableRes);
  }

}
