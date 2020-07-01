package com.mvm.MVM.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvm.MVM.dto.CommentDto;
import com.mvm.MVM.dto.DiscussionDto;
import com.mvm.MVM.model.Comment;
import com.mvm.MVM.model.Discussion;
import com.mvm.MVM.model.Image;
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
	
	@Autowired
	CommentService commentService;
	
	public Discussion findById(Long id) {
		return discussionRepo.findById(id).get();
	}
	
	public List<Discussion> findByForumId(Long id){
		return forumRepo.findById(id).get().getDiscussions();
	}
	
	public void save(Discussion discussion) {
		discussionRepo.save(discussion);
	}
	
	public List<CommentDto> getComments(Long id){
		List<CommentDto> dtos = new ArrayList<CommentDto>();
		for(Comment comment : discussionRepo.findById(id).get().getComments()) {
			dtos.add(commentService.model2dto(comment));
		}
		return dtos;
	}
	
	public DiscussionDto model2dto(Discussion discussion) {
		if(discussion != null) {
			DiscussionDto dto = new DiscussionDto();
			Image image = imageService.findByUserId(discussion.getUser().getId());
			if(image != null) {
				dto.setUserImage(imageService.bitmap2String(image.getPath()));
			}
			dto.setId(discussion.getId().toString());
			dto.setUserName(discussion.getUser().getName());
			dto.setTitle(discussion.getTitle());
			dto.setContent(discussion.getContent());
			dto.setDateTime(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(discussion.getDateTime()));
			dto.setForumId(discussion.getForum().getId().toString());
			dto.setUserUsername(discussion.getUser().getUsername());
			return dto;
		}
		return null;
	}
	
	public Discussion dto2model(DiscussionDto dto) throws ParseException {
		if(dto != null) {
			Discussion dis = new Discussion();
			dis.setContent(dto.getContent());
			dis.setDateTime((Date) new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(dto.getDateTime()));
			dis.setForum(forumRepo.findById(Long.parseLong(dto.getForumId())).get());
			dis.setTitle(dto.getTitle());
			dis.setUser(userService.findByUsername(dto.getUserUsername()));
			return dis;
		}
		return null;
	}
}
