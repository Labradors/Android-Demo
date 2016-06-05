package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.ui.adapter.CityPickerAdapter;
import org.jiangtao.android_useful_utils.view.widget.utils.AmapLocation;
import org.jiangtao.android_useful_utils.view.widget.utils.CityCompartor;
import org.jiangtao.android_useful_utils.view.widget.widget.SideBar;

/**
 * Created by kevin on 16-5-14.
 * City Picker
 */
public class CityPickerActivity extends AppCompatActivity implements AMapLocationListener {

  public static int OPEN_CITY_PICKER = 100;
  private SearchView mUiViewSearch;
  private Toolbar mUiToolbarSearch;
  private RecyclerView mUiViewCity;
  private TextView mUiViewBubble;
  private SideBar mUiViewSidebar;
  private CityPickerAdapter mCityPickerAdapter;
  private String mCity;
  private AmapLocation mAmapLocations;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_city_picker);
    initialization();
    startAmpLocation();
    showToolBar();
    showAllCitys();
  }

  private void showAllCitys() {
    List mAllCityDatas = Arrays.asList(getResources().getStringArray(R.array.city));
    Collections.sort(mAllCityDatas, new CityCompartor());
    mCityPickerAdapter = new CityPickerAdapter(this, mAllCityDatas, mCity);
    LinearLayoutManager manager = new LinearLayoutManager(this);
    manager.setOrientation(LinearLayoutManager.VERTICAL);
    mUiViewCity.setLayoutManager(manager);
    mUiViewCity.setAdapter(mCityPickerAdapter);
    mUiViewSidebar.setBubble(mUiViewBubble);
    mUiViewSidebar.setUpCharList(mCityPickerAdapter.getLetter());
    mUiViewSidebar.setOnTouchingLetterChangedListener(
        new SideBar.OnTouchingLetterChangedListener() {
          @Override public void onTouchingLetterChanged(String s) {
            int position = mCityPickerAdapter.getPositionForSection(s.charAt(0));
            if (position != -1) {
              mUiViewCity.scrollToPosition(position);
            }
          }
        });
  }

  private void startAmpLocation() {
    mAmapLocations = new AmapLocation(getApplicationContext());
    mAmapLocations.initLocations(getApplicationContext(), this);
    mAmapLocations.startLocations();
  }

  @SuppressLint("PrivateResource") private void showToolBar() {
    mUiToolbarSearch.setTitle("");
    mUiToolbarSearch.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    mUiToolbarSearch.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
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

  private void setActivityResult(String city) {
    Intent intent = getIntent();
    setResult(OPEN_CITY_PICKER, intent);
  }

  @Override public void onLocationChanged(AMapLocation aMapLocation) {
    if (aMapLocation != null) {
      if (aMapLocation.getErrorCode() == 0) {
        if (aMapLocation.getCity() != null) {
          mCity = aMapLocation.getCity();
          mAmapLocations.stopLocations();
          mAmapLocations.destroyLocations();
          mCityPickerAdapter.notifyDataSetChanged();
        }
      }
    }
  }
}
