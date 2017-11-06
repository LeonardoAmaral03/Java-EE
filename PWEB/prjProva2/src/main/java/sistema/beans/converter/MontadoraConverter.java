package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Montadora;
import sistema.service.MontadoraService;

@FacesConverter("converterMontadora")
public class MontadoraConverter implements Converter {
	
	private MontadoraService servico = new MontadoraService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			
			  for(Montadora m : servico.getMontadoras())
				 if(m.getNome().equals(value))
				  	return m;		
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object montadora) {
		if (montadora == null || montadora.equals("")) {
			return null;
		} else {
			return ((Montadora) montadora).getNome();
		}
	}
	
}
