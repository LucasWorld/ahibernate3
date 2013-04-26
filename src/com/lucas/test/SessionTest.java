package com.lucas.test;

import com.lucas.hibernate.util.HibernateUtil;

import junit.framework.TestCase;

public class SessionTest extends TestCase {
	public void testSession(){
		try {
			HibernateUtil.getSession();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void testSessionFactory(){
		try {
			HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
