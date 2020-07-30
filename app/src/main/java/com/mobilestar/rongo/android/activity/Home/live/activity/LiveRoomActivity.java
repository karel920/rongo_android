package com.mobilestar.rongo.android.activity.Home.live.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;
import com.mobilestar.rongo.android.activity.Home.live.activity.adapter.ChatListAdapter;
import com.mobilestar.rongo.android.activity.Home.live.activity.adapter.GoodListAdapter;
import com.mobilestar.rongo.android.activity.Home.live.activity.adapter.StampListAdapter;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.ChatInfo;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.GoodInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.StampInfo;
import com.mobilestar.rongo.android.base.BaseActivity;
import com.mobilestar.rongo.android.helper.AppSharedPreference;
import com.mobilestar.rongo.android.helper.InternetCheck;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;
import com.mobilestar.rongo.android.retrofit.ApiCall;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class LiveRoomActivity extends BaseActivity implements IRecyclerClickListener {

    static public LiveListInfo liveListInfo;

    @BindView(R.id.li_goods_list)
    LinearLayout liGoodsList;
    @BindView(R.id.li_stamp_list)
    RelativeLayout rlStamp;
    @BindView(R.id.recycler_chat)
    RecyclerView recyclerChat;
    @BindView(R.id.recycler_goods)
    RecyclerView recyclerGoods;
    @BindView(R.id.recycler_stamp)
    RecyclerView recyclerStamp;
    @BindView(R.id.et_chat)
    EditText etChat;

    GoodListAdapter mGoodsAdapter;
    ChatListAdapter mChatListAdapter;
    StampListAdapter mStampListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_chat);

        bindView(this);

        mGoodsAdapter = new GoodListAdapter(this);
        mChatListAdapter = new ChatListAdapter(this);
        mStampListAdapter = new StampListAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerChat.setLayoutManager(manager);
        recyclerChat.setAdapter(mChatListAdapter);

        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        recyclerGoods.setLayoutManager(manager2);
        recyclerGoods.setAdapter(mGoodsAdapter);

        GridLayoutManager manager3 = new GridLayoutManager(this, 3);
        recyclerStamp.setLayoutManager(manager3);
        recyclerStamp.setAdapter(mStampListAdapter);

        setVirtualData();
    }

    private void loadDatas() {
        if (InternetCheck.isConnectedToInternet(getActivity())) {
            hideLoader();
            showLoader();
            isLoading = true;
            AppSharedPreference preference = AppSharedPreference.getInstance(this);
            String token = preference.getTokenData().getToken().getAccessToken();
            ApiCall.getInstance().getLiveList(token, this);
        }
    }

    void setVirtualData(){
        ArrayList<GoodInfo> goodListData = new ArrayList<GoodInfo>();
        ArrayList<ChatInfo> chatListData = new ArrayList<ChatInfo>();
        ArrayList<StampInfo> stampListData = new ArrayList<StampInfo>();
        for (int i=0; i<15; i++){
            goodListData.add(new GoodInfo());
            chatListData.add(new ChatInfo());
            stampListData.add(new StampInfo());
        }
        mGoodsAdapter.addAllItem(goodListData);
        mChatListAdapter.addAllItem(chatListData);
        mStampListAdapter.addAllItem(stampListData);
    }

    @OnClick(R.id.iv_product)
    void onClickProduct(){
        if(liGoodsList.getVisibility() == View.GONE) {
            liGoodsList.setVisibility(View.VISIBLE);
        }else{
            liGoodsList.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.iv_live_stamp)
    void onClickStamp(){
        if(rlStamp.getVisibility() == View.GONE) {
            rlStamp.setVisibility(View.VISIBLE);
        }else{
            rlStamp.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.iv_stamp_close)
    void onClickStampClose(){
        rlStamp.setVisibility(View.GONE);
    }

    @OnClick(R.id.iv_live_close)
    void onClickClose(){
        finish();
    }

    @Override
    public void onRecyclerClick(int pos, Object data, Object type) {

    }

    @Override
    public void onBackPressed() {
        if(liGoodsList.getVisibility() == View.VISIBLE){
            liGoodsList.setVisibility(View.GONE);
            return;
        }else if(rlStamp.getVisibility() == View.VISIBLE){
            rlStamp.setVisibility(View.GONE);
            return;
        }
        super.onBackPressed();
    }
}
