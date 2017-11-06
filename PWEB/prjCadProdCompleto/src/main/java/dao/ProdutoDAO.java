package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Produto;

public class ProdutoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("prjCadProdCompleto");
	}
	
	public void salvar(Produto produto) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> getAllProdutos(){
		List<Produto> produtos;
		
		em = emf.createEntityManager();
		produtos = em.createQuery("Select p from Produto p").getResultList();
		em.close();
		
		return produtos;
	}
	
	public void alterar(Produto produto){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Produto produto){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		produto = em.merge(produto);
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
	}
}