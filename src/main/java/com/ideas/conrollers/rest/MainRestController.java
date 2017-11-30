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
import com.ideas.IdeaRepository;
import com.ideas.IdeaService;
import java.util.Arrays;

/**
 *
 * @author Гриша
 */

//crud
//findall
//postman
@RestController
public class MainRestController {


    @Autowired
    IdeaRepository repository;  //Service which will do all data retrieval/manipulation work
       
        @RequestMapping(value = "/save/", method = RequestMethod.POST)
        public String process(){
            System.out.println("com.ideas.conrollers.rest.MainRestController.process()");
    		// save a single Customer
    		repository.save(new Idea(1,"text1", "auth1"));

    		// save a list of Customers
    		repository.save(Arrays.asList(
        new Idea(2,"text2", "auth2"),
        new Idea(3,"text3", "auth3"),
        new Idea(4,"text4", "auth4"),
        new Idea(5,"text5", "auth5")
        ));

    		return "Done";
    	}
    
    @RequestMapping(value = "/idea/", method = RequestMethod.GET)
    public ResponseEntity<List<Idea>> listAllIdeas() {
        System.out.println("com.ideas.conrollers.rest.MainRestController.listAllIdeas()");
        List<Idea> ideas = (List<Idea>) repository.findAll();
        if (ideas.isEmpty()) {
            return new ResponseEntity<List<Idea>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Idea>>(ideas, HttpStatus.OK);
    }



     @RequestMapping(value = "/idea/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Idea> getIdea(@PathVariable("id") long id) {
         System.out.println("Fetching Idea with id " + id);
         Idea idea = (Idea) repository.findByid(id);
         if (idea == null) {
             System.out.println("Idea with id " + id + " not found");
             return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<Idea>(idea, HttpStatus.OK);
     }
    
     @RequestMapping(value = "/idea/", method = RequestMethod.POST)
     public ResponseEntity<Void> createIdea(@RequestBody Idea idea, UriComponentsBuilder ucBuilder) {
         System.out.println("Creating Idea by " + idea.getAuthor());
    
        
    
         repository.save(idea);
    
         HttpHeaders headers = new HttpHeaders();
         headers.setLocation(ucBuilder.path("/idea/{id}").buildAndExpand(idea.getId()).toUri());
         return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
     }
    //
    //
    //
         @RequestMapping(value = "/idea/{id}", method = RequestMethod.PUT)
     public ResponseEntity<Idea> updateIdea(@PathVariable("id") long id, @RequestBody Idea idea) {
         System.out.println("Updating Idea " + id);
    
         Idea currentIdea = repository.findByid(id);
         
    
         if (currentIdea==null) {
             System.out.println("Idea with id " + id + " not found");
             return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
         }
    
         currentIdea.setId(idea.getId());
         currentIdea.setAuthor(idea.getAuthor());
         currentIdea.setText(idea.getText());
    
    
         repository.save(idea);
         
         return new ResponseEntity<Idea>(currentIdea, HttpStatus.OK);
     }
    
    
     @RequestMapping(value = "/idea/{id}", method = RequestMethod.DELETE)
     public ResponseEntity<Idea> deleteIdea(@PathVariable("id") long id) {
         System.out.println("Fetching & Deleting Idea with id " + id);
    
         Idea idea = repository.findByid(id);
         if (idea == null) {
             System.out.println("Unable to delete. idea with id " + id + " not found");
             return new ResponseEntity<Idea>(HttpStatus.NOT_FOUND);
         }
    
         
         repository.delete(id);
         return new ResponseEntity<Idea>(HttpStatus.NO_CONTENT);
     }
    
    
     @RequestMapping(value = "/idea/", method = RequestMethod.DELETE)
     public ResponseEntity<Idea> deleteAllIdeas() {
         System.out.println("Deleting All Ideas");
    
         repository.deleteAll();
         return new ResponseEntity<Idea>(HttpStatus.NO_CONTENT);
     }

}
