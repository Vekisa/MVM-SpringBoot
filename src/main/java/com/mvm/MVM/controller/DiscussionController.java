package com.mvm.MVM.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvm.MVM.dto.CommentDto;
import com.mvm.MVM.dto.DiscussionDto;
import com.mvm.MVM.service.DiscussionService;

@RestController
@RequestMapping(value = "/discussion")
public class DiscussionController {
	@Autowired
	DiscussionService discussionService;
	
	@PostMapping(value = "/save", consumes = "application/json")
	public ResponseEntity save(@RequestBody DiscussionDto dto) {
		try {
			discussionService.save(discussionService.dto2model(dto));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/getComments/{id}", produces = "application/json")
	public ResponseEntity<List<CommentDto>> getComments(@PathVariable(value = "id") String discussionId){
		return new ResponseEntity<List<CommentDto>>(discussionService.getComments(Long.parseLong(discussionId)), HttpStatus.OK);
	}
}
