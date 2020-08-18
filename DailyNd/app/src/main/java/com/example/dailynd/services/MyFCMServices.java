package com.example.dailynd.services;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFCMServices extends FirebaseMessagingService {
    public MyFCMServices() {
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

    }
}
