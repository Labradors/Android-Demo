package org.jiangtao.android_useful_utils.view.widget.utils;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import java.util.ArrayList;

/**
 * Created by MrJiang
 * on 2016/4/19.
 * 定位
 */
public class AmapLocation {

  //声明AMapLocationClient类对象
  public AMapLocationClient mLocationClient = null;
  public Context mContext;
  public ArrayList<Double> mLocationsList;

  public AmapLocation(Context context) {
    mContext = context;
    mLocationClient = new AMapLocationClient(context.getApplicationContext());
  }

  public void initLocations(Context context, AMapLocationListener listener) {
    //设置定位回调监听
    mLocationClient.setLocationListener(listener);
    AMapLocationClientOption mLocationOption = null;
    //初始化定位参数
    mLocationOption = new AMapLocationClientOption();
    //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
    mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    //设置是否返回地址信息（默认返回地址信息）
    mLocationOption.setNeedAddress(true);
    //设置是否只定位一次,默认为false
    mLocationOption.setOnceLocation(false);
    //设置是否强制刷新WIFI，默认为强制刷新
    mLocationOption.setWifiActiveScan(true);
    //设置是否允许模拟位置,默认为false，不允许模拟位置
    mLocationOption.setMockEnable(false);
    //设置定位间隔,单位毫秒,默认为2000ms
    mLocationOption.setInterval(2000);
    //给定位客户端对象设置定位参数
    mLocationClient.setLocationOption(mLocationOption);
  }

  /**
   * 启动定位
   */
  public void startLocations() {
    mLocationClient.startLocation();
  }

  /**
   * 停止定位
   */
  public void stopLocations() {
    mLocationClient.stopLocation();
  }

  /**
   * 销毁定位
   */
  public void destroyLocations() {
    mLocationClient.onDestroy();
  }
}
