package store.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import store.util.HibernateUtil;

public class StartupListener implements ServletContextListener {
	
	private static final Logger logger = LoggerFactory.getLogger(StartupListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("startup listener worked!");
		HibernateUtil.getFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.destroy();
	}

}
