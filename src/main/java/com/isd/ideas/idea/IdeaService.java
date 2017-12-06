package com.isd.ideas.idea;

import com.isd.ideas.user_vote.UserVote;
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
    
    public List<UserVote> getUserVotesByIdeaId(long id);
    
    public UserVote getUserVoteById(long id, long user_vote_id);
    
    public void addUserVote(long id, UserVote userVote);
}
