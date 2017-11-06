package managedbean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Produto;

@ManagedBean
@SessionScoped
public class ProdutoMB {
	private Produto produto = new Produto();
	private ArrayList<Produto> listaProd = new ArrayList<Produto>();
	private double valTotVenda;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ArrayList<Produto> getListaProd() {
		return listaProd;
	}
	public void setListaProd(ArrayList<Produto> listaProd) {
		this.listaProd = listaProd;
	}
	
	public double getValTotVenda() {
		return valTotVenda;
	}
	public void setValTotVenda(double valTotVenda) {
		this.valTotVenda = valTotVenda;
	}
	
	public String salvar(){
		produto.valTotalItem();
		valTotVenda += produto.getValTotItem();
		listaProd.add(produto);
		produto = new Produto();
		return "";
	}
	
	public String limpar(){
		listaProd.clear();
		valTotVenda = 0;
		produto = new Produto();
		return "";
	}
}
