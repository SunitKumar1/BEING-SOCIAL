package com.example.SocialMedia.repository;

import com.example.SocialMedia.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer>{

}
