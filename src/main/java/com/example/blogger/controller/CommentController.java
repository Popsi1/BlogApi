package com.example.blogger.controller;

import com.example.blogger.dto.PostDto;
import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Comment;
import com.example.blogger.model.Post;
import com.example.blogger.service.BlogUserService;
import com.example.blogger.service.CommentService;
import com.example.blogger.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private PostService postService;
    private java.util.stream.Collectors Collectors;
    @Autowired
    private BlogUserService blogUserService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/register/{blogUserId}/{postId}")
    @Transactional
    public ResponseEntity<Comment> createComment(@PathVariable Long blogUserId, @PathVariable Long postId, @RequestBody Comment comment){
        Comment comment1 = commentService.save(comment);
        BlogUser blogUser = blogUserService.getUser2(blogUserId);
        Post post = postService.getPost(postId);
        post.getCommentList().add(comment1);
        comment1.setPost(post);
        blogUser.getComments().add(comment1);
        comment1.setBlogUser(blogUser);
        return new ResponseEntity<>(comment1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments(){
        List<Comment> comments = commentService.getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        Comment comment = commentService.getComment(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }


    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        String delete = commentService.deleteComment(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<Comment> editComment(@PathVariable Long id,
                                         @RequestBody Comment comment){
        Comment comment1 = commentService.editComment(id, comment);
        return new ResponseEntity<>(comment1, HttpStatus.OK);
    }

    @GetMapping(value="/blogUser/{blogUserId}")
    public List<Comment> commentsByBlogUser(@PathVariable Long blogUserId){
        return commentService.getCommentByBlogUserId(blogUserId);
    }

    @GetMapping(value="/post/{postId}")
    public List<Comment> commentsByPost(@PathVariable Long postId){
        return commentService.getCommentByPostId(postId);
    }

}
