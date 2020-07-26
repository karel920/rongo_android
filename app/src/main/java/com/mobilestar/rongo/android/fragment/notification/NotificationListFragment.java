package com.mobilestar.rongo.android.fragment.notification;


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

import com.mobilestar.rongo.android.fragment.notification.adapter.NotificationListAdapter;
import com.mobilestar.rongo.android.fragment.notification.model.NotificationInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationListFragment extends BaseFragment {

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    private NotificationListAdapter adapter;
    private int PAGE_SIZE = 10, page = 1;
    private boolean isLoading, isLastPage;

    ArrayList<NotificationInfo> mTestData;

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

        mTestData = new ArrayList<NotificationInfo>();
        for(int i =0; i< 15; i++){
            mTestData.add(new NotificationInfo());
        }
        adapter = new NotificationListAdapter();
        adapter.addAllItem(mTestData);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_lives);
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


    private static NotificationListFragment instance;

    public static NotificationListFragment getInstance() {
        if (instance == null) {
            instance = new NotificationListFragment();
        }
        return instance;
    }
}
