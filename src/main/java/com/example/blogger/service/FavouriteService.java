package com.example.blogger.service;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Favourite;
import com.example.blogger.model.Post;
import com.example.blogger.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {
    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private PostService postService;

    public Favourite addToFavourite(Long postId, Favourite favourite){
        Post post = postService.getPost(postId);
        if(number(postId)==0){
        favourite.setPost(post);
        Favourite favourite1 = favouriteRepository.save(favourite);
        return favourite1;
        }else
           return null;
    }

    public Long number(Long postId){
        Post post = postService.getPost(postId);
        Long num = favouriteRepository.count(post);
        return num;
    }
    public List<Favourite> getFavouritePost(){
        List<Favourite> favouritePosts = favouriteRepository.findAll();
        return favouritePosts;
    }


}
