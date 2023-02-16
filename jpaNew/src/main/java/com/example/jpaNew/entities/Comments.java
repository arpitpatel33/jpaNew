package com.example.jpaNew.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Comments")
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "commented_by")
    private String commentedBy;

    @Column(name = "comment_date")
    private Date commentDate;

    @Column(name = "posts_id")
    private Long postsId;

    public Comments() {
    }

    public Comments(Long id, String comment, String commentedBy, Date commentDate, Long postsId) {
        this.id = id;
        this.comment = comment;
        this.commentedBy = commentedBy;
        this.commentDate = commentDate;
        this.postsId= postsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getPostsId() {
        return postsId;
    }

    public void setPostsId(Long postsId) {
        this.postsId = postsId;
    }
}
