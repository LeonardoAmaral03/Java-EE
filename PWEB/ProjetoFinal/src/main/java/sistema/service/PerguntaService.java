package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Pergunta;
import sistema.modelos.PerguntaProva;
//import sistema.modelos.Prova;

public class PerguntaService extends Service {
	
	public void salvar(Pergunta pergunta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(pergunta);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pergunta> getPerguntas() {
		List<Pergunta> perguntas;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p From Pergunta p");
		perguntas = q.getResultList();
		em.close();
		
		return perguntas;
	}
	
	public void alterar(Pergunta pergunta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(pergunta);
		em.getTransaction().commit();	
	    em.close();
	}
	
	public void remover(Pergunta pergunta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			pergunta = em.find(Pergunta.class, pergunta.getId());
			em.remove(pergunta);
		em.getTransaction().commit();	
		em.close();
	}
	
	public Pergunta pesquisar(Pergunta pergunta) {
		EntityManager em = emf.createEntityManager();
		pergunta = em.find(Pergunta.class, pergunta.getId());
		em.close();
	    
	    return pergunta;
	}
	
	public List<PerguntaProva> pesquisarPerguntasProva(Pergunta pergunta){
		List<PerguntaProva> provas;
		
		EntityManager em = emf.createEntityManager();
		
			//Torna gerenciavel a entidade
		    pergunta = em.merge(pergunta);
		    
		    //Atualiza a entidade para não usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(pergunta);
			
			//Recupera a lista de produtos
			provas = pergunta.getPerguntas_prova();
		
		em.close();
    
		return provas;
	}
	
}
