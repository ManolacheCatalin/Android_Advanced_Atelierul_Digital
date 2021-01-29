package com.app.shopwithus.presentation.ui.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.databinding.MainListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>{

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
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void updateUi(List<Product> list){
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
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
