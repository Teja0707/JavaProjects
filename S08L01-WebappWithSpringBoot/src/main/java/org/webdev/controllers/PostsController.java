package org.webdev.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.webdev.models.Post;
import org.webdev.services.PostService;

@RestController
public class PostsController {
	
	@RequestMapping("/posts")
	public List<Post> getPosts(){
		return new PostService().getPosts();
	}
	
	@RequestMapping("/posts/{id}")
	public Post getPost(@PathVariable int id) {
		return new PostService().getPost(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/posts")
	public void addPost(@RequestBody Post inputPost) {
		new PostService().addPost(inputPost);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
	public void updatePost(@RequestBody Post inputPost,@PathVariable int id ) {
		new PostService().updatePost(inputPost,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
	public void deletePost(@PathVariable int id ) {
		new PostService().deletePost(id);
	}

}
