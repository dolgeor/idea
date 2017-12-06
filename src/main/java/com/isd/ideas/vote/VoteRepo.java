package com.isd.ideas.vote;

import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepo extends CrudRepository<Vote, Long>{
	Vote findByid(long id);  
     
        Vote findBydate(Date date);
}
