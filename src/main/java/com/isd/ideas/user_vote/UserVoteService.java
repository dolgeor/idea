package com.isd.ideas.user_vote;

import java.util.List;


public interface UserVoteService {
    
    public void createUserVote(UserVote userVote);

    public void deleteUserVote(long id);
    
    public UserVote findUserVoteById(long id);
    
    public List<UserVote> listUserVotes();
}
