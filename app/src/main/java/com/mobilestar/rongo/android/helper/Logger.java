package com.mobilestar.rongo.android.helper;

import android.util.Log;

import com.mobilestar.rongo.android.BuildConfig;

public class Logger {
    public static void e(String s) {
        if (BuildConfig.DEBUG)
            Log.e("TAG ", "" + s);
    }
}
