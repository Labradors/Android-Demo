package org.jiangtao.android_useful_utils.view.widget.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import org.jiangtao.android_useful_utils.R;

/**
 * Created by kevin on 16-6-5.
 */
public class CityPickerViewHolder extends RecyclerView.ViewHolder {

  public TextView mLetterTextView;
  public TextView mNameTextView;

  public CityPickerViewHolder(Context context,View itemView) {
    super(itemView);
    mLetterTextView = (TextView) itemView.findViewById(R.id.ui_city_picker_letter);
    mNameTextView = (TextView) itemView.findViewById(R.id.ui_city_picker_name);
  }
}
