package com.mobilestar.rongo.android.retrofit;

import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveInfoRes;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

interface APIService {

    @Multipart
    @POST("user_register")
    Call<LiveInfoRes> register(
            @Part("user_name") RequestBody userName,
            @Part("email") RequestBody email,
            @Part("phone") RequestBody phone,
            @Part("country_code") RequestBody countryCode,
            @Part("password") RequestBody password,
            @Part("facebook_id") RequestBody facebook_id,
            @Part("google_id") RequestBody google_id,
            @Part("device_token") RequestBody deviceToken,
            @Part("first_referral") RequestBody firstReferralId,
            @Part MultipartBody.Part image
    );

    @FormUrlEncoded
    @POST("user_name_check")
    Call<LiveInfoRes> checkUserName(@Field("user_name") String userName);


}
