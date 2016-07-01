package org.jiangtao.android_useful_utils.view.widget.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.regex.Pattern;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * author MrJiang on 2016/1/28.
 */
public final class PinyinUtils {
  /**
   * 获取拼音的首字母（大写）
   */
  public static String getFirstLetter(final String pinyin) {
    if (TextUtils.isEmpty(pinyin)) return "#";
    String c = pinyin.substring(0, 1);
    Pattern pattern = Pattern.compile("^[A-Za-z]+$");
    if (pattern.matcher(c).matches()) {
      return c.toUpperCase();
    }
    return "";
  }

  @NonNull public static String getPinYin(String word) {
    char c = word.charAt(0);
    String[] pinyin = null;
    try {
      pinyin = PinyinHelper.toHanyuPinyinStringArray(c, new HanyuPinyinOutputFormat());
    } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
      badHanyuPinyinOutputFormatCombination.printStackTrace();
    }
    if (pinyin != null && pinyin.length != 0) {
      return String.valueOf(pinyin[0]);
    }
    return "";
  }
}
