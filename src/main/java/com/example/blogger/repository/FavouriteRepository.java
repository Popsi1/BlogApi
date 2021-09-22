package com.example.blogger.repository;

import com.example.blogger.model.BlogUser;
import com.example.blogger.model.Favourite;
import com.example.blogger.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    @Query(value = "SELECT count(id) FROM Favourite where post = :post")
    public Long count(@Param("post") Post post);
}
