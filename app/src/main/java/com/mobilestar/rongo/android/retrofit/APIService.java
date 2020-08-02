package com.mobilestar.rongo.android.retrofit;

import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveDetailInfo;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveInfoRes;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;
import com.mobilestar.rongo.android.fragment.notification.model.NewsInfo;
import com.mobilestar.rongo.android.fragment.notification.model.NotificationInfo;
import com.mobilestar.rongo.android.fragment.notification.model.NotificationInfoRes;
import com.mobilestar.rongo.android.fragment.rank.model.RankInfo;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

interface APIService {

    @Multipart
    @POST("auth/register/customer")
    Call<LoginRes> register(
            @Part("nickname") RequestBody nickName,
            @Part("uuid") RequestBody uuid,
            @Part("invite_code") RequestBody inviteCode
    );

    @Multipart
    @POST("auth/login/customer")
    Call<LoginRes> login(
            @Part("nickname") RequestBody nickName,
            @Part("uuid") RequestBody uuid
    );

    @GET("live")
    Call<ArrayList<LiveListInfo>> getLiveList(@Header("Authorization") String tokenString);

    @GET("live/view/{liveId}")
    Call<LiveDetailInfo> getLiveDetail(@Path("liveId") Integer liveId, @Header("Authorization") String tokenString);

    @FormUrlEncoded
    @POST("user_name_check")
    Call<LiveInfoRes> checkUserName(@Field("user_name") String userName);


    @GET("notification")
    Call<ArrayList<NotificationInfo>> getNotifications(
            @Header("Authorization") String tokenString
    );

    @GET("news")
    Call<ArrayList<NewsInfo>> getNews(
            @Header("Authorization") String tokenString
    );

    @GET("products/ranking")
    Call<ArrayList<RankInfo>> getRanks(
            @Header("Authorization") String tokenString
    );

}
