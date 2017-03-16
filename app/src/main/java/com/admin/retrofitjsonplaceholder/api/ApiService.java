package com.admin.retrofitjsonplaceholder.api;

import com.admin.retrofitjsonplaceholder.config.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by ADMIN on 03/16/17.
 */

public interface ApiService {

    @GET("/photos")
    Call<ResponseBody> getAllPhotos();
    Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.URL_JSONPLACEHOLDER)
            .addConverterFactory(GsonConverterFactory.create()).build();
}
