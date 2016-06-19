package org.jiangtao.android_useful_utils.view.widget.ui.activity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.ui.interfaces.OnParcelableCallBack;
import org.jiangtao.android_useful_utils.view.widget.ui.model.Image;
import org.jiangtao.android_useful_utils.view.widget.widget.zoomImageView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 必须指定方法名getUri();
 */
public class GlideMaxImageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    public static final String CONSTANT_IMAGE_LIST = "list";
    public static final String CONSTANT_IMAGE_POSTION = "list_position";
    private List<? extends Parcelable> mItemLists;
    private int position;
    private ViewPager mUiViewViewPager;
    private TextView mUiViewPageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_max_image);
        ButterKnife.bind(this);
        initializationView();
        initializationItemList();
        setUpViewPagerAdapter();
    }

    @SuppressLint("SetTextI18n")
    private void setUpViewPagerAdapter() {
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter();
        mUiViewViewPager.setAdapter(adapter);
        mUiViewViewPager.setCurrentItem(position);
        mUiViewViewPager.setOnPageChangeListener(this);
        mUiViewPageText.setText(position + "/" + mItemLists.size());
    }

    private void initializationItemList() {
        mItemLists = getIntent().getParcelableArrayListExtra(CONSTANT_IMAGE_LIST);
        position = getIntent().getIntExtra(CONSTANT_IMAGE_POSTION, 0);
    }

    private void initializationView() {
        mUiViewViewPager = ButterKnife.findById(this, R.id.ui_view_view_pager);
        mUiViewPageText = ButterKnife.findById(this, R.id.ui_view_page_text);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onPageSelected(int position) {
        position += 1;
        mUiViewPageText.setText(position + "/" + mItemLists.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    class ImageViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (mItemLists != null && mItemLists.size() != 0) {
                return mItemLists.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View) object;
            container.removeView(v);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = LayoutInflater.from(GlideMaxImageActivity.this).inflate(R.layout.list_item_zoom_imageview, container, false);
            zoomImageView mImageView = (zoomImageView) v.findViewById(R.id.ui_view_zoom_image);
            //需要使用反射
            Class aClass = mItemLists.get(position).getClass();
            String name = null;
            Field field = null;
            try {
                field = aClass.getDeclaredField("url");
                name = field.getName();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Uri uri = Uri.EMPTY;
//            try {
//                Method method;
//                method = aClass.getMethod("getUri");
//                method.setAccessible(true);
//                Type returnType = method.getReturnType();
//                System.out.println("--------"+returnType.getClass().getSimpleName());
//                uri = (Uri) method.invoke(aClass);
//
//            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
            Glide.with(GlideMaxImageActivity.this).load(
                    Uri.parse("http://pics.sc.chinaz.com/files/pic/pic9/201606/apic21154.jpg"))
                    .centerCrop().into(mImageView);

            container.addView(mImageView);
            return mImageView;
        }
    }
}
