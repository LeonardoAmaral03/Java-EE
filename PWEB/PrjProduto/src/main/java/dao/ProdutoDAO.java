package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Produto;

public class ProdutoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("PrjProduto");
	}
	
	public void salvar(Produto produto) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}
}
