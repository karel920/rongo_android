package com.mobilestar.rongo.android.activity.Purchase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.View.NonScrollableListView;
import com.mobilestar.rongo.android.activity.Purchase.adapter.PaymentMethodAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentMethodActivity extends AppCompatActivity {

    @BindView(R.id.payment_method_list)
    NonScrollableListView paymentList;

    PaymentMethodAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        ButterKnife.bind(this);

        this.adapter = new PaymentMethodAdapter();

        this.paymentList.setAdapter(adapter);

    }

    @OnClick(R.id.payment_add_button)
    public void onAdd(View v) {
        Intent intent = new Intent(this, PaymentMethodAddActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.close)
    void onClose(View v) {
        finish();
    }
}
