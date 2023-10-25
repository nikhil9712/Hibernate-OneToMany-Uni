package OneToMany_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToMany_dto.Company;
import OneToMany_dto.Employee;

public class Company_dao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("Nikhil").createEntityManager();
	}

	public void saveCompany(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		System.out.println(company.getEmployee());
		entityTransaction.begin();
		List<Employee> employees = company.getEmployee();
		
		for (Employee employee : employees) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void getCompany(int companyid)
	{
		EntityManager entityManager = getEntityManager();
		
		
		Company c=entityManager.find(Company.class, companyid);
		System.out.println(c);
	}
	
	
	
	public void getaAllComapny()
	{
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("SELECT c FROM Company c");
		System.out.println(query.getResultList());
	}
	public void deleteCompany(int companyId)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Company company=entityManager.find(Company.class, companyId);
		
		entityTransaction.begin();
		List<Employee> employees=company.getEmployee();
			for(Employee employee:employees)
				{
					entityManager.remove(employee);
				}
			entityManager.remove(company);
		entityTransaction.commit();
	}
	
	public void updateCompany(int companyId,Company c) //company update only thogh i set employee in updated company i havent merge employee
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Company dbcompany=entityManager.find(Company.class, companyId); //return entity object
		
		
		if (dbcompany!=null) {
			entityTransaction.begin();
			c.setId(companyId);
			c.setEmployee(dbcompany.getEmployee());
			entityManager.merge(c);
			entityTransaction.commit();
			
		}
		else
		{
			System.out.println("No company found with given company id");
		}
		
		
	}
	
	public void updateEmployeeCompany(int companyid,Company c)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Company dbCompany=entityManager.find(Company.class, companyid);
		
		if (dbCompany!=null) {
			
			entityTransaction.begin();
			c.setId(companyid);
			
			List<Employee>employees=dbCompany.getEmployee();
			for (Employee employee : employees) {
				entityManager.merge(employee);
			}
			entityManager.merge(c);
			entityTransaction.commit();
		}
		
		else {
          System.out.println("company with given id does not exist !!");
		}
		
	}
	
	
	
	
}
