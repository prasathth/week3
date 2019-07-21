package com.pack.hibernate.service;

import java.util.List;

import com.pack.hibernate.model.Post;
import com.pack.hibernate.model.User;

public interface UserService {
	public int createUser(User user);
	public int deleteUser(long id);
	public int updateUser(long id, User user);
	
	
	public int createPost(int id,Post post);
	public Post getPostById(long id);
	public int deletePostById(long id);
	public List<Post> getAllPostByUserId(long id);
	public int deleteAllPostByUserId(int id,int p_id);
	public List<User> listAll();
	public User findUserId(int id);
	
}