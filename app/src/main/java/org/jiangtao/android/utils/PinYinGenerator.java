package org.jiangtao.android.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by MrJiang on 4/21/2016.
 */
public final class PinYinGenerator {

  private static final String EMPTY = "";

  /** 大写输出 */
  private final static HanyuPinyinOutputFormat OUTPUT_FORMAT = new HanyuPinyinOutputFormat();

  static {
    OUTPUT_FORMAT.setCaseType(HanyuPinyinCaseType.UPPERCASE);
    OUTPUT_FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
  }

  /**
   * 全拼
   *
   * @throws BadHanyuPinyinOutputFormatCombination
   */
  @SuppressWarnings("deprecation") public static String formatToPinYin(String chineseCharacters)
      throws BadHanyuPinyinOutputFormatCombination {
    if (null == chineseCharacters || EMPTY.equals(chineseCharacters.trim())) {
      return chineseCharacters;
    }

    return PinyinHelper.toHanyuPinyinString(chineseCharacters, OUTPUT_FORMAT, EMPTY);
  }

  /**
   * 获取拼音首字母
   *
   * @throws BadHanyuPinyinOutputFormatCombination
   */
  public static String formatAbbrToPinYin(String chineseCharacters)
      throws BadHanyuPinyinOutputFormatCombination {
    if (null == chineseCharacters || EMPTY.equals(chineseCharacters.trim())) {
      return chineseCharacters;
    }

    char[] chars = chineseCharacters.toCharArray();
    return String.valueOf(chars[0]);
  }
}
