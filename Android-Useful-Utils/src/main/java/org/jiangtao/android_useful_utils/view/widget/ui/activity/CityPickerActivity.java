package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.TextView;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.citypicker.CityPickerCallBack;
import org.jiangtao.android_useful_utils.view.widget.widget.SideBar;

/**
 * Created by kevin on 16-5-14.
 * City Picker
 */
public class CityPickerActivity extends Activity implements CityPickerCallBack {

  public static int OPEN_CITY_PICKER = 100;
  private SearchView mUiViewSearch;
  private Toolbar mUiToolbarSearch;
  private RecyclerView mUiViewCity;
  private TextView mUiViewBubble;
  private SideBar mUiViewSidebar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_city_picker);
    initialization();
    showToolBar();
  }

  @SuppressLint("PrivateResource") private void showToolBar() {
    mUiToolbarSearch.setTitle(getResources().getString(R.string.label_city_picker));
    mUiToolbarSearch.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    mUiToolbarSearch.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
          finish();
        return true;
      }
    });
    mUiViewSearch.setQueryHint("请输入城市名...");
    mUiViewSearch.setInputType(InputType.TYPE_CLASS_TEXT);
    mUiViewSearch.onActionViewExpanded();
    mUiViewSearch.setIconified(true);
  }

  private void initialization() {
    mUiViewSearch = (SearchView) findViewById(R.id.ui_view_search);
    mUiToolbarSearch = (Toolbar) findViewById(R.id.ui_toolbar_search);
    mUiViewCity = (RecyclerView) findViewById(R.id.ui_view_city);
    mUiViewBubble = (TextView) findViewById(R.id.ui_view_bubble);
    mUiViewSidebar = (SideBar) findViewById(R.id.ui_view_sidebar);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
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
