package com.mvm.MVM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvm.MVM.dto.DiscussionDto;
import com.mvm.MVM.dto.ForumDto;
import com.mvm.MVM.service.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	ForumService forumService;
	
	@GetMapping(value = "/findByCategoryName/{name}", produces = "application/json")
	public ResponseEntity<ForumDto> findByCategoryName(@PathVariable(value = "name") String name){
		ForumDto dto = forumService.model2dto(forumService.findByCategoryName(name));
		return new ResponseEntity<ForumDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getDiscussions/{name}", produces = "application/json")
	public ResponseEntity<List<DiscussionDto>> getDiscussions(@PathVariable(value = "name") String categoryName){
		List<DiscussionDto> dtos = forumService.getDiscussions(forumService.findByCategoryName(categoryName).getId());
		return new ResponseEntity<List<DiscussionDto>>(dtos, HttpStatus.OK);
	}
}
