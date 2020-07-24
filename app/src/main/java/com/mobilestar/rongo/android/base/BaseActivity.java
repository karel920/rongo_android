package com.mobilestar.rongo.android.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mobilestar.rongo.android.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public abstract class BaseActivity extends AppCompatActivity {
//    protected AppSharedPreference preference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        preference=AppSharedPreference.getInstance(this);
//        getWindow().setStatusBarColor(getResources().getColor(R.color.main_yellow_color));
    }

    protected void bindView(Activity activity){
        ButterKnife.bind(activity);
    }

//    @Optional
//    @OnClick(R.id.iv_back)
//    void back(){
//        onBackPressed();
//    }

    public void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }

    protected void showFocus(View view){
        view.requestFocus();
    }

}
