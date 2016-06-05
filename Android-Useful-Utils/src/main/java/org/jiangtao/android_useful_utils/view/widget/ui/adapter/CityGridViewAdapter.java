package org.jiangtao.android_useful_utils.view.widget.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.ui.androidinterface.OnItemClickListener;

/**
 * Created by kevin on 16-6-5.
 * hot city adapter
 */
public class CityGridViewAdapter extends BaseAdapter {

  private List<String> mHotCityDatas;
  private Context mContext;
  private OnItemClickListener mOnItemClickListener;

  public CityGridViewAdapter(Context context) {
    mContext = context;
    mOnItemClickListener = (OnItemClickListener) context;
    mHotCityDatas = new ArrayList<>();
    mHotCityDatas.add("北京市");
    mHotCityDatas.add("上海市");
    mHotCityDatas.add("广州市");
    mHotCityDatas.add("深圳市");
    mHotCityDatas.add("杭州市");
    mHotCityDatas.add("南京市");
    mHotCityDatas.add("天津市");
    mHotCityDatas.add("武汉市");
    mHotCityDatas.add("重庆市");
  }

  @Override public int getCount() {
    return mHotCityDatas.size();
  }

  @Override public Object getItem(int position) {
    return mHotCityDatas.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public View getView(final int position, View convertView, ViewGroup parent) {
    TextView view = null;
    if (convertView == null) {
      convertView = LayoutInflater.from(mContext)
          .inflate(R.layout.list_item_hot_city_gridview, parent, false);
      view = (TextView) convertView.findViewById(R.id.ui_city_picker_hot_city);
    }
    if (view != null) {
      view.setText(mHotCityDatas.get(position));
      view.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          mOnItemClickListener.onItemClick(mHotCityDatas.get(position));
        }
      });
    }
    return convertView;
  }
}