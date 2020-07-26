package com.mobilestar.rongo.android.retrofit;

import android.text.TextUtils;

import com.mobilestar.rongo.android.Activity.Home.fragment.model.LiveInfo;
import com.mobilestar.rongo.android.Activity.Home.fragment.model.LiveInfoRes;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
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

    public void register(LiveInfo loginData, final IApiCallback<LiveInfoRes> iApiCallback) {

        MultipartBody.Part bodyImage = null;
        if (!TextUtils.isEmpty(loginData.getImage())) {
            File file = new File(loginData.getImage());
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            bodyImage = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
            ;
        }

        RequestBody rbuserName = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getUserName());
        RequestBody rbEmail = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getEmail());
        RequestBody rbPassword = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getPassword());
        RequestBody rbphone = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getPhone());
        RequestBody rbcountryCode = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getCountryCode());
        RequestBody rbfacebookId = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getFacebookId());
        RequestBody rbgoogleId = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getGoogleId());
        RequestBody dToken = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getDeviceToken());
        RequestBody dReferral = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getFirstReferral());

        Call<LiveInfoRes> call = service.register(rbuserName, rbEmail, rbphone, rbcountryCode, rbPassword, rbfacebookId, rbgoogleId, dToken, dReferral, bodyImage);
        call.enqueue(new Callback<LiveInfoRes>() {
            @Override
            public void onResponse(Call<LiveInfoRes> call, Response<LiveInfoRes> response) {
                iApiCallback.onSuccess("register", response);
            }

            @Override
            public void onFailure(Call<LiveInfoRes> call, Throwable t) {
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

}
