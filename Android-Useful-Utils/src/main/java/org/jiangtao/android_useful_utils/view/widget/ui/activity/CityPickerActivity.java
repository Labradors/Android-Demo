package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.ui.adapter.CityPickerAdapter;
import org.jiangtao.android_useful_utils.view.widget.ui.androidinterface.OnItemClickListener;
import org.jiangtao.android_useful_utils.view.widget.utils.AmapLocation;
import org.jiangtao.android_useful_utils.view.widget.utils.CityCompartor;
import org.jiangtao.android_useful_utils.view.widget.widget.SideBar;

/**
 * Created by Kevin on 2016/6/6.
 */
public class CityPickerActivity extends AppCompatActivity
    implements AMapLocationListener, SearchView.OnQueryTextListener, OnItemClickListener {

  public static int OPEN_CITY_PICKER = 100;
  private static final int INITIAL_REQUEST = 1337;
  private static final String[] INITIAL_PERMS = {
      Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
  };
  public static final String CITY_VALUE = "city";
  private SearchView mUiViewSearch;
  private RecyclerView mUiViewCity;
  private TextView mUiViewBubble;
  private SideBar mUiViewSidebar;
  private CityPickerAdapter mCityPickerAdapter;
  private String mCity;
  private AmapLocation mAmapLocations;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_city_picker);
    showActionBar();
    initialization();
    startAmpLocation();
    showToolBar();
    showAllCitys();
  }

  private void showActionBar() {
    ActionBar bar = getSupportActionBar();
    assert bar != null;
    bar.setDisplayHomeAsUpEnabled(true);
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
    mUiViewSearch.setOnQueryTextListener(this);
    mUiViewSearch.setIconifiedByDefault(true);
    mUiViewSearch.setInputType(InputType.TYPE_CLASS_TEXT);
    mUiViewSearch.setQueryHint("请输入城市名");
    mUiViewSearch.onActionViewExpanded();
    mUiViewSearch.clearFocus();
  }

  private void initialization() {
    if (!canAccessLocation()) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        requestPermissions(INITIAL_PERMS, INITIAL_REQUEST);
      }
    }
    mUiViewSearch = (SearchView) findViewById(R.id.ui_city_picker_search);
    mUiViewCity = (RecyclerView) findViewById(R.id.ui_view_city);
    mUiViewBubble = (TextView) findViewById(R.id.ui_view_bubble);
    mUiViewSidebar = (SideBar) findViewById(R.id.ui_view_sidebar);
  }

  private boolean canAccessLocation() {
    return (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));
  }

  private boolean hasPermission(String perm) {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && (PackageManager.PERMISSION_GRANTED
        == checkSelfPermission(perm));
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mAmapLocations.destroyLocations();
  }

  private void setActivityResult(String city) {
    Intent intent = getIntent();
    intent.putExtra(CITY_VALUE, city);
    setResult(RESULT_OK, intent);
    finish();
  }

  @Override public void onLocationChanged(AMapLocation aMapLocation) {
    if (aMapLocation != null) {
      if (aMapLocation.getErrorCode() == 0) {
        if (aMapLocation.getCity() != null) {
          mCity = aMapLocation.getCity();
          mCityPickerAdapter.notifyDataSetChanged();
          mAmapLocations.stopLocations();
          mAmapLocations.destroyLocations();
        }
      }
    }
  }

  @Override public boolean onQueryTextSubmit(String query) {
    final ArrayList<String> list = mCityPickerAdapter.queryCommonName(query);
    if (list.size() != 0) {
      new MaterialDialog.Builder(this).items(list).itemsCallback(new MaterialDialog.ListCallback() {
        @Override public void onSelection(MaterialDialog dialog, View itemView, int which,
            CharSequence text) {
          setActivityResult(list.get(which));
        }
      }).show();
    } else {
      Toast.makeText(CityPickerActivity.this, "没有这个城市哦,请重新查询..", Toast.LENGTH_SHORT).show();
    }
    return true;
  }

  @Override public boolean onQueryTextChange(String newText) {
    return true;
  }

  @Override public void onItemClick(String result) {
    setActivityResult(result);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
    }
    return super.onOptionsItemSelected(item);
  }
}
