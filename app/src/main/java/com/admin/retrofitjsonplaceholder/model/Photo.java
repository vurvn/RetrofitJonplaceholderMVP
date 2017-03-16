package com.admin.retrofitjsonplaceholder.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by ADMIN on 03/16/17.
 */

public class Photo {

    @SerializedName("url")
    public String url;
    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;

    public Photo(String url, String thumbnailUrl) {
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    private static Photo getPhoto(JSONObject jsonObject){
        return new Gson().fromJson(jsonObject.toString(), Photo.class);
    }

    public static ArrayList<Photo> getAllPhotos(JSONArray jsonArray) throws JSONException {
        ArrayList<Photo> arrayList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            arrayList.add(getPhoto(jsonArray.getJSONObject(i)));
        }

        return arrayList;
    }
}
