package io.github.johnfeng.lockview.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import io.github.johnfeng.lockview.model.OverlayContextContract;
import io.github.johnfeng.lockview.model.OverlayFormattingContract;
import io.github.johnfeng.lockview.model.OverlayLayoutContract;

/**
 * Created by guangweifeng on 19/08/15.
 */
public class ImageCompositionRequest implements Parcelable {

    @SerializedName("RawImage")
    public byte[] rawImage;

    @SerializedName("ImageRequestOverride")
    public ImageRequestOverride imageRequestOverride;

    @SerializedName("OverlayFormattingContract")
    public OverlayFormattingContract overlayFormattingContract;

    @SerializedName("OverlayLayoutContract")
    public OverlayLayoutContract overlayLayoutContract;

    @SerializedName("OverlayContextContract")
    public OverlayContextContract overlayContextContract;

    protected ImageCompositionRequest(Parcel in) {
        in.readByteArray(rawImage);
        in.readParcelable(ImageRequestOverride.class.getClassLoader());
        in.readParcelable(OverlayFormattingContract.class.getClassLoader());
        in.readParcelable(OverlayLayoutContract.class.getClassLoader());
        in.readParcelable(OverlayContextContract.class.getClassLoader());
    }

    public static final Creator<ImageCompositionRequest> CREATOR = new Creator<ImageCompositionRequest>() {
        @Override
        public ImageCompositionRequest createFromParcel(Parcel in) {
            return new ImageCompositionRequest(in);
        }

        @Override
        public ImageCompositionRequest[] newArray(int size) {
            return new ImageCompositionRequest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(rawImage);
        dest.writeParcelable(imageRequestOverride, flags);
        dest.writeParcelable(overlayFormattingContract, flags);
        dest.writeParcelable(overlayLayoutContract, flags);
        dest.writeParcelable(overlayContextContract, flags);
    }

    @Override
    public String toString() {
        return "ImageCompositionRequest{" +
                "rawImage=" + Arrays.toString(rawImage) +
                ", imageRequestOverride=" + imageRequestOverride +
                ", overlayFormattingContract=" + overlayFormattingContract +
                ", overlayLayoutContract=" + overlayLayoutContract +
                ", overlayContextContract=" + overlayContextContract +
                '}';
    }
}
