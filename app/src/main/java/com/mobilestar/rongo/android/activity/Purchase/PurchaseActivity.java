package com.mobilestar.rongo.android.activity.Purchase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mobilestar.rongo.android.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PurchaseActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        ButterKnife.bind(this);
    }
    @OnClick(R.id.purchase_select_payment)
    void onSelectPurchase(View v) {
        Intent intent = new Intent(this, PaymentMethodActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.purchase_select_address)
    void onSelectAddress(View v) {
        Intent intent = new Intent(this, AddressListActivity. class);
        startActivity(intent);
    }

    @OnClick(R.id.close)
    void onClose(View v) {
        finish();
    }
}