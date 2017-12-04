package com.isd.ideas.roles;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long>{
	Role findByid(long id);  
        Role findBytype(String type);
}
