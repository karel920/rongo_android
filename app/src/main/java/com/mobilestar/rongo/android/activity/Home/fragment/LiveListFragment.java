package com.mobilestar.rongo.android.activity.Home.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.MainActivity;
import com.mobilestar.rongo.android.activity.Home.fragment.adapter.LiveRecyclerAdapter;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.live.activity.LiveRoomActivity;
import com.mobilestar.rongo.android.activity.Login.LoginActivity;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;
import com.mobilestar.rongo.android.base.BaseFragment;
import com.mobilestar.rongo.android.helper.AppSharedPreference;
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
public class LiveListFragment extends BaseFragment implements IRecyclerClickListener, IApiCallback {

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    private LiveRecyclerAdapter adapter;
    private int PAGE_SIZE = 16, page = 1;
    private boolean isLoading, isLastPage;

    ArrayList<LiveListInfo> mLiveList;

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

        mLiveList = new ArrayList<LiveListInfo>();
        adapter = new LiveRecyclerAdapter(this);
        adapter.addAllItem(mLiveList);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        setPageLimit(manager, recyclerView);
    }

    private void setPageLimit(final GridLayoutManager manager, RecyclerView recyclerView) {
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
        if (InternetCheck.isConnectedToInternet(getActivity())) {
            hideLoader();
            showLoader();
            isLoading = true;
            AppSharedPreference preference = AppSharedPreference.getInstance(getContext());
            String token = preference.getTokenData().getToken().getAccessToken();
            ApiCall.getInstance().getLiveList(token, this);
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
        if (type.toString().equals("click_live")) {
            LiveListInfo info = this.mLiveList.get(pos);
            LiveRoomActivity.liveListInfo = info;
            Intent intent = new Intent(getContext(), LiveRoomActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            getContext().startActivity(intent);
        }
    }

    private static LiveListFragment instance;

    public static LiveListFragment getInstance() {
        if (instance == null) {
            instance = new LiveListFragment();
        }
        return instance;
    }

    @Override
    public void onSuccess(String type, Response response) {
        Log.e("Live List", response.body().toString());

        this.hideLoader();

        for (LiveListInfo info: (ArrayList<LiveListInfo>)response.body()) {
            mLiveList.add(info);
        }

        adapter.addAllItem(mLiveList);
    }

    @Override
    public void onFailure(Object data) {
        Log.e("Live List Error", data.toString());

        this.hideLoader();
    }
}
