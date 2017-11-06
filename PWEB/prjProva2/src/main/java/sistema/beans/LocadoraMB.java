package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.LocadoraDataModel;
import sistema.modelos.Carro;
import sistema.modelos.Locadora;
import sistema.service.LocadoraService;

@ManagedBean
@ViewScoped
public class LocadoraMB {
	
	private Locadora locadora = new Locadora();
	private Locadora locadoraSelecionada;
	private LocadoraService servico = new LocadoraService();
	private List<Locadora> locadoras;
	
	public Locadora getLocadoraSelecionada() {
		return locadoraSelecionada;
	}

	public void setLocadoraSelecionada(Locadora locadoraSelecionada) {
		this.locadoraSelecionada = locadoraSelecionada;
	}
	
	public void salvar()
	{
		servico.salvar(locadora);
		
		if(locadoras != null)
			locadoras.add(locadora);
		
		
		locadora = new Locadora();
	}
	
	public DataModel<Locadora> getLocadoras() {
		if(locadoras == null)
			locadoras = servico.getLocadoras();
		
		return new LocadoraDataModel(locadoras);
	}

	public Locadora getLocadora() {
		return locadora;
	}
	
	public void remove(Locadora locadora) {
		if(servico.pesquisarCarrosLocadora(locadora).size() > 0)
		{
		   FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover locadora","Locadora possui carros!"));
		}
		else
		{
			servico.remover(locadora);
			locadoras.remove(locadora);
		}
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}
	
	public List <Carro> getCarrosLocadora() {
		if(locadoraSelecionada != null)
		{
			return servico.pesquisarCarrosLocadora(locadoraSelecionada);
		}
		else
			return null;
	}
	
	public void onRowEdit(RowEditEvent event) {

		Locadora l = ((Locadora) event.getObject());
		servico.alterar(l);
	}
	
}
