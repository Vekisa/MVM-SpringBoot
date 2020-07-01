package com.mvm.MVM.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvm.MVM.dto.CommentDto;
import com.mvm.MVM.model.Comment;
import com.mvm.MVM.model.Image;
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
	
	public Comment findById(Long id) {
		return commentRepo.findById(id).get();
	}
	
	public List<Comment> findByDiscussionId(Long id){
		return discussionService.findById(id).getComments();
	}
	
	public void save(Comment comment) {
		commentRepo.save(comment);
	}
	
	public List<String> getImages(Long id){
		List<String> contents = new ArrayList<String>();
		for(Image image : commentRepo.findById(id).get().getImages()) {
			contents.add(imageService.bitmap2String(image.getPath()));
		}
		return contents;
	}
	
	public CommentDto model2dto(Comment comment) {
		if(comment != null) {
			CommentDto dto = new CommentDto();
			dto.setId(comment.getId().toString());
			dto.setContent(comment.getContent());
			dto.setDateTime(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(comment.getDateTime()));
			dto.setDiscussionId(comment.getDiscussion().getId().toString());
			Image image = imageService.findByUserId(comment.getUser().getId());
			if(image != null) {
				dto.setUserImage(imageService.bitmap2String(image.getPath()));
			}
			dto.setUserName(comment.getUser().getName());
			dto.setUserUsername(comment.getUser().getUsername());
			return dto;
		}
		return null;
	}
	
	public Comment dto2model(CommentDto dto) throws ParseException {
		if(dto != null) {
			Comment comment = new Comment();
			comment.setContent(dto.getContent());
			comment.setDateTime((Date) new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(dto.getDateTime()));
			comment.setDiscussion(discussionService.findById(Long.parseLong(dto.getDiscussionId())));
			comment.setUser(userService.findByUsername(dto.getUserUsername()));
			return comment;
		}
		return null;
	}
}
