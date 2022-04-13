import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil
				.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		StudentManagement stm = new StudentManagement();
		stm.startApp(session);
		
		tx.commit();
		session.close();
	}
}