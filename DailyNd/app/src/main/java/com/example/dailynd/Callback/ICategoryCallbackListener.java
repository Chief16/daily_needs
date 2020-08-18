package com.example.dailynd.Callback;

import com.example.dailynd.Model.CategoryModel;
import com.example.dailynd.Model.PopularCategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {

    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryLoadFailed(String message);

}
