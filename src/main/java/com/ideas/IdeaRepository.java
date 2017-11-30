package com.ideas;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ideas.Idea;


public interface IdeaRepository extends CrudRepository<Idea, Long>{
	Idea findByid(long id);
        
}
