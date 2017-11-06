package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conteudo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private int cargaHoraria;
		
	@ManyToOne
	/*@JoinTable(name="TBL_DISCIPLINA_CONTEUDO",
			inverseJoinColumns=@JoinColumn(name="disciplina_id"),
					joinColumns=@JoinColumn(name="conteudo_id"))*/
	private Disciplina disciplina;
	
	@OneToMany(mappedBy="conteudo")
	private  List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	// DISSERTATIVA
	//@ManyToMany(cascade=CascadeType.ALL, mappedBy="conteudos")
	/*@JoinTable(
    		name="TBL_CONTEUDO_DISSERTATIVA",
    		joinColumns              = @JoinColumn(name ="conteudo_id"),
    		inverseJoinColumns       = @JoinColumn(name ="dissertativa_id") 
  	)*/
	//private  Collection<Dissertativa> dissertativas = new ArrayList<Dissertativa>();	
	
	
	// ALTERNATIVA
	//@ManyToMany(cascade=CascadeType.ALL, mappedBy="conteudos")
	/*@JoinTable(
    		name="TBL_CONTEUDO_ALTERNATIVA",
    		joinColumns              = @JoinColumn(name ="conteudo_id"),
    		inverseJoinColumns       = @JoinColumn(name ="alternativa_id") 
  	)*/
	//private  Collection<Alternativa> alternativas = new ArrayList<Alternativa>();
	
	
	// VDD E FALSO
	//@ManyToMany(cascade=CascadeType.ALL, mappedBy="conteudos")
	/*@JoinTable(
    		name="TBL_CONTEUDO_VERDADEIRO_FALSO",
    		joinColumns              = @JoinColumn(name ="conteudo_id"),
    		inverseJoinColumns       = @JoinColumn(name ="verdadeirofalso_id") 
  	)*/
	//private  Collection<VerdadeiroFalso> verdadeirofalsos = new ArrayList<VerdadeiroFalso>();
		
	public Conteudo() {
		super();
	}
	
	public Conteudo(long id, String nome, int cargaHoraria) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
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
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*public Collection<Dissertativa> getDissertativas() {
		return dissertativas;
	}

	public void setDissertativas(Collection<Dissertativa> dissertativas) {
		this.dissertativas = dissertativas;
	}

	public Collection<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Collection<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Collection<VerdadeiroFalso> getVerdadeirofalsos() {
		return verdadeirofalsos;
	}

	public void setVerdadeirofalsos(Collection<VerdadeiroFalso> verdadeirofalsos) {
		this.verdadeirofalsos = verdadeirofalsos;
	}
	
	public void addDissertativa(Dissertativa dissertativa) {
		dissertativas.add(dissertativa);
	}
	
	public void addAlternativa(Alternativa alternativa) {
		alternativas.add(alternativa);
	}
	
	public void addVerdadeiroFalso(VerdadeiroFalso verdadeiroFalso) {
		verdadeirofalsos.add(verdadeiroFalso);
	}*/

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	public void addPergunta(Pergunta pergunta) {
		perguntas.add(pergunta);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cargaHoraria;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Conteudo other = (Conteudo) obj;
		if (cargaHoraria != other.cargaHoraria)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conteudo [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + "]";
	}
	
}
