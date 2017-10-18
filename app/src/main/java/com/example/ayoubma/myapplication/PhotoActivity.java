package com.example.ayoubma.myapplication;

/**
 * Created by Ayoub Ma on 24/09/2017.
 */

class PhotoActivity {
    //title of image
    String mTitle;
    String mDiscription;
    // Resource Id of image
    int mResId;


    public int getResId() {
        return mResId;
    }

    public void setResId(int resId) {
        mResId = resId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDiscription;
    }

    public void setDescription(String description) {
        mDiscription = description;
    }

}
