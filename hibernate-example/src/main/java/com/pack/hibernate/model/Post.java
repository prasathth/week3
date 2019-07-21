package com.pack.hibernate.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	private String body;
	
}