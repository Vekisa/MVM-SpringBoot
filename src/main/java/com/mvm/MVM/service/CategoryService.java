package com.mvm.MVM.service;

import com.mvm.MVM.model.Category;
import com.mvm.MVM.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nema kategorije!");
        return category.get();
    }

    public void save(Category category){
        categoryRepository.save(category);
    }

    public Category findByName(String name){
        System.out.println("Ime: " + name);
        Optional<Category> category = categoryRepository.findByName(name.trim());
        if(!category.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nema kategorije!");
        return categoryRepository.findByName(name.trim()).get();
    }
}
