package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade {
	@Id
	private String nome;
	private int qtdPopulacional;
	private String estado;
	private String pais;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdPopulacional() {
		return qtdPopulacional;
	}
	public void setQtdPopulacional(int qtdPopulacional) {
		this.qtdPopulacional = qtdPopulacional;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString(){
		return "Cidade [nome=" + nome + ", qtdPopulacional=" + qtdPopulacional + ", estado=" + estado + ", pais=" + pais + "]";
	}
}
