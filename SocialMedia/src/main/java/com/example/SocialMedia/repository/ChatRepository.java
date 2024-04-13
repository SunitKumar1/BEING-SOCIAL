package com.example.SocialMedia.repository;

import com.example.SocialMedia.models.Chat;
import com.example.SocialMedia.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

    public List<Chat>findByUsersId(Integer userid);

    @Query("select c from Chat c Where :user Member of c.users And :regUser Member of c.users")
    public Chat findChatByUsersId(@Param("user") User user,@Param("regUser")User regUser);



}
