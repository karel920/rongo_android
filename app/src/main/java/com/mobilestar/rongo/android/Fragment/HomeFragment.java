package com.mobilestar.rongo.android.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.mobilestar.rongo.android.Activity.Home.fragment.LiveListFragment;
import com.mobilestar.rongo.android.Fragment.rank.RankListFragment;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.base.BaseFragment;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_radio) RadioGroup topRadioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bindView(view);

        this.topRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.home_radio_live :
                        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, LiveListFragment.getInstance()).commit();
                        break;
                    case R.id.home_radio_good :
//                        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, GoodFragment.newInstance()).commit();
                        break;
                    case R.id.home_radio_ranking :
                        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, RankListFragment.getInstance()).commit();
                        break;
                    case R.id.home_radio_store :
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView(view);
    }

    void setView(View view) {
        if (!(getCurrentFragment() instanceof LiveListFragment))
            addFragment(LiveListFragment.getInstance());
    }

    private void addFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private Fragment getCurrentFragment() {
        return getChildFragmentManager().findFragmentById(R.id.fragment_container);
    }
}