package com.mvm.MVM.repository;

import com.mvm.MVM.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    
}
