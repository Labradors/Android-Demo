package org.jiangtao.android_useful_utils.view.widget.ui.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kevin on 16-6-19.
 */
public class Image implements Parcelable{

    public String url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.url = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public Uri getUri() {
        return Uri.parse(url);
    }
}
