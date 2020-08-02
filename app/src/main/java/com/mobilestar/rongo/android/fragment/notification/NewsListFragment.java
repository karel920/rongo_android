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

import com.mobilestar.rongo.android.fragment.notification.adapter.NewsListAdapter;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseFragment;
import com.mobilestar.rongo.android.fragment.notification.model.NewsInfo;
import com.mobilestar.rongo.android.fragment.notification.model.NotificationInfo;
import com.mobilestar.rongo.android.helper.InternetCheck;
import com.mobilestar.rongo.android.helper.ProgressHelper;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;
import com.mobilestar.rongo.android.retrofit.ApiCall;
import com.mobilestar.rongo.android.retrofit.IApiCallback;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends BaseFragment implements IRecyclerClickListener, IApiCallback {

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    private NewsListAdapter adapter;
    private int PAGE_SIZE = 10, page = 1;
    private boolean isLoading, isLastPage;

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
        adapter = new NewsListAdapter(this);

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
                        getNews();
                    }
                }
            }
        });
        getNews();
    }


    private void getNews() {
        if (InternetCheck.isConnectedToInternet(getActivity())) {
            hideLoader();
            showLoader();
            isLoading = true;
            //preference.getTokenData().getToken().getAccessToken()
            ApiCall.getInstance().getNews("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4LjAuMTA5Ojg4ODhcL2FwaVwvYXV0aFwvcmVnaXN0ZXJcL2N1c3RvbWVyIiwiaWF0IjoxNTk2MDcyOTI4LCJleHAiOjE1OTY5MzY5MjgsIm5iZiI6MTU5NjA3MjkyOCwianRpIjoiZzd0Y0RLeGdKOHBzU2thSiIsInN1YiI6NDYsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.BmTXz2W9X2feGlHEQzbz2UC7RWxI-g-ciV71S7SKBvY", this);
        }
    }

    private void showLoader() {
        ProgressHelper.showDialog(getContext());
    }

    private void hideLoader() {
        ProgressHelper.dismiss();
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

    private static NewsListFragment instance;

    public static NewsListFragment getInstance() {
        if (instance == null) {
            instance = new NewsListFragment();
        }
        return instance;
    }

    @Override
    public void onSuccess(String type, Response response) {
        hideLoader();
        if (response.isSuccessful()) {
            if (type.equals("get_news")) {
                adapter.addAllItem((ArrayList<NewsInfo>) (response.body()));
                if (adapter.getItemCount() == 0) {
                    tvEmpty.setVisibility(View.VISIBLE);
                } else {
                    tvEmpty.setVisibility(View.GONE);
                }
            }
        } else {
            showToast("Something Wrong");
        }
    }

    @Override
    public void onFailure(Object data) {
        hideLoader();
        showToast("Failed");
    }
}
