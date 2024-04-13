package com.example.SocialMedia.service;

import com.example.SocialMedia.models.Reels;
import com.example.SocialMedia.models.User;


import java.util.List;

public interface ReelsService {

    public Reels createReel(Reels reel, User user);

    public List<Reels>findAllReels();

    public List<Reels>findUsersReel(Integer userId) throws Exception;


}
