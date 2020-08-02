package com.mobilestar.rongo.android.activity.GoodDetail.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.mobilestar.rongo.android.R;

import java.util.ArrayList;

public class GoodDetailImgAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> portfolios = new ArrayList<>();

    public GoodDetailImgAdapter(Context _context) {
        this.context = _context;
        portfolios = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return portfolios.size();
    }

    public void setAllItem(ArrayList<String> _items) {
        this.portfolios = _items;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());

        View cell = inflater.inflate(R.layout.item_good_detail_img, container, false);
        ImageView img = cell.findViewById(R.id.good_detail_cell_img);
        Glide.with(context).load(portfolios.get(position)).into(img);
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
