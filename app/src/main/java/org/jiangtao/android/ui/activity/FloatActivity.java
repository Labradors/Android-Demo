package org.jiangtao.android.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.jiangtao.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FloatActivity extends AppCompatActivity {
    TextView tvAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);
        tvAnimation = (TextView) findViewById(
                R.id.tv_animation
        );
        tvAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBaseAnimation();
                startBackGroundAnimation();
            }
        });
    }


    public void startAnimation() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(tvAnimation, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(tvAnimation, "rotationY", 0, 180),
                ObjectAnimator.ofFloat(tvAnimation, "rotation", 0, -90),
                ObjectAnimator.ofFloat(tvAnimation, "translationX", 0, 90),
                ObjectAnimator.ofFloat(tvAnimation, "translationY", 0, 90),
                ObjectAnimator.ofFloat(tvAnimation, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(tvAnimation, "scaleY", 1, 0.5f),
                ObjectAnimator.ofFloat(tvAnimation, "alpha", 1, 0.25f, 1)
        );
        set.setDuration(5 * 1000).start();

    }


    public void startBaseAnimation(){
        ObjectAnimator.ofFloat(tvAnimation, "translationY", -tvAnimation.getHeight(),tvAnimation.getHeight()/2).start();
    }


    public void startBackGroundAnimation() {
        ValueAnimator colorAnim = ObjectAnimator.ofInt(this, "backgroundColor", 0xFFFF8080, 0xFF8080FF);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
}