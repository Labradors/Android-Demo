package org.jiangtao.android.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import org.jiangtao.android.R;
import org.jiangtao.android.utils.setting.SettingItems;

/**
 * Created by MrJiang on 4/21/2016.
 */
public class LetterViewHolder extends BaseViewHolder {
  @Bind(R.id.text) TextView mText;

  public LetterViewHolder(Context context, ViewGroup parent) {
    super(context, LayoutInflater.from(context).inflate(R.layout.list_item_letter, parent, false));
    ButterKnife.bind(this, itemView);
  }

  @Override protected void bindTo(SettingItems settingItem) {
    super.bindTo(settingItem);
    mText.setText(settingItem.mText);
  }
}
