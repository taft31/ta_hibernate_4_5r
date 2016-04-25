package com.iotek.association.many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iotek.association.many2many.pojo.Engineer;
import com.iotek.association.many2many.pojo.Technology;
import com.iotek.common.HibernateSessionFactory;

public class Many2ManyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Engineer engineer1 = new Engineer();
		engineer1.setName("zhangsan");
		engineer1.setAge(20);
		engineer1.setCompany("iotek");
		engineer1.setGender("male");
		
		Engineer engineer2 = new Engineer();
		engineer2.setName("lisi");
		engineer2.setAge(20);
		engineer2.setCompany("iotek");
		engineer2.setGender("male");
		
		Technology technology1 = new Technology();
		technology1.setName("hibernate");
		technology1.setCategory("java");
		
		Technology technology2 = new Technology();
		technology2.setName("xml");
		technology2.setCategory("java");
		
		engineer1.getTechnologies().add(technology1);
		engineer1.getTechnologies().add(technology2);
		engineer2.getTechnologies().add(technology1);
		engineer2.getTechnologies().add(technology2);
		
		technology1.getEngineers().add(engineer1);
		technology1.getEngineers().add(engineer2);
		technology2.getEngineers().add(engineer1);
		technology2.getEngineers().add(engineer2);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.save(engineer1);
			session.save(engineer2);
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}
	}

}
