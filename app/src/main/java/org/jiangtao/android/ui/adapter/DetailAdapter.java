package org.jiangtao.android.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import org.jiangtao.android.ui.viewholder.BaseViewHolder;
import org.jiangtao.android.utils.setting.SettingItems;
import support.ui.adapters.EasyViewHolder;
import support.ui.adapters.debounced.DebouncedOnClickListener;


/**
 * Created by MrJiang on 4/17/2016.
 * 复用adapter
 */
public class DetailAdapter extends RecyclerView.Adapter<BaseViewHolder> {

  private ArrayList<SettingItems> mSettingItems;
  private Context mContext;
  private EasyViewHolder.OnItemClickListener itemClickListener;
  public DetailAdapter(Context context, ArrayList<SettingItems> settingItems) {
    this.mContext = context;
    this.mSettingItems = settingItems;
  }

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    BaseViewHolder baseViewHolder = null;
    switch (viewType) {
      case SettingItems.VIEW_TYPE_RELATIVE_CELL:
        break;
      case SettingItems.VIEW_TYPE_PHOTO_CELL:
        break;
      case SettingItems.VIEW_TYPE_DYNAMIC_CELL:
        break;
      case SettingItems.VIEW_TYPE_SIGNATURE_CELL:
        break;
      case SettingItems.VIEW_TYPE_SERVICE_CELL:
        break;
      case SettingItems.VIEW_TYPE_INFO_CELL:
        break;
      case SettingItems.VIEW_TYPE_ACCOUNT_HEADER:
        break;
    }
    bindListeners(baseViewHolder);
    return baseViewHolder;
  }

  public void setOnClickListener(final EasyViewHolder.OnItemClickListener listener) {
    this.itemClickListener = new DebouncedOnClickListener() {
      @Override public boolean onDebouncedClick(View v, int position) {
        if (listener != null) {
          listener.onItemClick(position, v);
        }
        return true;
      }
    };
  }

  private void bindListeners(BaseViewHolder cellViewHolder) {
    if (cellViewHolder != null) {
      cellViewHolder.setItemClickListener(itemClickListener);
    }
  }

  @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
    SettingItems settingItems = mSettingItems.get(position);
    holder.bindView(settingItems);
  }

  @Override public int getItemCount() {
    return mSettingItems == null ? 0 : mSettingItems.size();
  }

  @Override public int getItemViewType(int position) {
    SettingItems settingItem = mSettingItems.get(position);
    return settingItem.itemViewType;
  }
}
