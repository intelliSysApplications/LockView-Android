package io.github.johnfeng.lockview.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guangweifeng on 19/08/15.
 */
public class ImageRequestOverride implements Parcelable {

    @SerializedName("ImageRequestUrl")
    public String imageRequestUrl;

    @SerializedName("Arguments")
    public String arguments;

    protected ImageRequestOverride(Parcel in) {
        imageRequestUrl = in.readString();
        arguments = in.readString();
    }

    public static final Creator<ImageRequestOverride> CREATOR = new Creator<ImageRequestOverride>() {
        @Override
        public ImageRequestOverride createFromParcel(Parcel in) {
            return new ImageRequestOverride(in);
        }

        @Override
        public ImageRequestOverride[] newArray(int size) {
            return new ImageRequestOverride[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageRequestUrl);
        dest.writeString(arguments);
    }

    @Override
    public String toString() {
        return "ImageRequestOverride{" +
                "imageRequestUrl='" + imageRequestUrl + '\'' +
                ", arguments='" + arguments + '\'' +
                '}';
    }
}
