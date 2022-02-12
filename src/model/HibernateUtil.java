package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	private static ServiceRegistry serviceRegistry;

	static {

		try {

			Configuration conf = new Configuration().configure();
			conf.addAnnotatedClass(model.Client.class);
		//	conf.addAnnotatedClass(model.SessionObject.class);
			conf.addAnnotatedClass(Ordine.class);
		//	conf.addAnnotatedClass(nuovo.SessionUtil.class);

			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

			sessionFactory = conf.buildSessionFactory(sr);

		} catch (Throwable th) {

			System.err.println("Enitial SessionFactory creation failed" + th);

			throw new ExceptionInInitializerError(th);

		}

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}
}
