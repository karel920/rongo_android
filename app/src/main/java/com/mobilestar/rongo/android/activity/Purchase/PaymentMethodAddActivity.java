package com.mobilestar.rongo.android.activity.Purchase;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mobilestar.rongo.android.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentMethodAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement_method_add);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.close)
    void onClose(View v) {
        finish();
    }
}
