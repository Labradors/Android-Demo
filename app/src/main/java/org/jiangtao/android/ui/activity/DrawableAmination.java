package org.jiangtao.android.ui.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import org.jiangtao.android.R;

public class DrawableAmination extends AppCompatActivity {

  private ImageView mImageView;
  private AnimationDrawable mAnimationDrawable;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drawable_amination);
    mImageView = (ImageView) findViewById(R.id.img);
    mAnimationDrawable =
        (AnimationDrawable) getResources().getDrawable(R.drawable.animation_drawable);
    mImageView.setImageDrawable(mAnimationDrawable);
    mAnimationDrawable.start();

  }
}
