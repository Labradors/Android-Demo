package org.jiangtao.android.ui.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import org.jiangtao.android.R;
import org.jiangtao.android.model.Letter;
import support.ui.adapters.EasyViewHolder;

/**
 * Created by MrJiang on 4/21/2016.
 */
public class LetterViewHolder extends EasyViewHolder<Letter> {
  @Bind(R.id.text) TextView mText;

  public LetterViewHolder(Context context, ViewGroup parent) {
    super(context, parent, R.layout.list_item_letter);
    ButterKnife.bind(this, itemView);
  }

  @Override public void bindTo(int position, Letter value) {
    mText.setText(value.text);
  }
}
