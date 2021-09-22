package com.example.blogger.service;

import com.example.blogger.exception.UserNotFoundException;
import com.example.blogger.model.BlogUser;
import com.example.blogger.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogUserService {

    @Autowired
    private BlogUserRepository blogUserRepository;

    public BlogUser save(BlogUser blogUser){
      return blogUserRepository.save(blogUser);
    }

    public List<BlogUser> getAllUsers() {
        return blogUserRepository.findAll();
    }

    public BlogUser getUser2(Long id){
        return blogUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));//exception not working

    }

    public List<BlogUser> getUser(String name){
        return blogUserRepository.findByName(name);
    }

    public BlogUser login(String name, String password){
        BlogUser blogUser = blogUserRepository.findByNameAndPassword(name, password);
        return blogUser;

    }

    @Transactional
    public BlogUser editUser(Long id, BlogUser blogUser){
        BlogUser blogUser1 = getUser2(id);
        blogUser1.setName(blogUser.getName());
        blogUser1.setEmail(blogUser.getEmail());
        blogUser1.setPassword(blogUser.getPassword());
        return blogUser1;
    }


}
