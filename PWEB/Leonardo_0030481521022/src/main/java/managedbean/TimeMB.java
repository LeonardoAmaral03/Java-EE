package managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.TimeDAO;
import entidades.Time;

@ManagedBean
@SessionScoped
public class TimeMB {
	private Time time = new Time();
	private TimeDAO timeDAO = new TimeDAO();
	private List<Time> times;
	
	public List<Time> getListaTime(){
		if(times == null)
			times = timeDAO.getAllTimes();
		
		return times;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	public String salvar() {
		timeDAO.salvar(time);
		times = timeDAO.getAllTimes();
		time = new Time();
		return "";
	}
}
