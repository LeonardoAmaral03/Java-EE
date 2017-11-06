package managedbeans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Carro;

@ManagedBean
@SessionScoped
public class CarroMB {
	private Carro carro = new Carro();
	private ArrayList<Carro> listaCarro = new ArrayList<Carro>();
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public ArrayList<Carro> getListaCarro() {
		return listaCarro;
	}
	public void setListaCarro(ArrayList<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}
	
	public String salvar(){
		listaCarro.add(carro);
		carro = new Carro();
		return "";
	}
	
	public void remover(Carro carro){
		listaCarro.remove(carro);
	}
}
