package com.ideas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ideaService")
@Transactional
public class IdeaServiceImpl implements IdeaService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Idea> ideas;

    static {
        ideas = populateDummyIdeas();
    }

    public List<Idea> findAllIdeas() {
        return ideas;
    }

    public Idea findById(long id) {
        for (Idea idea : ideas) {
            if (idea.getId() == id) {
                return idea;
            }
        }
        return null;
    }

    public Idea findByAuthor(String name) {
        for (Idea idea : ideas) {
            if (idea.getAuthor().equalsIgnoreCase(name)) {
                return idea;
            }
        }
        return null;
    }

    @Override
    public void saveIdea(Idea idea) {
        idea.setId(counter.incrementAndGet());
        ideas.add(idea);
    }

    @Override
    public void updateIdea(Idea idea) {
        int index = ideas.indexOf(idea);
        ideas.set(index, idea);
    }

    public void deleteIdeaById(long id) {

        for (Iterator<Idea> iterator = ideas.iterator(); iterator.hasNext();) {
            Idea idea = iterator.next();
            if (idea.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isIdeaExist(Idea idea) {
       
        return findByAuthor(idea.getAuthor()) != null;
    }

    private static List<Idea> populateDummyIdeas() {
        List<Idea> ideas = new ArrayList<Idea>();
        ideas.add(new Idea(counter.incrementAndGet(),"text1", "vasea" ));
        ideas.add(new Idea(counter.incrementAndGet(),"text2", "petea" ));
        ideas.add(new Idea(counter.incrementAndGet(),"text3", "kolea" ));
        return ideas;
    }
    
    @Override
    public void deleteAllIdeas() {
        ideas.clear();
    }

}
