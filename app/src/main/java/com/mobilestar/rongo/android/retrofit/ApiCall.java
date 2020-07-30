package com.mobilestar.rongo.android.retrofit;

import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveInfoRes;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveListInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginInfo;
import com.mobilestar.rongo.android.activity.Login.model.LoginRes;

import java.util.ArrayList;
import com.mobilestar.rongo.android.activity.Home.fragment.model.LiveInfoRes;

import java.io.File;

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

    public void getLiveDetail(String token, Integer liveId, final IApiCallback<ArrayList<LiveListInfo>> iApiCallback) {

    }

//    public void register(LiveInfo loginData, final IApiCallback<LiveInfoRes> iApiCallback) {
//
//        MultipartBody.Part bodyImage = null;
//        if (!TextUtils.isEmpty(loginData.getImage())) {
//            File file = new File(loginData.getImage());
//            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            bodyImage = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
//            ;
//        }
//
//        RequestBody rbuserName = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getUserName());
//        RequestBody rbEmail = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getEmail());
//        RequestBody rbPassword = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getPassword());
//        RequestBody rbphone = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getPhone());
//        RequestBody rbcountryCode = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getCountryCode());
//        RequestBody rbfacebookId = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getFacebookId());
//        RequestBody rbgoogleId = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getGoogleId());
//        RequestBody dToken = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getDeviceToken());
//        RequestBody dReferral = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getFirstReferral());
//
//        Call<LiveInfoRes> call = service.register(rbuserName, rbEmail, rbphone, rbcountryCode, rbPassword, rbfacebookId, rbgoogleId, dToken, dReferral, bodyImage);
//        call.enqueue(new Callback<LiveInfoRes>() {
//            @Override
//            public void onResponse(Call<LiveInfoRes> call, Response<LiveInfoRes> response) {
//                iApiCallback.onSuccess("register", response);
//            }
//
//            @Override
//            public void onFailure(Call<LiveInfoRes> call, Throwable t) {
//                iApiCallback.onFailure("" + t.getMessage());
//            }
//        });
//    }

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
