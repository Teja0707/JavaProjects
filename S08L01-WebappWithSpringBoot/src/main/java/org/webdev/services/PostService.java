package org.webdev.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.webdev.models.Post;

@Service
public class PostService {

	static List<Post> posts = new ArrayList<Post>(

			Arrays.asList(

					new Post(1, "Cloud Native", "Book on Java Spring"), new Post(2, "Reset", "Book on Economy"),
					new Post(3, "How to influence friends", "Book on self improvement"),
					new Post(4, "G C Leong", "Book on Geography"),
					new Post(5, "Sherlock holmes", "A fiction on adventures of detective sherlock")

			));

	public List<Post> getPosts() {
		return posts;
	}

	public Post getPost(int id) {

		for (Post p : posts) {
			if (p.getPostId() == id)
				return p;
		}
		return null;
	}

	public void addPost(Post post) {
		posts.add(post);
	}

	public void updatePost(Post inputPost, int id) {
		
		for(int i=0;i<posts.size();i++) {
			Post p = posts.get(i);
			if (p.getPostId() == id) {
				posts.set(i, inputPost);
				return;
			}
		}
			
		}

	

	public void deletePost(int id) {
		for(int i=0;i<posts.size();i++) {
			Post p = posts.get(i);
			if (p.getPostId() == id) {
				posts.remove(i);
				return;
			}

	}

}}
