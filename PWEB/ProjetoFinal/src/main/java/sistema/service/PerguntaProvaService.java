package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.PerguntaProva;

public class PerguntaProvaService extends Service{
	
	public void salvar(PerguntaProva perguntaProva)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(perguntaProva);
		em.getTransaction().commit();	
	    em.close();
		
	}

	

	@SuppressWarnings("unchecked")
	public List <PerguntaProva> getPerguntasProva() {
		
		List <PerguntaProva> perguntaProvas;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select pp From PerguntaProva pp");
		perguntaProvas = q.getResultList();
		em.close();
		
		return perguntaProvas;
	}
	
	
	public void alterar(PerguntaProva perguntaProva) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(perguntaProva);
		em.getTransaction().commit();	
	    em.close();
	}
	
	
	public void remover(PerguntaProva perguntaProva) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			perguntaProva = em.find(PerguntaProva.class,perguntaProva.getId());
			em.remove(perguntaProva);
		em.getTransaction().commit();	
	    em.close();
	}
	
}
