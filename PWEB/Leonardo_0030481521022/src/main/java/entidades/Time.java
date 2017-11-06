package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Time {
	@Id
	private String nome;
	private String estadio;
	private int numJogadores;
	private String divisao;
	private String campeonato;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public int getNumJogadores() {
		return numJogadores;
	}
	public void setNumJogadores(int numJogadores) {
		this.numJogadores = numJogadores;
	}
	public String getDivisao() {
		return divisao;
	}
	public void setDivisao(String divisao) {
		this.divisao = divisao;
	}
	public String getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}
	
	@Override
	public String toString(){
		return "Time [nome=" + nome + ", estadio=" + estadio + ", numJogadores=" + numJogadores + ", divisao=" + divisao + ", campeonato=" + campeonato + "]";
	}
}
