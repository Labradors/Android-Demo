package org.jiangtao.android_useful_utils.view.widget.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.widget.WrapHeightGridView;

/**
 * Class: HotViewHolder <br>
 * Description:  <br>
 * Creator: kevin <br>
 * Date: 16/8/17 上午12:19 <br>
 * Update: 16/8/17 上午12:19 <br>
 */
public class HotViewHolder extends RecyclerView.ViewHolder {

  public WrapHeightGridView mGridView;

  public HotViewHolder(View itemView) {
    super(itemView);
    mGridView = (WrapHeightGridView) itemView.findViewById(R.id.ui_city_picker_grid);
  }
}
