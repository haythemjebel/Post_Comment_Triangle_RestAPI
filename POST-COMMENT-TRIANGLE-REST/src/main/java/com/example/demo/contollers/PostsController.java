package com.example.demo.contollers;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comments;
import com.example.demo.model.Posts;
import com.example.demo.repository.PostsRepository;

@RestController
@RequestMapping("/posts")
public class PostsController {

	@Autowired
	private PostsRepository postsRepository;

	@PostMapping(value = "/addPosts")
	public Posts addPost(@Valid @RequestBody Posts p) {
		p.setCreatedAt(new Date());
		p.setModifedAt(new Date());
		postsRepository.save(p);
		return p;
	}

	@PostMapping("/updatePost/{id}")
	public Posts updatePost(@PathVariable("id") Long id, @RequestBody Posts post) {
		Posts p = postsRepository.findOne(id);
		p.setDescription(post.getDescription());
		p.setTitle(post.getTitle());
		p.setModifedAt(new Date());
		postsRepository.save(p);
		return p;

	}

	@GetMapping(value = "/all")
	public List<Posts> getAllPosts() {
		return postsRepository.findAll();
	}

	@GetMapping(value = "/posts/{id}")
	public Optional<Posts> getPostById(@PathVariable Long id) {
		Optional<Posts> p = postsRepository.findById(id);
		return p;
	}

	@DeleteMapping(value = "/deletePost/{id}")
	public boolean deletePost(@PathVariable Long id) {
		postsRepository.deleteById(id);
		return true;
	}

}
