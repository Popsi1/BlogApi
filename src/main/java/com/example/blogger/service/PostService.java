package com.example.blogger.service;

import com.example.blogger.exception.PostNotFoundException;
import com.example.blogger.exception.UserNotFoundException;
import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Post;
import com.example.blogger.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    public String deletePost(Long id){
        Post post = getPost(id);
        postRepository.delete(post);
        return "this post have been deleted";
    }

    @Transactional
    public Post editPost(Long id, Post post){
        Post post1 = getPost(id);
        post1.setText(post.getText());
        return post1;
    }

    public List<Post> getPostByBlogUser(Long userId){
        List<Post> posts = postRepository.findPostByBlogUserId(userId);
        return posts;
    }
}
