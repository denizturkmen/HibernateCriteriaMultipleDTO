package com.denizturkmen.Client;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.denizturkmen.Dto.EmployeeDTO;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class CriteriaQueryDTOTest {

	public static void main(String[] args) {
		
		List<EmployeeDTO> employees = getEmployees();
		for (EmployeeDTO employeeDTO : employees) {
			System.out.println(employeeDTO.getEmployeeName()+"\t"+employeeDTO.getSalary()+"\t"+employeeDTO.getSalary());
		}
	}

	private static List<EmployeeDTO> getEmployees() {
		List<EmployeeDTO> resultList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
		    CriteriaQuery<EmployeeDTO> criteriaQuery = builder.createQuery(EmployeeDTO.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			
			
			Path<Object> employeeNamePath = root.get("employeeName");
			Path<Object> emailPath = root.get("email");
			Path<Object> salaryPath = root.get("salary");
			
			criteriaQuery.select(builder.construct(EmployeeDTO.class, employeeNamePath,emailPath,salaryPath));
			
			
			Query<EmployeeDTO> query = session.createQuery(criteriaQuery);
			//List<EmployeeDTO> list = query.list();
			 resultList = query.getResultList();
		} 
		
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

}

