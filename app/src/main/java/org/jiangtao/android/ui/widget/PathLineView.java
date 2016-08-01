package org.jiangtao.android.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kevin on 16-8-1.
 */
public class PathLineView extends View {

    private Path mPath;
    private RectF mRectF ;
    private Paint mPaint;

    public PathLineView(Context context) {
        super(context);
        init();
    }

    public PathLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.RED);
        mPath = new Path();
        mPath.moveTo(50, 50);
        mPath.lineTo(150, 150);
        // 相对前面的点 x 往后移动 100 个像素，y 往下移动 100 个像素
        mPath.rMoveTo(100, 100);
        mPath.lineTo(400, 400);
        mRectF = new RectF(0, 400, 800, 800);
        mPath.arcTo(mRectF, 0, 90,true);
        mPath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath, mPaint);
        canvas.drawRect(mRectF, mPaint);
    }
}
