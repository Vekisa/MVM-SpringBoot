package com.mvm.MVM.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvm.MVM.dto.CommentDto;
import com.mvm.MVM.service.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping(value = "/save", consumes = "application/json")
	public ResponseEntity save(@RequestBody CommentDto dto) throws ParseException {
		commentService.save(commentService.dto2model(dto));
		return ResponseEntity.ok().build();
	}
}
