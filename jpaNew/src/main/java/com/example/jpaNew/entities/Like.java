package com.example.jpaNew.entities;

import antlr.collections.impl.LList;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Like")
@Table(name = "like")

public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "liked_by")
    private String likedBy;

    @Column(name = "liked_date")
    private Date likedDate;

    @Column(name = "source")
    private String source;

    @Column(name = "source_id")
    private Long sourceId;

    public Like() {
    }

    public Like(Long id, String likedBy, Date likedDate, String source, Long sourceId) {
        this.id = id;
        this.likedBy = likedBy;
        this.likedDate = likedDate;
        this.source = source;
        this.sourceId = sourceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(String likedBy) {
        this.likedBy = likedBy;
    }

    public Date getLikedDate() {
        return likedDate;
    }

    public void setLikedDate(Date likedDate) {
        this.likedDate = likedDate;
    }

    public String getPostsId() {
        return source;
    }

    public void setPostsId(String source) {
        this.source = source;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }
}
