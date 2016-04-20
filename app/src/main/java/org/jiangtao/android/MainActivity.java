package org.jiangtao.android;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.jiangtao.android.ui.widget.IndexableListView;
import org.jiangtao.android.utils.PinYinGenerator;
import org.jiangtao.android.utils.StringMatcher;

public class MainActivity extends AppCompatActivity {

  private ArrayList<String> mItems;
  private IndexableListView mListView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mItems = new ArrayList<String>();
    mItems.add("你好");
    mItems.add("我好");
    mItems.add("日本");
    mItems.add("美国");
    mItems.add("新疆");
    mItems.add("德国");
    mItems.add("英国");
    mItems.add("法国)");
    mItems.add("俄罗斯");
    mItems.add("诺曼底");
    mItems.add("成都市");
    mItems.add("宜宾市");
    mItems.add("维吾尔族");
    mItems.add("汉族");
    mItems.add("蒙古族");
    mItems.add("白族");
    mItems.add("壮族");
    mItems.add("苗族)");
    mItems.add("纳西族");
    mItems.add("藏族");
    mItems.add("你好");
    mItems.add("我好");
    mItems.add("日本");
    mItems.add("美国");
    mItems.add("新疆");
    mItems.add("德国");
    mItems.add("英国");
    mItems.add("法国)");
    mItems.add("俄罗斯");
    mItems.add("诺曼底");
    mItems.add("成都市");
    mItems.add("宜宾市");
    mItems.add("维吾尔族");
    mItems.add("汉族");
    mItems.add("蒙古族");
    mItems.add("白族");
    mItems.add("壮族");
    mItems.add("苗族)");
    mItems.add("纳西族");
    mItems.add("藏族");
    ArrayList<String> mItemsPinYin = new ArrayList<>();
    for (int i = 0; i < mItems.size(); i++) {
      try {
        mItemsPinYin.add(PinYinGenerator.formatAbbrToPinYin(mItems.get(i)));
      } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
        badHanyuPinyinOutputFormatCombination.printStackTrace();
      }
    }

    Collections.sort(mItemsPinYin);

    ContentAdapter adapter = new ContentAdapter(this, android.R.layout.simple_list_item_1, mItems);

    mListView = (IndexableListView) findViewById(R.id.list);
    assert mListView != null;
    mListView.setAdapter(adapter);
    mListView.setFastScrollEnabled(true);
  }

  private class ContentAdapter extends ArrayAdapter<String> implements SectionIndexer {

    private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ContentAdapter(Context context, int textViewResourceId, List<String> objects) {
      super(context, textViewResourceId, objects);
    }

    @Override public int getPositionForSection(int section) {
      // If there is no item for current section, previous section will be selected
      for (int i = section; i >= 0; i--) {
        for (int j = 0; j < getCount(); j++) {
          if (i == 0) {
            // For numeric section
            for (int k = 0; k <= 9; k++) {
              if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(k))) {
                return j;
              }
            }
          } else {
            if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)),
                String.valueOf(mSections.charAt(i)))) {
              return j;
            }
          }
        }
      }
      return 0;
    }

    @Override public int getSectionForPosition(int position) {
      return 0;
    }

    @Override public Object[] getSections() {
      String[] sections = new String[mSections.length()];
      for (int i = 0; i < mSections.length(); i++)
        sections[i] = String.valueOf(mSections.charAt(i));
      return sections;
    }
  }
}
