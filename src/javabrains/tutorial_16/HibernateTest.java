package javabrains.tutorial_16;

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

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}

}
