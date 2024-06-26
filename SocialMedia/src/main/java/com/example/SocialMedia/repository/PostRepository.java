package com.example.SocialMedia.repository;

import com.example.SocialMedia.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("select p from Post p where p.user.id = :userId")
    List<Post> findPostByUserId(@Param("userId") Integer userId);

}
