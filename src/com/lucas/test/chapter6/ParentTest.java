package com.lucas.test.chapter6;

import junit.framework.TestCase;

import com.lucas.hibernate.dao.chapter6.ParentDao;
import com.lucas.hibernate.dao.chapter6.ParentDaoImpl;

public class ParentTest extends TestCase {
	private ParentDao parentDao = new ParentDaoImpl();

/*	public void testSaveParent(){
			try {
				parentDao.saveParent();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
	}*/
	
	//class com.lucas.hibernate.bean.chapter6.Parent$$EnhancerByCGLIB$$d144b919
/*	public void testParent() {
		try {
			parentDao.addChild();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
/*	
	public void testDelete(){
		try {
			parentDao.delete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
	
	
/*	public void testDeleteRelationship(){
		try {
			parentDao.deleteRelationship();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
	
	public void testGetParent(){
		try {
			parentDao.getParent();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
