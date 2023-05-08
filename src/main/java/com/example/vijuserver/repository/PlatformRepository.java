package com.example.vijuserver.repository;

import com.example.vijuserver.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlatformRepository extends JpaRepository<Platform, Long>, JpaSpecificationExecutor<Platform> {
}
