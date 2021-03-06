package javabrains.tutorial_9;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		Address addr = new Address();
		addr.setStreet("Street name");
		addr.setCity("City name");
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street name");
		addr2.setCity("Second City name");
		
		user.setHomeAddress(addr);
		user.setOfficeAddress(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	
	}

}
