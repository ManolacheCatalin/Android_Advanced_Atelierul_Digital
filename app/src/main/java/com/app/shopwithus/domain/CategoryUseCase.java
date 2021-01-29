package com.app.shopwithus.domain;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

import androidx.core.content.res.ResourcesCompat;

import com.app.shopwithus.R;
import com.app.shopwithus.data.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class CategoryUseCase {

    private String[] names={"Laptopuri","Telefoane","Camere foto","Tv&Audio","Ingrijire personala","Curatenie"};
    private Integer[] drawables={R.drawable.laptop_list,R.drawable.smartphone_list,R.drawable.camera_list,R.drawable.tv_list,
    R.drawable.personala_care_list,R.drawable.curatenie_list};
    private List<Category> list;
    private Context context;
    public CategoryUseCase(Context context){
     this.list=new ArrayList<>();
     this.context=context;
    }

    public List<Category> getItems(){
     Resources res=context.getResources();
     Drawable temp;
     for(int i=0;i<names.length;i++){
      temp=ResourcesCompat.getDrawable(res,drawables[i],null);
      list.add(new Category(names[i],temp));
     }
     return list;
    }

}
