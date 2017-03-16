package com.admin.retrofitjsonplaceholder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.admin.retrofitjsonplaceholder.R;
import com.admin.retrofitjsonplaceholder.model.Photo;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ADMIN on 03/16/17.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder>{
    private List<Photo> listPhoto;
    private Context context;

    public PhotoAdapter(List<Photo> listProduct, Context context){
        this.listPhoto = listProduct;
        this.context = context;

    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item , parent,false);

        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        Photo photo = listPhoto.get(position);
        holder.txtName.setText(photo.getUrl());
        Glide.with(context).load(photo.getThumbnailUrl())
                .centerCrop().into(holder.imgThumnal);

    }

    @Override
    public int getItemCount() {
        return listPhoto.size();
    }

    class PhotoHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgThumnal;
        public PhotoHolder(View itemView) {
            super(itemView);
            this.imgThumnal = (ImageView) itemView.findViewById(R.id.img_Thumnail);
            this.txtName = (TextView) itemView.findViewById(R.id.tv_Name);

        }
    }
}
