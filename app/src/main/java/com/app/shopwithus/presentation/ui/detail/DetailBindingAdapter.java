package com.app.shopwithus.presentation.ui.detail;

import android.net.Uri;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class DetailBindingAdapter {

    @BindingAdapter("SetImage")
    public static void setProductImage(ImageView view,String res){
        Uri uri=Uri.parse(res);
        Glide.with(view).load(uri).into(view);
    }

}
