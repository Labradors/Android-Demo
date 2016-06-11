package org.jiangtao.android_useful_utils.view.widget.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.jiangtao.android_useful_utils.R;
import org.jiangtao.android_useful_utils.view.widget.ui.interfaces.OnItemClickListener;
import org.jiangtao.android_useful_utils.view.widget.ui.viewholder.CityPickerViewHolder;
import org.jiangtao.android_useful_utils.view.widget.ui.viewholder.HotViewHolder;
import org.jiangtao.android_useful_utils.view.widget.ui.viewholder.LocationViewHolder;
import org.jiangtao.android_useful_utils.view.widget.utils.PinyinUtils;

/**
 * Created by kevin on 16-6-5.
 * 城市选择ViewHolder
 */
public class CityPickerAdapter extends RecyclerView.Adapter {

  public static final int VIEW_TYPE_LOCATION = 0;
  public static final int VIEW_TYPE_HOT = 1;
  public static final int VIEW_TYPE_ALL = 2;
  private Context mContext;
  private ArrayList<String> mCityDatas;
  private String mCity;
  private OnItemClickListener mOnItemClickListener;

  public CityPickerAdapter(Context context, List<String> citys, String city) {
    this.mContext = context;
    mOnItemClickListener = (OnItemClickListener) context;
    mCityDatas = new ArrayList<>();
    mCityDatas.clear();
    mCityDatas.addAll(citys);
    mCity = city;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    switch (viewType) {
      case VIEW_TYPE_ALL:
        View viewAll =
            LayoutInflater.from(mContext).inflate(R.layout.list_item_all_city, parent, false);
        return new CityPickerViewHolder(mContext, viewAll);

      case VIEW_TYPE_LOCATION:
        View viewLocation =
            LayoutInflater.from(mContext).inflate(R.layout.list_item_location, parent, false);
        return new LocationViewHolder(viewLocation);

      case VIEW_TYPE_HOT:
        View viewHot =
            LayoutInflater.from(mContext).inflate(R.layout.list_item_gridview, parent, false);
        return new HotViewHolder(viewHot);
    }
    return null;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    if (holder instanceof CityPickerViewHolder) {
      CityPickerViewHolder allViewHolder = (CityPickerViewHolder) holder;
      if (position < mCityDatas.size() - 1) {
        allViewHolder.mNameTextView.setText(mCityDatas.get(position));
      }
      if (position != 2 && position < mCityDatas.size()) {
        String oldLetter =
            PinyinUtils.getFirstLetter(PinyinUtils.getPinYin(mCityDatas.get(position - 1)));
        String currentLetter =
            PinyinUtils.getFirstLetter(PinyinUtils.getPinYin(mCityDatas.get(position)));
        if (currentLetter.equals(oldLetter)) {
          allViewHolder.mLetterTextView.setVisibility(View.GONE);
        } else {
          allViewHolder.mLetterTextView.setVisibility(View.VISIBLE);
          allViewHolder.mLetterTextView.setText(currentLetter);
        }
      } else {
        if (position < mCityDatas.size()) {
          allViewHolder.mLetterTextView.setVisibility(View.VISIBLE);
          allViewHolder.mLetterTextView.setText(
              PinyinUtils.getFirstLetter(PinyinUtils.getPinYin(mCityDatas.get(position))));
        }
      }
      allViewHolder.mNameTextView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          mOnItemClickListener.onItemClick(mCityDatas.get(position));
        }
      });
    } else if (holder instanceof HotViewHolder) {
      HotViewHolder hotViewHolder = (HotViewHolder) holder;
      hotViewHolder.mGridView.setAdapter(new CityGridViewAdapter(mContext));
    } else if (holder instanceof LocationViewHolder) {
      LocationViewHolder locationViewHolder = (LocationViewHolder) holder;
      locationViewHolder.mTextView.setText(mCity != null ? mCity : "正在定位当前城市...");
      locationViewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (mCity != null) {
            mOnItemClickListener.onItemClick(mCity);
          }
        }
      });
    }
  }

  @Override public int getItemCount() {
    return mCityDatas.size() + 2;
  }

  public ArrayList<String> getLetter() {
    ArrayList<String> cityStrings = new ArrayList<>();
    for (String c : mCityDatas) {
      String letter = PinyinUtils.getFirstLetter(PinyinUtils.getPinYin(c));
      if (!cityStrings.contains(letter)) {
        cityStrings.add(letter);
      }
    }
    return cityStrings;
  }

  public int getPositionForSection(char section) {
    for (int index = 0; index < mCityDatas.size(); index++) {
      final String object = mCityDatas.get(index);
      if (object != null) {
        char firstChar = PinyinUtils.getFirstLetter(PinyinUtils.getPinYin(object)).charAt(0);
        if (firstChar == section) {
          return index;
        }
      }
    }
    return RecyclerView.NO_POSITION;
  }

  @Override public int getItemViewType(int position) {
    switch (position) {
      case 0:
        return VIEW_TYPE_LOCATION;
      case 1:
        return VIEW_TYPE_HOT;
      default:
        return VIEW_TYPE_ALL;
    }
  }

  public ArrayList<String> queryCommonName(String name) {
    ArrayList<String> lists = new ArrayList<>();
    String letter = PinyinUtils.getPinYin(name);
    for (String city : mCityDatas) {
      String cityLetter = PinyinUtils.getPinYin(city);
      if (letter.equals(cityLetter)) {
        lists.add(city);
      }
    }
    return lists;
  }
}
