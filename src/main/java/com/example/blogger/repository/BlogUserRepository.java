package com.example.blogger.repository;

import com.example.blogger.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {
    List<BlogUser> findByName(String name);
    BlogUser findByNameAndPassword(String name, String password);


}
