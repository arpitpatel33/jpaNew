package com.example.jpaNew.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "SocialMediaPosts")
@Table(name = "social_media_posts")
public class SocialMediaPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "posted_by")
    private String postedBy;

    @Column(name = "posted_on")
    private Date postedOn;

    public SocialMediaPosts() {
    }

    public SocialMediaPosts(long id, String message, String postedBy, Date postedOn) {
        this.id = id;
        this.message = message;
        this.postedBy = postedBy;
        this.postedOn = postedOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
}
