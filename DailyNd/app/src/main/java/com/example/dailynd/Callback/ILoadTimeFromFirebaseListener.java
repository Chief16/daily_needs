package com.example.dailynd.Callback;

import com.example.dailynd.Model.OrderModel;

public interface ILoadTimeFromFirebaseListener {
    void onLoadTimeSuccess(OrderModel order, long estimateTimeInMs);
    void onLoadTimeFailed(String message);

}
