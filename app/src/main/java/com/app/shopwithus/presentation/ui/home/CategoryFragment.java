package com.app.shopwithus.presentation.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.databinding.FragmentCategoryBinding;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private List<Category> list;
    public CategoryFragment(){
     this.list=new ArrayList<>();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel= new ViewModelProvider(getActivity(),new CategoryViewModelFactory(getActivity().getBaseContext())).get(CategoryViewModel.class);
        FragmentCategoryBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_category,container,false);
        binding.setCategoryViewModel(categoryViewModel);
        return binding.getRoot();
    }
}