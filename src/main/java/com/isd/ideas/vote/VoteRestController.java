package com.isd.ideas.vote;

import java.sql.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/vote")
public class VoteRestController {

    @Autowired
    VoteService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Vote>> listAllUsers() {
        return ResponseEntity.ok(userService.listVote());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> getUser(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.findVoteById(id));
    }
    
    @RequestMapping(value = "/d/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> getUser(@PathVariable("date") Date date) {
        return ResponseEntity.ok(userService.findVoteByDate(date));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Vote vote)
    {
        userService.createVote(vote);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Vote> deleteRole(@PathVariable("id") long id) {
        userService.deleteVote(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
