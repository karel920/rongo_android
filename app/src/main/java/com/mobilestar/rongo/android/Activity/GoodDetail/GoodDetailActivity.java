package com.mobilestar.rongo.android.Activity.GoodDetail;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.mobilestar.rongo.android.Activity.GoodDetail.Adapter.GoodDetailImgAdapter;
import com.mobilestar.rongo.android.Activity.GoodDetail.Adapter.GoodDetailLiveAdapter;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.View.NonScrollableListView;

public class GoodDetailActivity extends AppCompatActivity {

    private GoodDetailImgAdapter adapter;
    private GoodDetailLiveAdapter liveAdapter;
    private ViewPager goodImagesViewPager;
    private NonScrollableListView goodLiveList;
    private ToggleButton descriptioToggle;
    private TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);

        goodImagesViewPager = findViewById(R.id.good_detail_images);
        goodLiveList = findViewById(R.id.good_detail_live_list);
        descriptioToggle = findViewById(R.id.good_detail_desc_toogle);
        description = findViewById(R.id.description);

        adapter = new GoodDetailImgAdapter(this);
        liveAdapter = new GoodDetailLiveAdapter();

        goodImagesViewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        goodLiveList.setAdapter(liveAdapter);

        Layout l = description.getLayout();
        if (l != null) {
            int lines = l.getLineCount();
            if (lines <= 4){
                this.descriptioToggle.setVisibility(View.GONE);
            } else {
                this.descriptioToggle.setVisibility(View.VISIBLE);
            }
        }
        this.descriptioToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    description.setMaxLines(100);
                } else  {
                    description.setMaxLines(4);
                }
            }
        });
    }

    public void onNextImage(View v) {
        int currentSelection = this.goodImagesViewPager.getCurrentItem();
        int count = this.adapter.getCount();

        if(currentSelection < count -1) {
            this.goodImagesViewPager.setCurrentItem(currentSelection + 1 , true);
        }
    }
    public void onPrevImage(View v) {
        int currentSelection = this.goodImagesViewPager.getCurrentItem();

        if(currentSelection > 0) {
            this.goodImagesViewPager.setCurrentItem(currentSelection - 1 , true);
        }
    }
}