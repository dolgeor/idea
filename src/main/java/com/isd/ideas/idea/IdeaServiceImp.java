package com.isd.ideas.idea;


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
        if ((Idea) repo.findByid(idea.getId()) != null) {
            throw new IllegalArgumentException();
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
        Idea currentIdea = (Idea) repo.findByid(id);
        if (currentIdea == null) {
            throw new IdeaException("There is no idea with id: " + id);
        }
        return currentIdea;
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

        Idea idea = repo.findByid(id);
        if (idea == null) {
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

}
