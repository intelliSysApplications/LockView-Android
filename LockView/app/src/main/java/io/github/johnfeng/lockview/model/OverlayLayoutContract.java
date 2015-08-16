package io.github.johnfeng.lockview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guangweifeng on 16/08/15.
 */
public class OverlayLayoutContract implements Parcelable {

    @SerializedName("AutoExpand")
    public boolean isAutoExpand;

    @SerializedName("Origin")
    public OverlayPoint origin;

    @SerializedName("ParagraphSpacing")
    public int paragraphSpacing;

    @SerializedName("TargetWidth")
    public int targetWidth;

    @SerializedName("TargetHeight")
    public int targetHeight;

    protected OverlayLayoutContract(Parcel in) {
        isAutoExpand = in.readInt() == 1;
        origin = in.readParcelable(OverlayPoint.class.getClassLoader());
        paragraphSpacing = in.readInt();
        targetWidth = in.readInt();
        targetHeight = in.readInt();
    }

    public static final Creator<OverlayLayoutContract> CREATOR = new Creator<OverlayLayoutContract>() {
        @Override
        public OverlayLayoutContract createFromParcel(Parcel in) {
            return new OverlayLayoutContract(in);
        }

        @Override
        public OverlayLayoutContract[] newArray(int size) {
            return new OverlayLayoutContract[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(isAutoExpand ? 1 : 0);
        dest.writeParcelable(origin, flags);
        dest.writeInt(paragraphSpacing);
        dest.writeInt(targetWidth);
        dest.writeInt(targetHeight);
    }
}
