package io.github.johnfeng.lockview.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by guangweifeng on 4/09/15.
 */
public class PrefUtils {

    public static boolean getBoolData(Context context, String key, boolean defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void saveBoolData(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        sharedPreferences.edit()
                .putBoolean(key, value)
                .apply();
    }

    public static void saveStringData(Context context, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        sharedPreferences.edit()
                .putString(key, value)
                .apply();
    }

    public static String getStringData(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        return sharedPreferences.getString(key, defaultValue);
    }

    public static void saveLongData(Context context, String key, long value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        sharedPreferences.edit()
                .putLong(key, value)
                .apply();
    }

    public static long getLongData(Context context, String key, long defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        return sharedPreferences.getLong(key, defaultValue);
    }

    public static int getIntData(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        return sharedPreferences.getInt(key, defaultValue);
    }

    public static void saveIntData(Context context, String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                context);
        sharedPreferences.edit()
                .putInt(key, value)
                .apply();
    }
}
