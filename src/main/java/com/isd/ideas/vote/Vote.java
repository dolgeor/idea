package com.isd.ideas.vote;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
    
@Entity
@Table(name = "vote_t")
public class Vote {
    
    @Column(name = "vote_id", nullable = false)
    @Id
    private long id;

    @Column(name = "date", nullable = false)
    private Date date;
    
    @Column(name = "like_dislike", nullable = false)
    private Boolean like_dislike;

    public Vote() {
    }

    public Vote(long id, Date date, Boolean like_dislike) {
        this.id = id;
        this.date = date;
        this.like_dislike = like_dislike;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getLike_dislike() {
        return like_dislike;
    }

    public void setLike_dislike(Boolean like_dislike) {
        this.like_dislike = like_dislike;
    }

    @Override
    public String toString() {
        return "Vote{" + "id=" + id + ", date=" + date + ", like_dislike=" + like_dislike + '}';
    }
    
}
