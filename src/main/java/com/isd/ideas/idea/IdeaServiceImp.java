package com.isd.ideas.idea;


import com.isd.ideas.user_vote.UserVote;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ideaService")
public class IdeaServiceImp implements IdeaService {

    @Autowired
    IdeaRepo repo;

    @Override
    public void createIdea(Idea idea) {

        System.out.println("Creating Idea : " + idea);
        if (repo.exists(idea.getId())) {
            throw new IdeaException("Idea with id " + idea.getId() + " already exists");
        }
        repo.save(idea);

    }

    @Override
    public void updateIdea(long id, Idea idea) {
        System.out.println("Updating Idea " + idea);

        Idea currentIdea = repo.findByid(id);

        if (currentIdea == null) {
            throw new IdeaException("Idea with id " + id + " not found");
        }
        
        currentIdea.setDate(idea.getDate());
        currentIdea.setText(idea.getText());
        currentIdea.setAuthor(idea.getAuthor());
        
        repo.save(currentIdea);

    }

    @Override
    public Idea findIdeaById(long id) {
        System.out.println("Fetching Idea with id " + id);
        if (!repo.exists(id)) {
            throw new IdeaException("There is no idea with id: " + id);
        }
        return (Idea) repo.findByid(id);
    }

    
    @Override
    public List<Idea> listIdeas() {
        List<Idea> list = (List<Idea>) repo.findAll();
        if (list.isEmpty()) {
            throw new IdeaException("There are no Ideas");
        }
        return list;
    }

    @Override
    public void deleteIdea(long id) {
        System.out.println("Fetching & Deleting Idea with id " + id);
        if (!repo.exists(id)) {
            throw new IdeaException("Unable to delete. Idea with id " + id + " not found");
        }
        repo.delete(id);

    }

    @Override
    public List<Idea> findIdeaByAuthor(String author) {
       System.out.println("Fetching Ideas created by " + author);
        List<Idea> ideas = repo.findByauthor(author);
        if (ideas.isEmpty()) {
            throw new IdeaException("There are no Ideas created by " + author);
        }
        return ideas; 
    }

    @Override
    public List<Idea> findByDate(Date date) {
        System.out.println("Fetching Ideas created at" + date);
        List<Idea> ideas = repo.findBydate(date);
        if (ideas.isEmpty()) {
            throw new IdeaException("There are no Ideas created at " + date);
        }
        return ideas; 
    }
//    @Autowired
//    UserVoteRepo userVoteRepo;
//    @Override
//    public void addUserVote(long id) {
//        Idea idea = repo.findByid(id);
//        UserVote uv =  new UserVote("anon");
//        userVoteRepo.save(uv);
//        idea.getUserVotes().add(uv);
//        repo.save(idea);
//    }

    @Override
    public void addUserVote(long id, String voter) {
        Idea idea = repo.findByid(id);
        idea.getUserVotes().add(new UserVote(voter, idea));
        repo.save(idea);
    }

}
