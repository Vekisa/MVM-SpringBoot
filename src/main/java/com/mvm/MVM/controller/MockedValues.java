package com.mvm.MVM.controller;

import com.mvm.MVM.dto.ForumDto;
import com.mvm.MVM.model.mocked.PredictedPrice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mocked")
public class MockedValues {

    @GetMapping(value = "/predicted_prices", produces = "application/json")
    public ResponseEntity<List<PredictedPrice>> prdictedPrice(){
        List<PredictedPrice> list = new ArrayList<>();
        PredictedPrice pp1 = new PredictedPrice();
        pp1.setCity("Novi Sad");
        pp1.setLongitude(45.255185);
        pp1.setLatitude(19.842735);
        pp1.setPrice(19.3);
        pp1.setCurr("din");
        pp1.setUnit("kg");
        PredictedPrice pp2 = new PredictedPrice();
        pp2.setCity("Beograd");
        pp2.setLongitude(44.820991);
        pp2.setLatitude(20.457666);
        pp2.setPrice(18.9);
        pp2.setUnit("kg");
        pp2.setCurr("din");
        PredictedPrice pp3 = new PredictedPrice();
        pp3.setCity("Nis");
        pp3.setLongitude(43.318594);
        pp3.setLatitude(21.892918);
        pp3.setPrice(18.7);
        pp3.setUnit("kg");
        pp3.setCurr("din");
        PredictedPrice pp4 = new PredictedPrice();
        pp4.setCity("Subotica");
        pp4.setLongitude(46.084594);
        pp4.setLatitude(19.660043);
        pp4.setPrice(17.7);
        pp4.setUnit("kg");
        pp4.setCurr("din");
        list.add(pp1);
        list.add(pp2);
        list.add(pp3);
        list.add(pp4);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/best_price", produces = "application/json")
    public ResponseEntity<PredictedPrice> bestPrice(){
        PredictedPrice pp = new PredictedPrice();
        pp.setCity("Kragujevac");
        pp.setLongitude(46.084594);
        pp.setLatitude(19.660043);
        pp.setPrice(18.7);
        pp.setUnit("kg");
        pp.setCurr("din");

        return new ResponseEntity<>(pp, HttpStatus.OK);
    }


}
