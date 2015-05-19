package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import model.Car;
import model.Model;
import dao.CarDao;
import dao.ICarDao;
import dao.ModelDao;

@ManagedBean(name = "carBean")
@ViewScoped
public class CarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Model model;

    private Car car;

    private ICarDao carDao;

    private ICarDao modelDao;

    @ManagedProperty(value = "#{listBean}")
    private ListBean listBean;
    
    public void setListBean(ListBean listBean) {
        this.listBean = listBean;
    }

    /** Constructor */
    public CarBean() {
        car = new Car();
        model = new Model();

        carDao = new CarDao();
        modelDao = new ModelDao();
    }

    public void search(Long id) {
        car = carDao.select(id);
        this.car.setBrand(null);
    }

    public String create2() {
        model.setCar(car);
        modelDao.insert(model);
        listBean.read();
        return "index?faces-redirect=true";
    }

    public String create() {
        carDao.insert(car);
        listBean.read();
        return "index?faces-redirect=true";
    }

    public void delete(Long id) {
        carDao.delete(id);
        listBean.read();
    }

    /** @return model */
    public Model getModel() {
        return model;
    }

    /** @return car */
    public Car getCar() {
        return car;
    }
}