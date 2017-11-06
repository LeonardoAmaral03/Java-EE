package managedbeans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Aluno;

@ManagedBean
@SessionScoped
public class AlunoMB {
	private Aluno aluno = new Aluno();
	private ArrayList <Aluno> listaAlu = new ArrayList<Aluno>();
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public ArrayList<Aluno> getListaAlu() {
		return listaAlu;
	}
	public void setListaAlu(ArrayList<Aluno> listaAlu) {
		this.listaAlu = listaAlu;
	}
	
	public String salvar(){
		listaAlu.add(aluno);
		aluno = new Aluno();
		return "";
	}
}
