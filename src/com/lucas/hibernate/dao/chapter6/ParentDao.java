package com.lucas.hibernate.dao.chapter6;

import org.hibernate.HibernateException;

import com.lucas.hibernate.bean.chapter6.Parent;

public interface ParentDao {
	public void addChild() throws HibernateException;
	public void saveParent() throws HibernateException;
	public void delete() throws HibernateException;
	public void deleteRelationship() throws HibernateException;
	
	public Parent getParent() throws HibernateException;
}
