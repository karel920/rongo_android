package com.mobilestar.rongo.android.activity.GoodDetail;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.gson.Gson;
import com.mobilestar.rongo.android.Models.GoodDetailModel;
import com.mobilestar.rongo.android.activity.GoodDetail.Adapter.GoodDetailImgAdapter;
import com.mobilestar.rongo.android.activity.GoodDetail.Adapter.GoodDetailLiveAdapter;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.View.NonScrollableListView;
import com.mobilestar.rongo.android.activity.GoodDetail.Sheet.PucharseSheet;
import com.mobilestar.rongo.android.activity.Purchase.PurchaseActivity;
import com.mobilestar.rongo.android.response.ProductDetailResponse;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.*;

public class GoodDetailActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private GoodDetailImgAdapter adapter;
    private GoodDetailLiveAdapter liveAdapter;
    private ViewPager goodImagesViewPager;
    private NonScrollableListView goodLiveList;
    private ToggleButton descriptioToggle;
    private ToggleButton likeButton;
    private TextView description;
    private TextView title;
    private TextView number;
    private TextView followCount;
    private TextView shopName;
    private TextView shopFollower;
    private ImageView shopImage;
    private TextView price;

    private int goodId;
    private OkHttpClient client;
    private GoodDetailModel product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);

        this.goodId = getIntent().getIntExtra("GoodId", 0);

        goodImagesViewPager = findViewById(R.id.good_detail_images);
        goodLiveList = findViewById(R.id.good_detail_live_list);
        descriptioToggle = findViewById(R.id.good_detail_desc_toogle);
        description = findViewById(R.id.description);
        title = findViewById(R.id.good_detail_page_title);
        number = findViewById(R.id.good_detail_page_number);
        followCount = findViewById(R.id.good_detail_page_follower);
        shopName = findViewById(R.id.good_detail_page_shop_name);
        shopImage = findViewById(R.id.good_detail_page_shop_img);
        shopFollower = findViewById(R.id.good_detail_page_shop_follower);
        price = findViewById(R.id.good_detail_page_price);
        likeButton = findViewById(R.id.good_detail_page_like);

        ButterKnife.bind(this);

        adapter = new GoodDetailImgAdapter(this);
        liveAdapter = new GoodDetailLiveAdapter();
        client = new OkHttpClient();

        goodImagesViewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        goodLiveList.setAdapter(liveAdapter);

        Layout l = description.getLayout();
        if (l != null) {
            int lines = l.getLineCount();
            if (lines <= 4){
                this.descriptioToggle.setVisibility(View.GONE);
            } else {
                this.descriptioToggle.setVisibility(View.VISIBLE);
            }
        }
        this.descriptioToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    description.setMaxLines(100);
                } else  {
                    description.setMaxLines(4);
                }
            }
        });

        new GoodDetailFetcher().execute();
    }

    public void onNextImage(View v) {
        int currentSelection = this.goodImagesViewPager.getCurrentItem();
        int count = this.adapter.getCount();

        if(currentSelection < count -1) {
            this.goodImagesViewPager.setCurrentItem(currentSelection + 1 , true);
        }
    }
    public void onPrevImage(View v) {
        int currentSelection = this.goodImagesViewPager.getCurrentItem();

        if(currentSelection > 0) {
            this.goodImagesViewPager.setCurrentItem(currentSelection - 1 , true);
        }
    }

    @OnClick(R.id.good_detail_purchase_button)
    public void onPurchase(View v) {
        Intent intent = new Intent(this, PurchaseActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.back)
    public void onBack(View v) {
        finish();
    }

    Handler updater = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            adapter.setAllItem(product.portfolios);
            description.setText(product.description);
            title.setText(product.label);
            number.setText(product.number);
            followCount.setText("" + product.nLikes);
            shopName.setText(product.store.name);
            shopFollower.setText("" + product.store.followers);
            price.setText("" + product.price);

            Glide.with(GoodDetailActivity.this).load(product.store.icon).into(shopImage);

            if(product.isLike == 1) {
                likeButton.setChecked(true);
            } else {
                likeButton.setChecked(false);
            }

            likeButton.setOnCheckedChangeListener(GoodDetailActivity.this);
        }
    };

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        new GoodLiker().execute();
    }

    class GoodDetailFetcher extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            Gson gson = new Gson();
            Request request = new Request.Builder()
                    .url("http://192.168.0.109:8888/api/product/" + goodId)
                    .header("Authorization", "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4LjAuMTA5Ojg4ODhcL2FwaVwvYXV0aFwvcmVnaXN0ZXJcL2N1c3RvbWVyIiwiaWF0IjoxNTk2MDcyOTI4LCJleHAiOjE1OTY5MzY5MjgsIm5iZiI6MTU5NjA3MjkyOCwianRpIjoiZzd0Y0RLeGdKOHBzU2thSiIsInN1YiI6NDYsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.BmTXz2W9X2feGlHEQzbz2UC7RWxI-g-ciV71S7SKBvY")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String responseStr = response.body().string();
                ProductDetailResponse _product = gson.fromJson(responseStr, ProductDetailResponse.class);
                product = _product.product;

                updater.sendEmptyMessage(0);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    class GoodLiker extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            RequestBody body = new FormBody.Builder()
                    .add("product_id", "" + goodId)
                    .build();
            Request request = new Request.Builder()
                    .url("http://192.168.0.109:8888/api/product/like")
                    .post(body)
                    .header("Authorization", "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4LjAuMTA5Ojg4ODhcL2FwaVwvYXV0aFwvcmVnaXN0ZXJcL2N1c3RvbWVyIiwiaWF0IjoxNTk2MDcyOTI4LCJleHAiOjE1OTY5MzY5MjgsIm5iZiI6MTU5NjA3MjkyOCwianRpIjoiZzd0Y0RLeGdKOHBzU2thSiIsInN1YiI6NDYsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.BmTXz2W9X2feGlHEQzbz2UC7RWxI-g-ciV71S7SKBvY")
                    .build();
            try {
                Response response = client.newCall(request).execute();
            } catch (IOException e) {

            }
            return null;
        }
    }
}