package com.example.SocialMedia.service;

import com.example.SocialMedia.models.Chat;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImplementation implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat createChat(User regUser, User user2) {
        Chat isExist=chatRepository.findChatByUsersId(user2,regUser);

        if(isExist!=null){
            return isExist;
        }

        Chat chat=new Chat();
        chat.getUsers().add(user2);
        chat.getUsers().add(regUser);

        chat.setTimestamp(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    @Override
    public Chat findChatById(Integer chatId) throws Exception {
      Optional<Chat>opt =chatRepository.findById(chatId);

      if(opt.isEmpty()){
          throw new Exception("chat does not exist with id--"+chatId);
      }

      return opt.get();

    }

    @Override
    public List<Chat> findUsersChat(Integer userId) {
        return chatRepository.findByUsersId(userId);
    }
}
