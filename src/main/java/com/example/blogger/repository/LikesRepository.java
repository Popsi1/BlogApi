package com.example.blogger.repository;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    @Query(value = "SELECT count(id) FROM Likes where blogUser = :blogUser")
    public Long count(@Param("blogUser")BlogUser blogUser);

    @Query(value = "SELECT COUNT(*) FROM likes", nativeQuery = true)
    public Long getNum();

    @Query("select l from Likes l where l.blogUser.id = ?1")//u can convert a finder method to jp query
    Likes findLikesByBlogUserId(Long blogUserId);


}
