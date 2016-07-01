package org.jiangtao.android_useful_utils.view.widget.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import org.jiangtao.android_useful_utils.R;

/**
 * Created by kevin on 16-6-10.
 * Custom SearchView
 */
public class FilletCustomSearchView extends View {

  private Paint mPaint;

  public FilletCustomSearchView(Context context) {
    super(context);
    initialization();
  }

  public FilletCustomSearchView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initialization();
    @SuppressLint("Recycle") TypedArray searchTa =
        context.obtainStyledAttributes(attrs, R.styleable.fsv);
    int color = searchTa.getColor(R.styleable.fsv_fsv_color,0xffff0000);
    setBackgroundColor(color);
    searchTa.recycle();
  }

  public FilletCustomSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialization();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public FilletCustomSearchView(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    initialization();
  }

  private void initialization() {
  }
}
