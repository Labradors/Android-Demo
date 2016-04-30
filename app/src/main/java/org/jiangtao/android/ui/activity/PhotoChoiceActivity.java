package org.jiangtao.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import mediapicker.MediaItem;
import mediapicker.MediaOptions;
import mediapicker.activities.MediaPickerActivity;
import org.jiangtao.android.R;

/**
 * Created by MrJiang on 4/30/2016.
 * demo
 */
public class PhotoChoiceActivity extends AppCompatActivity {

  public static int REQUEST_PHOTOGRAPH = 500;
  public static int REQUEST_MEDIA = 200;
  private ArrayList<MediaItem> items = new ArrayList<>();

  @Bind(R.id.photo_single_image) Button mPhotoSingleImage;
  @Bind(R.id.photo_multi_image) Button mPhotoMultiImage;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photo_choice);
    ButterKnife.bind(this);
  }

  @OnClick({ R.id.photo_single_image, R.id.photo_multi_image, R.id.photo_gallery })
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.photo_single_image:
        MediaOptions.Builder builders = new MediaOptions.Builder();
        MediaOptions options =
            builders.setIsCropped(true).setFixAspectRatio(true).setImageSize(1).build();
        MediaPickerActivity.open(this, REQUEST_MEDIA, options, false);
        break;
      case R.id.photo_multi_image:
        MediaOptions.Builder builder = new MediaOptions.Builder();
        MediaOptions options1 =
            builder.canSelectMultiPhoto(true).setMediaListSelected(items).setImageSize(9).build();
        MediaPickerActivity.open(this, REQUEST_MEDIA, options1, false);
        break;
      case R.id.photo_gallery:
        MediaOptions.Builder builders2 = new MediaOptions.Builder();
        MediaOptions options2 =
            builders2.setIsCropped(true).setFixAspectRatio(true).setImageSize(1).build();
        MediaPickerActivity.open(this, REQUEST_PHOTOGRAPH, options2, true);
        break;
    }
  }
}
