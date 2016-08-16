package org.jiangtao.android.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kevin on 16/7/30.
 */
public class PathView extends View {

  private Paint mPaint;
  private Path mPath;

  public PathView(Context context) {
    super(context);
    init();
  }

  public PathView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();

  }

  public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(2);
    mPaint.setColor(Color.RED);
    mPath = new Path();
    mPath.rMoveTo(50,50);
    mPath.lineTo(150, 150);
    mPath.rMoveTo(100,100);
    mPath.lineTo(400,400);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    canvas.drawPath(mPath, mPaint);
  }
}
