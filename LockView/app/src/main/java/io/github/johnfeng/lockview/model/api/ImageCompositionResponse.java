package io.github.johnfeng.lockview.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by guangweifeng on 19/08/15.
 */
public class ImageCompositionResponse implements Parcelable {

    @SerializedName("Image")
    public byte[] image;

    @SerializedName("ResultString")
    public String resultString;

    protected ImageCompositionResponse(Parcel in) {
        in.readByteArray(image);
        this.resultString = in.readString();
    }

    public static final Creator<ImageCompositionResponse> CREATOR = new Creator<ImageCompositionResponse>() {
        @Override
        public ImageCompositionResponse createFromParcel(Parcel in) {
            return new ImageCompositionResponse(in);
        }

        @Override
        public ImageCompositionResponse[] newArray(int size) {
            return new ImageCompositionResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(image);
        dest.writeString(resultString);
    }

    @Override
    public String toString() {
        return "ImageCompositionResponse{" +
                "image=" + Arrays.toString(image) +
                ", resultString='" + resultString + '\'' +
                '}';
    }
}
