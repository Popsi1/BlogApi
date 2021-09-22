package com.example.blogger.model;

import com.example.blogger.dto.BlogUserRegistration;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "blogUser")
public class BlogUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "blogUser", cascade = CascadeType.ALL)
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "blogUser", cascade = CascadeType.ALL)
    private List<Comment> comments;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "blogUser")
    private Set<Connection> blogUser =new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userConnected")
    private Set<Connection> userConnected =new HashSet<>();


    public static BlogUser from(BlogUserRegistration blogUserRegistration){
        BlogUser blogUser = new BlogUser();
        blogUser.setName(blogUserRegistration.getName());
        blogUser.setEmail(blogUserRegistration.getEmail());
        blogUser.setPassword(blogUserRegistration.getPassword());
        return blogUser;
    }


}
