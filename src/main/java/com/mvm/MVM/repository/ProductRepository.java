package com.mvm.MVM.repository;


import com.mvm.MVM.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryName(String categoryName);
}
