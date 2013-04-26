package com.lucas.hibernate.dao.chapter6;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lucas.hibernate.bean.chapter6.Child;
import com.lucas.hibernate.bean.chapter6.Parent;
import com.lucas.hibernate.util.HibernateUtil;

public class ParentDaoImpl implements ParentDao {

	@Override
	public void addChild() throws HibernateException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Parent parent = (Parent) session.load(Parent.class, 2l);
			Child child = new Child();
			child.setName("name");
			child.setParent(parent);
			parent.getChildren().add(child);
			
			//session.save(child);
			session.flush();

			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void saveParent() throws HibernateException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Parent parent = new Parent();
			session.save(parent);
			session.flush();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete() throws HibernateException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Parent parent = (Parent)session.load(Parent.class, 2l);
			session.delete(parent);
			session.flush();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteRelationship() throws HibernateException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Parent parent = (Parent)session.load(Parent.class, 2l);
			Child child = (Child)parent.getChildren().iterator().next();
			parent.getChildren().remove(child);
			
			session.delete(child);
			session.flush();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}		
	}

	@Override
	public Parent getParent() throws HibernateException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Parent parent = null;
		try {
			transaction = session.beginTransaction();
			parent = (Parent)session.load(Parent.class, 20l);
			System.out.println(parent.getChildren().size());
			System.out.println(parent.getClass());
			transaction.commit();
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return parent;
	}
	
	
}
