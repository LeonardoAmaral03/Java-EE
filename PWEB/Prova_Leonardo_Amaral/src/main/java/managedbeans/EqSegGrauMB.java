package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.EqSegGrau;

@ManagedBean
@SessionScoped
public class EqSegGrauMB {
	private EqSegGrau eqSegGrau = new EqSegGrau();

	public EqSegGrau getEqSegGrau() {
		return eqSegGrau;
	}

	public void setEqSegGrau(EqSegGrau eqSegGrau) {
		this.eqSegGrau = eqSegGrau;
	}
	
	public String calcular(){
		eqSegGrau.calcX1();
		eqSegGrau.calcX2();
		return "";
	}
}
