package com.mobilestar.rongo.android.activity.Home.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;

public class GoodRecyclerAdapter extends RecyclerView.Adapter<GoodRecyclerAdapter.GoodRecycleerVH> {

    private IRecyclerClickListener listener;

    public void setListener(IRecyclerClickListener _listener) {
        this.listener = _listener;
    }

    @NonNull
    @Override
    public GoodRecycleerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cell = inflater.inflate(R.layout.item_good_list, parent, false);
        return new GoodRecycleerVH(cell);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodRecycleerVH holder, int position) {
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onRecyclerClick(position,null, null); //should update parameters.
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class GoodRecycleerVH extends RecyclerView.ViewHolder {

        public View container;

        public GoodRecycleerVH(@NonNull View itemView) {
            super(itemView);
            this.container = itemView;
        }
    }
}
