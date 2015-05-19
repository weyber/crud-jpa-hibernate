package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import JPA.JPAUtil;
import model.Car;

public class ModelDao implements Serializable, ICarDao {

	private static final long serialVersionUID = 1L;

	@Override
	public void insert(Object object) {
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

	@Override
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

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car select(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> select(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

}
