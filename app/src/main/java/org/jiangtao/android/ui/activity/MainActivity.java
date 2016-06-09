package org.jiangtao.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.crypto.interfaces.PBEKey;
import org.jiangtao.android.R;
import org.jiangtao.android_useful_utils.view.widget.ui.activity.CityPickerActivity;
import org.jiangtao.android_useful_utils.view.widget.ui.activity.MapSearchActivity;

public class MainActivity extends AppCompatActivity {


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    Button button = (Button) findViewById(R.id.ui_city_picker);
    Button mapButton = (Button) findViewById(R.id.ui_map_search);
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
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode==CityPickerActivity.OPEN_CITY_PICKER&&resultCode==RESULT_OK) {
      Toast.makeText(this, data.getStringExtra(CityPickerActivity.CITY_VALUE), Toast.LENGTH_SHORT).show();
    }
  }
}
