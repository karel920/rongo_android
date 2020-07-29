package com.mobilestar.rongo.android.activity.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.MainActivity;
import com.mobilestar.rongo.android.activity.Login.model.LoginInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;
import com.mobilestar.rongo.android.helper.AppSharedPreference;
import com.mobilestar.rongo.android.retrofit.ApiCall;
import com.mobilestar.rongo.android.retrofit.IApiCallback;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements IApiCallback<LoginRes> {

    @BindView(R.id.nickNameEditText)
    EditText txtNickName;
    @BindView(R.id.inviteCodeEditText)
    EditText txtInviteCode;
    @BindView(R.id.checkTermsPrivacy)
    CheckBox checkPrivacy;

    LoginInfo loginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegister)
    void register() {
        Log.e("Register", "Did click register button");

        if (this.txtNickName.getText() == null || this.txtNickName.getText().toString().equals("")) {
            return;
        }

        if (!this.checkPrivacy.isChecked()) {
            return;
        }

        loginInfo = new LoginInfo();
        loginInfo.setNickname(this.txtNickName.getText().toString());
        loginInfo.setUuid(UUID.randomUUID().toString());
        loginInfo.setInviteCode(this.txtInviteCode.getText().toString());

        ApiCall.getInstance().register(loginInfo, this);
    }

    @Override
    public void onSuccess(String type, Response response) {
        Log.e("Token Data", response.body().toString());

        AppSharedPreference.getInstance(this).setLoginData(loginInfo);
        AppSharedPreference.getInstance(this).setTokenData((LoginRes) response.body());
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void onFailure(Object data) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}