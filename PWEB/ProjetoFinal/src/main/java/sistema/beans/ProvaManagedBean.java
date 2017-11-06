package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.ProvaDataModel;
//import sistema.modelos.Pergunta;
import sistema.modelos.PerguntaProva;
import sistema.modelos.Prova;
import sistema.service.ProvaService;

@ManagedBean
@ViewScoped
public class ProvaManagedBean {
	
	private Prova prova = new Prova();
	private Prova provaSelecionada;
	private ProvaService servico = new ProvaService();
	private List<Prova> provas;
	
	public Prova getProva() {
		return prova;
	}
	public void setProva(Prova prova) {
		this.prova = prova;
	}
	public Prova getProvaSelecionada() {
		return provaSelecionada;
	}
	public void setProvaSelecionada(Prova provaSelecionada) {
		this.provaSelecionada = provaSelecionada;
	}
	
	public void salvar()
	{
		servico.salvar(prova);
		
		if(provas != null)
			provas.add(prova);
		
		
		prova = new Prova();
	}
	
	public DataModel<Prova> getProvas() {
		if(provas == null)
			provas = servico.getProvas();
		
		return new ProvaDataModel(provas);
	}
	
	public void remove(Prova prova) {
		if(servico.pesquisarPerguntasProva(prova).size() > 0)
		{
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover prova","Prova tem perguntas!"));
		}
		else
		{
			servico.remover(prova);
			provas.remove(prova);
		}
	}
	
	public List <PerguntaProva> getPerguntasProva() {
		if(provaSelecionada != null)
		{
			return servico.pesquisarPerguntasProva(provaSelecionada);
		}
		else
			return null;
	}
	
	public void onRowEdit(RowEditEvent event) {
		Prova p = ((Prova) event.getObject());
		servico.alterar(p);
	}
	
}
