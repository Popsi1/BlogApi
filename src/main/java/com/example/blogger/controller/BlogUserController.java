package com.example.blogger.controller;

import com.example.blogger.dto.BlogUserRegistration;
import com.example.blogger.exception.UserNotFoundException;
import com.example.blogger.model.BlogUser;
import com.example.blogger.repository.BlogUserRepository;
import com.example.blogger.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class BlogUserController {
    @Autowired
    private BlogUserService blogUserService;

    @PostMapping("/register")
    public ResponseEntity<BlogUserRegistration> createUser(@Valid @RequestBody BlogUserRegistration blogUserRegistration){
        BlogUser blogUser = blogUserService.save(BlogUser.from(blogUserRegistration));
        return new ResponseEntity<>(BlogUserRegistration.from(blogUser), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BlogUser>> getUsers(){
        List<BlogUser> blogUserList = blogUserService.getAllUsers();
        return new ResponseEntity<>(blogUserList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogUser> getUser2(@PathVariable Long id){
        BlogUser blogUser = blogUserService.getUser2(id);
        return new ResponseEntity<>(blogUser, HttpStatus.OK);
    }

    @GetMapping(value = "/username/{name}")
    public ResponseEntity<List<BlogUser>> getUser(@PathVariable String name){
        List<BlogUser> blogUserList = blogUserService.getUser(name);
        return new ResponseEntity<>(blogUserList, HttpStatus.OK);
    }
    @GetMapping("/blogUser/{name}/{password}")
    public BlogUser login(@PathVariable String name,@PathVariable String password){
        BlogUser blogUser = blogUserService.login(name, password);
        return blogUser;
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<BlogUserRegistration> editUser(@PathVariable Long id,
                                                         @RequestBody BlogUserRegistration blogUserRegistration){
        BlogUser blogUser = blogUserService.editUser(id, BlogUser.from(blogUserRegistration));
        return new ResponseEntity<>(BlogUserRegistration.from(blogUser), HttpStatus.OK);    }


//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<CartDto> deleteCart(@PathVariable final Long id){
//        Cart cart = cartService.deleteCart(id);
//        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
//    }

}
