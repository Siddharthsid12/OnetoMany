package com.cg.jpainitialsetup.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.cg.jpainitialsetup.domain.Employee;
import com.cg.jpainitialsetup.domain.Project;

public class InsertDemo {

	public static void main(String[] args) {
		
		Project jeeTraining = new Project();
		jeeTraining.setName("JEE Training");
		jeeTraining.setDuration(3);
		
		
		
		Employee employee = new Employee();
		employee.setName("Siddharth");
		employee.setProject(jeeTraining);
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(jeeTraining);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
