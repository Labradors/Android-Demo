package org.jiangtao.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.jiangtao.android.R;
import org.jiangtao.android_useful_utils.view.widget.ui.activity.CityPickerActivity;
import org.jiangtao.android_useful_utils.view.widget.ui.activity.GlideMaxImageActivity;
import org.jiangtao.android_useful_utils.view.widget.ui.activity.MapSearchActivity;
import picker.image.android.com.library.ui.ImagePickerActivity;

import static org.jiangtao.android_useful_utils.view.widget.utils.TransitionHelper.setupWindowAnimations;
import static org.jiangtao.android_useful_utils.view.widget.utils.TransitionHelper.transitionToActivity;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    setupWindowAnimations(this,500,Gravity.LEFT);
    Button buttonObject = (Button) findViewById(R.id.ui_view_animation_object);
    Button animationButton = (Button) findViewById(R.id.ui_view_animation_drawable);
    Button button = (Button) findViewById(R.id.ui_city_picker);
    Button mapButton = (Button) findViewById(R.id.ui_map_search);
    Button customButton = (Button) findViewById(R.id.ui_custom_view);
    Button glideButton = (Button) findViewById(R.id.ui_view_glide_max_image);
    final Button customTimer = (Button) findViewById(R.id.ui_view_custom_ps);
    Button animationBtn = (Button) findViewById(R.id.ui_view_animation_button);
    Button newImageView = (Button) findViewById(R.id.ui_view_new_image);

    Button pathButton = (Button) findViewById(R.id.path_view);
    pathButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, PathViewActivity.class);
        startActivity(intent);
      }
    });


    Button buttonLine = (Button) findViewById(R.id.ui_view_path_line_two);
    buttonLine.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, PathActivity.class);
        startActivity(intent);
      }
    });
    
    assert button != null;
    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CityPickerActivity.class);
        startActivityForResult(intent, CityPickerActivity.OPEN_CITY_PICKER);
      }
    });
    assert mapButton != null;
    mapButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MapSearchActivity.class);
        startActivityForResult(intent, CityPickerActivity.OPEN_CITY_PICKER);
      }
    });
    assert customButton != null;
    customButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //Intent intent = new Intent(MainActivity.this, CustomViewActivity.class);
        //startActivity(intent);

        transitionToActivity(CustomViewActivity.class,MainActivity.this);
      }
    });

    assert glideButton != null;
    glideButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, GlideMaxImageActivity.class);
        List<String> list = new ArrayList<>();
        String url = "http://pics.sc.chinaz.com/files/pic/pic9/201606/apic21154.jpg";
        intent.putExtra(GlideMaxImageActivity.CONSTANT_IMAGE, url);
        intent.putExtra(GlideMaxImageActivity.CONSTANT_IMAGE_POSTION, 0);
        startActivity(intent);
      }
    });

    assert customTimer != null;
    customTimer.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //点击打开自定义timer
        Intent intent = new Intent(MainActivity.this, FloatActivity.class);
        startActivity(intent);
//        transitionToActivity(FloatActivity.class,customTimer,MainActivity.this);
      }
    });

    assert animationBtn != null;
    animationBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DemoActivity.class);
        startActivity(intent);
      }
    });
    newImageView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ImagePickerActivity.openActivity(MainActivity.this, null,
            ImagePickerActivity.CONSTANT_REQUEST_CODE);
      }
    });

    animationButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DrawableAmination.class);
        startActivity(intent);
      }
    });

    buttonObject.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ObjectAnimation.class);
        startActivity(intent);
      }
    });
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == CityPickerActivity.OPEN_CITY_PICKER && resultCode == RESULT_OK) {
      Toast.makeText(this, data.getStringExtra(CityPickerActivity.CITY_VALUE), Toast.LENGTH_SHORT)
          .show();
    }
  }
}
