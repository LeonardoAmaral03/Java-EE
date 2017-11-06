package managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;
import dao.ClienteDAO;
import entidades.Cliente;

@ManagedBean
@SessionScoped
public class ClienteMB {
	private Cliente cliente = new Cliente();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private List <Cliente> clientes;
	
    
  //Edição de um cliente na tabela
  	public void onRowEdit(RowEditEvent event) {

  		Cliente cliente = ((Cliente) event.getObject());
  	    clienteDAO.alterar(cliente);
  	    clientes = clienteDAO.getAllClientes();
  	}

    
    
    public void remover(Cliente cliente){
    	clienteDAO.remover(cliente);
    	clientes = clienteDAO.getAllClientes();
    }
    
    
	public List<Cliente> getListaCli() {
		if(clientes == null)
			clientes = clienteDAO.getAllClientes();
		
		return clientes;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String salvar(){
		clienteDAO.salvar(cliente);
		clientes = clienteDAO.getAllClientes();
		cliente = new Cliente();
		return "";
	}
}
