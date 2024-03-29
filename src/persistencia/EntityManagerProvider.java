package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	static {
		emf = Persistence.createEntityManagerFactory("CRUDBasicoPU");
		em = emf.createEntityManager();
	}
	
	public static EntityManager getInstancia() {
		return em;
	}
	
	public static void close() {
		em.close();
		emf.close();
	}
}
