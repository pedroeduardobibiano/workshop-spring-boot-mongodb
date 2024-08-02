package com.educandoweb.workshopmongo.repository;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
