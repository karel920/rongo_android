package com.mobilestar.rongo.android.activity.Home.live.activity.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilestar.rongo.android.R;
import com.mobilestar.rongo.android.activity.Home.live.activity.model.ChatInfo;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.getstream.chat.android.client.models.Message;

public class ChatViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_chat_name)
    TextView tvNameView;
    @BindView(R.id.tv_chat)
    TextView tvChatView;

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(Message info, int position) {
        String name = "";
        name = info.user.getExtraValue("name", name);
        tvNameView.setText(name);

        tvChatView.setText(info.getText());
    }
}
