package com.mvm.MVM.service;

import com.mvm.MVM.model.Product;
import com.mvm.MVM.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    public List<Product> getProductFromCategory(String category){

        if(category==null)
            category = userService.getCurrentUser().getCategory().getName();

        return productRepository.findAllByCategoryName(category);
    }



}
