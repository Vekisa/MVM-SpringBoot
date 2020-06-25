package com.mvm.MVM.repository;

import com.mvm.MVM.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
	public Image findByUserId(Long id);
	public Image findByCategoryId(Long id);
}
