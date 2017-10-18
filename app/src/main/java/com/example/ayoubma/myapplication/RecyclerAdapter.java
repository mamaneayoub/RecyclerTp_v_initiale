package com.example.ayoubma.myapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract.CommonDataKinds.*;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ayoub Ma on 24/09/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PhotoHolder> {

    public List<PhotoActivity> mPhotos;

    public Context ctx;

    public RecyclerAdapter(List<PhotoActivity> photos, Context context) {
        this.mPhotos = photos;
        this.ctx = context;
    }

    @Override
    public RecyclerAdapter.PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);
        return new PhotoHolder(inflatedView, this.ctx, this.mPhotos);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PhotoHolder holder, int position) {
        PhotoActivity itemPhoto = mPhotos.get(position);
        holder.mPhoto.setBackgroundResource(itemPhoto.getResId());
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public static class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //2
        //private TextView mItemDescription;
        private ImageView mPhoto;
        public View rootView;

        //3
        private static final String PHOTO_KEY = "PHOTO";
        private static final String PHOTO_DES = "DESCRIPTION";
        Context ctx;
        List<PhotoActivity> photoActivityList;
        //4
        public PhotoHolder(View v, Context context, List<PhotoActivity> photoActivityList) {
            super(v);
            this.ctx = context;
            this.photoActivityList = photoActivityList;
            PhotoActivity photoActivity = new PhotoActivity();
            v.setOnClickListener(this);
            rootView = v;
            mPhoto = (ImageView) v.findViewById(R.id.image);
            //mItemDescription = (TextView) v.findViewById(R.id.item_description);
            v.setOnClickListener(this);
        }


        //5
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            //Toast toast =  Toast.makeText(this.ctx, "Hello toast!"+position, Toast.LENGTH_SHORT);
            //toast.show();
            PhotoActivity photoActivity = this.photoActivityList.get(position);
            Intent showPhotoIntent = new Intent(this.ctx, ItemActivity.class);
            showPhotoIntent.putExtra(PHOTO_KEY, photoActivity.getResId());
            showPhotoIntent.putExtra(PHOTO_DES, photoActivity.getDescription());
            this.ctx.startActivity(showPhotoIntent);
        }
    }
}
