package com.ideas;

import java.util.List;





public interface IdeaService {
	
	Idea findById(long id);
	
	Idea findByAuthor(String author);
	
	void saveIdea(Idea idea);
        
        void updateIdea(Idea idea);
	
	void deleteIdeaById(long id);

	List<Idea> findAllIdeas(); 
	
	void deleteAllIdeas();
	
	public boolean isIdeaExist(Idea idea);
	
}
