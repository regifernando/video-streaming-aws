package com.video.streaming.videostreamingaws.repository;

import com.video.streaming.videostreamingaws.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findBySub(String sub);
}
