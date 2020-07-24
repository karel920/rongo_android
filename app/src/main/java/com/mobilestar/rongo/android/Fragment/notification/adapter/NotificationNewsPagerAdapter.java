package com.mobilestar.rongo.android.Fragment.notification.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationNewsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public NotificationNewsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment) {
        list.add(fragment);
    }

    public void setTitle(String title) {
        titleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titleList.size() > 0)
            return titleList.get(position);
        else
            return "";
    }
}
