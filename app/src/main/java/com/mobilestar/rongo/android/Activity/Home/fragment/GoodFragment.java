package com.mobilestar.rongo.android.Activity.Home.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilestar.rongo.android.Activity.GoodDetail.GoodDetailActivity;
import com.mobilestar.rongo.android.Activity.Home.fragment.adapter.GoodRecyclerAdapter;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

import butterknife.BindView;

public class GoodFragment extends Fragment implements IRecyclerClickListener {
    RecyclerView goodsList;
    SwipeRefreshLayout swipeRefreshLayout;

    GoodRecyclerAdapter adapter;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentContent = inflater.inflate(R.layout.fragment_good, container, false);

        this.goodsList = fragmentContent.findViewById(R.id.home_good_list);
        this.swipeRefreshLayout = fragmentContent.findViewById(R.id.good_refresh_layout);

        adapter = new GoodRecyclerAdapter();
        adapter.setListener(this);
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

        return fragmentContent;
    }

    @Override
    public void onRecyclerClick(int pos, Object data, Object type) {
        Intent intent = new Intent(this.getContext(), GoodDetailActivity.class);
        startActivity(intent);
    }
}