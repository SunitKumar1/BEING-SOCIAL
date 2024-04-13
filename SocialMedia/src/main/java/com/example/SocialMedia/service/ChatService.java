package com.example.SocialMedia.service;

import com.example.SocialMedia.models.Chat;
import com.example.SocialMedia.models.User;

import java.util.List;

public interface ChatService {

    public Chat createChat(User regUser,User user2);

    public Chat findChatById(Integer chatId) throws Exception;

    public List<Chat>findUsersChat(Integer userId);
}
