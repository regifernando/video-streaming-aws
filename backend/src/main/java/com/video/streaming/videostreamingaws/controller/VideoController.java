package com.video.streaming.videostreamingaws.controller;

import com.video.streaming.videostreamingaws.dto.CommentDto;
import com.video.streaming.videostreamingaws.dto.UploadVideoResponse;
import com.video.streaming.videostreamingaws.dto.VideoDto;
import com.video.streaming.videostreamingaws.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UploadVideoResponse uploadVideo(@RequestParam("file") MultipartFile file) {
        return videoService.uploadVideo(file);
    }

    @PostMapping("/thumbnail")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadThumbnail(@RequestParam("file") MultipartFile file, @RequestParam("videoId") String videoId) {
        return videoService.uploadThumbnail(file, videoId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public VideoDto editVideoMetaData(@RequestBody VideoDto videoDto){
        return videoService.editVideo(videoDto);
    }

    @GetMapping("/{videoId}")
    @ResponseStatus(HttpStatus.OK)
    public VideoDto getVideoDetails(@PathVariable String videoId) {
        return videoService.getVideoDetails(videoId);
    }

//    @PostMapping("/{videoId}/like")
//    @ResponseStatus(HttpStatus.OK)
//    public VideoDto likeVideo(@PathVariable String videoId) {
//        return videoService.likeVideo(videoId);
//    }

//    @PostMapping("/{videoId}/disLike")
//    @ResponseStatus(HttpStatus.OK)
//    public VideoDto disLikeVideo(@PathVariable String videoId) {
//        return videoService.disLikeVideo(videoId);
//    }
//
//    @PostMapping("/{videoId}/comment")
//    @ResponseStatus(HttpStatus.OK)
//    public void addComment(@PathVariable String videoId, @RequestBody CommentDto commentDto) {
//        videoService.addComment(videoId, commentDto);
//    }
//
//    @GetMapping("/{videoId}/comment")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CommentDto> getAllComments(@PathVariable String videoId) {
//        return videoService.getAllComments(videoId);
//    }
//
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VideoDto> getAllVideos() {
        return videoService.getAllVideos();
    }

}