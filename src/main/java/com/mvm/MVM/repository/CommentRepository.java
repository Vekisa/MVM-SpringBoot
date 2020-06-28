package com.mvm.MVM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvm.MVM.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
