package org.jiangtao.android_useful_utils.view.widget.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by kevin on 16-6-5.
 * 城市选择ViewHolder
 */
public class CityPickerAdapter extends RecyclerView.Adapter {

  private Context mContext;
  private ViewGroup mParent;

  public CityPickerAdapter(Context context,ViewGroup parent){
    this.mContext = context;
    this.mParent = parent;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }
}
