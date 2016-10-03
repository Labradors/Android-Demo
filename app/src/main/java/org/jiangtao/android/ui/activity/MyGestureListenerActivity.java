package org.jiangtao.android.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import org.jiangtao.android.R;

public class MyGestureListenerActivity extends AppCompatActivity {

  private GestureDetectorCompat mDetector;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_gesture_listener);
    mDetector = new GestureDetectorCompat(this, new MyGestureListener());
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    this.mDetector.onTouchEvent(event);
    return super.onTouchEvent(event);
  }

  class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
    private static final String DEBUG_TAG = "Gestures";

    @Override
    public boolean onDown(MotionEvent event) {
      Log.d(DEBUG_TAG,"onDown: " + event.toString());
      return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
        float velocityX, float velocityY) {
      Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
      return true;
    }
  }

  public static void startMyGesture(Activity activity){
    Intent intent = new Intent(activity,MyGestureListenerActivity.class);
    activity.startActivity(intent);
  }
}
