package com.mobilestar.rongo.android.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.mobilestar.rongo.android.activity.Login.model.LoginInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;

import org.json.JSONObject;

public class AppSharedPreference {
    private static final String DB_NAME = "rongo";
    private static AppSharedPreference appSharedPreference;
    private static SharedPreferences preferences;

    private AppSharedPreference() {
    }

    public static AppSharedPreference getInstance(Context context) {
        if (appSharedPreference == null) {
            appSharedPreference = new AppSharedPreference();
            preferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        }
        return appSharedPreference;
    }

    public LoginRes getTokenData() {
        String jsonStr = preferences.getString("tokenData", "");
        if(!jsonStr.equals("")){
            return new Gson().fromJson(jsonStr, LoginRes.class);
        }else{
            return null;
        }
    }

    public void setTokenData(LoginRes tokenData) {
        preferences.edit().putString("tokenData", new Gson().toJson(tokenData)).apply();
    }

    public LoginInfo getLoginData() {
        String jsonStr = preferences.getString("loginData", "");
        if(!jsonStr.equals("")){
            return new Gson().fromJson(jsonStr, LoginInfo.class);
        }else{
            return null;
        }
    }

    public void setLoginData(LoginInfo loginData) {
        preferences.edit().putString("loginData", new Gson().toJson(loginData)).apply();
    }

    public void setCouponIdFromNotification(String couponId) {
        preferences.edit().putString("notification_id", couponId).apply();
    }

    public String getCouponIdFromNotification() {
       return preferences.getString("notification_id", null);
    }

    public void setHelpHistory() {
        preferences.edit().putBoolean("is_show_help", true).apply();
    }

    public boolean getHelpHistory() {
        return preferences.getBoolean("is_show_help", false);
    }

    public String getLatitude() {
        return preferences.getString("latitude", "6.5244");
    }

    public void setLatitude(String latitude) {
        preferences.edit().putString("latitude", latitude).apply();
    }

    public String getLongitude() {
        return preferences.getString("longitude", "3.3792");
    }

    public void setLongitude(String longitude) {
        preferences.edit().putString("longitude", longitude).apply();
    }

    public void setIsNotification(String isNotification) {
        preferences.edit().putString("isNotification", isNotification).apply();
    }

    public String getIsNotification() {
        return preferences.getString("isNotification", "1");
    }

    public void clear() {
        boolean isHelpShown = getHelpHistory();
        preferences.edit().clear().apply();
        preferences.edit().putBoolean("is_show_help", isHelpShown).apply();
    }

    public String getDeviceToken() {
        return preferences.getString("deviceToken", "");
    }

    public void setDeviceToken(String deviceToken) {
        preferences.edit().putString("deviceToken", deviceToken).apply();
    }

    public void setFirstReferralId(String referralBuyerId){
        preferences.edit().putString("referral_sender_id", referralBuyerId).apply();
    }

    public String getFirstReferralId(){
       return preferences.getString("referral_sender_id", "0");
    }

    public void setShareVendorId(String shareVendorId){
        preferences.edit().putString("share_vendor_id", shareVendorId).apply();
    }

    public void setShareBlogId(String shareVendorId){
        preferences.edit().putString("share_blog_id", shareVendorId).apply();
    }

    public void setShareContestId(String contestId){
        preferences.edit().putString("share_contest_id", contestId).apply();
    }

    public String getShareContestId(){
        return preferences.getString("share_contest_id", "");
    }

    public String getShareVendorId(){
        return preferences.getString("share_vendor_id", "");
    }

    public void setShareCouponId(String shareCouponId){
        preferences.edit().putString("share_coupon_id", shareCouponId).apply();
    }

    public void setShareTripId(String shareTripId){
        preferences.edit().putString("share_trip_id", shareTripId).apply();
    }

    public String getShareTripId(){
        return preferences.getString("share_trip_id", "");
    }

    public String getShareBlogId(){
        return preferences.getString("share_blog_id", "");
    }

    public String getShareCouponId(){
        return preferences.getString("share_coupon_id", "");
    }

    public void setNotificationHistory(String couponIdsStrFromNotification){
        preferences.edit().putString("coupon_from_notification", couponIdsStrFromNotification).apply();
        return;
    }

    public String getNotificationHistory(){
        return preferences.getString("coupon_from_notification", (new JSONObject()).toString());
    }

    public void setAirtimeBuyTime(long time){
        preferences.edit().putLong("buy_airtime_time", time).apply();
    }

    public long getAritimeBuyTime(){
        return preferences.getLong("buy_airtime_time", 0);
    }

    public void setAirtimePhoneNumber(String phoneNumber){
        preferences.edit().putString("airtime_phone", phoneNumber).apply();
        return;
    }

    public String getAirtimePhoneNumber(){
        return preferences.getString("airtime_phone", "");
    }

    public void setPublicKey(String bankKey){
        preferences.edit().putString("bank_key", bankKey).apply();
    }

    public String getPublicKey(){
        return preferences.getString("bank_key","");
    }

    public void setEncryptionKey(String bankKey){
        preferences.edit().putString("bank_encryption_key", bankKey).apply();
    }

    public String getEncryptionKey(){
        return preferences.getString("bank_encryption_key","");
    }

    public void setReffralKey(String bankKey){
        preferences.edit().putString("bank_referral_key", bankKey).apply();
    }

    public String getReffralKey(){
        return preferences.getString("bank_referral_key","");
    }
}
