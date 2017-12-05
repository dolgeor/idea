package com.isd.ideas.idea;

import java.sql.Date;
import java.util.List;


public interface IdeaService {
    
    public void createIdea(Idea idea);
    
    public void updateIdea(long id,Idea idea);
         
    public void deleteIdea(long id);
    
    public Idea findIdeaById(long id);
    
    public List<Idea> findIdeaByAuthor(String author);
    
    public List<Idea> findByDate(Date date);
    
    public List<Idea> listIdeas();
    
    public void addUserVote(long id, String voter);
}
