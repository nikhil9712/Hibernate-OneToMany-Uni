package Controller;
import OneToMany_dao.Company_dao;
import OneToMany_dto.Company;
import java.util.ArrayList;
import java.util.List;

import OneToMany_dao.Company_dao;
import OneToMany_dto.Company;
import OneToMany_dto.Employee;

public class MainController {

	public static void main(String[] args) {
		
		
		Employee e1=new Employee();
		e1.setId(1); //id is sent when we update employee id
		e1.setName("Anshul1");
		e1.setAddress("Amemdabad");
		e1.setPhone(9945698547l);
	//	System.out.println(e1);
		
		Employee e2=new Employee();
		e1.setId(2);
		e2.setName("Anshul2");
		e2.setAddress("Amemdabad");
		e2.setPhone(8862469713l);
		
		Employee e3=new Employee();
		e1.setId(3);
		e3.setName("Anshul3");
		e3.setAddress("Amemdabad");
		e3.setPhone(9878754868l);
		
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
	//	System.out.println(employees);
		
		Company company2=new Company();
		company2.setName("Microsoft");
		company2.setGst("MKL578");
		company2.setEmployee(employees);
		
		Company_dao cdao=new Company_dao();
		//cdao.saveCompany(company2);
		
		cdao.getCompany(1);
		cdao.getCompany(1);
		
		//cdao.getaAllComapny();
		//cdao.deleteCompany(3);
		
		//cdao.updateEmployeeCompany(1,company2);
		
	}
}
