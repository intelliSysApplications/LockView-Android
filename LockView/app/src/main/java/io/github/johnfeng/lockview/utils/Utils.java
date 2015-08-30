package io.github.johnfeng.lockview.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by guangweifeng on 30/08/15.
 */
public class Utils {
    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
            Locale.CHINA);
    public static final SimpleDateFormat sdf = new SimpleDateFormat("M月d日 HH:mm", Locale.CHINA);
    public static final SimpleDateFormat sdf2 = new SimpleDateFormat("M月d日", Locale.CHINA);
    public static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm",
            Locale.CHINA);
    public static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    public static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
    public static final SimpleDateFormat sdf6 = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
    public static final SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
            Locale.CHINA);
    public static final SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);

    public static final long SECOND_IN_MS = 1000;
    public static final long MINUTE_IN_MS = 60 * SECOND_IN_MS;
    public static final long HOUR_IN_MS = 60 * MINUTE_IN_MS;
    public static final long DAY_IN_MS = 24 * HOUR_IN_MS;
    public static final long MONTH_IN_MS = 30 * DAY_IN_MS;
    public static final long YEAR_IN_MS = 12 * MONTH_IN_MS;

    private static String getTime(long time, SimpleDateFormat format) {
        long timeSpace = System.currentTimeMillis() - time;
        if (timeSpace < 10 * SECOND_IN_MS) {
            return "刚刚";
        } else if (timeSpace < MINUTE_IN_MS) {
            return ((int) (timeSpace / SECOND_IN_MS)) + "秒前";
        } else if (timeSpace < HOUR_IN_MS) {
            return ((int) (timeSpace / MINUTE_IN_MS)) + "分钟前";
        } else if (timeSpace < DAY_IN_MS) {
            return ((int) (timeSpace / HOUR_IN_MS)) + "小时前";
        } else {
            return format.format(new Date(time));
        }
    }

    private static String getExpiredTime(long time) {
        long timeSpace = System.currentTimeMillis() - time;
        if (timeSpace < 10 * SECOND_IN_MS) {
            return "刚刚";
        } else if (timeSpace < MINUTE_IN_MS) {
            return ((int) (timeSpace / SECOND_IN_MS)) + "秒前";
        } else if (timeSpace < HOUR_IN_MS) {
            return ((int) (timeSpace / MINUTE_IN_MS)) + "分钟前";
        } else if (timeSpace < DAY_IN_MS) {
            return ((int) (timeSpace / HOUR_IN_MS)) + "小时前";
        } else if (timeSpace < MONTH_IN_MS) {
            return ((int) (timeSpace / DAY_IN_MS)) + "天前";
        } else if (timeSpace < YEAR_IN_MS) {
            return ((int) (timeSpace / MONTH_IN_MS)) + "月前";
        } else {
            return ((int) (timeSpace / YEAR_IN_MS)) + "年前";
        }
    }

    public static long getTime(String datetime) {
        try {
            Date d = format.parse(datetime);
            return d.getTime();
        } catch (ParseException e) {
        }
        return 0;
    }

    public static boolean isToday(String time) {
        if (time == null || "".equals(time)) {
            return false;
        }
        Date date = null;

        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long days = daysBetweenToday(date);
        if (days == 0) {
            return true;
        }
        return false;
    }

    public static long daysBetweenToday(Date from) {
        Calendar compare = Calendar.getInstance();
        compare.setTime(from);
        //  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
        compare.set(Calendar.HOUR_OF_DAY, 0);
        compare.set(Calendar.MINUTE, 0);
        compare.set(Calendar.SECOND, 0);
        compare.set(Calendar.MILLISECOND, 0);
        compare.set(compare.get(Calendar.YEAR), compare.get(Calendar.MONTH),
                compare.get(Calendar.DAY_OF_MONTH));

        Calendar today = Calendar.getInstance();    //今天

        //  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        return (compare.getTime()
                .getTime() - today.getTime()
                .getTime()) / (1000 * 60 * 60 * 24);
    }

    public static boolean isYesterday(String time) {
        if (time == null || "".equals(time)) {
            return false;
        }
        Date date = null;

        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long days = daysBetweenToday(date);
        if (days == -1) {
            return true;
        }
        return false;
    }

    public static boolean isTomorrow(String time) {
        if (time == null || "".equals(time)) {
            return false;
        }
        Date date = null;

        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long days = daysBetweenToday(date);
        if (days == 1) {
            return true;
        }
        return false;
    }

    /**
     * Used to get message create-time for send message
     *
     * @return
     */
    public static String getMessageCreateTime() {
        return format.format(new Date());
    }

    public static String timeExpireString(String datetime) {
        try {
            format.setTimeZone(TimeZone.getDefault());
            Date d = format.parse(datetime);
            // 服务器返回的时间为GMT＋8，所以还需要计算时差
            long timeZoneOffset = TimeZone.getDefault()
                    .getRawOffset() - TimeZone.getTimeZone("GMT+8")
                    .getRawOffset();
            long time = d.getTime() + timeZoneOffset;
            return getExpiredTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }

    public static String timeString(String datetime) {
        if (TextUtils.isEmpty(datetime)) {
            return "";
        }
        return timeStringDesc(datetime, sdf2);
    }

    public static String timeStringDesc(String datetime, SimpleDateFormat simpleDateFormat) {
        try {
            format.setTimeZone(TimeZone.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            Date d = format.parse(datetime);
            // 服务器返回的时间为GMT＋8，所以还需要计算时差
            long timeZoneOffset = TimeZone.getDefault()
                    .getRawOffset() - TimeZone.getTimeZone("GMT+8")
                    .getRawOffset();
            long time = d.getTime() + timeZoneOffset;
            return getTime(time, simpleDateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }

    public static String timeString(String datetime, SimpleDateFormat simpleDateFormat) {
        if (TextUtils.isEmpty(datetime)) {
            return datetime;
        }
        try {
            format.setTimeZone(TimeZone.getDefault());
            Date d = format.parse(datetime);
            return simpleDateFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }

    public static String parseMonthToText(int month) {
        return parseNumberToText(month);
    }

    public static String parseYearToText(int year) {
        StringBuilder builder = new StringBuilder();
        int thousand = year / 1000;
        int hundred = year / 100 % 10;
        int decade = year / 10 % 10;
        int singleDigit = year % 10;

        builder.append(parseNumberToText(thousand));
        builder.append(parseNumberToText(hundred));
        builder.append(parseNumberToText(decade));
        builder.append(parseNumberToText(singleDigit));
        return builder.toString();
    }

    public static String parseNumberToText(int number) {
        switch (number) {
            case 0: {
                return "零";
            }
            case 1: {
                return "一";
            }
            case 2: {
                return "二";
            }
            case 3: {
                return "三";
            }
            case 4: {
                return "四";
            }
            case 5: {
                return "五";
            }
            case 6: {
                return "六";
            }
            case 7: {
                return "七";
            }
            case 8: {
                return "八";
            }
            case 9: {
                return "九";
            }
            case 10: {
                return "十";
            }
            case 11: {
                return "十一";
            }
            case 12: {
                return "十二";
            }
            default: {
                return "";
            }
        }
    }

}
