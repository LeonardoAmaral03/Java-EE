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
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome, faculdade, curso;
	private int cargaHoraria;
		
	@OneToMany(mappedBy="disciplina")  //(cascade=CascadeType.ALL, mappedBy="disciplina")
	/*@JoinTable(
    		name="TBL_DISCIPLINA_CONTEUDO",
    		joinColumns              = @JoinColumn(name ="disciplina_id"),
    		inverseJoinColumns       = @JoinColumn(name ="conteudo_id") 
  	)*/
	private  List<Conteudo> conteudos = new ArrayList<Conteudo>();

	public Disciplina(long id, String nome, String faculdade, String curso, int cargaHoraria) {
		super();
		this.id = id;
		this.nome = nome;
		this.faculdade = faculdade;
		this.curso = curso;
		this.cargaHoraria = cargaHoraria;
	}
	
	public Disciplina() {
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

	public String getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	/*public static long getSerialversionuid() {
		return serialVersionUID;
	}*/		
	
	public void addConteudo(Conteudo conteudo) {
		conteudos.add(conteudo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cargaHoraria;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((faculdade == null) ? 0 : faculdade.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (cargaHoraria != other.cargaHoraria)
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (faculdade == null) {
			if (other.faculdade != null)
				return false;
		} else if (!faculdade.equals(other.faculdade))
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
		return "Disciplina [id=" + id + ", nome=" + nome + ", faculdade=" + faculdade + ", curso=" + curso
				+ ", cargaHoraria=" + cargaHoraria + "]";
	}
	
}
