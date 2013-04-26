package com.lucas.hibernate.dao.chapter4;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lucas.hibernate.util.HibernateUtil;

public class CatDaoImpl implements CatDao {

	@Override
	public void save() throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		//Session dynamicSession =null;
		try {
			transaction = session.beginTransaction();
			//dynamicSession = session.getSession(EntityMode.MAP);
			Map david = new HashMap();
			david.put("name", "david");
			david.put("address", "beijing");
			session.save("Customer", david);
			session.flush();
			

		} catch (Exception e) {
			// TODO: handle exception
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
