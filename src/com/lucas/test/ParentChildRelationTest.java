package com.lucas.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.lucas.hibernate.bean.Blog;
import com.lucas.hibernate.bean.BlogItem;
import com.lucas.hibernate.dao.BlogDao;
import com.lucas.hibernate.dao.BlogDaoImpl;
import com.lucas.hibernate.dao.BlogItemDao;
import com.lucas.hibernate.dao.BlogItemDaoImpl;

import junit.framework.TestCase;

public class ParentChildRelationTest extends TestCase {
	BlogItemDao blogItemDao = new BlogItemDaoImpl();
/*	public void testCreateBlog(){
		BlogDao blogDao = new BlogDaoImpl();
		blogDao.createBlog("java程序设计");
	}	*/
	
/*	public void testCreateBlogItem(){
		Blog blog = new Blog();
		blog.set_id(1l);
		blog.set_name("java程序设计");
		blog.set_items(new ArrayList());
			
		
		blogItemDao.createBlogItem(blog, "C++", "C++ program");
	}*/
	
/*	public void testCreateBlogItem2(){
		blogItemDao.createBlogItem(1l, "PHP", "PHP program");
	}*/
	
/*	public void testUpdateBlogItem(){
		BlogItem blogItem = new BlogItem();
		blogItem.set_id(1l);
		blogItem.set_title("title");
		blogItem.set_datetime(Calendar.getInstance());
		
		Blog blog = new Blog();
		blog.set_id(1l);
		blog.set_name("java程序设计");
		blog.set_items(new ArrayList());
		
		blogItem.set_blog(blog);
		blogItemDao.updateBlogItem(blogItem, "IOS program");
	}*/
	
	public void testGetBlogAndItems(){
		Blog blog = blogItemDao.getBlogAndAllItems(1l);
		System.out.println(blog);
	}
	
/*	public void testListAllBlogNamesAndItemCounts(){
		List list = blogItemDao.listAllBlogNamesAndItemCounts(1);
		System.out.println(list.size());
	}*/
	
/*	public void testlistBlogsAndRecentItems(){
		List list = blogItemDao.listBlogsAndRecentItems();
		System.out.println(list.size());
	}*/
	
}
