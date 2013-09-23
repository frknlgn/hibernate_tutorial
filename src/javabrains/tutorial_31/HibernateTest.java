package javabrains.tutorial_31;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(5);
		/*exampleUser.setUserName("User 5");
		Example example = Example.create(exampleUser).excludeProperty("userName");*/
		
		exampleUser.setUserName("User 1%");
		Example example = Example.create(exampleUser).enableLike();
		
		Criteria criteria = session.createCriteria(UserDetails.class)
				.add(example);
		
		/*
		Criteria criteria = session.createCriteria(UserDetails.class)
				.setProjection(Projections.max("userName"))
				.addOrder(Order.desc("userId"));*/

		List<UserDetails> users = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : users) {
			System.out.println(user.getUserName());
		}
	}
}
