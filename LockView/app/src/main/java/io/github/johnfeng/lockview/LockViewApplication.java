package io.github.johnfeng.lockview;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.johnfeng.lockview.utils.TrackEventUtil;

/**
 * Created by guangweifeng on 18/07/15.
 */
public class LockViewApplication extends Application {
    private static final String TAG = LockViewApplication.class.getSimpleName();
    private static final String GOOGLE_ANALYTICS_UA_ID = "UA-59729566-2";

    private static GoogleAnalytics analytics;
    private static Tracker tracker;
    private static LockViewApplication mInstance;
    private static Gson mGson;

    public static GoogleAnalytics getAnalytics() {
        return analytics;
    }

    public static Tracker getTracker() {
        return tracker;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        initGATracker();
        trackOnAppStart();
        initGson();
    }

    public static LockViewApplication getApp() {
        if (mInstance == null) {
            mInstance = new LockViewApplication();
        }
        return mInstance;
    }

    private void initGson() {
        if (mGson == null) {
            new GsonBuilder().serializeNulls()
                    .generateNonExecutableJson()
                    .setPrettyPrinting()
                    .create();
        }
    }

    public Gson getGsonInstance() {
        if (mGson == null) {
            initGson();
        }
        return mGson;
    }

    private void initGATracker() {
        analytics = GoogleAnalytics.getInstance(this);
        analytics.setLocalDispatchPeriod(1800);

        tracker = LockViewApplication.getAnalytics()
                .newTracker(GOOGLE_ANALYTICS_UA_ID);
        tracker.enableExceptionReporting(true);
        tracker.enableAdvertisingIdCollection(true);
        tracker.enableAutoActivityTracking(true);
    }

    private void trackOnAppStart() {
        TrackEventUtil.trackUIEvent(this,
                TrackEventUtil.TrackCategory.CATEGORY_UX,
                TrackEventUtil.TrackAction.ACTION_APP_START,
                "");
    }
}
