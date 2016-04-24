package org.jiangtao.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import org.jiangtao.android.R;
import support.ui.adapters.EasyRecyclerAdapter;
import support.ui.adapters.EasyViewHolder;

public class MainActivity extends AppCompatActivity implements EasyViewHolder.OnItemClickListener {

  @Bind(R.id.search) SearchView mSearch;
  @Bind(R.id.city) RecyclerView mCity;
  @Bind(R.id.title) RecyclerView mTitle;
  private EasyRecyclerAdapter mAdapter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mTitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
  }

  @Override public void onItemClick(int position, View view) {

  }
}
