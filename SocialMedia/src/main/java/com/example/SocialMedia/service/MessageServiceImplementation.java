package com.example.SocialMedia.service;

import com.example.SocialMedia.models.Chat;
import com.example.SocialMedia.models.Message;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.repository.ChatRepository;
import com.example.SocialMedia.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService{

    @Autowired
   private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Message createMessage(User user, Integer chatId, Message req) throws Exception {

        Chat chat=chatService.findChatById(chatId);

        Message message=new Message();

        message.setChat(chat);
        message.setContent(req.getContent());
        message.setImage(req.getImage());
        message.setUser(user);
        message.setTimestamp(LocalDateTime.now());

        Message savedMessage=messageRepository.save(message);

        chat.getMessages().add(savedMessage);
        chatRepository.save(chat);
        return savedMessage;
    }

    @Override
    public List<Message> findChatsMessages(Integer chatId) throws Exception {
        Chat chat=chatService.findChatById(chatId);
        return messageRepository.findByChatId(chatId);
    }
}
