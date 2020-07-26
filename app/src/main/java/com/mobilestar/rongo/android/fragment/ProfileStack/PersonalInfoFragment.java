package com.mobilestar.rongo.android.fragment.ProfileStack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.listener.ProfileFragmentListener;

public class PersonalInfoFragment extends Fragment {
    ProfileFragmentListener fragmentListener;
    public PersonalInfoFragment(ProfileFragmentListener _fragmentListener) {
        // Required empty public constructor
        this.fragmentListener = _fragmentListener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);

        ImageButton backButton = view.findViewById(R.id.personal_info_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragment().getChildFragmentManager().beginTransaction().remove(PersonalInfoFragment.this).commit();
                Log.e("personal Info", "back pressed");
            }
        });
        return view;
    }
}