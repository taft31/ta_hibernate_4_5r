package com.iotek.association.one2many;

import java.sql.Date;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iotek.association.one2many.pojo.Order;
import com.iotek.association.one2many.pojo.OrderLine;
import com.iotek.common.HibernateSessionFactory;

public class One2ManyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrderLine ol1 = new OrderLine();
		ol1.setProduct("Java");
		ol1.setPrice(20.5);
		ol1.setQuantity(5L);
		
		OrderLine ol2 = new OrderLine();
		ol2.setProduct("Jdbc");
		ol2.setPrice(45.6);
		ol2.setQuantity(7L);
		
		Order order = new Order();
		order.setOrderedDate(new Date(System.currentTimeMillis()));
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.DAY_OF_MONTH, cl.get(Calendar.DAY_OF_MONTH)+3);
		order.setShippedDate(new Date(cl.getTimeInMillis()));
		order.getOrderlines().add(ol1);
		order.getOrderlines().add(ol2);
		ol1.setOrder(order);
		ol2.setOrder(order);
		order.setTotal(ol1.getPrice()*ol1.getQuantity()+ol2.getPrice()*ol2.getQuantity());
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.save(order);
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}
		
	}

}
