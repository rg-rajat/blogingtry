package com.blogging.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	
	public Comment save (Comment comment);

	public Comment findById(Integer id);
	
	public void delete(Comment id);



	



}
