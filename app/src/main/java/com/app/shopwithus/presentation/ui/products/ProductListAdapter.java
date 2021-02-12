package com.app.shopwithus.presentation.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.databinding.MainListItemBinding;
import com.app.shopwithus.presentation.ui.detail.ProductHelp;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> implements Click {

    private final List<Product> items;

    public ProductListAdapter(){
        this.items =new ArrayList<>();
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainListItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.main_list_item,parent,false);
        return new ProductListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {
        Product item=items.get(position);
        holder.bind(item);
        holder.binding.setHandler(this::click);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void updateUi(List<Product> list){
        this.items.clear();
        this.items.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public void click(View view,Product product) {
        ProductHelp.getInstance().setProduct(product);
        Navigation.findNavController(view).navigate(R.id.nav_detail);
    }

    static class ProductListViewHolder extends RecyclerView.ViewHolder{
        private final MainListItemBinding binding;

        public ProductListViewHolder(MainListItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        public void bind(Product product){
            binding.setProduct(product);
        }
    }
}
