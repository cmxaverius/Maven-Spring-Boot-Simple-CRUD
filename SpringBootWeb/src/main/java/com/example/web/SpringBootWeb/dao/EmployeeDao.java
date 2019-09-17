package com.example.web.SpringBootWeb.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.web.SpringBootWeb.model.Employee;
import com.example.web.SpringBootWeb.service.EmployeeService;

@Service
public class EmployeeDao implements EmployeeService{

	private EntityManagerFactory emf;
	
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Employee> listEmployee() {
		EntityManager em = emf.createEntityManager();
		//menggunakan nama tabel sesuai dengan di generate object / class 
		return em.createQuery("FROM Employee", Employee.class).getResultList();
	}

	@Override
	public Employee EmployeeSaveUpdate(Employee employee) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee saved = em.merge(employee);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Employee getIdEmployee(Integer id) {
		EntityManager em = emf.createEntityManager();
		//Method untuk mencari ID di class mahasiswa
		return em.find(Employee.class, id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Employee.class, id));
		em.getTransaction().commit();
	}	
}
