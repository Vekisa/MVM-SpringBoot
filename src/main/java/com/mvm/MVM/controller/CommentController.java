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
	
	@GetMapping(value = "/getImages/{id}")
	public ResponseEntity<List<String>> getImages(@PathVariable(value = "id") String id){
		List<String> contents = commentService.getImages(Long.parseLong(id));
		return new ResponseEntity<List<String>>(contents, HttpStatus.OK);
	}
}
