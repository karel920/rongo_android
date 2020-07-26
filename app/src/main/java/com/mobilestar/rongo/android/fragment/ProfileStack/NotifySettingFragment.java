package com.mobilestar.rongo.android.fragment.ProfileStack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.listener.ProfileFragmentListener;

public class NotifySettingFragment extends Fragment {
    ProfileFragmentListener listener;

    public NotifySettingFragment(ProfileFragmentListener _listener) {
        this.listener = _listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notify_setting, container, false);

        ImageButton button = view.findViewById(R.id.notify_setting_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragment().getChildFragmentManager().beginTransaction().remove(NotifySettingFragment.this).commit();
            }
        });

        return view;
    }
}