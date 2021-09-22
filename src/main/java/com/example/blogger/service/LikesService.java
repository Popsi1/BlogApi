package com.example.blogger.service;

import com.example.blogger.exception.UserNotFoundException;
import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Likes;
import com.example.blogger.model.Post;
import com.example.blogger.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LikesService {
    @Autowired
    private PostService postService;
    @Autowired
    private BlogUserService blogUserService;
    @Autowired
    private LikesRepository likesRepository;

    public Long createLike(Long postId, Long blogUserId, Likes likes) {
        Post post = postService.getPost(postId);
        BlogUser blogUser = blogUserService.getUser2(blogUserId);
        if(number(blogUser.getId())==0){
            likes.setBlogUser(blogUser);
            likes.setPost(post);
            Likes likes1 = likesRepository.save(likes);
            return num();
        }else
        {
            deleteLike(blogUser.getId());
            return num();
        }
    }

    public Long number(Long blogUserId){
        BlogUser blogUser = blogUserService.getUser2(blogUserId);
        Long num = likesRepository.count(blogUser);
        return num;
    }

    public Long num(){
        Long num1= likesRepository.getNum();
        return num1;
    }

    public List<Likes> getLikes1() {
        return likesRepository.findAll();
    }

    public Likes getLike(Long blogUserId){
        Likes likes = likesRepository.findLikesByBlogUserId(blogUserId);
        return likes;
    }
    public String deleteLike(Long blogUserId){
        Likes like = getLike(blogUserId);
        likesRepository.delete(like);
        return "this like have been deleted";
    }


//    public void deleteLike(Long likeId){
//        likesRepository.delete(likeId);
//    }


        //return likes.getBlogUsers().size(); }
    //else
//        likes.getBlogUsers().remove(blogUser);
//        return likes.getBlogUsers().size();
//    }
}
