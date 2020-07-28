package com.mobilestar.rongo.android.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobilestar.rongo.android.R;

public class SearchCategorySpinnerAdapter extends BaseAdapter {

    private String[] categories = {
            "すべて",
            "ストア",
            "商品 ",
            "配信動画"
    };

    @Override
    public int getCount() {
        return this.categories.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View cell = inflater.inflate(R.layout.item_search_category, parent, false);
        TextView title = cell.findViewById(R.id.search_category_main);

        title.setText(this.categories[position]);

        return cell;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View cell = inflater.inflate(R.layout.item_search_category_dropdown, parent, false);
        TextView title = cell.findViewById(R.id.search_category_dropdown);

        title.setText(this.categories[position]);

        return cell;
    }
}
