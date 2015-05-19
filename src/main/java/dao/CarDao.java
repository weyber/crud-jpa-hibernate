package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import JPA.JPAUtil;
import model.Car;

public class CarDao implements Serializable, ICarDao {
    private static final long serialVersionUID = 1L;

    /* Insert */
    @Override
    public void insert(Object object){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }catch (Throwable exception ) {
            System.out.println(exception.getMessage());
        }finally {
            em.close();
        }
    }

    /* UPDATE */
    public void update(Object object) {
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        }catch (Throwable exception ) {
            System.out.println(exception.getMessage());
        }finally {
            em.close();
        }
    }

    /* DELETE */
    public void delete(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        Car car = em.find(Car.class, id);

        try {
            em.getTransaction().begin();
            em.remove(car);
            em.getTransaction().commit();
        }catch (Throwable exception) {
            System.out.println(exception.getMessage());
        }finally {
            em.close();
        }
    }

    /* SELECT */
    public Car select(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        Car car = null;
        try{
            car =  em.find(Car.class, id);
        }catch (Throwable exception ) {
            System.out.println(exception.getMessage());
        }finally {
            em.close();
        }
        return car;
    }

    public List<Car> select() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Car> query;
        List<Car> cars = null;

        try {
            query = em.createNamedQuery("findAll", Car.class);
            cars = query.getResultList(); 
        }catch (Throwable exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            em.close();
        }
        return cars;
    }

    public List<Car> select(String brand) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Car> query;
        List<Car> cars = null;

        try {
            query = em.createNamedQuery("findByBrand", Car.class);
            query.setParameter("brand", "%" + brand + "%");
            cars = query.getResultList();
        }catch (Throwable exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            em.close();
        }
        return cars;
    }
}
