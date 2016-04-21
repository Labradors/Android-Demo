package org.jiangtao.android.ui.viewholder;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import org.jiangtao.android.utils.setting.SettingItems;
import support.ui.adapters.EasyViewHolder;

/**
 * Created by MrJiang on 4/17/2016.
 * base viewholder
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

  private Activity mActivity;
  private SettingItems mSettingItems;
  private EasyViewHolder.OnItemClickListener itemClickListener;

  public BaseViewHolder(Context context, View itemView) {
    super(itemView);
    mActivity = (Activity) context;
    bindListeners();
  }

  private void bindListeners() {
    itemView.setOnClickListener(this);
  }

  public void bindView(SettingItems settingItem) {
    this.mSettingItems = settingItem;
    itemView.setOnClickListener(this);
    bindTo(settingItem);
  }

  protected void bindTo(SettingItems settingItem) {
  }

  @Override public void onClick(View v) {
    if (itemClickListener == null) return;
    itemClickListener.onItemClick(getAdapterPosition(), v);
  }

  public SettingItems getSettingItem() {
    return mSettingItems;
  }

  public Activity getActivity() {
    return mActivity;
  }

  public void setItemClickListener(EasyViewHolder.OnItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }
}
