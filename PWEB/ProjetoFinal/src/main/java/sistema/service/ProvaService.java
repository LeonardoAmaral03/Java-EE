package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

//import sistema.modelos.Pergunta;
import sistema.modelos.PerguntaProva;
import sistema.modelos.Prova;

public class ProvaService extends Service{
	
	public void salvar(Prova prova) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(prova);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Prova> getProvas() {
		List<Prova> provas;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p From Prova p");
		provas = q.getResultList();
		em.close();
		
		return provas;
	}
	
	public void alterar(Prova prova) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(prova);
		em.getTransaction().commit();	
	    em.close();
	}
	
	public void remover(Prova prova) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			prova = em.find(Prova.class, prova.getId());
			em.remove(prova);
		em.getTransaction().commit();	
		em.close();
	}
	
	public Prova pesquisar(Prova prova) {
		EntityManager em = emf.createEntityManager();
		prova = em.find(Prova.class, prova.getId());
		em.close();
	    
	    return prova;
	}
	
	public List<PerguntaProva> pesquisarPerguntasProva(Prova prova){
		List<PerguntaProva> perguntas;
		
		EntityManager em = emf.createEntityManager();
		
			//Torna gerenciavel a entidade
		    prova = em.merge(prova);
		    
		    //Atualiza a entidade para não usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(prova);
			
			//Recupera a lista de produtos
			perguntas = prova.getPerguntas_prova();
		
		em.close();
    
		return perguntas;
	}
	
}
