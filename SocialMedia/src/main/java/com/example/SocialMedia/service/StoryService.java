package com.example.SocialMedia.service;

import com.example.SocialMedia.models.Story;
import com.example.SocialMedia.models.User;

import java.util.List;

public interface StoryService {

    public Story createStory(Story story, User user);

    public List<Story>findStoryByUserId(Integer userId) throws Exception;

}
