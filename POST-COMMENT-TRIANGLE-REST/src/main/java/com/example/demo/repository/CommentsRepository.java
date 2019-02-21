package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.demo.model.Comments;

@Component
public interface CommentsRepository extends JpaRepository<Comments, Long> {

	List<Comments> findByPostId(Long postId);

	@Query("select p from Comments p where p.id= :x")
	Comments findCommentById(@Param("x") Long id);
//	@Query("select c from Comments c , Posts p where c.post.id = p.id and c.id= :x")
//	Optional<Comments> findcommById(@Param("x")Long id);
	@Query("select p from Comments p where p.id= :x")
	List<Comments> findcommById(@Param("x")Long id);


}
