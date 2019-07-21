package com.pack.hibernate.model;

import java.io.Serializable;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table(name = "Address")
@Data
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	private String street;
	
	private String city;
	
	private String pincode;

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
		
}