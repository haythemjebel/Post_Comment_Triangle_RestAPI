package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Posts;
import com.example.demo.model.Triangle;
import com.example.demo.repository.PostsRepository;
import com.example.demo.repository.TriangleRepository;

@SpringBootApplication
public class PostCommentTriangleRestApplication implements CommandLineRunner{

	@Autowired
	private PostsRepository postsRepository;

	@Autowired
	private TriangleRepository triangleRepository;

	public static void main(String[] args){
		SpringApplication.run(PostCommentTriangleRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		postsRepository.save(new Posts("First", "First post", new Date(), new Date()));
//		postsRepository.save(new Posts("Second", "second post", new Date(), new Date()));
//		postsRepository.save(new Posts("Third", "Third post", new Date(), new Date()));
//
//		triangleRepository.save(new Triangle(10, 10, 10));
	}

}

