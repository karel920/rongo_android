package com.mobilestar.rongo.android.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.fragment.adapter.GoodRecyclerAdapter;
import com.mobilestar.rongo.android.activity.Home.fragment.adapter.LiveRecyclerAdapter;
import com.mobilestar.rongo.android.activity.Home.live.fragment.model.LiveInfo;
import com.mobilestar.rongo.android.adpater.SearchCategorySpinnerAdapter;
import com.mobilestar.rongo.android.adpater.StoreAdapter;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

import java.util.ArrayList;

public class SearchFragment extends Fragment implements IRecyclerClickListener {

    RecyclerView goodList;
    RecyclerView liveList;
    RecyclerView storeList;
    Spinner searchCategory;
    ImageButton headerClose;

    View headerContianer;
    View storeContainer;
    View goodContainer;
    View liveContainer;

    GoodRecyclerAdapter goodListAdapter;
    LiveRecyclerAdapter liveListAdapter;
    StoreAdapter storeAdapter;
    SearchCategorySpinnerAdapter categorySpinnerAdapter;

    ArrayList<LiveInfo> mTestData;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout =  inflater.inflate(R.layout.fragment_search, container, false);
        this.goodList = layout.findViewById(R.id.search_good_list);
        this.liveList = layout.findViewById(R.id.search_live_list);
        this.storeList = layout.findViewById(R.id.search_store_list);
        this.searchCategory = layout.findViewById(R.id.search_category);

        this.headerContianer = layout.findViewById(R.id.search_header);
        this.storeContainer = layout.findViewById(R.id.search_store_container);
        this.goodContainer = layout.findViewById(R.id.search_good_container);
        this.liveContainer = layout.findViewById(R.id.search_live_container);

        this.headerClose = layout.findViewById(R.id.search_header_close);

        mTestData = new ArrayList<LiveInfo>();
        for(int i =0; i< 15; i++){
            mTestData.add(new LiveInfo());
        }

        this.goodListAdapter = new GoodRecyclerAdapter();
        this.liveListAdapter = new LiveRecyclerAdapter(this);
        this.storeAdapter = new StoreAdapter();
        this.categorySpinnerAdapter = new SearchCategorySpinnerAdapter();

        this.liveListAdapter.addAllItem(mTestData);

        this.goodList.setAdapter(this.goodListAdapter);
        this.liveList.setAdapter(this.liveListAdapter);
        this.storeList.setAdapter(this.storeAdapter);
        this.searchCategory.setAdapter(this.categorySpinnerAdapter);

        goodListAdapter.notifyDataSetChanged();
        liveListAdapter.notifyDataSetChanged();
        storeAdapter.notifyDataSetChanged();

        this.searchCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 :
                        goodContainer.setVisibility(View.VISIBLE);
                        storeContainer.setVisibility(View.VISIBLE);
                        liveContainer.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        hideAllContainers();
                        storeContainer.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        hideAllContainers();
                        goodContainer.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        hideAllContainers();
                        liveContainer.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                goodContainer.setVisibility(View.VISIBLE);
                storeContainer.setVisibility(View.VISIBLE);
                liveContainer.setVisibility(View.VISIBLE);
            }
        });
        this.headerClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerContianer.setVisibility(View.GONE);
            }
        });

        return layout;
    }

    private void hideAllContainers() {
        this.goodContainer.setVisibility(View.GONE);
        this.storeContainer.setVisibility(View.GONE);
        this.liveContainer.setVisibility(View.GONE);
    }

    @Override
    public void onRecyclerClick(int pos, Object data, Object type) {

    }
}