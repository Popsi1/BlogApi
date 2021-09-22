package com.example.blogger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String text;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private BlogUser blogUser;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Post post;
}
