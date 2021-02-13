package com.app.shopwithus.presentation.ui.products;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.data.remote.ServerFetchProducts;
import com.app.shopwithus.databinding.FragmentCategoryBinding;
import com.app.shopwithus.databinding.FragmentProductsBinding;
import com.app.shopwithus.di.DepInjectionHelp;
import com.app.shopwithus.domain.ProductsMediator;
import com.app.shopwithus.domain.ProductsUseCase;
import com.app.shopwithus.presentation.ui.home.CategoryViewModel;
import com.app.shopwithus.presentation.ui.home.CategoryViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

    private List<Product> list;
    private ProductsViewModel viewModel;
    private MutableLiveData<String> mutableLiveData;
    private String argv;

    public ProductsFragment() {
        this.list = new ArrayList<>();
        mutableLiveData=new MutableLiveData<>();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        argv = getArguments().getString("Category");
        mutableLiveData.setValue(argv);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity(), new ProductViewModelFactory(DepInjectionHelp.getInstance().getProductsUseCase(), mutableLiveData)).get(ProductsViewModel.class);
        FragmentProductsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false);
        binding.setViewmodel(viewModel);
        viewModel.getArgv().setValue(argv);
        return binding.getRoot();
    }

}
