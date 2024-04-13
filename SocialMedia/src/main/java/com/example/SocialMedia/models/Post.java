package com.example.SocialMedia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String caption;
    private String image;

    private String video;

    @ManyToOne
    private User user;

    @OneToMany
    private List<User> liked=new ArrayList<>();

    private LocalDateTime createdAt;

    @OneToMany
    private List<Comment>comments=new ArrayList<>();


}
