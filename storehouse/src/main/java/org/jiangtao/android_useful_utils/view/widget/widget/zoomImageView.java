package org.jiangtao.android_useful_utils.view.widget.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by kevin on 16-6-19.
 */
public class zoomImageView extends ImageView {
    public zoomImageView(Context context) {
        super(context);
    }

    public zoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public zoomImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public zoomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
