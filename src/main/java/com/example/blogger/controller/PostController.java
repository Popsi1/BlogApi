package com.example.blogger.controller;

import com.example.blogger.dto.BlogUserRegistration;
import com.example.blogger.dto.PostDto;
import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Post;
import com.example.blogger.service.BlogUserService;
import com.example.blogger.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    private java.util.stream.Collectors Collectors;
    @Autowired
    private BlogUserService blogUserService;

    @PostMapping("/register/{id}")
    @Transactional
    public ResponseEntity<Post> createPost(@PathVariable Long id,@RequestBody PostDto postDto){
        Post post = postService.save(Post.from(postDto));
        BlogUser blogUser = blogUserService.getUser2(id);
        post.setBlogUser(blogUser);
        blogUser.getPosts().add(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts(){
        List<Post> posts = postService.getPosts();
        List<PostDto> postDtos = posts.stream().map(PostDto::from).collect(java.util.stream.Collectors.toList());
        return new ResponseEntity<>(postDtos, HttpStatus.OK);
    }


    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id){
        Post post = postService.getPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }


    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        String delete = postService.deletePost(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<Post> editPost(@PathVariable Long id,
                                                         @RequestBody PostDto postDto){
        Post post1 = postService.editPost(id, Post.from(postDto));
        return new ResponseEntity<>(post1, HttpStatus.OK);
    }

    @GetMapping(value="/users/{userId}")
    public List<Post> postsByUser(@PathVariable Long userId){
        return postService.getPostByBlogUser(userId);
    }
}
