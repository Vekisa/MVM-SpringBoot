package com.mvm.MVM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvm.MVM.dto.DiscussionDto;
import com.mvm.MVM.dto.ForumDto;
import com.mvm.MVM.model.Discussion;
import com.mvm.MVM.model.Forum;
import com.mvm.MVM.repository.ForumRepository;

@Service
public class ForumService {
	@Autowired
	ForumRepository forumRepo;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	DiscussionService discussionService;
	
	public Forum findByCategoryName(String name) {
		return forumRepo.findByCategoryName(name);
	}
	
	public List<DiscussionDto> getDiscussions(Long id){
		List<DiscussionDto> dtos = new ArrayList<>();
		for(Discussion dis : forumRepo.findById(id).get().getDiscussions()) {
			dtos.add(discussionService.model2dto(dis));
		}
		return dtos;
	}
	
	public ForumDto model2dto(Forum forum) {
		if(forum != null) {
			ForumDto dto = new ForumDto();
			dto.setCategoryId(forum.getCategory().getId().toString());
			dto.setId(forum.getId().toString());
			return dto;
		}
		return null;
	}
	
	public Forum dto2model(ForumDto dto) {
		if(dto != null) {
			Forum forum = new Forum();
			forum.setCategory(categoryService.findById(Long.parseLong(dto.getCategoryId())));
			forum.setId(Long.parseLong(dto.getId()));
			return forum;
		}
		return null;
	}
}
