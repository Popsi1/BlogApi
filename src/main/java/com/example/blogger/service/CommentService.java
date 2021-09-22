package com.example.blogger.service;

import com.example.blogger.exception.PostNotFoundException;
import com.example.blogger.model.Comment;
import com.example.blogger.model.Post;
import com.example.blogger.repository.CommentRepository;
import com.example.blogger.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    private CommentRepository commentRepository;

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    public String deleteComment(Long id){
        Comment comment = getComment(id);
        commentRepository.delete(comment);
        return "this comment have been deleted";
    }

    @Transactional
    public Comment editComment(Long id, Comment comment){
        Comment comment1 = getComment(id);
        comment1.setText(comment.getText());
        return comment1;
    }

    public List<Comment> getCommentByPostId(Long postId){
        List<Comment> comments = commentRepository.findCommentByPostId(postId);
        return comments;
    }

    public List<Comment> getCommentByBlogUserId(Long blogUserId){
        List<Comment> comments = commentRepository.findCommentByBlogUserId(blogUserId);
        return comments;
    }
}
