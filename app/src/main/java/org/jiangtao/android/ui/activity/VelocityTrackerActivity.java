package org.jiangtao.android.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import org.jiangtao.android.R;

public class VelocityTrackerActivity extends AppCompatActivity {

  private static final String DEBUG_TAG = "Velocity";
  private VelocityTracker mVelocityTracker = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_velocity_tracker);
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    int index = event.getActionIndex();
    int action = event.getActionMasked();
    int pointerId = event.getPointerId(index);
    switch(action) {
      case MotionEvent.ACTION_DOWN:
        Log.d(DEBUG_TAG, "onTouchEvent: "+pointerId);
        if(mVelocityTracker == null) {
          // Retrieve a new VelocityTrackerActivity object to watch the velocity of a motion.
          mVelocityTracker = VelocityTracker.obtain();
        }
        else {
          // Reset the velocity tracker back to its initial state.
          mVelocityTracker.clear();
        }
        // Add a user's movement to the tracker.
        mVelocityTracker.addMovement(event);
        break;
      case MotionEvent.ACTION_MOVE:
        mVelocityTracker.addMovement(event);
        // When you want to determine the velocity, call
        // computeCurrentVelocity(). Then call getXVelocity()
        // and getYVelocity() to retrieve the velocity for each pointer ID.
        mVelocityTracker.computeCurrentVelocity(1000);
        // Log velocity of pixels per second
        // Best practice to use VelocityTrackerCompat where possible.
        Log.d(DEBUG_TAG, "X velocity: " +
            VelocityTrackerCompat.getXVelocity(mVelocityTracker,
                pointerId));
        Log.d(DEBUG_TAG, "Y velocity: " +
            VelocityTrackerCompat.getYVelocity(mVelocityTracker,
                pointerId));
        break;
      case MotionEvent.ACTION_UP:
      case MotionEvent.ACTION_CANCEL:
        // Return a VelocityTrackerActivity object back to be re-used by others.
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        break;
    }
    return true;
  }

  public static void startVelocityTracker(Activity activity){
    Intent intent = new Intent(activity,VelocityTrackerActivity.class);
    activity.startActivity(intent);
  }
}
