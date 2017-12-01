package com.isd.ideas.roles;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.isd.ideas.roles.RolesService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RolesRestController {
    
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ResponseEntity<List<Roles>> listAllRoles() {
        return new RolesService().listAllRoles();
    }
    
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Roles> getRole(@PathVariable("id") long id) {
        return new RolesService().getRole(id);
    }
    
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public ResponseEntity<Void> createRole(@RequestBody Roles role, UriComponentsBuilder ucBuilder) {
        return new RolesService().createRole(role, ucBuilder);
    }
    
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Roles> updateIdea(@PathVariable("id") long id, @RequestBody Roles idea) {
        return new RolesService().updateRole(id, idea);
    }
    
    @RequestMapping(value = "/roles", method = RequestMethod.DELETE)
    public ResponseEntity<Roles> deleteAllRoles() {
        return new RolesService().deleteAllRoles();
    }
    
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Roles> deleteRole(@PathVariable("id") long id) {
        return new RolesService().deleteRole(id);
    }
}
