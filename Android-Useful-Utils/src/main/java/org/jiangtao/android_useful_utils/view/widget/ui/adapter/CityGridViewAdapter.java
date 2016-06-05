package org.jiangtao.android_useful_utils.view.widget.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import org.jiangtao.android_useful_utils.R;

/**
 * Created by kevin on 16-6-5.
 * hot city adapter
 */
public class CityGridViewAdapter
    extends RecyclerView.Adapter<CityGridViewAdapter.HotCityViewHolder> {

  private List<String> mHotCityDatas;
  private Context mContext;

  public CityGridViewAdapter(Context context) {
    mContext = context;
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

  @Override public HotCityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(mContext).inflate(R.layout.list_item_hot_city_gridview, parent, false);
    return new HotCityViewHolder(view);
  }

  @Override public void onBindViewHolder(HotCityViewHolder holder, int position) {
    if (holder.name!=null) {
      holder.name.setText(mHotCityDatas.get(position));
    }
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemCount() {
    return mHotCityDatas.size();
  }

  public class HotCityViewHolder extends RecyclerView.ViewHolder {
    TextView name;

    public HotCityViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.ui_city_picker_hot_city);
    }
  }
}