package com.isd.ideas.idea;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

@Table(name = "idea",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "id")}
)
public class Idea {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "text", nullable = false)
    private String text;
    
    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "date", nullable = false)
    private Date date;

    public Idea() {
    }

    public Idea(long id, String text, String author, Date date) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   
    @Override
    public String toString() {
        return String.format("IDEA: %d%n%s%nPosted: %s%nCreated by:%s",id,text,date,author);
    }
}
