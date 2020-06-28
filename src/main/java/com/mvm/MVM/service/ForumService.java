package com.mvm.MVM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvm.MVM.model.Forum;
import com.mvm.MVM.repository.ForumRepository;

@Service
public class ForumService {
	@Autowired
	ForumRepository forumRepo;
	
	public Forum findByCategoryName(String name) {
		return forumRepo.findByCategoryName(name);
	}
}
