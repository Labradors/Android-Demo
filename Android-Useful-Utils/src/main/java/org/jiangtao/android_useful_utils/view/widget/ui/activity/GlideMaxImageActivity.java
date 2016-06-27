package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.widget.ViewPagerFixed;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 必须指定方法名getUri();
 */
public class GlideMaxImageActivity extends AppCompatActivity
    implements ViewPager.OnPageChangeListener {

  public static final String CONSTANT_IMAGE_LIST = "list";
  public static final String CONSTANT_IMAGE_POSTION = "list_position";
  public static final String CONSTANT_IMAGE = "image";
  private List<String> mItemLists;
  private int position;
  private ViewPagerFixed mUiViewViewPager;
  private TextView mUiViewPageText;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_glide_max_image);
    ButterKnife.bind(this);
    initializationView();
    initializationItemList();
    setUpViewPagerAdapter();
  }

  @SuppressLint("SetTextI18n") private void setUpViewPagerAdapter() {
    ImageViewPagerAdapter adapter = new ImageViewPagerAdapter();
    mUiViewViewPager.setAdapter(adapter);
    mUiViewViewPager.setCurrentItem(position);
    mUiViewViewPager.setOnPageChangeListener(this);
    mUiViewPageText.setText((position + 1) + "/" + mItemLists.size());
  }

  private void initializationItemList() {
    mItemLists = getIntent().getStringArrayListExtra(CONSTANT_IMAGE_LIST);
    position = getIntent().getIntExtra(CONSTANT_IMAGE_POSTION, 0);
    String image = getIntent().getStringExtra(CONSTANT_IMAGE);
    if (image != null) {
      mItemLists = new ArrayList<>();
      mItemLists.add(image);
    }
  }

  private void initializationView() {
    mUiViewViewPager = ButterKnife.findById(this, R.id.ui_view_view_pager);
    mUiViewPageText = ButterKnife.findById(this, R.id.ui_view_page_text);
  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

  }

  @SuppressLint("SetTextI18n") @Override public void onPageSelected(int position) {
    mUiViewPageText.setText((position + 1) + "/" + mItemLists.size());
    position += 1;
  }

  @Override public void onPageScrollStateChanged(int state) {

  }

  class ImageViewPagerAdapter extends PagerAdapter {

    @Override public int getCount() {
      if (mItemLists != null && mItemLists.size() != 0) {
        return mItemLists.size();
      }
      return 0;
    }

    @Override public boolean isViewFromObject(View view, Object object) {
      return view == object;
    }

    @Override public void destroyItem(ViewGroup container, int position, Object object) {
      View v = (View) object;
      container.removeView(v);
    }

    @Override public Object instantiateItem(ViewGroup container, int position) {
      View v = LayoutInflater.from(GlideMaxImageActivity.this)
          .inflate(R.layout.list_item_zoom_imageview, container, false);
      PhotoView imageView = (PhotoView) v.findViewById(R.id.ui_view_zoom_image);
      Uri uri = Uri.parse(mItemLists.get(position));
      container.addView(imageView);
      Glide.with(GlideMaxImageActivity.this).load(uri).into(imageView);
      imageView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
        @Override public void onPhotoTap(View view, float v, float v1) {
          GlideMaxImageActivity.this.finish();
        }

        @Override public void onOutsidePhotoTap() {

        }
      });
      return imageView;
    }
  }
}
