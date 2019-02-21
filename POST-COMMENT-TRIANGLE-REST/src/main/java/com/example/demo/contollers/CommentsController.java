package com.example.demo.contollers;

import java.util.Date;
import java.util.List;
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
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.PostsRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	private CommentsRepository commentsRepository;

	@Autowired
	private PostsRepository postRepository;

	@PostMapping("/addComment/{postId}")
	public Comments createComments(@PathVariable(value = "postId") Long postId, @RequestBody @Valid Comments c) {
		Posts post = postRepository.findOne(postId);
		c.setPost(post);
		c.setCreatedDate(new Date());
		c.setModifedDate(new Date());
		commentsRepository.save(c);
		return c;
	}

	@DeleteMapping("/deleteComment/{postId}/{id}")
	public boolean deleteComment(@PathVariable(value = "postId") Long postId, @PathVariable Long id) {
		commentsRepository.deleteById(id);
		return true;
	}

	@GetMapping("/posts/{postId}/comments")
	public List<Comments> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
		return commentsRepository.findByPostId(postId);
	}

	@GetMapping("/comment/{id}")
	public List<Comments> getCommentById(@PathVariable Long id) {
		List<Comments> c = commentsRepository.findcommById(id);
		return c;
	}

	@PostMapping("/updateComment/{postId}/{commentId}")
	public Comments updateComments(@PathVariable("postId") Long postId, @PathVariable Long commentId,
			@RequestBody Comments comments) throws NotFoundException {
		if (!postRepository.existsById(postId)) {
			throw new NotFoundException("Post not found!");
		}
		Comments c = commentsRepository.findCommentById(commentId);
		c.setText(comments.getText());
		c.setModifedDate(new Date());
		commentsRepository.save(c);
		return c;

	}
}
