package com.example.dailynd.Remote;

import com.example.dailynd.Model.FCMResponse;
import com.example.dailynd.Model.FCMSendData;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({

            "Content-Type:application/json",
            "Authorization:key=AAAA3VoD-W0:APA91bGI0IFapCyeMr2VMjtFPJPUP0TXY8_FWesNhaEu7FXOT0PodBH0rFovA2DE55QR1Iw4FxxQ34j0oZKqQHC1V8CnNPwGBw8TTEwIrTNzqwN5gG055y2jNoBgGuV7Y_uUfjTaUqvF"


    })
    @POST("fom/send")
    Observable<FCMResponse> sendNotification(@Body FCMSendData body);

}
