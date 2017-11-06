package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.Montadora;
import sistema.service.MontadoraService;

public class MontadoraDataModel extends ListDataModel<Montadora> implements SelectableDataModel<Montadora>{
	
	private MontadoraService servico = new MontadoraService();
	
	public MontadoraDataModel() {
		
	}
	
	public MontadoraDataModel(List<Montadora> list) {
		super(list);
	}
	
	@Override
	public Montadora getRowData(String rowKey) {
		for(Montadora m: servico.getMontadoras())
			if(Integer.parseInt(rowKey) == m.getCodigo())
				return m;
		
		return null;
	}
	
	@Override
	public Object getRowKey(Montadora montadora) {
		return montadora.getCodigo();
	}
	
}
