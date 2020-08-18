package com.example.dailyndserver.callback;

import com.example.dailyndserver.model.CategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {

    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryLoadFailed(String message);

}
