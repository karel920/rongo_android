package com.mobilestar.rongo.android.Fragment.rank;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.Fragment.rank.adapter.RankListAdapter;
import com.mobilestar.rongo.android.Fragment.rank.model.RankInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseFragment;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankListFragment extends BaseFragment implements IRecyclerClickListener {

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    private RankListAdapter adapter;
    private int PAGE_SIZE = 10, page = 1;
    private boolean isLoading, isLastPage;

    ArrayList<RankInfo> mTestData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerReward(view);
    }

    private void setRecyclerReward(View view) {
        page = 1;

        mTestData = new ArrayList<RankInfo>();
        for(int i =0; i< 15; i++){
            mTestData.add(new RankInfo());
        }
        adapter = new RankListAdapter(this);
        adapter.addAllItem(mTestData);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        setPageLimit(manager, recyclerView);
    }

    private void setPageLimit(final LinearLayoutManager manager, RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = manager.getChildCount();
                int totalItemCount = manager.getItemCount();
                int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= PAGE_SIZE) {
                        page = page + 1;
                        getReward();
                    }
                }
            }
        });
        getReward();
    }


    private void getReward() {
        //if (InternetCheck.isConnectedToInternet(getActivity())) {
//            hideLoader();
//            showLoader();
//            isLoading = true;
//            ApiCall.getInstance().awufCashList(preference.getLoginData().getId(), String.valueOf(page), this);
        // }
    }

    private void showLoader() {
        /*if (!TextUtils.isEmpty(search) && page == 1)
            refreshLayout.setRefreshing(true);
        else if (page == 1 && !refreshLayout.isRefreshing())*/
//        ProgressHelper.showDialog(getContext());
        /*else if (!refreshLayout.isRefreshing())
            progressBar.setVisibility(View.VISIBLE);*/
    }

    private void hideLoader() {
//        ProgressHelper.dismiss();
        /*progressBar.setVisibility(View.GONE);
        refreshLayout.setRefreshing(false);*/
        isLoading = false;
    }


    @Override
    public void onRecyclerClick(int pos, Object data, Object type) {
        if (type.toString().equals("click_news")) {
//            Intent intent = new Intent(getContext(), RewardCouponDetailActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            getContext().startActivity(intent);
        }
    }

    private static RankListFragment instance;

    public static RankListFragment getInstance() {
        if (instance == null) {
            instance = new RankListFragment();
        }
        return instance;
    }
}