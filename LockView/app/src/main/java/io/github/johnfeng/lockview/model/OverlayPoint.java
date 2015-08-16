package io.github.johnfeng.lockview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guangweifeng on 16/08/15.
 */
public class OverlayPoint implements Parcelable {

    @SerializedName("X")
    public int x;

    @SerializedName("Y")
    public int y;

    protected OverlayPoint(Parcel in) {
        x = in.readInt();
        y = in.readInt();
    }

    public static final Creator<OverlayPoint> CREATOR = new Creator<OverlayPoint>() {
        @Override
        public OverlayPoint createFromParcel(Parcel in) {
            return new OverlayPoint(in);
        }

        @Override
        public OverlayPoint[] newArray(int size) {
            return new OverlayPoint[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(x);
        dest.writeInt(y);
    }

    @Override
    public String toString() {
        return "OverlayPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
