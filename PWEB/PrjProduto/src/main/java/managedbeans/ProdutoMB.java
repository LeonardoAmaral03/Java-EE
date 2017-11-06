package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.ProdutoDAO;
import entidades.Produto;

@ManagedBean
@SessionScoped
public class ProdutoMB {
	private Produto produto = new Produto();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String salvar() {
		produtoDAO.salvar(produto);
		produto = new Produto();
		return "";
	}
}
