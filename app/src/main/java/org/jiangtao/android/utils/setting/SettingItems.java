package org.jiangtao.android.utils.setting;

import java.util.ArrayList;

/**
 * Created by MrJiang
 * on 4/17/2016.
 */
public class SettingItems {

  public static final int VIEW_TYPE_RELATIVE_CELL = 0;
  public static final int VIEW_TYPE_PHOTO_CELL = 1;
  public static final int VIEW_TYPE_DYNAMIC_CELL = 2;
  public static final int VIEW_TYPE_SIGNATURE_CELL = 3;
  public static final int VIEW_TYPE_SERVICE_CELL = 4;
  public static final int VIEW_TYPE_INFO_CELL = 5;
  public static final int VIEW_TYPE_ACCOUNT_HEADER = 6;

  public int itemViewType;
  public ArrayList<String> mList;
  public String mContent;
  public String mText;
  public String mValue;
  public int mType;
  public int mIcon;
  public Object mData;

  private SettingItems() {
  }

  public static class Builder {
    private int itemViewType;
    private ArrayList<String> mList;
    private String mContent;
    private String mText;
    private String mValue;
    private int mType;
    private int mIcon;
    private Object mData;

    public SettingItems build() {
      SettingItems settingItems = new SettingItems();
      settingItems.itemViewType = itemViewType;
      settingItems.mList = mList;
      settingItems.mContent = mContent;
      settingItems.mText = mText;
      settingItems.mValue = mValue;
      settingItems.mType = mType;
      settingItems.mIcon = mIcon;
      settingItems.mData = mData;
      return settingItems;
    }

    public Builder itemViewType(int itemViewType) {
      this.itemViewType = itemViewType;
      return this;
    }

    public Builder list(ArrayList<String> list) {
      this.mList = list;
      return this;
    }

    public Builder content(String content) {
      this.mContent = content;
      return this;
    }

    public Builder text(String text) {
      this.mText = text;
      return this;
    }

    public Builder value(String value) {
      this.mValue = value;
      return this;
    }

    public Builder type(int type) {
      this.mType = type;
      return this;
    }

    public Builder icon(int icon) {
      this.mIcon = icon;
      return this;
    }

    public Builder data(Object data) {
      this.mData = data;
      return this;
    }
  }
}
