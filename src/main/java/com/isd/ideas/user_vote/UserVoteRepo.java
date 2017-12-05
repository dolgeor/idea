package com.isd.ideas.user_vote;

import com.isd.ideas.idea.Idea;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserVoteRepo extends CrudRepository<UserVote, Long>{
	UserVote findByid(long id);  
        List<UserVote> findByidea(Idea idea);
}
