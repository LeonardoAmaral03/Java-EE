package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;

public class DisciplinaService extends Service {
	
	public void salvar(Disciplina disciplina) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(disciplina);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> getDisciplinas() {
		List<Disciplina> disciplinas;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select d From Disciplina d");
		disciplinas = q.getResultList();
		em.close();
		
		return disciplinas;
	}
	
	public void alterar(Disciplina disciplina) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(disciplina);
		em.getTransaction().commit();	
	    em.close();
	}
	
	public void remover(Disciplina disciplina) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			disciplina = em.find(Disciplina.class, disciplina.getId());
			em.remove(disciplina);
		em.getTransaction().commit();	
		em.close();
	}
	
	public Disciplina pesquisar(Disciplina disciplina) {
		EntityManager em = emf.createEntityManager();
		disciplina = em.find(Disciplina.class, disciplina.getId());
		em.close();
	    
	    return disciplina;
	}
	
	public List<Conteudo> pesquisarConteudosDisciplina(Disciplina disciplina){
		List<Conteudo> conteudos;
		
		EntityManager em = emf.createEntityManager();
		
			//Torna gerenciavel a entidade
		    disciplina = em.merge(disciplina);
		    
		    //Atualiza a entidade para n�o usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(disciplina);
			
			//Recupera a lista de produtos
			conteudos = disciplina.getConteudos();
		
		em.close();
    
		return conteudos;
	}
	
}
