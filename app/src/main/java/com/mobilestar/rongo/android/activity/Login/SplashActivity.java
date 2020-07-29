package com.mobilestar.rongo.android.activity.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.MainActivity;
import com.mobilestar.rongo.android.activity.Login.model.LoginInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;
import com.mobilestar.rongo.android.helper.AppSharedPreference;
import com.mobilestar.rongo.android.retrofit.ApiCall;
import com.mobilestar.rongo.android.retrofit.IApiCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements IApiCallback<LoginRes> {

    @BindView(R.id.btnSplashRegister)
    Button btnRegister;

    LoginInfo loginData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        this.btnRegister.setVisibility(View.GONE);
        loginData = AppSharedPreference.getInstance(this).getLoginData();
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    void loginWithLoginData() {
        LoginInfo loginInfo = AppSharedPreference.getInstance(this).getLoginData();

        ApiCall.getInstance().login(loginInfo, this);
    }

    @OnClick(R.id.btnSplashRegister)
    void onClickRegister() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if (loginData != null) {
                btnRegister.setVisibility(View.GONE);
                loginWithLoginData();
            } else {
                btnRegister.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    public void onSuccess(String type, Response<LoginRes> response) {
        Log.e("Token Data", response.body().toString());

        AppSharedPreference.getInstance(this).setTokenData((LoginRes) response.body());
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }

    @Override
    public void onFailure(Object data) {

    }
}