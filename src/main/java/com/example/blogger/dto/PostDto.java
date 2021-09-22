package com.example.blogger.dto;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String text;
    private Date dateCreated;

    public static PostDto from(Post post){
        PostDto postDto1 = new PostDto();
        postDto1.setId(post.getId());
        postDto1.setText(post.getText());
        return postDto1;
    }

}
