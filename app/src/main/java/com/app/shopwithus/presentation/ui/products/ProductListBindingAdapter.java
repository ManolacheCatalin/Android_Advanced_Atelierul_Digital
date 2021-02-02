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

    @BindingAdapter("SetProductList")
    public static void setItems(RecyclerView recyclerView, List<Product> list){
        RecyclerView.Adapter<?> adapter=recyclerView.getAdapter();
        if(adapter==null){
            adapter=new ProductListAdapter();
            recyclerView.setAdapter(adapter);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        if(list!=null){
            ((ProductListAdapter)adapter).updateUi(list);
        }
    }
}
