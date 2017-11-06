package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Date;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pergunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int tempoMinuto, dificuldade;
	private String enunciado, resposta;
	private Date dataCriacao;
	
	@ManyToOne		//(cascade=CascadeType.ALL)
	/*@JoinTable(
			name="TBL_CONTEUDO_PERGUNTA",
    		joinColumns              = @JoinColumn(name ="pergunta_id"),
    		inverseJoinColumns       = @JoinColumn(name ="conteudo_id")
	)*/
	private Conteudo conteudo;
	
	
	@OneToMany(mappedBy="pergunta")		//(cascade=CascadeType.ALL)
	/*@JoinTable(
    		name="TBL_PERGUNTA_PROVA",
    		joinColumns              = @JoinColumn(name ="pergunta_id"),
    		inverseJoinColumns       = @JoinColumn(name ="prova_id") 
  	)*/
	private  List<PerguntaProva> perguntas_prova = new ArrayList<PerguntaProva>();

	public Pergunta() {
		super();
	}

	public Pergunta(long id, int tempoMinuto, int dificuldade, String enunciado, String resposta, Date dataCriacao) {
		super();
		this.id = id;
		this.tempoMinuto = tempoMinuto;
		this.dificuldade = dificuldade;
		this.enunciado = enunciado;
		this.resposta = resposta;
		this.dataCriacao = dataCriacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTempoMinuto() {
		return tempoMinuto;
	}

	public void setTempoMinuto(int tempoMinuto) {
		this.tempoMinuto = tempoMinuto;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public List<PerguntaProva> getPerguntas_prova() {
		return perguntas_prova;
	}

	public void setPerguntas_prova(List<PerguntaProva> perguntas_prova) {
		this.perguntas_prova = perguntas_prova;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void addPerguntaProva(PerguntaProva perguntaProva) {
		perguntas_prova.add(perguntaProva);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + dificuldade;
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((resposta == null) ? 0 : resposta.hashCode());
		result = prime * result + tempoMinuto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dificuldade != other.dificuldade)
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (id != other.id)
			return false;
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equals(other.resposta))
			return false;
		if (tempoMinuto != other.tempoMinuto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pergunta [id=" + id + ", tempoMinuto=" + tempoMinuto + ", dificuldade=" + dificuldade + ", enunciado="
				+ enunciado + ", resposta=" + resposta + ", dataCriacao=" + dataCriacao + "]";
	}
	
}
