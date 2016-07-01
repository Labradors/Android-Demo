package org.jiangtao.android_useful_utils.view.widget.utils;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import java.util.ArrayList;

/**
 * Created by MrJiang
 * on 2016/4/19.
 */
public class AmapLocation {


  public AMapLocationClient mLocationClient = null;
  public Context mContext;
  public ArrayList<Double> mLocationsList;

  public AmapLocation(Context context) {
    mContext = context;
    mLocationClient = new AMapLocationClient(context.getApplicationContext());
  }

  public void initLocations(Context context, AMapLocationListener listener) {
    mLocationClient.setLocationListener(listener);
    AMapLocationClientOption mLocationOption = null;
    mLocationOption = new AMapLocationClientOption();
    mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    mLocationOption.setNeedAddress(true);
    mLocationOption.setOnceLocation(false);
    mLocationOption.setWifiActiveScan(true);
    mLocationOption.setMockEnable(false);
    mLocationOption.setInterval(2000);
    mLocationClient.setLocationOption(mLocationOption);
  }

  public void startLocations() {
    mLocationClient.startLocation();
  }

  public void stopLocations() {
    mLocationClient.stopLocation();
  }

  public void destroyLocations() {
    mLocationClient.onDestroy();
  }
}
