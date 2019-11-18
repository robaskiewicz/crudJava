package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import entidade.Estado;

public class EstadoDAO {
	
	private EntityManager em = EntityManagerProvider.getInstancia();
	
	public Estado buscaPorId(long id) {
		return em.find(Estado.class, id);
	}
	
	public void salvar(Estado estado) {
		em.getTransaction().begin();
		em.merge(estado);
		em.getTransaction().commit();
	}
	
	public void remover(Estado estado) {
		try {
		Estado estadoParaRemover = buscaPorId(estado.getId());
		em.getTransaction().begin();
		em.remove(estadoParaRemover);
		em.flush();
		em.getTransaction().commit();
		} catch (PersistenceException ex) {
			em.getTransaction().rollback();
			throw ex;
		}
	}
	
	public List<String> getSiglas() {
		return em.createNamedQuery("Estado.getSiglas")
		.getResultList();
	}

}
