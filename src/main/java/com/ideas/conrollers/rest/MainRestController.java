/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideas.conrollers.rest;

import com.ideas.Idea;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ideas.Idea;
import com.ideas.IdeaService;

/**
 *
 * @author Гриша
 */

//crud
//findall
//postman
@RestController
public class MainRestController {

//    @Autowired
//    UserService userService;  //Service which will do all data retrieval/manipulation work
// 
    @Autowired
    IdeaService ideaService;  //Service which will do all data retrieval/manipulation work

//    //-------------------Retrieve All Users--------------------------------------------------------
//     
//    @RequestMapping(value = "/user/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUsers() {
//        List<User> users = userService.findAllUsers();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }
//-------------------Retrieve All Ideas--------------------------------------------------------
    @RequestMapping(value = "/idea/", method = RequestMethod.GET)
    public ResponseEntity<List<Idea>> listAllIdeas() {
        List<Idea> ideas = ideaService.findAllIdeas();
        if (ideas.isEmpty()) {
            return new ResponseEntity<List<Idea>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Idea>>(ideas, HttpStatus.OK);
    }

// 
//    //-------------------Retrieve Single User--------------------------------------------------------
//     
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//        System.out.println("Fetching User with id " + id);
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
    @RequestMapping(value = "/idea/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Idea> getIdea(@PathVariable("id") long id) {
        System.out.println("Fetching Idea with id " + id);
        Idea idea = ideaService.findById(id);
        if (idea == null) {
            System.out.println("Idea with id " + id + " not found");
            return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Idea>(idea, HttpStatus.OK);
    }

//     
//     
//    //-------------------Create a User--------------------------------------------------------
//     
//    @RequestMapping(value = "/user/", method = RequestMethod.POST)
//    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating User " + user.getName());
// 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
// 
//        userService.saveUser(user);
// 
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    @RequestMapping(value = "/idea/", method = RequestMethod.POST)
    public ResponseEntity<Void> createIdea(@RequestBody Idea idea, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Idea by " + idea.getAuthor());

        if (ideaService.isIdeaExist(idea)) {
            System.out.println("A idea by  " + idea.getAuthor() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        ideaService.saveIdea(idea);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/idea/{id}").buildAndExpand(idea.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

//     
//    //------------------- Update a User --------------------------------------------------------
//     
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        System.out.println("Updating User " + id);
//         
//        User currentUser = userService.findById(id);
//         
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
// 
//        currentUser.setName(user.getName());
//        currentUser.setAge(user.getAge());
//        currentUser.setSalary(user.getSalary());
//         
//        userService.updateUser(currentUser);
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }

        @RequestMapping(value = "/idea/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Idea> updateIdea(@PathVariable("id") long id, @RequestBody Idea idea) {
        System.out.println("Updating Idea " + id);
         
        Idea currentIdea = ideaService.findById(id);
         
        if (currentIdea==null) {
            System.out.println("Idea with id " + id + " not found");
            return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
        }
        
        currentIdea.setId(idea.getId());
        currentIdea.setAuthor(idea.getAuthor());
        currentIdea.setText(idea.getText());
        
       
         
        ideaService.updateIdea(currentIdea);
        return new ResponseEntity<Idea>(currentIdea, HttpStatus.OK);
    }
    
    
//    //------------------- Delete a User --------------------------------------------------------
//     
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
//        System.out.println("Fetching & Deleting User with id " + id);
// 
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("Unable to delete. User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
// 
//        userService.deleteUserById(id);
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
    @RequestMapping(value = "/idea/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Idea> deleteIdea(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Idea with id " + id);

        Idea idea = ideaService.findById(id);
        if (idea == null) {
            System.out.println("Unable to delete. idea with id " + id + " not found");
            return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
        }

        ideaService.deleteIdeaById(id);
        return new ResponseEntity<Idea>(HttpStatus.NO_CONTENT);
    }

//    //------------------- Delete All Users --------------------------------------------------------
//     
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteAllUsers() {
//        System.out.println("Deleting All Users");
// 
//        userService.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//  }
    @RequestMapping(value = "/idea/", method = RequestMethod.DELETE)
    public ResponseEntity<Idea> deleteAllIdeas() {
        System.out.println("Deleting All Ideas");

        ideaService.deleteAllIdeas();
        return new ResponseEntity<Idea>(HttpStatus.NO_CONTENT);
    }

}
