package io.github.johnfeng.lockview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guangweifeng on 16/08/15.
 */
public class OverlayFormattingContract implements Parcelable {

    @SerializedName("TitleFont")
    public FontContract titleFont = new FontContract("Segoe UI", 16);

    @SerializedName("ForegroundTitle")
    public String foregroundTitle;

    @SerializedName("BackgroundTitle")
    public String backgroundTitle;

    @SerializedName("FirstLineFont")
    public FontContract firstLineFont;

    @SerializedName("ForegroundFirstLine")
    public String foregroundFirstLine;

    @SerializedName("BackgroundFirstLine")
    public String backgroundFirstLine;

    @SerializedName("SecondLineFont")
    public FontContract secondLineFont;

    @SerializedName("ForegroundSecondLine")
    public String foregroundSecondLine;

    @SerializedName("BackgroundSecondLine")
    public String backgroundSecondLine;

    protected OverlayFormattingContract(Parcel in) {
        in.readParcelable(titleFont.getClass()
                .getClassLoader());
        foregroundTitle = in.readString();
        backgroundTitle = in.readString();
        in.readParcelable(firstLineFont.getClass()
                .getClassLoader());
        foregroundFirstLine = in.readString();
        backgroundFirstLine = in.readString();
        in.readParcelable(secondLineFont.getClass()
                .getClassLoader());
        foregroundSecondLine = in.readString();
        backgroundSecondLine = in.readString();
    }

    public static final Creator<OverlayFormattingContract> CREATOR = new Creator<OverlayFormattingContract>() {
        @Override
        public OverlayFormattingContract createFromParcel(Parcel in) {
            return new OverlayFormattingContract(in);
        }

        @Override
        public OverlayFormattingContract[] newArray(int size) {
            return new OverlayFormattingContract[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(titleFont, flags);
        dest.writeString(foregroundTitle);
        dest.writeString(backgroundTitle);
        dest.writeParcelable(firstLineFont, flags);
        dest.writeString(foregroundFirstLine);
        dest.writeString(foregroundSecondLine);
        dest.writeParcelable(secondLineFont, flags);
        dest.writeString(foregroundSecondLine);
        dest.writeString(backgroundSecondLine);
    }

    @Override
    public String toString() {
        return "OverlayFormattingContract{" +
                "titleFont=" + titleFont +
                ", foregroundTitle='" + foregroundTitle + '\'' +
                ", backgroundTitle='" + backgroundTitle + '\'' +
                ", firstLineFont=" + firstLineFont +
                ", foregroundFirstLine='" + foregroundFirstLine + '\'' +
                ", backgroundFirstLine='" + backgroundFirstLine + '\'' +
                ", secondLineFont=" + secondLineFont +
                ", foregroundSecondLine='" + foregroundSecondLine + '\'' +
                ", backgroundSecondLine='" + backgroundSecondLine + '\'' +
                '}';
    }
}
