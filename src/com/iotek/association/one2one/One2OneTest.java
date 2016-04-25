package com.iotek.association.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.iotek.association.one2one.pojo.Passport;
import com.iotek.association.one2one.pojo.Person;
import com.iotek.common.HibernateSessionFactory;

public class One2OneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setName("jack");
		person.setGender("male");
		person.setAge(20);
		
		Passport passport = new Passport();
		passport.setBh("G45672349");
		person.setPassport(passport);
		passport.setPerson(person);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.save(person);
			//Person p = (Person)session.get(Person.class, 53L);
			//System.out.println(p);
			trans.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			trans.rollback();
		}
	}

}
