package com.mvm.MVM.service;

import com.mvm.MVM.model.Discussion;
import com.mvm.MVM.repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;


    public List<Discussion> getAll(){
        return discussionRepository.findAll();
    }



}
