package com.example.blogger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @JoinColumn
    @OneToOne
    private BlogUser blogUser;
    @JoinColumn
    @ManyToOne
    private Post post;
    @JoinColumn
    @OneToOne
    private Comment comment;
    private String text;

}
