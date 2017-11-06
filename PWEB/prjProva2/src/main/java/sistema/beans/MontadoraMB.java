package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.MontadoraDataModel;
import sistema.modelos.Carro;
import sistema.modelos.Montadora;
import sistema.service.MontadoraService;

@ManagedBean
@ViewScoped
public class MontadoraMB {
	
	private Montadora montadora = new Montadora();
	private Montadora montadoraSelecionada;
	private MontadoraService servico = new MontadoraService();
	private List<Montadora> montadoras;
	
	public Montadora getMontadoraSelecionada() {
		return montadoraSelecionada;
	}
	public void setMontadoraSelecionada(Montadora montadoraSelecionada) {
		this.montadoraSelecionada = montadoraSelecionada;
	}
	
	public void salvar()
	{
		servico.salvar(montadora);
		
		if(montadoras != null)
			montadoras.add(montadora);
		
		
		montadora = new Montadora();
	}
	
	public DataModel<Montadora> getMontadoras() {
		if(montadoras == null)
			montadoras = servico.getMontadoras();
		
		return new MontadoraDataModel(montadoras);
	}
	
	public Montadora getMontadora() {
		return montadora;
	}
	
	public void remove(Montadora montadora) {
		if(servico.pesquisarCarrosMontadora(montadora).size() > 0)
		{
		   FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover montadora","Montadora possui carros!"));
		}
		else
		{
			servico.remover(montadora);
			montadoras.remove(montadora);
		}
	}
	
	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	
	public List <Carro> getCarrosMontadora() {
		if(montadoraSelecionada != null)
		{
			return servico.pesquisarCarrosMontadora(montadoraSelecionada);
		}
		else
			return null;
	}
	
	public void onRowEdit(RowEditEvent event) {

		Montadora m = ((Montadora) event.getObject());
		servico.alterar(m);
	}
	
}
