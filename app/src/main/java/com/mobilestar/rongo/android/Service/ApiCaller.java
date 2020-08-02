package com.mobilestar.rongo.android.Service;

import android.os.AsyncTask;
import android.view.textclassifier.TextLinks;

import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

import okhttp3.OkHttpClient;

public class ApiCaller extends AsyncTask<Object, Integer , Object> {

    public enum METHOD {
        GET, POST
    };
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    String url;
    OkHttpClient client;
    ApiListener listener;

    public ApiCaller(String _url, ApiListener _listener) {
        this.client = new OkHttpClient();
        this.listener = _listener;
        this.url = _url;
    }

    public void setListener(ApiListener _listener) {
        this.listener = _listener;
    }

    @Override
    protected Object doInBackground(Object[] objects) { // 0: method, 1 : header, 2: body
        METHOD method = (METHOD) objects[0];
        Map<String, String> headers = (Map<String, String>) objects[1];
        Map<String, String> body = (Map<String, String>) objects[2];

        Request request;
        Request.Builder builder = new Request.Builder();

        if(method == METHOD.GET) {
            for(String key : headers.keySet()) {
                builder.addHeader(key, headers.get(key));
            }
        } else {
            Gson gson = new Gson();
            String params = gson.toJson(body);
            RequestBody requestBody = RequestBody.create(JSON,params);
            builder.post(requestBody);
        }

        builder.url(this.url);

        request = builder.build();
        Response response;
        try {
            response = this.client.newCall(request).execute();
            String res = response.body().string();
            this.listener.onSuccess(res);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            this.listener.onFail();
            return "Error";
        }

    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
