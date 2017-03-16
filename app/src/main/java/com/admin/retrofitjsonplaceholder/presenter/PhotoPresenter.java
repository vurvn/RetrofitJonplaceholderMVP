package com.admin.retrofitjsonplaceholder.presenter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.admin.retrofitjsonplaceholder.adapter.PhotoAdapter;
import com.admin.retrofitjsonplaceholder.api.ApiService;
import com.admin.retrofitjsonplaceholder.api.ApiServiceIml;
import com.admin.retrofitjsonplaceholder.listener.FetchDataCallBack;
import com.admin.retrofitjsonplaceholder.model.Photo;

import java.util.ArrayList;

/**
 * Created by ADMIN on 03/16/17.
 */

public class PhotoPresenter extends BasePresenter{
    String TAG = PhotoPresenter.class.getSimpleName();

    private PhotoAdapter productAdapter;
    ApiServiceIml apiServiceIml;
    private ArrayList<Photo> photoArrayList;

    public PhotoPresenter(Context context, RecyclerView recyclerView) {

        super(context);

        apiServiceIml = new ApiServiceIml();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 1);
        recyclerView.setLayoutManager(layoutManager);
        photoArrayList = new ArrayList<>();
        productAdapter = new PhotoAdapter(photoArrayList, context);
        recyclerView.setAdapter(productAdapter);
    }

    public void fetchData(){
        apiServiceIml.getAllPhotos(new FetchDataCallBack() {
            @Override
            public void onFetchSuccess(ArrayList<Photo> list) {
                Log.d(TAG, list.toString());
                photoArrayList.addAll(list);
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFetchFault(Exception e) {

            }
        });
    }
}
