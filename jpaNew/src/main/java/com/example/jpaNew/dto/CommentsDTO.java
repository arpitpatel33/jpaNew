package com.example.jpaNew.dto;


import com.example.jpaNew.entities.Comments;
import com.example.jpaNew.entities.Like;
import com.example.jpaNew.entities.SocialMediaPosts;

import java.util.List;

public class CommentsDTO {


private SocialMediaPosts socialMediaPosts;

private List<com.example.jpaNew.entities.Like> likes;

private Comments comments;

    public List<Like> getLikes() {
        return likes;
    }
}
