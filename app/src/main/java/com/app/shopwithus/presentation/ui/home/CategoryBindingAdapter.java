package com.app.shopwithus.presentation.ui.home;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.data.model.Category;

import java.util.List;

public class CategoryBindingAdapter {


    @BindingAdapter("SetImage")
    public static void setImage(ImageView imageView){

    }
    @BindingAdapter("SetTitle")
    public static void setTitle(TextView textView,String title){

    }
    @BindingAdapter("SetFavourite")
    public static void setFavourite(ImageButton imageButton){

    }
    @BindingAdapter("SetCategoryList")
    public static void setItems(RecyclerView recyclerView, List<Category> list){
     RecyclerView.Adapter<?> adapter=recyclerView.getAdapter();
     if(adapter==null){
       adapter=new CategoryAdapter();
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
     }
     if(list!=null){
         ((CategoryAdapter)adapter).updateUi(list);
     }
    }
}
