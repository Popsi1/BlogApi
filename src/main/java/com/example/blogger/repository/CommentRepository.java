package com.example.blogger.repository;

import com.example.blogger.controller.CommentController;
import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByBlogUserId(Long userId);
    List<Comment> findCommentByPostId(Long postId);
}
