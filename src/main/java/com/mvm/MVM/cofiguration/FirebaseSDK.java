package com.mvm.MVM.cofiguration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import com.mvm.MVM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@Configuration
public class FirebaseSDK {

    @PostConstruct
    public void initFCM(){

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("C://Users//Milica//Downloads//androidradnik-firebase-adminsdk-nu5dk-93c537f39d.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://androidradnik.firebaseio.com")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirebaseApp.initializeApp(options);

        System.out.println(FirebaseApp.getInstance());


    }

    public static void sendPush(String title,String messageToSend,String topic){

        AndroidNotification androidNofi = AndroidNotification.builder()
                .setSound("default")
                .build();

        System.out.println(topic);

        Notification notification = Notification.builder().setTitle(title).setBody(messageToSend).build();

        Message message = Message.builder()
                .setNotification(notification)
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000)
                        .setNotification(androidNofi)
                        .build())
                .setTopic(topic)
                .build();



        String response = null;
        try {
            response = FirebaseMessaging.getInstance().sendAsync(message).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully sent message: " + response);


    }




}
