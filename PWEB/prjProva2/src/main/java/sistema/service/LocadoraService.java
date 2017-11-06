package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Carro;
import sistema.modelos.Locadora;

public class LocadoraService extends Service{
	
	public void salvar(Locadora locadora) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(locadora);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Locadora> getLocadoras() {
		List<Locadora> locadoras;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select l From Locadora l");
		locadoras = q.getResultList();
		em.close();
		
		return locadoras;
	}
	
	public void alterar(Locadora locadora) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(locadora);
		em.getTransaction().commit();	
	    em.close();
	}
	
	public void remover(Locadora locadora) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			locadora = em.find(Locadora.class, locadora.getCodigo());
			em.remove(locadora);
		em.getTransaction().commit();	
		em.close();
	}
	
	public Locadora pesquisar(Locadora locadora) {
		EntityManager em = emf.createEntityManager();
		locadora = em.find(Locadora.class, locadora.getCodigo());
		em.close();
	    
	    return locadora;
	}
	
	public List<Carro> pesquisarCarrosLocadora(Locadora locadora){
		List<Carro> carros;
		
		EntityManager em = emf.createEntityManager();
		
			//Torna gerenciavel a entidade
		    locadora = em.merge(locadora);
		    
		    //Atualiza a entidade para não usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(locadora);
			
			//Recupera a lista de produtos
			carros = locadora.getCarros();
		
		em.close();
    
		return carros;
	}
	
}
