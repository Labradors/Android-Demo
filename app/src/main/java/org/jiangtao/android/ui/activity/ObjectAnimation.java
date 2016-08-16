package org.jiangtao.android.ui.activity;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import org.jiangtao.android.R;

public class ObjectAnimation extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_object_animation);
    Button button = (Button) findViewById(R.id.btn_animation);
    button.animate().setStartDelay(1000).alpha(5)
        .scaleX(2).scaleY(2).setListener(new Animator.AnimatorListener() {
      @Override public void onAnimationStart(Animator animation) {

      }

      @Override public void onAnimationEnd(Animator animation) {

      }

      @Override public void onAnimationCancel(Animator animation) {

      }

      @Override public void onAnimationRepeat(Animator animation) {

      }
    });
  }
}
