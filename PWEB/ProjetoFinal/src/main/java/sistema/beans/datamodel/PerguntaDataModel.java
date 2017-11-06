package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.Pergunta;
import sistema.service.PerguntaService;

public class PerguntaDataModel extends ListDataModel<Pergunta> implements SelectableDataModel<Pergunta>{
	
	private PerguntaService servico = new PerguntaService();
	
	public PerguntaDataModel() {
		
	}
	
	public PerguntaDataModel(List<Pergunta> list) {
		super(list);
	}
	
	@Override
	public Pergunta getRowData(String rowKey) {
		for(Pergunta p: servico.getPerguntas())
			if(Integer.parseInt(rowKey) == p.getId())
				return p;
		
		return null;
	}
	
	@Override
	public Object getRowKey(Pergunta pergunta) {
		return pergunta.getId();
	}
	
}
