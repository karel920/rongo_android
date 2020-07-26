package com.mobilestar.rongo.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Utils {
    private static final String APP_NAME = "RentFo";
    public static final String IS_LOGEDIN = "FirstLogin";
    public static final String IS_FIRSTTIME = "FirstTime";

    private static Utils utils = null;

    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    public static Utils getInstance() {
        if (utils == null) {
            utils = new Utils();
        }

        return utils;
    }

    //    SharedPreference
    private SharedPreferences getSharedPreferences(Context mContext) {
        return mContext.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor(Context mContext) {
        sharedPreferences = getSharedPreferences(mContext);
        return sharedPreferences.edit();
    }

    public void setBooleanToSharedPreference(Context mContext, String key, boolean val) {
        editor = getEditor(mContext);
        editor.putBoolean(key, val);
        editor.apply();
    }

    public void setStringToSharedPreference(Context mContext, String key, String val) {
        editor = getEditor(mContext);
        editor.putString(key,val);
        editor.apply();
    }

    public String getStringFromSharedPreference(Context mContext, String key) {
        sharedPreferences = getSharedPreferences(mContext);
        return sharedPreferences.getString(key, null);
    }

    public boolean getBooleanFromSharedPreference(Context mContext, String key) {
        sharedPreferences = getSharedPreferences(mContext);
        return sharedPreferences.getBoolean(key, false);
    }
}
