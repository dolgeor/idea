package com.isd.ideas.vote;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


interface VoteService {
    
    public void createVote(Vote vote);
    
    public void deleteVote(long id);    
    
    public Vote findVoteById(long id);
    
    public Vote findVoteByDate(Date date);
    
    public List<Vote> listVote();
}
