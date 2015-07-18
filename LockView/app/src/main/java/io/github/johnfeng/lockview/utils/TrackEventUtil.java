package io.github.johnfeng.lockview.utils;

import android.content.Context;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import io.github.johnfeng.lockview.LockViewApplication;

/**
 * Created by guangweifeng on 18/07/15.
 */
public class TrackEventUtil {

    private static Tracker getGATracker() {
        return LockViewApplication.getTracker();
    }

    public static class TrackScreen {
        public static final String SCREEN_HOME_FRAGMENT = "home_fragment";
    }

    public static class TrackCategory {
        public static final String CATEGORY_UX = "UX";
    }

    public static class TrackAction {
        public static final String ACTION_APP_START = "app_start";
        public static final String ACTION_CLICK = "click";
    }

    public static class TrackLabel {
        public static final String LABEL_SUMBIT = "submit";
    }

    public static void trackUIEvent(Context context, String category, String action, String label) {
        //GA Tracker
        Tracker tracker = getGATracker();
        if (tracker != null) {
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory(category)
                    .setAction(action)
                    .setLabel(label)
                    .build());
        }
    }

    public static void trackUIEvent(Context context, String screen, String category, String action,
                                    String label) {
        //GA Tracker
        Tracker tracker = getGATracker();
        if (tracker != null) {
            tracker.setScreenName(screen);
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory(category)
                    .setAction(action)
                    .setLabel(label)
                    .build());
        }
    }
}
