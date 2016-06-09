package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.RadioGroup;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import org.jiangtao.android_useful_utils.R;

/**
 * Created by kevin on 16-6-9.
 * location
 */
public class MapSearchActivity extends AppCompatActivity
    implements LocationSource, AMapLocationListener {

  private MapView mUiMapView;
  private SearchView mUiSearchView;
  private AMap mUiMap;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    initialization();
    initializationLocation();
    mUiMapView.onCreate(savedInstanceState);
  }

  private void initializationLocation() {
    if (mUiMap == null) {
      mUiMap = mUiMapView.getMap();
    }
    mUiMap.setLocationSource(this);
    mUiMap.getUiSettings().setMyLocationButtonEnabled(true);
    mUiMap.setMyLocationEnabled(true);
  }

  private void initialization() {
    mUiMapView = (MapView) findViewById(R.id.ui_view_map);
    mUiSearchView = (SearchView) findViewById(R.id.ui_view_map_search);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mUiMapView.onDestroy();
  }

  @Override protected void onResume() {
    super.onResume();
    mUiMapView.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
    mUiMapView.onPause();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mUiMapView.onSaveInstanceState(outState);
  }

  @Override public void onLocationChanged(AMapLocation aMapLocation) {
    if (aMapLocation != null) {
      if (aMapLocation.getErrorCode() == 0) {
      }
    }
  }

  @Override public void activate(OnLocationChangedListener onLocationChangedListener) {

  }

  @Override public void deactivate() {

  }
}
