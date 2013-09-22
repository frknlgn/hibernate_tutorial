package javabrains.tutorial_22;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Test User");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		user.setUserName("Updated user");
		user.setUserName("Updated user again");
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Updated user after session is closed");
	}

}
