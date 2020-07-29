package com.mobilestar.rongo.android.activity.Purchase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.View.NonScrollableListView;
import com.mobilestar.rongo.android.activity.Purchase.adapter.DeliveryAddressAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressListActivity extends AppCompatActivity {
    @BindView(R.id.address_list)
    NonScrollableListView addressList;

    DeliveryAddressAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);

        ButterKnife.bind(this);

        this.adapter = new DeliveryAddressAdapter();

        this.addressList.setAdapter(adapter);
    }

    @OnClick(R.id.add_new_address)
    void onAddNewAddress(View v) {
        Intent intent = new Intent(this, AddressAddActivity. class);
        startActivity(intent);
    }
    @OnClick(R.id.close)
    void onClose(View v) {
        finish();
    }

}
