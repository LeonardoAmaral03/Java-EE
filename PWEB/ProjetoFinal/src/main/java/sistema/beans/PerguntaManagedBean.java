package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.PerguntaDataModel;
import sistema.modelos.Conteudo;
import sistema.modelos.Pergunta;
import sistema.modelos.PerguntaProva;
//import sistema.modelos.Prova;
import sistema.service.ConteudoService;
import sistema.service.PerguntaService;

@ManagedBean(name="perguntaManagedBean")
@ViewScoped
public class PerguntaManagedBean {
	
	private Pergunta pergunta = new Pergunta();
	private Pergunta perguntaSelecionada;
	private Conteudo conteudo;
	private PerguntaService servico = new PerguntaService();
	private ConteudoService contServico = new ConteudoService();
	private List<Pergunta> perguntas;
	
	public Conteudo getConteudo() {
		return conteudo;
	}
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	
	public List<Conteudo> getConteudos() {
		return contServico.getConteudos();
	}
	
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public Pergunta getPerguntaSelecionada() {
		return perguntaSelecionada;
	}
	public void setPerguntaSelecionada(Pergunta perguntaSelecionada) {
		this.perguntaSelecionada = perguntaSelecionada;
	}
	
	public void salvar()
	{
		conteudo.addPergunta(pergunta);
		pergunta.setConteudo(conteudo);
		
		perguntas.add(pergunta);
		servico.salvar(pergunta);
		
		pergunta = new Pergunta();
		conteudo = null;
	}
	
	public DataModel<Pergunta> getPerguntas() {
		if(perguntas == null)
			perguntas = servico.getPerguntas();
		
		return new PerguntaDataModel(perguntas);
	}
	
	public void remove(Pergunta pergunta) {
		if(servico.pesquisarPerguntasProva(pergunta).size() > 0)
		{
		   FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover pergunta","Pergunta esta em provas!"));
		}
		else
		{
			servico.remover(pergunta);
			perguntas.remove(pergunta);
		}
	}
	
	public List <PerguntaProva> getPerguntasProva() {
		if(perguntaSelecionada != null)
		{
			return servico.pesquisarPerguntasProva(perguntaSelecionada);
		}
		else
			return null;
	}
	
	public void onRowEdit(RowEditEvent event) {
		Pergunta p = ((Pergunta) event.getObject());
		servico.alterar(p);
	}
	
}
