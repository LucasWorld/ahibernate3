package com.lucas.hibernate.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lucas.hibernate.bean.Blog;
import com.lucas.hibernate.bean.BlogItem;
import com.lucas.hibernate.util.HibernateUtil;

public class BlogItemDaoImpl implements BlogItemDao{

	@Override
	public BlogItem createBlogItem(Blog blog, String title, String text)
			throws HibernateException {
		// TODO Auto-generated method stub
		BlogItem blogItem = new BlogItem();
		blogItem.set_title(title);
		blogItem.set_text(text);
		blogItem.set_blog(blog);
		blogItem.set_datetime(Calendar.getInstance());
		blog.get_items().add(blogItem);
		Session session = HibernateUtil.getSession();
		Transaction transation  = null;
		try {
			transation = session.beginTransaction();
			session.update(blog);
			transation.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (transation != null) {
				transation.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return blogItem;
	}

	@Override
	public BlogItem createBlogItem(Long blogid, String title, String text)
			throws HibernateException {
		// TODO Auto-generated method stub
		BlogItem blogItem = new BlogItem();
		blogItem.set_title(title);
		blogItem.set_text(text);
		blogItem.set_datetime(Calendar.getInstance());
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Blog blog = (Blog) session.load(Blog.class, blogid);
			blogItem.set_blog(blog);
			blog.get_items().add(blogItem);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public void updateBlogItem(BlogItem item, String text)
			throws HibernateException {
		// TODO Auto-generated method stub
		item.set_text(text);
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(item);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

	@Override
	public void updateBlogItem(Long itemid, String text)
			throws HibernateException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			BlogItem blogItem = (BlogItem) session.load(BlogItem.class, itemid);
			blogItem.set_text(text);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if(transaction != null){
				transaction.rollback();
			}
		}finally{
			session.close();
		}		
	}

	@Override
	public List listAllBlogNamesAndItemCounts(int max)
			throws HibernateException {
		// TODO Auto-generated method stub
        List result = new ArrayList();
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
        	transaction = session.beginTransaction();
        	result = session.createQuery("select blog._id, blog._name, count(blogItem) " +
                    "from Blog as blog " +
                    "left outer join blog._items as blogItem " +
                    "group by blog._name, blog._id " +
                    "order by max(blogItem._datetime)").setMaxResults(max).list();
        	transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
       return result;
	}

	@Override
	public Blog getBlogAndAllItems(Long blogid) throws HibernateException {
		// TODO Auto-generated method stub
		Blog blog = null;
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
        	transaction = session.beginTransaction();
        	blog = (Blog)session.createQuery("from Blog as blog " +
                    "left outer join fetch blog._items " +
                    "where blog._id = :blogid").setParameter("blogid", blogid).uniqueResult();
        	transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
       return blog;
	}

	@Override
	public List listBlogsAndRecentItems() throws HibernateException {
		// TODO Auto-generated method stub
        List result = new ArrayList();
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
        	transaction = session.beginTransaction();
            Calendar cal = Calendar.getInstance();
            cal.roll(Calendar.MONTH, false);
        	result = session.createQuery( "from Blog as blog " +
                    "inner join blog._items as blogItem " +
                    "where blogItem._datetime > :minDate").setCalendar("minDate", cal).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			if(transaction != null){
				transaction.rollback();
			}
		}finally{
			session.close();
		}
       return result;
	}

}
