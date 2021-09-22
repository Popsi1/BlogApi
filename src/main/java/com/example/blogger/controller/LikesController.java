package com.example.blogger.controller;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Likes;
import com.example.blogger.model.Post;
import com.example.blogger.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;
    @PostMapping("/post/{postId}/blogUser/{blogUserId}")
    public ResponseEntity<Long> createLikes(@PathVariable Long postId, @PathVariable Long blogUserId, @RequestBody Likes likes){
        Long numberOfLikes = likesService.createLike(postId, blogUserId, likes);
        return new ResponseEntity<>(numberOfLikes, HttpStatus.OK);
    }
    @GetMapping("/likes")
    public List<Likes> getLikes(){
        List<Likes> likes = likesService.getLikes1();
        return likes;
    }

    @GetMapping("/like/{blogUserId}")
    public Likes getLike(@PathVariable Long blogUserId){
        Likes likes = likesService.getLike(blogUserId);
        return likes;
    }

    @DeleteMapping("like/{blogUserId}")
    public String deleteLike(@PathVariable Long blogUserId){
        String str = likesService.deleteLike(blogUserId);
        return str;
    }

    @GetMapping("/{id}")
    public Long count(@PathVariable Long id){
        Long num=likesService.number(id);
        return num;
    }
    @GetMapping
    public Long count(){
        Long num=likesService.num();
        return num;
    }
}
