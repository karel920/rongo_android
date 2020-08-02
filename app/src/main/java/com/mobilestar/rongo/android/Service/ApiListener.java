package com.mobilestar.rongo.android.Service;

public interface ApiListener {
    abstract public void onSuccess(String response);
    abstract public void onFail();
}
