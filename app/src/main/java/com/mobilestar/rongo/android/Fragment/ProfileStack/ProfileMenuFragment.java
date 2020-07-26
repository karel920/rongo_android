package com.mobilestar.rongo.android.Fragment.ProfileStack;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.listener.ProfileFragmentListener;

public class ProfileMenuFragment extends Fragment {

    ProfileFragmentListener fragmentListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ProfileMenuFragment(ProfileFragmentListener _fragmentListener) {
        // Required empty public constructor

        this.fragmentListener = _fragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View container = inflater.inflate(R.layout.fragment_profile_menu, parent, false);

        Button personalInfo = container.findViewById(R.id.profile_menu_personal_info);
        Button notifySetting = container.findViewById(R.id.profile_menu_notify_setting);
        Button soundSetting = container.findViewById(R.id.profile_menu_sound_setting);
        personalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.onPersonalInformation();
            }
        });
        notifySetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.onNotifySetting();
            }
        });
        soundSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.onSoundSetting();
            }
        });

        return container;
    }

    public void onPersonalInfo(View v) {
        this.fragmentListener.onPersonalInformation();
    }
}