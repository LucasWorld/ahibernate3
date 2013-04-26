package com.lucas.test.chapter4;

import com.lucas.hibernate.dao.chapter4.CatDao;
import com.lucas.hibernate.dao.chapter4.CatDaoImpl;

import junit.framework.TestCase;

public class PersistentTest extends TestCase {
	CatDao catDao = new CatDaoImpl();
	
	
	public void testSave(){
		
		try {
			catDao.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
