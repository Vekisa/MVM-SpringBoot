package com.mvm.MVM.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvm.MVM.dto.CommentDto;
import com.mvm.MVM.model.Comment;
import com.mvm.MVM.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	DiscussionService discussionService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	UserService userService;
	
	public List<Comment> findByDiscussionId(Long id){
		return discussionService.findById(id).getComments();
	}
	
	public void save(Comment comment) {
		commentRepo.save(comment);
	}
	
	public CommentDto model2dto(Comment comment) {
		if(comment != null) {
			CommentDto dto = new CommentDto();
			dto.setContent(comment.getContent());
			dto.setDateTime(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss").format(comment.getDateTime()));
			dto.setDiscussionId(comment.getDiscussion().getId().toString());
			dto.setUserImage(imageService.bitmap2String(imageService.findByUserId(comment.getUser().getId()).getPath()));
			dto.setUserName(comment.getUser().getName());
			dto.setUserUsername(comment.getUser().getUsername());
			return dto;
		}
		return null;
	}
	
	public Comment dto2model(CommentDto dto) {
		if(dto != null) {
			Comment comment = new Comment();
			comment.setContent(dto.getContent());
			comment.setDateTime(Date.from(LocalDate.parse(dto.getDateTime()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			comment.setDiscussion(discussionService.findById(Long.parseLong(dto.getDiscussionId())));
			comment.setUser(userService.findByUsername(dto.getUserUsername()));
			return comment;
		}
		return null;
	}
}
