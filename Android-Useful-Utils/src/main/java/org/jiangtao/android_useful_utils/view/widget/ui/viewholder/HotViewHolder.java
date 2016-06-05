package org.jiangtao.android_useful_utils.view.widget.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import org.jiangtao.android_useful_utils.R;

/**
 * Created by kevin on 16-6-5.
 */
public class HotViewHolder extends RecyclerView.ViewHolder {

  public RecyclerView mGridView;

  public HotViewHolder(View itemView) {
    super(itemView);
    mGridView = (RecyclerView) itemView.findViewById(R.id.ui_city_picker_hot);
  }
}
