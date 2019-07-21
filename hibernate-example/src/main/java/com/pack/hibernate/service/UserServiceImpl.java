package com.pack.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pack.hibernate.dao.UserDao;
import com.pack.hibernate.model.Post;
import com.pack.hibernate.model.User;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
    @Qualifier(value = "hibernateDAOImpl")
	private UserDao userdao; 
	
	public UserServiceImpl(@Qualifier(value = "hibernateDAOImpl") UserDao userdao) {
		super();
		this.userdao = userdao;
	}
	@Transactional
	public int createUser(User user) {
		return userdao.createUser(user);
	}

	public int deleteUser(long id) {
		return userdao.deleteUser(id);
	}

	public int updateUser(long id, User user) {
		return userdao.updateUser(id, user);
	}

	public int createPost(int id,Post post) {
 		return userdao.createPost(id,post);
	}

	public Post getPostById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deletePostById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Post> getAllPostByUserId(long id) {
		return userdao.getAllPostByUserId(id);
	}

	public int deleteAllPostByUserId(int id, int p_id) {
		return userdao.deleteAllPostByUserId(id, p_id);
	}
	public List<User> listAll() {
		return userdao.listAll();
	}
	public User findUserId(int id) {
		return userdao.findById(id);
	}

}