package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Pergunta;
import sistema.modelos.PerguntaProva;
import sistema.modelos.Prova;
import sistema.service.PerguntaProvaService;
import sistema.service.PerguntaService;
import sistema.service.ProvaService;

@ManagedBean(name="perguntaProvaManagedBean")
@ViewScoped
public class PerguntaProvaManagedBean {
	
	private PerguntaProva perguntaProva = new PerguntaProva();
	private Pergunta pergunta;
	private Prova prova;
	private PerguntaProvaService servico = new PerguntaProvaService();
	private PerguntaService pergServico = new PerguntaService();
	private ProvaService provServico = new ProvaService();
	private List<PerguntaProva> perguntaProvas;
	
	public void salvar() {
		pergunta.addPerguntaProva(perguntaProva);
		perguntaProva.setPergunta(pergunta);
		
		prova.addPerguntaProva(perguntaProva);
		perguntaProva.setProva(prova);
		
		perguntaProvas.add(perguntaProva);
		servico.salvar(perguntaProva);
		
		perguntaProva = new PerguntaProva();
		pergunta = null;
		prova = null;
		
	}
	
	public List <Pergunta> getPerguntas() {
		return pergServico.getPerguntas();
	}
	
	public List <Prova> getProvas() {
		return provServico.getProvas();
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public PerguntaProva getPerguntaProva() {
		return perguntaProva;
	}

	public void setPerguntaProva(PerguntaProva perguntaProva) {
		this.perguntaProva = perguntaProva;
	}

	public List<PerguntaProva> getPerguntaProvas() {
		if(perguntaProvas == null)
			perguntaProvas = servico.getPerguntasProva();
		
		return perguntaProvas;
	}
	
	public void remove(PerguntaProva perguntaProva) {
		perguntaProvas.remove(perguntaProva);
		servico.remover(perguntaProva);
	}
	
	public void onRowEdit(RowEditEvent event) {
		PerguntaProva pp = ((PerguntaProva) event.getObject());
		servico.alterar(pp);
	}
	
}
