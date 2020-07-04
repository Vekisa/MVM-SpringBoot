package com.mvm.MVM.service;

import com.google.firebase.messaging.*;

import com.mvm.MVM.cofiguration.FirebaseSDK;
import com.mvm.MVM.model.Offer;
import com.mvm.MVM.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class OfferService {

    @Autowired
    private UserService userService;

    @Autowired
    private OfferRepository offerRepository;

    public void offerSet(){

        String registrationToken = "ei5tFmXLScmI4NwrnlWAob:APA91bE9GZx6ZmisDlD13Tt9jkavgvCDsp6bRxEDYZ3l3sg5RBhpoLanOEzbyI6ZhEBKfc0KqsJ-Rd60gvMVsPzGCM5HbkAIc16lJNRuiEX7qSXKn5lQMscxN5wVy1t1oGQAx1NkUBkG";




    }

    public List<Offer> getOffers(){

        String name = userService.getCurrentUser().getName();

        String topic = userService.getCurrentUser().getCategory().getName();

        return offerRepository.getAllByCategoryName(topic);

    }


    public void postOffer(Offer offer) {
        String name = userService.getCurrentUser().getName();

        String topic = userService.getCurrentUser().getCategory().getName().trim();


        offer.setCategoryName(userService.getCurrentUser().getCategory().getName());
        offer.setUsername(name);



        String fullMessage = offer.getName()+"\n"+"Cena:"+offer.getPrice();

        FirebaseSDK.sendPush(name,fullMessage,topic);

        offerRepository.save(offer);


    }
}
