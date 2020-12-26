package com.app.shopwithus.presentation.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.databinding.MainCategoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private final List<Category> list;

    public CategoryAdapter() {
        this.list =new ArrayList<>();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainCategoryItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.main_category_item,parent,false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
     Category item=list.get(position);
     holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void updateUi(List<Category> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder{
        private final MainCategoryItemBinding binding;

        public CategoryViewHolder(MainCategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        public void bind(Category model){
          binding.setModel(model);
        }
    }
}
