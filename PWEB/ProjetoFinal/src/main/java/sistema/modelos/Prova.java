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
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Prova implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private Date dataCriacao, dataAplic;
	//private ArrayList<Date> datasAplic = new ArrayList<Date>();
	private int dificuldade, tempoMinuto, qntPerguntas;
	
	@OneToMany(mappedBy="prova")
	private List<PerguntaProva> perguntas_prova = new ArrayList<PerguntaProva>();
	
	//@ManyToMany(cascade=CascadeType.ALL,mappedBy="provas_alternativa")
	//private Collection<Alternativa> exercicios_alternativa = new ArrayList<Alternativa>();
	
	//@ManyToMany(cascade=CascadeType.ALL,mappedBy="provas_dissertativa")
	//private Collection<Dissertativa> exercicios_dissertativa = new ArrayList<Dissertativa>();
	
	//@ManyToMany(cascade=CascadeType.ALL,mappedBy="provas_verdadeiro_falso")
	//private Collection<VerdadeiroFalso> exercicios_verdadeiro_falso = new ArrayList<VerdadeiroFalso>();

	public Prova() {
		super();
	}

	public Prova(long id, Date dataCriacao, Date dataAplic, int dificuldade, int tempoMinuto, int qntPerguntas) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.dataAplic = dataAplic;
		this.dificuldade = dificuldade;
		this.tempoMinuto = tempoMinuto;
		this.qntPerguntas = qntPerguntas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAplic() {
		return dataAplic;
	}

	public void setDataAplic(Date dataAplic) {
		this.dataAplic = dataAplic;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public int getTempoMinuto() {
		return tempoMinuto;
	}

	public void setTempoMinuto(int tempoMinuto) {
		this.tempoMinuto = tempoMinuto;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getQntPerguntas() {
		return qntPerguntas;
	}

	public void setQntPerguntas(int qntPerguntas) {
		this.qntPerguntas = qntPerguntas;
	}

	/*public Collection<Alternativa> getExercicios_alternativa() {
		return exercicios_alternativa;
	}

	public void setExercicios_alternativa(Collection<Alternativa> exercicios_alternativa) {
		this.exercicios_alternativa = exercicios_alternativa;
	}

	public Collection<Dissertativa> getExercicios_dissertativa() {
		return exercicios_dissertativa;
	}

	public void setExercicios_dissertativa(Collection<Dissertativa> exercicios_dissertativa) {
		this.exercicios_dissertativa = exercicios_dissertativa;
	}

	public Collection<VerdadeiroFalso> getExercicios_verdadeiro_falso() {
		return exercicios_verdadeiro_falso;
	}

	public void setExercicios_verdadeiro_falso(Collection<VerdadeiroFalso> exercicios_verdadeiro_falso) {
		this.exercicios_verdadeiro_falso = exercicios_verdadeiro_falso;
	}
	
	public void addExercicioDissertativa(Dissertativa dissertativa) {
		exercicios_dissertativa.add(dissertativa);
	}
	
	public void addExercicioAlternativa(Alternativa alternativa) {
		exercicios_alternativa.add(alternativa);
	}
	
	public void addExercicioVerdadeiroFalso(VerdadeiroFalso verdadeiroFalso) {
		exercicios_verdadeiro_falso.add(verdadeiroFalso);
	}*/
	
	public void addPerguntaProva(PerguntaProva perguntaProva) {
		perguntas_prova.add(perguntaProva);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<PerguntaProva> getPerguntas_prova() {
		return perguntas_prova;
	}

	public void setPerguntas_prova(List<PerguntaProva> perguntas_prova) {
		this.perguntas_prova = perguntas_prova;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAplic == null) ? 0 : dataAplic.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + dificuldade;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + qntPerguntas;
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
		Prova other = (Prova) obj;
		if (dataAplic == null) {
			if (other.dataAplic != null)
				return false;
		} else if (!dataAplic.equals(other.dataAplic))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dificuldade != other.dificuldade)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qntPerguntas != other.qntPerguntas)
			return false;
		if (tempoMinuto != other.tempoMinuto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prova [id=" + id + ", nome=" + nome + ", dataCriacao=" + dataCriacao + ", dataAplic=" + dataAplic
				+ ", dificuldade=" + dificuldade + ", tempoMinuto=" + tempoMinuto + ", qntPerguntas=" + qntPerguntas
				+ "]";
	}
	
}
