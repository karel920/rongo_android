package com.mobilestar.rongo.android.activity.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import com.mobilestar.rongo.android.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.nickNameEditText)
    EditText txtNickName;
    @BindView(R.id.inviteCodeEditText)
    EditText txtInviteCode;
    @BindView(R.id.checkTermsPrivacy)
    CheckBox checkPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @OnClick(R.id.btnRegister)
    private void register() {
        if (this.txtNickName.getText() == null || this.txtNickName.getText().toString().equals("")) {
            return;
        }

        if (!this.checkPrivacy.isChecked()) {
            return;
        }


    }
}