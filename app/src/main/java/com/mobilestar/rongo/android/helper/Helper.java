package com.mobilestar.rongo.android.helper;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Helper {

    public static boolean detectSpecialCharPattern(String s) {
        return !Pattern.compile("\\w+", Pattern.UNICODE_CASE).matcher(s).matches();
    }

    public static boolean checkValidEmail(String email) {
        return !Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidMobile(String mobile) {
        return !Patterns.PHONE.matcher(mobile).matches();
    }

    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,30}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return !matcher.matches();
    }

    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showKeyboard(Context context){
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }


    public static CircularProgressDrawable getProgress(Context context) {
        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(context);
        progressDrawable.setStrokeWidth(5f);
        progressDrawable.setCenterRadius(30f);
        progressDrawable.start();
        return progressDrawable;
    }

    public static String generateUserToken(String userId, String security) {
        try {
            byte[] keyData = security.getBytes("UTF-8");
            String jwtStr = Jwts.builder().claim("user_id", userId)
                    .signWith(SignatureAlgorithm.HS256, security.getBytes()).compact();
            Log.e("Stream Token", jwtStr);
            return jwtStr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
