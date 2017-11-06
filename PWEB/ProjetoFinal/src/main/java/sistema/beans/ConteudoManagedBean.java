package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.ConteudoDataModel;
import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;
import sistema.service.ConteudoService;
import sistema.service.DisciplinaService;

@ManagedBean(name="conteudoManagedBean")
@ViewScoped
public class ConteudoManagedBean {
	
	private Conteudo conteudo = new Conteudo();
	private Conteudo conteudoSelecionado;
	private Disciplina disciplina;
	private ConteudoService servico = new ConteudoService();
	private DisciplinaService discServico = new DisciplinaService();
	private List<Conteudo> conteudos;
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public List<Disciplina> getDisciplinas() {
		return discServico.getDisciplinas();
	}
	
	public Conteudo getConteudo() {
		return conteudo;
	}
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	public Conteudo getConteudoSelecionado() {
		return conteudoSelecionado;
	}
	public void setConteudoSelecionado(Conteudo conteudoSelecionado) {
		this.conteudoSelecionado = conteudoSelecionado;
	}
	
	public void salvar()
	{
		disciplina.addConteudo(conteudo);
		conteudo.setDisciplina(disciplina);
		
		conteudos.add(conteudo);
		servico.salvar(conteudo);
		
		conteudo = new Conteudo();
		disciplina = null;
	}
	
	public DataModel<Conteudo> getConteudos() {
		if(conteudos == null)
			conteudos = servico.getConteudos();
		
		return new ConteudoDataModel(conteudos);
	}
	
	public void remove(Conteudo conteudo) {
		if(servico.pesquisarPerguntasConteudo(conteudo).size() > 0)
		{
		   FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover conteudo","Conteudo possui perguntas!"));
		}
		else
		{
			servico.remover(conteudo);
			conteudos.remove(conteudo);
		}
	}
	
	public List <Pergunta> getPerguntasConteudo() {
		if(conteudoSelecionado != null)
		{
			return servico.pesquisarPerguntasConteudo(conteudoSelecionado);
		}
		else
			return null;
	}
	
	public void onRowEdit(RowEditEvent event) {
		Conteudo c = ((Conteudo) event.getObject());
		servico.alterar(c);
	}
	
}
