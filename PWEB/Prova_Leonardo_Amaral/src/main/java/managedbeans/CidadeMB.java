package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;
import dao.CidadeDAO;
import entidades.Cidade;

@ManagedBean
@SessionScoped
public class CidadeMB {
	private Cidade cidade = new Cidade();
	private CidadeDAO cidadeDAO = new CidadeDAO();
	private List<Cidade> cidades;
	
	public void onRowEdit (RowEditEvent event){
		Cidade cidade = ((Cidade) event.getObject());
		cidadeDAO.alterar(cidade);
		cidades = cidadeDAO.getAllCidades();
	}
	
	public void remover(Cidade cidade){
		cidadeDAO.remover(cidade);
		cidades = cidadeDAO.getAllCidades();
	}
	
	public List<Cidade> getListaCidade(){
		if(cidades == null)
			cidades = cidadeDAO.getAllCidades();
		
		return cidades;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String salvar() {
		cidadeDAO.salvar(cidade);
		cidades = cidadeDAO.getAllCidades();
		cidade = new Cidade();
		return "";
	}
}
