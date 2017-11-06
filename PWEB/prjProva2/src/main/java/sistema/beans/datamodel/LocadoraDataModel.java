package sistema.beans.datamodel;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Locadora;
import sistema.service.LocadoraService;

public class LocadoraDataModel extends ListDataModel<Locadora> implements SelectableDataModel<Locadora>{
	
	private LocadoraService servico = new LocadoraService();
	
	public LocadoraDataModel() {
		
	}
	
	public LocadoraDataModel(List<Locadora> list) {
		super(list);
	}
	
	@Override
	public Locadora getRowData(String rowKey) {
		for(Locadora l: servico.getLocadoras())
			if(Integer.parseInt(rowKey) == l.getCodigo())
				return l;
		
		return null;
	}
	
	@Override
	public Object getRowKey(Locadora locadora) {
		return locadora.getCodigo();
	}
	
}
