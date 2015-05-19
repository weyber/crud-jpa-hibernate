package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dao.ICarDao;
import dao.ModelDao;
import model.Car;
import model.Model;

@ManagedBean(name="updateBean")
@ViewScoped
public class UpdateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Car carUpdate;
	
	private Model modelUpdate;
	
	private ICarDao modelDao;

	@ManagedProperty(value="#{listBean}")
	private ListBean listBean;
	
	public void setListBean(ListBean listBean) {
		this.listBean = listBean;
	}
	
	/* Constructor */
	public UpdateBean() {
		carUpdate = new Car();
		modelUpdate = new Model();
		modelDao = new ModelDao();
	}
	
	public void search(Long id, Long id2) {
		for (Car car : listBean.getCars()) {
			if(car.getId().equals(id)) {
				this.carUpdate = car;
				break;
			}
		}
	
		for (Model model : this.carUpdate.getModels()) {
			if(model.getId().equals(id2)) {
				this.modelUpdate = model;
				break;
			}
		}
	
	}
	
	public String update() {
		modelDao.update(this.carUpdate);
		return "index?faces-redirect=true";
	}
	
	/* Gets and Sets */
	public Car getCarUpdate() {
		return carUpdate;
	}

	public Model getModelUpdate() {
		return modelUpdate;
	}
}
