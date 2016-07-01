package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/6/20.
 */
public class CustomTimerView extends View  {
  public CustomTimerView(Context context) {
    super(context);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public CustomTimerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  public CustomTimerView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public CustomTimerView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }
}
