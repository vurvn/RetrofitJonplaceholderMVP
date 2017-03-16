package com.admin.retrofitjsonplaceholder.listener;

import com.admin.retrofitjsonplaceholder.model.Photo;

import java.util.ArrayList;

/**
 * Created by ADMIN on 03/16/17.
 */

public interface FetchDataCallBack {
    void onFetchSuccess(ArrayList<Photo> list);
    void onFetchFault(Exception e);
}
