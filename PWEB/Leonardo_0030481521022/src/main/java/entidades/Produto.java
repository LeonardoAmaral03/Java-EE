package entidades;

public class Produto {
	private String descricao;
	private double valUnitario;
	private double quantidade;
	private double valTotItem;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValUnitario() {
		return valUnitario;
	}
	public void setValUnitario(double valUnitario) {
		this.valUnitario = valUnitario;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public void valTotalItem() {
		valTotItem = quantidade * valUnitario;
	}
	
	public double getValTotItem() {
		return valTotItem;
	}
	public void setValTotItem(double valTotItem) {
		this.valTotItem = valTotItem;
	}
	
}
