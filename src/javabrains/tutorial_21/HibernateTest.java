package javabrains.tutorial_21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("User");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("Updated user");
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
	}

}
