package com.example.dailynd.Callback;

import com.example.dailynd.Model.BestDealModel;

import java.util.List;

public interface IBestDealCallbackListener {

    void onBestDealLoadSuccess(List<BestDealModel> bestDealModels);
    void onBestDealLoadFailed(String message);

}
