package com.example.blogger.dto;

import com.example.blogger.model.BlogUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogUserRegistration {
    private Long id;
    private String name;
    private String email;
    private String password;

    public static BlogUserRegistration from(BlogUser blogUser){
        BlogUserRegistration blogUserRegistration = new BlogUserRegistration();
        blogUserRegistration.setId(blogUser.getId());
        blogUserRegistration.setName(blogUser.getName());
        blogUserRegistration.setEmail(blogUser.getEmail());
        blogUserRegistration.setPassword(blogUser.getPassword());
        return blogUserRegistration;
    }


}
