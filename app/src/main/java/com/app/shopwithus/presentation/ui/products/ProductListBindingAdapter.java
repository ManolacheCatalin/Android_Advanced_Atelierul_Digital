package com.app.shopwithus.presentation.ui.products;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.presentation.ui.home.CategoryAdapter;

import java.util.List;

public class ProductListBindingAdapter {

//    @BindingAdapter("SetImageResource")
//    public static void setImageRes(ImageView imageView, Integer drawable){
//
//    }
//    @BindingAdapter("SetNameResource")
//    public static void setName(TextView textView,String res){
//
//    }
    @BindingAdapter("SetPrice")
    public static void setPrice(TextView textView,Double res){

    }
    @BindingAdapter("SetFavourite")
    public static void setFavourite(ImageView imageView,boolean res){

    }
    @BindingAdapter("SetProductList")
    public static void setItems(RecyclerView recyclerView, List<Product> list){
        RecyclerView.Adapter<?> adapter=recyclerView.getAdapter();
        if(adapter==null){
            adapter=new CategoryAdapter();
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        if(list!=null){
            ((ProductListAdapter)adapter).updateUi(list);
        }
    }
}
