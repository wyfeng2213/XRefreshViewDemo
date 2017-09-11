package com.example.administrator.xrefreshviewdemo;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * preference工具类
 * 使用默认路径，存放在项目所在目录底下
 */
public class PreferenceUtils {
    public static String getPrefString(Context context, String key,
                                       final String defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getString(key, defaultValue);
    }

    public static void setPrefString(Context context, final String key,
                                     final String value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putString(key, value).commit();
    }

    public static boolean getPrefBoolean(Context context, final String key,
                                         final boolean defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getBoolean(key, defaultValue);
    }

    public static boolean hasKey(Context context, final String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(
                key);
    }

    public static void setPrefBoolean(Context context, final String key,
                                      final boolean value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putBoolean(key, value).commit();
    }

    public static void setPrefInt(Context context, final String key,
                                  final int value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putInt(key, value).commit();
    }

    public static int getPrefInt(Context context, final String key,
                                 final int defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getInt(key, defaultValue);
    }

    public static void setPrefFloat(Context context, final String key,
                                    final float value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putFloat(key, value).commit();
    }

    public static float getPrefFloat(Context context, final String key,
                                     final float defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getFloat(key, defaultValue);
    }

    public static void setPreffLong(Context context, final String key,
                                    final long value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putLong(key, value).commit();
    }

    public static long getPrefLong(Context context, final String key,
                                   final long defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getLong(key, defaultValue);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void setPrefSet(Context context, final String key,
                                  Set<String> values) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putStringSet(key, values).commit();
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getPrefSet(Context context, final String key,
                                         final Set<String> defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getStringSet(key, defaultValue);
    }


    //保存set进sp
    public static void setPrefSet(Context context, String keySize, final String key,
                                  Set<String> values) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        if (values == null || values.size() <= 0) return;
        Editor editor = settings.edit();
        editor.putInt(keySize, values.size());
        Iterator<String> it = values.iterator();
        int i = 0;
        while (it.hasNext()) {
            String v = it.next();
            String _key = key + i;
            editor.remove(_key);
            editor.putString(_key, v);
            i++;
        }
        editor.commit();
    }


    //获取set数据
    public static Set<String> getPrefSet(Context context, String keySize, String key, String defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        int size = settings.getInt(keySize, 0);
        if (size > 0) {
            Set<String> values = new HashSet<String>();
            for (int i = 0; i < size; i++) {
                values.add(settings.getString(key + i, defaultValue));
            }

            return values;
        }
        return null;
    }

    public static void clearPreference(Context context,
                                       final SharedPreferences p) {
        final Editor editor = p.edit();
        editor.clear();
        editor.commit();
    }

    public static void clearPreference(Context context) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        final Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public static void removePrefLong(Context context, final String key) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().remove(key).commit();
    }
}
