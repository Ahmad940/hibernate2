import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory buildFactory() {
		try {
			return new Configuration()
					.configure(new File("hibernate.cfg.xml"))
					.buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("Build sessionfactory failed");
			System.out.println(e);
			return null;
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return buildFactory();
	}
}
