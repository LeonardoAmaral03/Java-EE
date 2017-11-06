package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Time;


public class TimeDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public TimeDAO() {
		emf = Persistence.createEntityManagerFactory("Leonardo_0030481521022");
	}
	
	public void salvar(Time time) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(time);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Time> getAllTimes(){
		List<Time> times;
		
		em = emf.createEntityManager();
		times = em.createQuery("Select t from Time t").getResultList();
		em.close();
		
		return times;
	}
}
