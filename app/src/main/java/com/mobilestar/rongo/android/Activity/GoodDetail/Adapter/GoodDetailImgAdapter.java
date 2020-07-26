package com.mobilestar.rongo.android.Activity.GoodDetail.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.mobilestar.rongo.android.R;

public class GoodDetailImgAdapter extends PagerAdapter {

    Context context;

    public GoodDetailImgAdapter(Context _context) {
        this.context = _context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());

        View cell = inflater.inflate(R.layout.item_good_detail_img, container, false);
        ImageView img = cell.findViewById(R.id.good_detail_cell_img);
        Glide.with(context).load(R.drawable.icon_live_thumb).into(img);
        container.addView(cell);
        return cell;
    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
