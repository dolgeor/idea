package com.isd.ideas.user_vote;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userVoteService")
public class UserVoteServiceImp implements UserVoteService {

    @Autowired
    UserVoteRepo repo;

    @Override
    public void createUserVote(UserVote userVote) {

        System.out.println("Creating UserVote : " + userVote);
        if (repo.exists(userVote.getId())) {
            throw new UserVoteException("UserVote with id " + userVote.getId() + " already exists");
        }
        repo.save(userVote);

    }

    @Override
    public UserVote findUserVoteById(long id) {
        System.out.println("Fetching UserVote with id " + id);
        if (!repo.exists(id)) {
            throw new UserVoteException("There is no UserVote with id: " + id);
        }
        return (UserVote) repo.findByid(id);
    }

    @Override
    public List<UserVote> listUserVotes() {
        List<UserVote> list = (List<UserVote>) repo.findAll();
        if (list.isEmpty()) {
            throw new UserVoteException("There are no Ideas");
        }
        return list;
    }

    @Override
    public void deleteUserVote(long id) {
        System.out.println("Fetching & Deleting UserVote with id " + id);
        if (!repo.exists(id)) {
            throw new UserVoteException("Unable to delete. UserVote with id " + id + " not found");
        }
        repo.delete(id);

    }

}
