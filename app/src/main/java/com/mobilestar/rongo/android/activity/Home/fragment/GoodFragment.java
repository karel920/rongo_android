package com.mobilestar.rongo.android.activity.Home.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobilestar.rongo.android.Models.GoodModel;
import com.mobilestar.rongo.android.Service.ApiCaller;
import com.mobilestar.rongo.android.Service.ApiListener;
import com.mobilestar.rongo.android.activity.GoodDetail.GoodDetailActivity;
import com.mobilestar.rongo.android.activity.Home.fragment.adapter.GoodRecyclerAdapter;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;
import com.mobilestar.rongo.android.listener.GoodLikeChangeListener;
import com.mobilestar.rongo.android.local.GoodStorage;
import com.mobilestar.rongo.android.retrofit.ApiCall;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.*;

public class GoodFragment extends Fragment implements IRecyclerClickListener, GoodLikeChangeListener {
    RecyclerView goodsList;
    SwipeRefreshLayout swipeRefreshLayout;

    GoodRecyclerAdapter adapter;
    RadioGroup goodType;

    OkHttpClient client;

    public GoodFragment() {
        // Required empty public constructor
    }

    public static GoodFragment newInstance() {
        GoodFragment fragment = new GoodFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        this.client = new OkHttpClient();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentContent = inflater.inflate(R.layout.fragment_good, container, false);

        this.goodsList = fragmentContent.findViewById(R.id.home_good_list);
        this.swipeRefreshLayout = fragmentContent.findViewById(R.id.good_refresh_layout);
        this.goodType = fragmentContent.findViewById(R.id.good_type);

        adapter = new GoodRecyclerAdapter(getContext());
        adapter.setListener(this);
        adapter.setLikeChangeListener(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 3);
        this.goodsList.setLayoutManager(layoutManager);
        this.goodsList.setAdapter(adapter);

        this.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // do something to refresh good :)
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        this.goodType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.good_type_all :
                        getDataWithType(1);
                        break;

                    case R.id.good_type_fav :
                        getDataWithType(2);
                        break;

                    case R.id.good_type_orderbytime :
                        getDataWithType(3);
                        break;
                }
            }
        });

        getDataWithType(1);

        return fragmentContent;
    }

    private void getDataWithType(int type) {
        String url = "http://192.168.0.109:8888/api/products?type=" + type;
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization", "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4LjAuMTA5Ojg4ODhcL2FwaVwvYXV0aFwvcmVnaXN0ZXJcL2N1c3RvbWVyIiwiaWF0IjoxNTk2MDcyOTI4LCJleHAiOjE1OTY5MzY5MjgsIm5iZiI6MTU5NjA3MjkyOCwianRpIjoiZzd0Y0RLeGdKOHBzU2thSiIsInN1YiI6NDYsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.BmTXz2W9X2feGlHEQzbz2UC7RWxI-g-ciV71S7SKBvY");
        new GoodsFetcher(url,header).execute();
    }

    @Override
    public void onRecyclerClick(int pos, Object data, Object type) {
        Intent intent = new Intent(this.getContext(), GoodDetailActivity.class);
        intent.putExtra("GoodId", adapter.getData().get(pos).id);
        startActivity(intent);
    }


    Handler goodsFetcherHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            ArrayList<GoodModel> goods = (ArrayList<GoodModel>) msg.obj;
            adapter.setAllData(goods);
        }
    };

    @Override
    public void onLikeChange(int productId) {
        new GoodLiker(productId).execute();
    }

    class GoodsFetcher extends AsyncTask {

        String url;
        Map<String, String> header;
        Map<String, String > body;


        public GoodsFetcher(String _url, Map<String, String> _header) {
            this.url = _url;
            this.header = _header;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            Headers headers ;
            Gson gson = new Gson();
            String headerString = gson.toJson(this.header);
            headers = new Headers.Builder()
                    .add(headerString)
                    .build();


            Request request = new Request.Builder()
                    .url(this.url)
                    .header("Authorization", "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4LjAuMTA5Ojg4ODhcL2FwaVwvYXV0aFwvcmVnaXN0ZXJcL2N1c3RvbWVyIiwiaWF0IjoxNTk2MDcyOTI4LCJleHAiOjE1OTY5MzY5MjgsIm5iZiI6MTU5NjA3MjkyOCwianRpIjoiZzd0Y0RLeGdKOHBzU2thSiIsInN1YiI6NDYsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.BmTXz2W9X2feGlHEQzbz2UC7RWxI-g-ciV71S7SKBvY")
                    .header("Connection", "close")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String responseStr = response.body().string();
                Type typeForGoodModel = new TypeToken<ArrayList<GoodModel>>(){}.getType();
                ArrayList<GoodModel> goods = gson.fromJson(responseStr, typeForGoodModel);

                Message msg = new Message();
                msg.obj = goods;

                goodsFetcherHandler.sendMessage(msg);

                Log.e("response", responseStr);

            } catch (IOException e) {
                e.printStackTrace();
                Log.e("response", e.getMessage());
            }
            return null;
        }
    }
    class GoodLiker extends AsyncTask {
        private int goodId;

        public GoodLiker(int productId) {
            this.goodId = productId;
        }

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