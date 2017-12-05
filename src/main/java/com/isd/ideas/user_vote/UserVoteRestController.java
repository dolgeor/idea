package com.isd.ideas.user_vote;

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
@RequestMapping(value = "/user_vote")
public class UserVoteRestController {

    @Autowired
    UserVoteService userVoteService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserVote>> listAllUserVotes() {
        return ResponseEntity.ok(userVoteService.listUserVotes());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserVote> getUserVote(@PathVariable("id") long id) {
        return ResponseEntity.ok(userVoteService.findUserVoteById(id));
    }
    
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUserVote(@RequestBody UserVote userVote)//, UriComponentsBuilder ucBuilder)
    {
        userVoteService.createUserVote(userVote);
        return ResponseEntity.ok().build();
    }
//    @Autowired
//    IdeaService ideaService;
//    @RequestMapping(value = "idea/{id}/user_vote", method = RequestMethod.POST)
//    public ResponseEntity<Void> createUserVote(@PathVariable("id") long idea_id)//, UriComponentsBuilder ucBuilder)
//    {
//        ideaService.addUserVote(idea_id);
//        
//        return ResponseEntity.ok().build();
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserVote> deleteUserVote(@PathVariable("id") long id) {
        userVoteService.deleteUserVote(id);
        return new ResponseEntity<UserVote>(HttpStatus.NO_CONTENT);
    }
}
