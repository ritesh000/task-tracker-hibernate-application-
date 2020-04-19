package com.entity.tasktraker;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Note {

     @Id
	private int id;
	private String title;
	@Column(length = 3000)
	private String content;
	private Date AddedDtae;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddedDtae() {
		return AddedDtae;
	}
	public void setAddedDtae(Date addedDtae) {
		AddedDtae = addedDtae;
	}
	public Note(String title, String content, Date addedDtae) {
		super();
		this.id = new Random().nextInt(100000);
		this.title = title;
		this.content = content;
		AddedDtae = addedDtae;
	}
	public Note() {
		super();
		
	}

}
