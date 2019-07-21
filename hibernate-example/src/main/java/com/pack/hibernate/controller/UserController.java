package com.pack.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.hibernate.model.Post;
import com.pack.hibernate.model.User;
import com.pack.hibernate.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
//@EnableSwagger2
//@PropertySource("classpath:documentation.properties")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping(value="/",produces= { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public List<User> listAll()
	{
		return userservice.listAll();
	}
	
	@PostMapping(value="/",consumes= { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public String createUser(@Valid @RequestBody User user)
	{
		if(userservice.createUser(user)==1)
			return "insert done";
		else
			return "insert not done";
	}
	
	@GetMapping(value="/{id}", produces= { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public User findUsingId(@PathVariable int id)
	{
		return userservice.findUserId(id);
	}
	
	@DeleteMapping(value="/{id}")
	public String deleteUser(@PathVariable long id)
	{
		if(userservice.deleteUser(id) == 1)
			return "delete done";
		else
			return "delete failed";
	}
	
	@PostMapping(value="/{id}/post",consumes= { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public String savePost(@PathVariable int id, @RequestBody Post post)
	{
		if(userservice.createPost(id,post)==1)
			return "insert success";
		else
			return "no insert";
	}
	
	@GetMapping(value = "/{id}/posts", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public List<Post> listPosts(@PathVariable int id)
	{
		return userservice.getAllPostByUserId(id);
	}
	
	@DeleteMapping(value = "/{id}/posts/{post_id}")
	public String deleteAllPost(@PathVariable int id, @PathVariable int p_id) {
		if (userservice.deleteAllPostByUserId(id,p_id) == 1) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}
	
	@PutMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public String updateUser(@PathVariable int id, @RequestBody User user) {
		if (userservice.updateUser(id,user) == 1) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}
	
	
}
