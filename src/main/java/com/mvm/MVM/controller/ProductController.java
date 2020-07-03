package com.mvm.MVM.controller;

import com.mvm.MVM.dto.UserDto;
import com.mvm.MVM.model.Product;
import com.mvm.MVM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsFromCategory(@RequestParam(required = false) String category){
        return new ResponseEntity<>(productService.getProductFromCategory(category),HttpStatus.OK);
    }


}
