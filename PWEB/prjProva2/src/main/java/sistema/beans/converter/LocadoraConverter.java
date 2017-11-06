package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Locadora;
import sistema.service.LocadoraService;

@FacesConverter("converterLocadora")
public class LocadoraConverter implements Converter {
	
	private LocadoraService servico = new LocadoraService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			
			  for(Locadora l : servico.getLocadoras())
				 if(l.getNome().equals(value))
				  	return l;		
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object locadora) {
		if (locadora == null || locadora.equals("")) {
			return null;
		} else {
			return ((Locadora) locadora).getNome();
		}
	}
	
}
