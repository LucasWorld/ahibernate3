package com.lucas.hibernate.dao;

import java.util.ArrayList;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lucas.hibernate.bean.Blog;
import com.lucas.hibernate.util.HibernateUtil;

public class BlogDaoImpl implements BlogDao{
	
	public Blog createBlog(String name){
		Blog blog = new Blog();
		blog.set_name(name);
		blog.set_items(new ArrayList());
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(blog);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if(transaction != null ){
				transaction.rollback();
			}
			throw e;
		}finally{
			session.close();
		}
		return blog;
	}
}
