package org.jiangtao.android.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import org.jiangtao.android.R;
import org.jiangtao.android.model.Letter;
import org.jiangtao.android.ui.adapter.HotCityGridAdapter;
import org.jiangtao.android.ui.view.WrapHeightGridView;
import org.jiangtao.android.ui.viewholder.LetterViewHolder;
import org.jiangtao.android.utils.setting.LetterBuildUtils;
import support.ui.adapters.BaseEasyViewHolderFactory;
import support.ui.adapters.EasyRecyclerAdapter;
import support.ui.adapters.EasyViewHolder;

public class MainActivity extends AppCompatActivity implements EasyViewHolder.OnItemClickListener {

  @Bind(R.id.search) SearchView mSearch;
  @Bind(R.id.locations_city) TextView mLocationsCity;
  @Bind(R.id.city) RecyclerView mAllCity;
  @Bind(R.id.text_pro) TextView mTextPro;
  @Bind(R.id.result) RecyclerView mResult;
  @Bind(R.id.title) RecyclerView mTitle;
  @Bind(R.id.gridview) WrapHeightGridView mWrapHeightGridView;
  private EasyRecyclerAdapter mAdapter;
  private EasyRecyclerAdapter mLetterAdaper;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mSearch.setIconifiedByDefault(false);
    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    mWrapHeightGridView.setAdapter(new HotCityGridAdapter(getApplicationContext()));
    mLetterAdaper = new EasyRecyclerAdapter(this);
    mLetterAdaper.viewHolderFactory(new BaseEasyViewHolderFactory(this));
    mLetterAdaper.bind(Letter.class, LetterViewHolder.class);
    mTitle.setLayoutManager(new LinearLayoutManager(this));
    mTitle.setAdapter(mLetterAdaper);
  }

  @Override protected void onResume() {
    super.onResume();
    mLetterAdaper.appendAll(LetterBuildUtils.buildLetterDatas());
    mLetterAdaper.notifyDataSetChanged();
  }

  @Override public void onItemClick(int position, View view) {

  }
}
