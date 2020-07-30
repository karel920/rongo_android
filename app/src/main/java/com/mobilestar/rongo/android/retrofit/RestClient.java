package com.mobilestar.rongo.android.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobilestar.rongo.android.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RestClient {

//    private static final String BASE_URL = "http://192.168.0.110:8888/justship/public/api/";;//"http://192.168.0.106:8000/api/";//
    private static final String BASE_URL = "http://192.168.0.109:8888/api/";
//    private static final String BASE_URL = "http://192.168.0.102:8000/api/";

    private static APIService apiRestInterfaces;

    static APIService getClient() {


        final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .readTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS);
//                .build();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(interceptor);
        }

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        if (apiRestInterfaces == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient.build())
                    .build();
            apiRestInterfaces = client.create(APIService.class);
        }
        return apiRestInterfaces;
    }
}
