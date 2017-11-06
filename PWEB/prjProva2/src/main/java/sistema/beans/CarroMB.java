package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Carro;
import sistema.modelos.Locadora;
import sistema.modelos.Montadora;
import sistema.service.CarroService;
import sistema.service.LocadoraService;
import sistema.service.MontadoraService;

@ManagedBean(name="carroMB")
@ViewScoped
public class CarroMB {
	
	private Carro carro = new Carro();
	private Locadora locadora;
	private Montadora montadora;
	private CarroService carService = new CarroService();
	private LocadoraService locService = new LocadoraService();
	private MontadoraService monService = new MontadoraService();
	private List<Carro> carros;
	
	public void salvar() {
		locadora.addCarro(carro);
		carro.setLocadora(locadora);
		
		montadora.addCarro(carro);
		carro.setMontadora(montadora);
		
		carros.add(carro);
		carService.salvar(carro);
		
		carro = new Carro();
		locadora = null;
		montadora = null;
		
	}
	
	public List <Locadora> getLocadoras() {
		return locService.getLocadoras();
	}
	
	public List <Montadora> getMontadoras() {
		return monService.getMontadoras();
	}

	public Locadora getLocadora() {
		return locadora;
	}

	public Montadora getMontadora() {
		return montadora;
	}
	
	public void remove(Carro carro) {
		carros.remove(carro);
		carService.remover(carro);
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public List<Carro> getCarros() {
		if(carros == null)
			carros = carService.getCarros();
		
		return carros;
	}
	
	public void onRowEdit(RowEditEvent event) {
		Carro c = ((Carro) event.getObject());
		carService.alterar(c);
	}
	
}
