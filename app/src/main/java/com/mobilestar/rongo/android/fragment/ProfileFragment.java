package com.mobilestar.rongo.android.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilestar.rongo.android.fragment.ProfileStack.NotifySettingFragment;
import com.mobilestar.rongo.android.fragment.ProfileStack.PersonalInfoFragment;
import com.mobilestar.rongo.android.fragment.ProfileStack.ProfileMenuFragment;
import com.mobilestar.rongo.android.fragment.ProfileStack.SoundSettingFragment;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.listener.ProfileFragmentListener;

public class ProfileFragment extends Fragment implements ProfileFragmentListener {

    ProfileMenuFragment menuFragment;
    PersonalInfoFragment personalInfoFragment;
    NotifySettingFragment notifySettingFragment;
    SoundSettingFragment soundSettingFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        menuFragment = new ProfileMenuFragment(this);
        personalInfoFragment = new PersonalInfoFragment(this);
        notifySettingFragment = new NotifySettingFragment(this);
        soundSettingFragment = new SoundSettingFragment(this);

        this.getChildFragmentManager().beginTransaction().add(R.id.profile_main_container, this.menuFragment).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onPersonalInfoClick(View v) {
        this.onPersonalInformation();
    }

    @Override
    public void onPersonalInformation() {
        this.getChildFragmentManager().beginTransaction().add(R.id.profile_main_container, this.personalInfoFragment).commit();
    }

    @Override
    public void onNotifySetting() {
        this.getChildFragmentManager().beginTransaction().add(R.id.profile_main_container, this.notifySettingFragment).commit();
    }

    @Override
    public void onSoundSetting() {
        this.getChildFragmentManager().beginTransaction().add(R.id.profile_main_container, this.soundSettingFragment).commit();
    }
}