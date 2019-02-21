package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.demo.model.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

	@Query("select p from Posts p where p.id= :x")
	public Posts findOne(@Param("x") Long postId);
}
