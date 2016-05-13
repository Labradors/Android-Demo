package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.ButterKnife;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.citypicker.CityPickerCallBack;

/**
 * Created by kevin on 16-5-14.
 * City Picker
 */
public class CityPickerActivity extends Activity implements CityPickerCallBack {

  public static int OPEN_CITY_PICKER = 100;
  private RecyclerView mCityPickerRecyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_city_picker);
    init();
    ButterKnife.bind(this);
  }

  private void init() {
    mCityPickerRecyclerView = (RecyclerView) findViewById(R.id.city_recycler_view);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_item_city, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int i = item.getItemId();
    if (i == R.id.action_search) {

    }
    return super.onOptionsItemSelected(item);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }

  /**
   * @return Request Code
   */
  private boolean isCorrectCode() {
    return true;
  }

  @Override public void popularCityCallBack(String cityName) {
    setActivityResult(cityName);
  }

  @Override public void locationCityCallBack(String cityName) {
    setActivityResult(cityName);
  }

  @Override public void commonCityCallBack(String cityName) {
    setActivityResult(cityName);
  }

  private void setActivityResult(String city) {
    Intent intent = getIntent();
    setResult(OPEN_CITY_PICKER, intent);
  }
}
