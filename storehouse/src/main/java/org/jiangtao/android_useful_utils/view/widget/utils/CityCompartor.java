package org.jiangtao.android_useful_utils.view.widget.utils;

import java.util.Comparator;

/**
 * Created by kevin on 16-6-5.
 */
public class CityCompartor implements Comparator<String> {

  @Override public int compare(String lhs, String rhs) {
    String a = PinyinUtils.getFirstLetter(PinyinUtils.getPinYin(lhs));
    String b = PinyinUtils.getFirstLetter(PinyinUtils.getPinYin(rhs));
    return a.compareTo(b);
  }
}
