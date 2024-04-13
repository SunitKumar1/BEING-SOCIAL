package com.example.SocialMedia.service;

import com.example.SocialMedia.models.Chat;
import com.example.SocialMedia.models.Message;
import com.example.SocialMedia.models.User;

import java.util.List;

public interface MessageService {

    public Message createMessage(User user, Integer chatId , Message req) throws Exception;

    public List<Message> findChatsMessages(Integer chatId) throws Exception;



}
