package store.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class HibernateUtil {

	private static final EntityManagerFactory factory;
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
	
	static {
		try {
			factory = Persistence.createEntityManagerFactory("store");
			logger.info("EntityManagerFactory initialized!");
		} catch (final Exception e) {
			throw new ExceptionInInitializerError(e);
			//Возможно стоит прокинуть другое исключение, любят прокидывать либо IllegalStateException  или NullPointerException.
		}
	}
	
	private HibernateUtil() {
		
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	public static void destroy() {
		factory.close();
	}
}
