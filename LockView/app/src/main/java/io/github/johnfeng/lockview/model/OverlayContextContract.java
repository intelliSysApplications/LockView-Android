package io.github.johnfeng.lockview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guangweifeng on 16/08/15.
 */
public class OverlayContextContract implements Parcelable {

    @SerializedName("Title")
    public String title;

    @SerializedName("FirstLine")
    public String firstLine;

    @SerializedName("SecondLine")
    public String secondLine;


    protected OverlayContextContract(Parcel in) {
        title = in.readString();
        firstLine = in.readString();
        secondLine = in.readString();
    }

    public static final Creator<OverlayContextContract> CREATOR = new Creator<OverlayContextContract>() {
        @Override
        public OverlayContextContract createFromParcel(Parcel in) {
            return new OverlayContextContract(in);
        }

        @Override
        public OverlayContextContract[] newArray(int size) {
            return new OverlayContextContract[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(firstLine);
        dest.writeString(secondLine);
    }

    @Override
    public String toString() {
        return "OverlayContextContract{" +
                "title='" + title + '\'' +
                ", firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                '}';
    }
}
