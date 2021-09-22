package com.example.blogger.repository;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostByBlogUserId(Long id);
}
