package com.mvm.MVM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvm.MVM.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Long>{
	public Forum findByCategoryName(String name);
}
