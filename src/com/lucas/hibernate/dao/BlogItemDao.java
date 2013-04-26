package com.lucas.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.lucas.hibernate.bean.Blog;
import com.lucas.hibernate.bean.BlogItem;

public interface BlogItemDao {
	public BlogItem createBlogItem(Blog blog, String title, String text)
			throws HibernateException;

	public BlogItem createBlogItem(Long blogid, String title, String text)
			throws HibernateException;

	public void updateBlogItem(BlogItem item, String text)
			throws HibernateException;

	public void updateBlogItem(Long itemid, String text)
			throws HibernateException;

	public List listAllBlogNamesAndItemCounts(int max)
			throws HibernateException;

	public Blog getBlogAndAllItems(Long blogid) throws HibernateException;

	public List listBlogsAndRecentItems() throws HibernateException;
}
