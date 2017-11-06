package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Carro;

public class CarroService extends Service{
	
	public void salvar(Carro carro)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(carro);
		em.getTransaction().commit();	
	    em.close();
		
	}

	

	@SuppressWarnings("unchecked")
	public List <Carro> getCarros() {
		
		List <Carro > carros;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Carro c");
		carros = q.getResultList();
		em.close();
		
		return carros;
	}
	
	
	public void alterar(Carro carro) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(carro);
		em.getTransaction().commit();	
	    em.close();
	}
	
	
	public void remover(Carro carro) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			carro = em.find(Carro.class,carro.getCodigo());
			em.remove(carro);
		em.getTransaction().commit();	
	    em.close();
	}
	
}
