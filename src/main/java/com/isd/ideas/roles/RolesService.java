package com.isd.ideas.roles;

import com.isd.ideas.roles.RolesRepository;
import com.isd.ideas.roles.Roles;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public class RolesService {

    @Autowired
    RolesRepository repository;

    public ResponseEntity<List<Roles>> listAllRoles() {

        List<Roles> roles = (List<Roles>) repository.findAll();
        if (roles.isEmpty()) {
            System.out.println("com.isd.ideas.roles.RolesService.listAllRoles(): roles isEmpty();");
            return new ResponseEntity<List<Roles>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println("com.isd.ideas.roles.RolesService.listAllRoles()");
        return new ResponseEntity<List<Roles>>(roles, HttpStatus.OK);
    }

    public ResponseEntity<Roles> getRole(@PathVariable("id") long id) {
        System.out.println("Fetching Role with id " + id);
        Roles role = (Roles) repository.findByid(id);
        if (role == null) {
            System.out.println("Role with id " + id + " not found");
            return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Roles>(role, HttpStatus.OK);
    }

    public ResponseEntity<Void> createRole(@RequestBody Roles role, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Role with type :" + role.getType().toUpperCase());

        repository.save(role);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/roles/{id}").buildAndExpand(role.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    public ResponseEntity<Roles> updateRole(@PathVariable("id") long id, @RequestBody Roles role) {
        System.out.println("Updating Role " + id);

        Roles currentRole = repository.findByid(id);

        if (currentRole == null) {
            System.out.println("Role with id " + id + " not found");
            return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
        }

        currentRole.setId(role.getId());
        currentRole.setType(role.getType());

        repository.save(role);

        return new ResponseEntity<Roles>(currentRole, HttpStatus.OK);
    }

    public ResponseEntity<Roles> deleteAllRoles() {
        System.out.println("Deleting All Ideas");

        repository.deleteAll();
        return new ResponseEntity<Roles>(HttpStatus.NO_CONTENT);
    }
    
    public ResponseEntity<Roles> deleteRole(@PathVariable("id") long id) {
         System.out.println("Fetching & Deleting Role with id " + id);
    
         Roles role = repository.findByid(id);
         if (role == null) {
             System.out.println("Unable to delete. Role with id " + id + " not found");
             return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
         }
    
         
         repository.delete(id);
         return new ResponseEntity<Roles>(HttpStatus.NO_CONTENT);
     }
    
    
}
