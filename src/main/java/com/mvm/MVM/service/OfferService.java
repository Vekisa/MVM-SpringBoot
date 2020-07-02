package com.mvm.MVM.service;

import com.google.firebase.messaging.*;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

@Service
public class OfferService {

    public void offerSet(){

        String registrationToken = "ei5tFmXLScmI4NwrnlWAob:APA91bE9GZx6ZmisDlD13Tt9jkavgvCDsp6bRxEDYZ3l3sg5RBhpoLanOEzbyI6ZhEBKfc0KqsJ-Rd60gvMVsPzGCM5HbkAIc16lJNRuiEX7qSXKn5lQMscxN5wVy1t1oGQAx1NkUBkG";

        AndroidNotification androidNofi = AndroidNotification.builder()
                .setSound("default")
                .build();

        Notification notification = Notification.builder().setTitle("Mile").setBody("Mile").build();

        Message message = Message.builder()
                .setNotification(notification)
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000)
                        .setNotification(androidNofi)
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setBadge(42)
                                .build())
                        .build())
                .setToken(registrationToken)
                .build();



// Send a message to the device corresponding to the provided
// registration token.

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().sendAsync(message).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


// Response is a message ID string.
        System.out.println("Successfully sent message: " + response);


    }


}
