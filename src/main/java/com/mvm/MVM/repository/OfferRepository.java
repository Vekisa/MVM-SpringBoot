package com.mvm.MVM.repository;

import com.mvm.MVM.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer,Long> {

    List<Offer> getAllByCategoryName(String categoryName);

}
