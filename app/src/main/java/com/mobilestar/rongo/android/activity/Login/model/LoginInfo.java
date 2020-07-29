package com.mobilestar.rongo.android.activity.Login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInfo {
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("inviteCode")
    @Expose
    private String inviteCode;

    public String getNickname() {
        return nickname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
