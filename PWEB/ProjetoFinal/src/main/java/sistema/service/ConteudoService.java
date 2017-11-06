package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Conteudo;
import sistema.modelos.Pergunta;

public class ConteudoService extends Service {
	
	public void salvar(Conteudo conteudo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(conteudo);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Conteudo> getConteudos() {
		List<Conteudo> conteudos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Conteudo c");
		conteudos = q.getResultList();
		em.close();
		
		return conteudos;
	}
	
	public void alterar(Conteudo conteudo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(conteudo);
		em.getTransaction().commit();	
	    em.close();
	}
	
	public void remover(Conteudo conteudo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			conteudo = em.find(Conteudo.class, conteudo.getId());
			em.remove(conteudo);
		em.getTransaction().commit();	
		em.close();
	}
	
	public Conteudo pesquisar(Conteudo conteudo) {
		EntityManager em = emf.createEntityManager();
		conteudo = em.find(Conteudo.class, conteudo.getId());
		em.close();
	    
	    return conteudo;
	}
	
	public List<Pergunta> pesquisarPerguntasConteudo(Conteudo conteudo){
		List<Pergunta> perguntas;
		
		EntityManager em = emf.createEntityManager();
		
			//Torna gerenciavel a entidade
		    conteudo = em.merge(conteudo);
		    
		    //Atualiza a entidade para não usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(conteudo);
			
			//Recupera a lista de produtos
			perguntas = conteudo.getPerguntas();
		
		em.close();
    
		return perguntas;
	}
	
}
