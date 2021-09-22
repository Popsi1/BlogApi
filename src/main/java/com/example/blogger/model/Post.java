package com.example.blogger.model;

import com.example.blogger.dto.BlogUserRegistration;
import com.example.blogger.dto.PostDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @UpdateTimestamp
    private Date dateCreated;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private BlogUser blogUser;
    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    public static Post from(PostDto postDto){
        Post post = new Post();
        post.setText(postDto.getText());
        post.setDateCreated(post.getDateCreated());
        return post;
    }
}
