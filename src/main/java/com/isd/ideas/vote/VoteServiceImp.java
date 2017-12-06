package com.isd.ideas.vote;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("VoteService")
public class VoteServiceImp implements VoteService {

    @Autowired
    VoteRepo repo;

    @Override
    public void createVote(Vote vote) {
        repo.save(vote);
    }

    @Override
    public Vote findVoteById(long id) {
        System.out.println("Fetching vote with id " + id);
        if (repo.findByid(id) == null) {
            throw new VoteException("There is no vote with id: " + id);
        }
        return repo.findByid(id);
    }
    
    @Override
    public Vote findVoteByDate(Date date) {
        System.out.println("Fetching vote with id " + date);
        if (repo.findBydate(date) == null) {
            throw new VoteException("There is no vote with id: " + date);
        }
        return repo.findBydate(date);
    }

    @Override
    public List<Vote> listVote() {
        List<Vote> list = (List<Vote>) repo.findAll();
        if (list.isEmpty()) {
            throw new VoteException("There are no votes");
        }
        return list;
    }

    @Override
    public void deleteVote(long id) {
        System.out.println("Fetching & Deleting User with id " + id);
        if (repo.findByid(id) == null) {
            throw new VoteException("Unable to delete. Vote with id " + id + " not found");
        }
        repo.delete(id);
    }

}
