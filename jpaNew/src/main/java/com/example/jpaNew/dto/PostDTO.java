package com.example.jpaNew.dto;

import com.example.jpaNew.entities.Comments;
import com.example.jpaNew.entities.Like;
import com.example.jpaNew.entities.SocialMediaPosts;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostDTO {

    private SocialMediaPosts socialMediaPosts;

    @Autowired

    private CommentsDTO commentsDTO;

    private List<com.example.jpaNew.entities.Like> likes;



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

    public void getLikes(Like likes){


    }
}


