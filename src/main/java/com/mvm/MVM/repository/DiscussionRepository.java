package com.mvm.MVM.repository;

import com.mvm.MVM.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
}
