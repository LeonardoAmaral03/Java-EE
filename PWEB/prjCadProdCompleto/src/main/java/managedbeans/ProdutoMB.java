package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;
import dao.ProdutoDAO;
import entidades.Produto;

@ManagedBean
@SessionScoped
public class ProdutoMB {
	private Produto produto = new Produto();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private List <Produto> produtos;
	
	public void onRowEdit (RowEditEvent event){
		Produto produto = ((Produto) event.getObject());
		produtoDAO.alterar(produto);
		produtos = produtoDAO.getAllProdutos();
	}
	
	public void remover(Produto produto){
		produtoDAO.remover(produto);
		produtos = produtoDAO.getAllProdutos();
	}
	
	public List<Produto> getListaProd(){
		if(produtos == null)
			produtos = produtoDAO.getAllProdutos();
		
		return produtos;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String salvar() {
		produtoDAO.salvar(produto);
		produtos = produtoDAO.getAllProdutos();
		produto = new Produto();
		return "";
	}
}
