package com.video.streaming.videostreamingaws.repository;

import com.video.streaming.videostreamingaws.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VideoRepository extends MongoRepository<Video, String> {
}
