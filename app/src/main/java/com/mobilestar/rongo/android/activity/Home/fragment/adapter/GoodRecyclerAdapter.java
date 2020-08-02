package com.mobilestar.rongo.android.activity.Home.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobilestar.rongo.android.Models.GoodModel;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;
import com.mobilestar.rongo.android.listener.GoodLikeChangeListener;
import com.mobilestar.rongo.android.local.GoodStorage;

import java.util.ArrayList;

public class GoodRecyclerAdapter extends RecyclerView.Adapter<GoodRecyclerAdapter.GoodRecycleerVH> {

    private IRecyclerClickListener listener;
    private GoodLikeChangeListener likeChangeListener;
    Context context;
    private ArrayList<GoodModel> goods = new ArrayList<>();

    public GoodRecyclerAdapter(Context _context) {
        this.context = _context;
    }

    public void setListener(IRecyclerClickListener _listener) {
        this.listener = _listener;
    }
    public void setLikeChangeListener(GoodLikeChangeListener _listener) {
        this.likeChangeListener = _listener;
    }
    public void setAllData(ArrayList<GoodModel> _goods) {
        this.goods = _goods;
        this.notifyDataSetChanged();
    }

    public ArrayList<GoodModel> getData() {
        return this.goods;
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

        GoodModel good = this.goods.get(position);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onRecyclerClick(position,null, null); //should update parameters.
                }
            }
        });
        Glide.with(context).load(good.thumbnail).into(holder.img);
        holder.title.setText(good.label);
        holder.price.setText(""+good.price);
        holder.store.setText(good.storeName);
        if(good.isLike == 1) {
            holder.isLike.setChecked(true);
        } else {
            holder.isLike.setChecked(false);
        }

        holder.isLike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                likeChangeListener.onLikeChange(good.id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.goods.size();
    }

    static class GoodRecycleerVH extends RecyclerView.ViewHolder {

        public View container;

        public ImageView img;
        public TextView title;
        public TextView price;
        public TextView store;
        public ToggleButton isLike;

        public GoodRecycleerVH(@NonNull View itemView) {
            super(itemView);
            this.container = itemView;

            this.img = itemView.findViewById(R.id.good_detail_img);
            this.title = itemView.findViewById(R.id.good_detail_title);
            this.store = itemView.findViewById(R.id.good_detail_store);
            this.price = itemView.findViewById(R.id.good_detail_price);
            this.isLike = itemView.findViewById(R.id.good_detail_like);
        }
    }
}
