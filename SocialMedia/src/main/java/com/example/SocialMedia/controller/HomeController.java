package com.example.SocialMedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
@GetMapping
public String homeController(){
    return "YOu are in the Home Controller";
}
@GetMapping("/home")
public String homeController2(){
    return "YOu are in the Home Controller 2";
}



}
