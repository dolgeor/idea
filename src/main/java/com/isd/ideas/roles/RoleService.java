package com.isd.ideas.roles;

import java.util.List;


interface RoleService {
    
    public void createRole(Role role);
    
    public void updateRole(long id,Role role);
         
    public void deleteRole(long id);
    
    public Role findRoleById(long id);
    
    public List<Role> listRoles();
}
