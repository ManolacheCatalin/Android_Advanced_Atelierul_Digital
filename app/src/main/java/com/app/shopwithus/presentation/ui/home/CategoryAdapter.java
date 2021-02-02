package com.app.shopwithus.presentation.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.databinding.MainCategoryItemBinding;
import com.app.shopwithus.databinding.MainListItemBinding;
import com.app.shopwithus.databinding.MainListItemBindingImpl;
import com.app.shopwithus.presentation.ui.products.ProductsFragment;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> implements Click {

    private List<Category> items;
    private Category item;

    public CategoryAdapter() {
        this.items = new ArrayList<>();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainCategoryItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.main_category_item, parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        item = items.get(position);
        holder.bind(item);
        holder.binding.setHandler(this);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void updateUi(List<Category> list) {
        this.items.clear();
        this.items.addAll(list);
        this.notifyDataSetChanged();
    }


    @Override
    public void click(View view, Category category) {
        Log.d("DEBUG",category.getCategoryName());
        Bundle bundle = new Bundle();
        bundle.putString("Category", category.getCategoryName());
        Navigation.findNavController(view).navigate(R.id.nav_product, bundle);
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final MainCategoryItemBinding binding;

        public CategoryViewHolder(MainCategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Category category) {
            binding.setCategory(category);
        }
    }
}
