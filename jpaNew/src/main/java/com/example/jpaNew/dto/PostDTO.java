package com.example.jpaNew.dto;

import com.example.jpaNew.entities.Comments;
import com.example.jpaNew.entities.SocialMediaPosts;

import java.util.List;

public class PostDTO {

    private SocialMediaPosts socialMediaPosts;

    private List<com.example.jpaNew.entities.Comments> comments;

    public SocialMediaPosts getSocialMediaPosts() {
        return socialMediaPosts;
    }

    public void setSocialMediaPosts(SocialMediaPosts socialMediaPosts) {
        this.socialMediaPosts = socialMediaPosts;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        comments = comments;
    }
}


