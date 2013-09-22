package javabrains.tutorial_26;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select userName from UserDetails");
		// Query query = session.createQuery("select new map(userId, userName) from UserDetails");
		// Query query = session.createQuery("select max(userId) from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		List<String> userNames = (List<String>) query.list();

		session.getTransaction().commit();
		session.close();

		for(String u : userNames){
			System.out.println(u);
		}
	}

}
