package com.isd.ideas.idea;


import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.isd.ideas.roles.RoleServiceImp;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/idea")
public class IdeaRestController {

    @Autowired
    IdeaService ideaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Idea>> listAllIdeas() {
        return ResponseEntity.ok(ideaService.listIdeas());
    }
   
    @RequestMapping(params = "author",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Idea>> getIdeasByAuthor(@RequestParam("author") String author) {
        return ResponseEntity.ok(ideaService.findIdeaByAuthor(author));
    }
    
    @RequestMapping(params = "date",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Idea>> getIdeasByDate(@RequestParam("date") Date date) {
        return ResponseEntity.ok(ideaService.findByDate(date));
    }
    
//    @RequestMapping(params = "id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Idea> getIdea(@RequestParam("id") long id) {
//        return ResponseEntity.ok(ideaService.findIdeaById(id));
//    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Idea> getIdea(@PathVariable("id") long id) {
        return ResponseEntity.ok(ideaService.findIdeaById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createIdea(@RequestBody Idea idea)//, UriComponentsBuilder ucBuilder)
    {
        ideaService.createIdea(idea);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Idea> updateIdea(@PathVariable("id") long id, @RequestBody Idea idea) {
        ideaService.updateIdea(id, idea);
        return ResponseEntity.ok(idea);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Idea> deleteRole(@PathVariable("id") long id) {
        ideaService.deleteIdea(id);
       return new ResponseEntity<Idea>(HttpStatus.NO_CONTENT);
    }
}
