package com.app.shopwithus.presentation.ui.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.data.model.Product;
import com.bumptech.glide.Glide;

import java.util.List;

public class CategoryBindingAdapter {


    @BindingAdapter("SetImage")
    public static void setImage(ImageView imageView,Drawable drawable){
        Glide.with(imageView.getContext()).load(drawable).into(imageView);
    }

    @BindingAdapter("SetCategoryList")
    public static void setItems(RecyclerView recyclerView, List<Category> list){
     RecyclerView.Adapter<?> adapter=recyclerView.getAdapter();
     if(adapter==null){
       adapter=new CategoryAdapter();
       recyclerView.setAdapter(adapter);
       recyclerView.setNestedScrollingEnabled(false);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
     }
     if(list!=null){
         ((CategoryAdapter)adapter).updateUi(list);
    }
    }
}
