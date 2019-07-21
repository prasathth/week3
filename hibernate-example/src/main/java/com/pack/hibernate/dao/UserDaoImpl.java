package com.pack.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.hibernate.model.Post;
import com.pack.hibernate.model.User;


@Repository("hibernateDAOImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory ;
	
	
	public int createUser(User user) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(user);
		return 1;
	}

	public int deleteUser(long id) {
		Session session = sessionfactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);
		return 1;
	}

	public int updateUser(long id, User user) {
		Session session = sessionfactory.getCurrentSession();
		User userr = session.get(User.class, id);
		
		if(userr != null)
		{
			if(user.getName()!=null)
				userr.setName(user.getName());
		}
		session.saveOrUpdate(userr);
		return 1;
	}

	public int createPost(int id,Post post) {
		Session session = sessionfactory.getCurrentSession();
		User user = findById(id);
		List<Post> posts = user.getPosts();
		posts.add(post);
		user.setPosts(posts);
		session.saveOrUpdate(user);
		return 1;
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
		return sessionfactory.getCurrentSession().get(User.class,id).getPosts();
	}

	public int deleteAllPostByUserId(int id,int p_id) {
		Session session = sessionfactory.getCurrentSession();
		User user = findById(id);
		
		return 0;
	}

	public List<User> listAll() {
		Session currentsession = sessionfactory.getCurrentSession();
		return currentsession.createQuery("from user").list();
	}

	public User findById(int id) {
		return sessionfactory.getCurrentSession().get(User.class,id);
	}

	
}