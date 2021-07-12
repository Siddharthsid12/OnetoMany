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
		
		Project ilt = new Project();
		ilt.setName("Cloud Computing");
		ilt.setDuration(2);
		
		
		Employee employee = new Employee();
		employee.setName("Siddharth");
		
		employee.getProjects().add(jeeTraining);
		employee.getProjects().add(ilt);
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(jeeTraining);
		entityManager.persist(ilt);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
