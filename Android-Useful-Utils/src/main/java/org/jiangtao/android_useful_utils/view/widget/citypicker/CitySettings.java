package org.jiangtao.android_useful_utils.view.widget.citypicker;

import java.util.List;

/**
 * Created by kevin on 16-5-14.
 * View Common
 */
public class CitySettings<T extends CommonCity> {
  private int itemType;
  private Object data;
  private List<T> mCityArray;

  // TODO: 16-5-14 build data error
  public class Builder {
    public int itemType;
    public Object data;
    public List<T> mCityArray;

    public CitySettings builder() {
      CitySettings settings = new CitySettings();
      settings.itemType = itemType;
      settings.data = data;
      settings.mCityArray = mCityArray;
      return settings;
    }
  }
}
