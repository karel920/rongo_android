package com.mobilestar.rongo.android.activity.Home.live.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.getstream.sdk.chat.Chat;
import com.getstream.sdk.chat.viewmodel.ChannelViewModel;
import com.getstream.sdk.chat.viewmodel.ChannelViewModelFactory;
import com.google.android.gms.common.api.Api;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveDetailInfo;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;
import com.mobilestar.rongo.android.activity.Home.live.activity.adapter.ChatListAdapter;
import com.mobilestar.rongo.android.activity.Home.live.activity.adapter.GoodListAdapter;
import com.mobilestar.rongo.android.activity.Home.live.activity.adapter.StampListAdapter;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.ChatInfo;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.GoodInfo;
import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.StampInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;
import com.mobilestar.rongo.android.base.BaseActivity;
import com.mobilestar.rongo.android.helper.AppSharedPreference;
import com.mobilestar.rongo.android.helper.Constants;
import com.mobilestar.rongo.android.helper.Helper;
import com.mobilestar.rongo.android.helper.InternetCheck;
import com.mobilestar.rongo.android.interfaces.IRecyclerClickListener;
import com.mobilestar.rongo.android.retrofit.ApiCall;
import com.mobilestar.rongo.android.retrofit.IApiCallback;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.getstream.chat.android.client.ChatClient;
import io.getstream.chat.android.client.api.models.ChannelQueryRequest;
import io.getstream.chat.android.client.call.Call;
import io.getstream.chat.android.client.controllers.ChannelController;
import io.getstream.chat.android.client.errors.ChatError;
import io.getstream.chat.android.client.events.ChatEvent;
import io.getstream.chat.android.client.events.NewMessageEvent;
import io.getstream.chat.android.client.models.Channel;
import io.getstream.chat.android.client.models.Message;
import io.getstream.chat.android.client.models.User;
import io.getstream.chat.android.client.socket.InitConnectionListener;
import io.getstream.chat.android.client.socket.SocketListener;
import io.getstream.chat.android.client.utils.ChatUtils;
import io.getstream.chat.android.client.utils.Result;
import io.getstream.chat.android.client.utils.observable.Subscription;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveRoomActivity extends BaseActivity implements IRecyclerClickListener, IApiCallback<LiveDetailInfo> {

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

    // Top View
    @BindView(R.id.iv_store_logo)
    ImageView imgStoreView;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_go_to_store)
    TextView btnFollowStore;
    @BindView(R.id.li_watch)
    LinearLayout watchView;
    @BindView(R.id.iv_live_status)
    ImageView imgStatus;

    // Bottom View
    @BindView(R.id.iv_product)
    ImageView btnAddedProduct;
    @BindView(R.id.iv_live_stamp)
    ImageView btnStamp;
    @BindView(R.id.iv_heart)
    ImageView btnLike;
    @BindView(R.id.tv_like_count)
    TextView tvLikeCount;

    private LiveDetailInfo liveDetailInfo;

    ArrayList<Message> mMessageList = new ArrayList<Message>();
    GoodListAdapter mGoodsAdapter;
    ChatListAdapter mChatListAdapter;
    StampListAdapter mStampListAdapter;

    User chatUser;
    ChatClient chatClient;
    ChatListener chatListener;
    Subscription subscription;
    ChannelController channelController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_chat);

        ButterKnife.bind(this);

        mGoodsAdapter = new GoodListAdapter(this);
        mChatListAdapter = new ChatListAdapter(this);
        mStampListAdapter = new StampListAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerChat.setLayoutManager(manager);
        recyclerChat.setAdapter(mChatListAdapter);
        mChatListAdapter.addAllItem(mMessageList);

        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        recyclerGoods.setLayoutManager(manager2);
        recyclerGoods.setAdapter(mGoodsAdapter);
        mGoodsAdapter.addAllItem(new ArrayList<GoodInfo>());

        GridLayoutManager manager3 = new GridLayoutManager(this, 3);
        recyclerStamp.setLayoutManager(manager3);
        recyclerStamp.setAdapter(mStampListAdapter);
        mStampListAdapter.addAllItem(new ArrayList<StampInfo>());

        loadDatas();
        configureStoreView();
        configureChatAndProductView(true);
    }

    private void loadDatas() {
        if (InternetCheck.isConnectedToInternet(this)) {
            AppSharedPreference preference = AppSharedPreference.getInstance(this);
            String token = preference.getTokenData().getToken().getAccessToken();

            if (LiveRoomActivity.liveListInfo.getId() != null) {
                ApiCall.getInstance().getLiveDetail(token, LiveRoomActivity.liveListInfo.getId(), this);
            } else {
                finish();
            }
        }
    }

    private void configureStoreView() {
        if (this.liveDetailInfo == null) {
            imgStoreView.setVisibility(View.GONE);
            imgStatus.setVisibility(View.GONE);
            tvStoreName.setVisibility(View.GONE);
            watchView.setVisibility(View.GONE);
            btnFollowStore.setVisibility(View.GONE);
        } else {
            imgStoreView.setVisibility(View.VISIBLE);
            imgStatus.setVisibility(View.VISIBLE);
            tvStoreName.setVisibility(View.VISIBLE);
            watchView.setVisibility(View.VISIBLE);
            btnFollowStore.setVisibility(View.VISIBLE);

            tvStoreName.setText(liveDetailInfo.getStore().getName());
            imgStatus.setVisibility((liveDetailInfo.getStatus() == 1) ? View.VISIBLE : View.GONE);
            String followText = liveDetailInfo.getStore().getFollow() ? " +フォロー" : "✓フォロー中";
            btnFollowStore.setText(followText);
//            Glide.with(this).load(liveDetailInfo.getStore().getThumbnail()).centerCrop().placeholder(R.drawable.img_store_placeholder).into(imgStoreView);
        }
    }

    private void configureUser() {
        chatClient = Chat.getInstance().getClient();

        AppSharedPreference preference = AppSharedPreference.getInstance(this);
        chatUser = new User(preference.getTokenData().getStreamUserId());
        LoginInfo userInfo = preference.getLoginData();
        Map<String, Object> extraData = new HashMap<String, Object>();
        extraData.put("name", userInfo.getNickname());
        chatUser.setExtraData(extraData);
        String token = Helper.generateUserToken(preference.getTokenData().getStreamUserId(), Constants.StreamSecretKey);
        chatListener = new ChatListener();

        chatClient.setUser(chatUser, token, chatListener);
    }

    private void configureChannel() {
        channelController = chatClient.channel("livestream", liveDetailInfo.getChannelId());
        channelController.watch().enqueue(new Function1<Result<Channel>, Unit>() {
            @Override
            public Unit invoke(Result<Channel> channelResult) {
                if (channelResult.isSuccess()) {
                    Channel channel = channelResult.data();
                    channelLoaded(channel);
                }

                return null;
            }
        });
    }

    private void channelLoaded(Channel channel) {
        this.mMessageList = (ArrayList<Message>) channel.getMessages();
        mChatListAdapter.addAllItem(mMessageList);
        scrollToBottom(recyclerChat);

        subscription = channelController.events().subscribe(new Function1<ChatEvent, Unit>() {
            @Override
            public Unit invoke(ChatEvent chatEvent) {
                if (chatEvent instanceof NewMessageEvent) {
                    upsertMessage(chatEvent.getMessage());
                }

                return null;
            }
        });
    }

    protected void upsertMessage(Message message) {
        boolean updated = false;
        for (int i = 0; i < mMessageList.size(); i++) {
            Message m = mMessageList.get(i);
            if (m.getId().equals(message.getId())) {
                updated = true;
                mMessageList.set(i, message);
                break;
            }
        }

        if (!updated) {
            mMessageList.add(message);
        }

        mChatListAdapter.addAllItem(mMessageList);
        scrollToBottom(recyclerChat);
    }

    private void configureChatAndProductView(Boolean hidden) {
        btnAddedProduct.setVisibility(hidden ? View.GONE : View.VISIBLE);
        btnStamp.setVisibility(hidden ? View.GONE : View.VISIBLE);
        btnLike.setVisibility(hidden ? View.GONE : View.VISIBLE);
        tvLikeCount.setVisibility(hidden ? View.GONE : View.VISIBLE);
        etChat.setVisibility(hidden ? View.GONE : View.VISIBLE);

        etChat.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    sendMessage();
                    return true;
                }

                return false;
            }
        });
    }

    private void scrollToBottom(final RecyclerView recyclerView) {
        // scroll to last item to get the view of last item
        final LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        final RecyclerView.Adapter adapter = recyclerView.getAdapter();
        final int lastItemPosition = adapter.getItemCount() - 1;

        layoutManager.scrollToPositionWithOffset(lastItemPosition, 0);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                // then scroll to specific offset
                View target = layoutManager.findViewByPosition(lastItemPosition);
                if (target != null) {
                    int offset = recyclerView.getMeasuredHeight() - target.getMeasuredHeight();
                    layoutManager.scrollToPositionWithOffset(lastItemPosition, offset);
                }
            }
        });
    }

    private void sendMessage() {
        if (!etChat.getText().toString().equals("")) {
            String string = etChat.getText().toString();
            Message message = new Message();
            message.setText(string);
            message.setUser(chatUser);

            channelController.sendMessage(message).enqueue(new Function1<Result<Message>, Unit>() {
                @Override
                public Unit invoke(Result<Message> messageResult) {
                    return null;
                }
            });

            etChat.setText("");
            Helper.hideSoftKeyboard(this, etChat);
        }
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

    @Override
    public void onSuccess(String type, Response<LiveDetailInfo> response) {
        this.liveDetailInfo = response.body();
        this.configureStoreView();
        this.configureUser();
    }

    @Override
    public void onFailure(Object data) {
        Log.e("Live Detail Info Error", data.toString());
    }

    class ChatListener extends InitConnectionListener {
        @Override
        public void onSuccess(@NotNull ConnectionData data) {
            super.onSuccess(data);

            configureChannel();
            configureChatAndProductView(false);
        }

        @Override
        public void onError(@NotNull ChatError error) {
            super.onError(error);
        }
    }
}
