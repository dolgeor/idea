package com.ideas;


import org.springframework.data.repository.CrudRepository;



public interface IdeaRepository extends CrudRepository<Idea, Long>{
	Idea findByid(long id);
        
}
