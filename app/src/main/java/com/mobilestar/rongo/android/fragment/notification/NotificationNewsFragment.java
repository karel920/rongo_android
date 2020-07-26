package com.mobilestar.rongo.android.fragment.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mobilestar.rongo.android.fragment.notification.adapter.NotificationNewsPagerAdapter;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseFragment;

import butterknife.BindView;

public class NotificationNewsFragment extends BaseFragment {

    @BindView(R.id.notification_news_view_pager)
    ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notificaton_news, container, false);
        bindView(view);
        setPager(view);
        return view;
    }

    private void setPager(View view) {
        NotificationNewsPagerAdapter pagerAdapter = new NotificationNewsPagerAdapter(getChildFragmentManager());
        pagerAdapter.setTitle(getString(R.string.notification));
        pagerAdapter.setTitle(getString(R.string.news));
        pagerAdapter.addFragment(NotificationListFragment.getInstance());
        pagerAdapter.addFragment(NewsListFragment.getInstance());
        viewPager.setAdapter(pagerAdapter);
        ((TabLayout) view.findViewById(R.id.tab_layout)).setupWithViewPager(viewPager);
    }

    private static NotificationNewsFragment instance;

    public static NotificationNewsFragment getInstance() {
        if (instance == null)
            instance = new NotificationNewsFragment();

        return instance;
    }

}
