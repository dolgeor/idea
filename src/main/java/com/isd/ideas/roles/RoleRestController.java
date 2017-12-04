package com.isd.ideas.roles;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.isd.ideas.roles.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/role")
public class RoleRestController {

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Role>> listAllRoles() {
        return ResponseEntity.ok(roleService.listRoles());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") long id) {
        return ResponseEntity.ok(roleService.findRoleById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createRole(@RequestBody Role role)//, UriComponentsBuilder ucBuilder)
    {
        roleService.createRole(role);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestBody Role role) {
        roleService.updateRole(id, role);
        return ResponseEntity.ok(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Role> deleteRole(@PathVariable("id") long id) {
        roleService.deleteRole(id);
       return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
    }
}
