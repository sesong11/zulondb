package com.example.zumlondb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zumlondb.model.ZulView;

@Repository
public interface ZulViewRepository extends JpaRepository<ZulView, Integer> {
	Optional<ZulView> findByPath(String slug);
}
