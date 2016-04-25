package com.iotek.basic;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iotek.basic.pojo.Student;
import com.iotek.common.HibernateSessionFactory;

public class StudentTest {
	public static void main(String args[]){
		Student student = new Student();
		student.setId(12345L);
		student.setName("jack");
		student.setAddress("shanghai");
		student.setGender("male");
		student.setAge(30);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.save(student);
			//student = (Student)session.get(Student.class, 22L);
			//System.out.println(student);
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}
	}
}
