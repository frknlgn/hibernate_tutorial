package javabrains.tutorial_24;

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
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);
		
		user = (UserDetails) session.get(UserDetails.class, 1);

		session.getTransaction().commit();
		session.close();

		user.setUserName("Changed name");
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(user);

		session.getTransaction().commit();
		session.close();
	}

}
