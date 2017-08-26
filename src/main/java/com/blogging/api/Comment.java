package com.blogging.api;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity(name="comment_from_user")
public class Comment {
	
	@Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Integer id;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	
	public Comment(Integer id, Date createDate, String comment_name, String comment_text, String comment_email) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.comment_name = comment_name;
		this.comment_text = comment_text;
		this.comment_email = comment_email;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	private String comment_name;
	private String comment_text;
	private String comment_email;
	
	public Comment()
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment_name() {
		return comment_name;
	}

	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public String getComment_email() {
		return comment_email;
	}

	public void setComment_email(String comment_email) {
		this.comment_email = comment_email;
	}
	
	
}
