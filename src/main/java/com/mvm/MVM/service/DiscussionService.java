package com.mvm.MVM.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvm.MVM.dto.DiscussionDto;
import com.mvm.MVM.model.Discussion;
import com.mvm.MVM.repository.DiscussionRepository;
import com.mvm.MVM.repository.ForumRepository;

@Service
public class DiscussionService {
	@Autowired
	DiscussionRepository discussionRepo;
	
	@Autowired
	ForumRepository forumRepo;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	UserService userService;
	
	public Discussion findById(Long id) {
		return discussionRepo.findById(id).get();
	}
	
	public List<Discussion> findByForumId(Long id){
		return forumRepo.findById(id).get().getDiscussions();
	}
	
	public void save(Discussion discussion) {
		discussionRepo.save(discussion);
	}
	
	public DiscussionDto model2dto(Discussion discussion) {
		if(discussion != null) {
			DiscussionDto dto = new DiscussionDto();
			dto.setUserImage(imageService.bitmap2String(imageService.findByUserId(discussion.getUser().getId()).getPath()));
			dto.setUserName(discussion.getUser().getName());
			dto.setTitle(discussion.getTitle());
			dto.setContent(discussion.getContent());
			dto.setDateTime(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss").format(discussion.getDateTime()));
			return dto;
		}
		return null;
	}
	
	public Discussion dto2model(DiscussionDto dto) {
		if(dto != null) {
			Discussion dis = new Discussion();
			dis.setContent(dto.getContent());
			dis.setDateTime(Date.from(LocalDate.parse(dto.getDateTime()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			dis.setForum(forumRepo.findById(Long.parseLong(dto.getForumId())).get());
			dis.setTitle(dto.getTitle());
			dis.setUser(userService.findByUsername(dto.getUserUsername()));
			return dis;
		}
		return null;
	}
}
