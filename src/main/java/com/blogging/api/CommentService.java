package com.blogging.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentrepository;
	
	public Comment save (Comment comment)
	{
		return commentrepository.save(comment);
	}
	public Comment findById(Integer id)
	{
	return commentrepository.findById(id);
	}
	
	public void deleteById(Comment id)
	{
	commentrepository.delete(id);
	}

	public Object findAll() {
		
		return commentrepository.findAll();
	}
}
