package org.jiangtao.android_useful_utils.view.widget.citypicker;

/**
 * Created by kevin on 16-5-14.
 * City CallBack
 */
public interface CityPickerCallBack {
  /**
   * Hot City
   */
  void popularCityCallBack(String cityName);

  /**
   * Location City
   */
  void locationCityCallBack(String cityName);

  /**
   * Common City
   */
  void commonCityCallBack(String cityName);
}
