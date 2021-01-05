package org.webdev.repository;

import org.springframework.data.repository.CrudRepository;
import org.webdev.models.Post;

public interface PostsRepository extends CrudRepository<Post, Integer> {

}
