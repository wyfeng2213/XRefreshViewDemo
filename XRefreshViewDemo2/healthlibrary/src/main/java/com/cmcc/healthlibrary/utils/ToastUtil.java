package com.cmcc.healthlibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * The type Toast util.
 */
public class ToastUtil {

    /**
     * Show.
     *
     * @param context the context
     * @param msg     the msg
     */
    public static void show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
