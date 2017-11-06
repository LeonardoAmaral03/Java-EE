package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Cliente;

public class ClienteDAO {

	private EntityManagerFactory emf;
	private EntityManager        em;
	
	public ClienteDAO(){
		
		emf = Persistence.
			  createEntityManagerFactory("PrCliente");
		
	}
	
	public void salvar(Cliente cliente){
	  em = emf.createEntityManager();
	  em.getTransaction().begin();
	  em.persist(cliente);
	  em.getTransaction().commit();
	  em.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List <Cliente> getAllClientes(){
		List <Cliente> clientes;
		
		em = emf.createEntityManager();
		clientes = em.
				   createQuery("Select c from Cliente c").
				   getResultList();
				   
		em.close();
		
		return clientes;
	}
	
	public void alterar(Cliente cliente){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
	public void remover(Cliente cliente){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		cliente = em.merge(cliente);
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
