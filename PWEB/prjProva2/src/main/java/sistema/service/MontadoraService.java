package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Carro;
import sistema.modelos.Montadora;

public class MontadoraService extends Service{
	
	public void salvar(Montadora montadora) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(montadora);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Montadora> getMontadoras() {
		List<Montadora> montadoras;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select m From Montadora m");
		montadoras = q.getResultList();
		em.close();
		
		return montadoras;
	}
	
	public void alterar(Montadora montadora) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(montadora);
		em.getTransaction().commit();	
	    em.close();
	}
	
	public void remover(Montadora montadora) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			montadora = em.find(Montadora.class, montadora.getCodigo());
			em.remove(montadora);
		em.getTransaction().commit();	
		em.close();
	}
	
	public Montadora pesquisar(Montadora montadora) {
		EntityManager em = emf.createEntityManager();
		montadora = em.find(Montadora.class, montadora.getCodigo());
		em.close();
	    
	    return montadora;
	}
	
	public List<Carro> pesquisarCarrosMontadora(Montadora montadora){
		List<Carro> carros;
		
		EntityManager em = emf.createEntityManager();
		
			//Torna gerenciavel a entidade
		    montadora = em.merge(montadora);
		    
		    //Atualiza a entidade para não usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(montadora);
			
			//Recupera a lista de produtos
			carros = montadora.getCarros();
		
		em.close();
    
		return carros;
	}
}
