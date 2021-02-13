package com.app.shopwithus.presentation.ui.detail;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.data.remote.SendOrder;
import com.app.shopwithus.databinding.FragmentDetailBinding;
import com.app.shopwithus.domain.OrderMediator;
import com.app.shopwithus.domain.OrderUseCase;

public class DetailFragment  extends Fragment{
    private DetailViewModel detailViewModel;
    private FragmentDetailBinding binding;

    public DetailFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        detailViewModel= new ViewModelProvider(getActivity(),new DetailViewModelFactory(getUseCase())).get(DetailViewModel.class);
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false);
        binding.setViewmodel(detailViewModel);
        binding.setProduct(detailViewModel.getProduct());
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.quantityDetail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()!=0 && Integer.parseInt(binding.quantityDetail.getText().toString())>0){
                    detailViewModel.setQ(Integer.parseInt(binding.quantityDetail.getText().toString()));
                }
            }
        });
    }

    public OrderUseCase getUseCase(){
        OrderUseCase usecase=new OrderUseCase(new OrderMediator(new SendOrder()));
        return usecase;
    }
}
