package org.jiangtao.android_useful_utils.view.widget.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kevin on 16-6-10.
 */
public class FilletCustomSearchView extends View {
  public FilletCustomSearchView(Context context) {
    super(context);
  }

  public FilletCustomSearchView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FilletCustomSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public FilletCustomSearchView(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }


}
