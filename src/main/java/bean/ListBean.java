package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Car;
import dao.CarDao;
import dao.ICarDao;

@ManagedBean(name="listBean")
@SessionScoped 
public class ListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	private ICarDao carDao;

	private String pesquisar;
	
	private boolean bool;
	
	@PostConstruct
	public void init(){
		carDao = new CarDao();
		read();
		bool = false;
	}

	public void read() {
		cars = carDao.select();	
	}

	public void read2() {
		cars = carDao.select(getPesquisar());
		pesquisar = null;
		bool = true;
	}

	public void read3() {
		if(bool){
			cars = carDao.select();
			bool = false;
		}
	}
	
	/* Gets and Sets */
	public String getPesquisar() {
		return pesquisar;
	}

	public void setPesquisar(String pesquisar) {
		this.pesquisar = pesquisar;
	}

	public List<Car> getCars() {
		return cars;
	}	
}
