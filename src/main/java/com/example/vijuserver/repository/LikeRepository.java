package com.example.vijuserver.repository;

import com.example.vijuserver.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LikeRepository extends JpaRepository<Like, Long>, JpaSpecificationExecutor<Like> {
}
