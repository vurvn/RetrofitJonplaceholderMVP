package com.admin.retrofitjsonplaceholder.api;

import android.util.Log;

import com.admin.retrofitjsonplaceholder.listener.FetchDataCallBack;
import com.admin.retrofitjsonplaceholder.model.Photo;

import org.json.JSONArray;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ADMIN on 03/16/17.
 */

public class ApiServiceIml {

    ApiService apiService;

    public void getAllPhotos(final FetchDataCallBack dataCallback){
        apiService = ApiService.retrofit.create(ApiService.class);
        Call<ResponseBody> getProducts = apiService.getAllPhotos();
        getProducts.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONArray obj = new JSONArray((response.body().string() ));
                    dataCallback.onFetchSuccess(Photo.getAllPhotos(obj));
                } catch (Exception e){
                    dataCallback.onFetchFault(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                dataCallback.onFetchFault(new Exception(t));
            }
        });
    }
}
