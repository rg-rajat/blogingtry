package com.blogging.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@Autowired
	private CommentRepository commentrepo;

	//----------------inserting comment------------------
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public @ResponseBody String insertComment (@RequestParam String comment_name,
		@RequestParam String comment_text,@RequestParam String comment_email) {
		
		Comment comment= new Comment();
		comment.setComment_name(comment_name);
         comment.setComment_text(comment_text);
         comment.setComment_email(comment_email);
		
         service.save(comment);
         
		return "Insertion Successful";
	}
//--------------fetching all comments-------------------------	
	@GetMapping(path="/comments")
	public @ResponseBody Object getAllComments() {
	// This returns a JSON or XML with the users
	return service.findAll();
	}
//-------------------fetching comments for particular id-------------------	
	@RequestMapping(value = "/comment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<Comment> getComment(@PathVariable("id") Integer id) {
	       //System.out.println("Fetching User with id " + id);
	      Comment  user = service.findById(id);
	       if (user != null) {
	           //System.out.println("User with id " + id + " not found");
	           //return new ResponseEntity<Object>(user, HttpStatus.OK);
	    	   return new ResponseEntity<Comment>(user, HttpStatus.OK);
	       }
	       //return new ResponseEntity<Object>(user, HttpStatus.OK);
	       return new ResponseEntity<Comment>(user, HttpStatus.OK);
	   }
	//-------------deleting comment for particular id------------------------------
	@RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<Object> deleteComment(@PathVariable("id") Integer id) {
		Comment user=new Comment();
		user.setId(id);
	    service.deleteById(user);
	    return new ResponseEntity<Object>( HttpStatus.OK);
	   }
	
}
