package eu.jonbo.zcalendar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * Created by jonas on 2017-11-10.
 */

public class PreferenceHandler {
    private static SharedPreferences mSettings;

//    public static final String NOTIFICATION_SOUND = "notification_sound";
//    public static final String NOTIFICATION_VIBRATE = "notification_vibrate";
//    public static final String NOTIFICATION_ENABLED = "notifications_enabled";
//    public static final String NOTIFICATION_POPUP = "notification_popup";

//    public static final String SETTINGS_APP_THEME = "theme";
//    public static final String SETTINGS_WIDGET_THEME = "widget_theme";
//    public static final String SETTINGS_WIDGET_COUNTDOWN = "widget_countdown_enabled";
//    public static final String SETTINGS_HIDE_DECLINED_EVENTS = "hide_devlined_events";
//    public static final String SETTINGS_SNOOZE_TIME = "snooze_time";

//    public static final String SETTINGS_LAST_USED_VIEW = "last_view";
    public static final String SETTINGS_FIRST_DAY_OF_WEEK = "fdow";
//    public static final String SETTINGS_DEFAULT_CALENDAR = "dc";
//    public static final String HARDWARE_ACCELERATION_ENABLED = "enable_hardware_acceleration";


//    private static int mAppTheme = -1;
//    private static int mWidgetAppTheme = -1;
    private static String mDirstDayOfWeek = "-1";
//    private static SharedPreferences mSettings;
//    private static String mDefaultCalendar = "-2";

    //public static void init(Context context) {
        //getAppTheme(context, mAppTheme);
        //getWidgetAppTheme(context, mWidgetAppTheme);
        //getFirstDayOfWeek(context, mDirstDayOfWeek);
    //}

//    public static boolean getWidgetCountdownEnabledEnabled(Context context) {
//        return getSharedPreferences(context).getBoolean(SETTINGS_WIDGET_COUNTDOWN, true);
//    }

//    public static boolean getHideDeclinedEvents(Context context) {
//        return getSharedPreferences(context).getBoolean(SETTINGS_HIDE_DECLINED_EVENTS, true);
//    }

//    public static boolean getHardwareAccelerationEnabled(Context context) {
//        return getSharedPreferences(context).getBoolean(HARDWARE_ACCELERATION_ENABLED, true);
//    }

//    public static boolean getNotificationPopup(Context context) {
//        return getSharedPreferences(context).getBoolean(NOTIFICATION_POPUP, true);
//    }

//    public static boolean getNotificationEnabled(Context context) {
//        return getSharedPreferences(context).getBoolean(NOTIFICATION_ENABLED, true);
//    }

//    public static boolean getNotificationVibrate(Context context) {
//        return getSharedPreferences(context).getBoolean(NOTIFICATION_VIBRATE, true);
//    }

//    public static String getNotificationSound(Context context) {
//        return getSharedPreferences(context).getString(NOTIFICATION_SOUND, "content://settings/system/notification_sound");
//    }

//    public static int getWidgetAppTheme(Context context, int defaultvalue) {
//        if (mWidgetAppTheme == -1 && context != null)
//            mWidgetAppTheme = Integer.valueOf(getSharedPreferences(context).getString(SETTINGS_WIDGET_THEME, ""+defaultvalue));
//
//        return mWidgetAppTheme;
//    }

//    public static int getAppTheme(Context context, int defaultvalue) {
//        if (mAppTheme == -1 && context != null)
//            mAppTheme = Integer.valueOf(getSharedPreferences(context).getString(SETTINGS_APP_THEME, ""+defaultvalue));
//
//        return mAppTheme;
//    }

//    public static void setWidgetAppTheme(Context context, int value) {
//        mWidgetAppTheme = value;
//        putStringPreference(context, SETTINGS_WIDGET_THEME, ""+value);
//    }

//    public static void setAppTheme(Context context, int value) {
//        mAppTheme = value;
//        putStringPreference(context, SETTINGS_APP_THEME, ""+value);
//    }

    public static String getFirstDayOfWeek(Context context, String defaultvalue) {
        if (mDirstDayOfWeek.equals("-1") && context != null)
            mDirstDayOfWeek = getSharedPreferences(context).getString(SETTINGS_FIRST_DAY_OF_WEEK, defaultvalue);

        return mDirstDayOfWeek;
    }

//    public static void setFirstDayOfWeek(Context context, String value) {
//        mDirstDayOfWeek = value;
//        putStringPreference(context, SETTINGS_FIRST_DAY_OF_WEEK, value);
//    }

//    public static String getDefaultCalendar(Context context, String defaultvalue) {
//        if (mDefaultCalendar.equals("-2") && context != null)
//            mDefaultCalendar = getSharedPreferences(context).getString(SETTINGS_DEFAULT_CALENDAR, defaultvalue);
//
//        return mDefaultCalendar;
//    }

//    public static void setDefaultCalendar(Context context, String value) {
//        mDefaultCalendar = value;
//        putStringPreference(context, SETTINGS_DEFAULT_CALENDAR, value);
//    }

//    public static int getSnoozeTime(Context context, int defaultvalue) {
//        return getSharedPreferences(context).getInt(SETTINGS_SNOOZE_TIME, defaultvalue);
//    }

//    public static int getLastUsedView(Context context, int defaultvalue) {
//        return getSharedPreferences(context).getInt(SETTINGS_LAST_USED_VIEW, defaultvalue);
//    }

//    public static void setLastUsedView(Context context, int value) {
//        putIntPreference(context, SETTINGS_LAST_USED_VIEW, value);
//    }

//    private static void putBooleanPreference(Context context, String key, boolean value) {
//        SharedPreferences preferences = getSharedPreferences(context);
//
//        Editor editor = preferences.edit();
//        editor.putBoolean(key, value);
//        editor.apply();
//    }

//    private static void putIntPreference(Context context, String key, int value) {
//        SharedPreferences preferences = getSharedPreferences(context);
//
//        Editor editor = preferences.edit();
//        editor.putInt(key, value);
//        editor.apply();
//    }

//    private static void putStringPreference(Context context, String key, String value) {
//        SharedPreferences preferences = getSharedPreferences(context);
//
//        Editor editor = preferences.edit();
//        editor.putString(key, value);
//        editor.apply();
//    }

    private static SharedPreferences getSharedPreferences(Context context) {
        if (mSettings == null) {
            mSettings = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return mSettings;
    }
}
