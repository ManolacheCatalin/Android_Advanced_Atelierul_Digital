package com.app.shopwithus.presentation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Category;
import com.app.shopwithus.databinding.FragmentHomeBinding;

import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
//    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<Category> list=new ArrayList<>();
    public CategoryFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel= new ViewModelProvider(getActivity(),new CategoryViewModelFactory()).get(CategoryViewModel.class);
        FragmentHomeBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        binding.setCategoryViewModel(categoryViewModel);
        adapter=new CategoryAdapter();
        adapter.updateUi(list);
        return binding.getRoot();
    }
}