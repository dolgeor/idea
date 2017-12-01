package com.isd.ideas.roles;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Гриша
 */
public interface RolesRepository extends CrudRepository<Roles, Long>{
	Roles findByid(long id);
        
}
