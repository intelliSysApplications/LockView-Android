package io.github.johnfeng.lockview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guangweifeng on 16/08/15.
 */
public class FontContract implements Parcelable {

    @SerializedName("FontFamily")
    public String fontFamily;

    @SerializedName("FontSize")
    public int fontSize;

    protected FontContract(Parcel in) {
        in.writeString(fontFamily);
        in.writeInt(fontSize);
    }

    public static final Creator<FontContract> CREATOR = new Creator<FontContract>() {
        @Override
        public FontContract createFromParcel(Parcel in) {
            return new FontContract(in);
        }

        @Override
        public FontContract[] newArray(int size) {
            return new FontContract[size];
        }
    };

    public FontContract(String fontFamily, int fontSize) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fontFamily);
        dest.writeInt(fontSize);
    }

    @Override
    public String toString() {
        return "FontContract{" +
                "fontFamily='" + fontFamily + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}
