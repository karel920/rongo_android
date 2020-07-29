package com.mobilestar.rongo.android.activity.Login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRes {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("token")
    @Expose
    private TokenRes token;
    @SerializedName("chat_user_id")
    @Expose
    private String streamUserId;

    public TokenRes getToken() {
        return token;
    }

    public Integer getSuccess() {
        return success;
    }

    public String getStreamUserId() {
        return streamUserId;
    }

    public void setToken(TokenRes token) {
        this.token = token;
    }

    public void setStreamUserId(String streamUserId) {
        this.streamUserId = streamUserId;
    }
}
