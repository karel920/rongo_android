package com.mobilestar.rongo.android.retrofit;

import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveInfoRes;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;
import com.mobilestar.rongo.android.fragment.notification.model.NewsInfo;
import com.mobilestar.rongo.android.fragment.notification.model.NotificationInfo;
import com.mobilestar.rongo.android.fragment.rank.model.RankInfo;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCall {
    private static APIService service;

    public static ApiCall getInstance() {
        if (service == null) {
            service = RestClient.getClient();
        }
        return new ApiCall();
    }

    // MARK: - Login
    //
    public void register(LoginInfo loginData, final IApiCallback<LoginRes> iApiCallback) {
        RequestBody nickName = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getNickname());
        RequestBody uuid = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getUuid());
        RequestBody inviteCode = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getUuid());

        Call<LoginRes> call = service.register(nickName, uuid, inviteCode);

        call.enqueue(new Callback<LoginRes>() {
            @Override
            public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {
                iApiCallback.onSuccess("register", response);
            }

            @Override
            public void onFailure(Call<LoginRes> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }

    public void login(LoginInfo loginData, final IApiCallback<LoginRes> iApiCallback) {
        RequestBody nickName = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getNickname());
        RequestBody uuid = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getUuid());
        Call<LoginRes> call = service.login(nickName, uuid);

        call.enqueue(new Callback<LoginRes>() {
            @Override
            public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {
                iApiCallback.onSuccess("register", response);
            }

            @Override
            public void onFailure(Call<LoginRes> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }

    // MARK: - Live
    //
    public void getLiveList(String token, final IApiCallback<ArrayList<LiveListInfo>> iApiCallback) {
        String tokenString = "bearer " + token;

        Call<ArrayList<LiveListInfo>> call = service.getLiveList(tokenString);
        call.enqueue(new Callback<ArrayList<LiveListInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<LiveListInfo>> call, Response<ArrayList<LiveListInfo>> response) {
                iApiCallback.onSuccess("getLiveList", response);
            }

            @Override
            public void onFailure(Call<ArrayList<LiveListInfo>> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }


    public void checkUserName(String userName, IApiCallback<LiveInfoRes> iApiCallback) {
        Call<LiveInfoRes> call = service.checkUserName(userName);
        call.enqueue(new Callback<LiveInfoRes>() {
            @Override
            public void onResponse(Call<LiveInfoRes> call, Response<LiveInfoRes> response) {
                iApiCallback.onSuccess("checkUserName", response);
            }

            @Override
            public void onFailure(Call<LiveInfoRes> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }

    public void getNotifications(String token, final IApiCallback<ArrayList<NotificationInfo>> iApiCallback) {
        String tokenString = "bearer " + token;

        Call<ArrayList<NotificationInfo>> call = service.getNotifications(tokenString);
        call.enqueue(new Callback<ArrayList<NotificationInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<NotificationInfo>> call, Response<ArrayList<NotificationInfo>> response) {
                iApiCallback.onSuccess("get_notification", response);
            }

            @Override
            public void onFailure(Call<ArrayList<NotificationInfo>> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }

    public void getNews(String token, final IApiCallback<ArrayList<NewsInfo>> iApiCallback) {
        String tokenString = "bearer " + token;

        Call<ArrayList<NewsInfo>> call = service.getNews(tokenString);
        call.enqueue(new Callback<ArrayList<NewsInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<NewsInfo>> call, Response<ArrayList<NewsInfo>> response) {
                iApiCallback.onSuccess("get_news", response);
            }

            @Override
            public void onFailure(Call<ArrayList<NewsInfo>> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }

    public void getRanks(String token, final IApiCallback<ArrayList<RankInfo>> iApiCallback) {
        String tokenString = "bearer " + token;

        Call<ArrayList<RankInfo>> call = service.getRanks(tokenString);
        call.enqueue(new Callback<ArrayList<RankInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<RankInfo>> call, Response<ArrayList<RankInfo>> response) {
                iApiCallback.onSuccess("get_news", response);
            }

            @Override
            public void onFailure(Call<ArrayList<RankInfo>> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }

}
