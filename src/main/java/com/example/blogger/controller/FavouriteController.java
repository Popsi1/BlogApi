package com.example.blogger.controller;

import com.example.blogger.model.Favourite;
import com.example.blogger.model.Post;
import com.example.blogger.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favours")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping("/{postId}")
    public Favourite addPost(@PathVariable Long postId, @RequestBody Favourite favourite){
        Favourite favourite1 = favouriteService.addToFavourite(postId, favourite);
        return favourite1;
    }

    @GetMapping("/{id}")
    public Long count(@PathVariable Long id){
        Long num=favouriteService.number(id);
        return num;
    }
}
