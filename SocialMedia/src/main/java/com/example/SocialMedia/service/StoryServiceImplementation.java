package com.example.SocialMedia.service;

import com.example.SocialMedia.models.Story;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoryServiceImplementation implements StoryService{

    @Autowired
    private UserService userService;

    @Autowired
    private StoryRepository storyRepository;
    @Override
    public Story createStory(Story story, User user) {

        Story createdStory=new Story();

        createdStory.setCaptions(story.getCaptions());
        createdStory.setImage(story.getImage());
         createdStory.setUser(user);
         createdStory.setTimestamp(LocalDateTime.now());

        return storyRepository.save(createdStory);
    }

    @Override
    public List<Story> findStoryByUserId(Integer userId) throws Exception {
        User user=userService.findUserById(userId);

        return storyRepository.findByUserId(userId);
    }
}
