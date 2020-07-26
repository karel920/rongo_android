package com.mobilestar.rongo.android.helper;

import android.util.Log;

import com.marcus.justship.BuildConfig;

public class Logger {
    public static void e(String s) {
        if (BuildConfig.DEBUG)
            Log.e("TAG ", "" + s);
    }
}
