package com.mobilestar.rongo.android.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.R;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHoder> {
    @NonNull
    @Override
    public StoreViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cell = inflater.inflate(R.layout.item_store, parent, false);

        return new StoreViewHoder(cell);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHoder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class StoreViewHoder extends RecyclerView.ViewHolder {

        public StoreViewHoder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
