package com.denizturkmen.Client;

import java.util.Date;

import org.hibernate.Session;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class SaveEmployeeTest {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			session.beginTransaction();
			
			Employee employee = new Employee();
			employee.setEmployeeName("Deniz TÜRKMEN");
			employee.setEmail("turkmen@gmail.com");
			employee.setSalary(45644D);
			employee.setDoj(new Date());
			
			
			Employee employee1 = new Employee();
			employee1.setEmployeeName("Eren TÜRKMEN");
			employee1.setEmail("eren@gmail.com");
			employee1.setSalary(200D);
			employee1.setDoj(new Date());

			Employee employee2 = new Employee();
			employee2.setEmployeeName("Ali Mali");
			employee2.setEmail("alimali@gmail.com");
			employee2.setSalary(1000D);
			employee2.setDoj(new Date());
			
			Employee employee3 = new Employee();
			employee3.setEmployeeName("Besra TÜRKMEN");
			employee3.setEmail("besra@gmail.com");
			employee3.setSalary(25000D);
			employee3.setDoj(new Date());
			
			session.save(employee);
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			
			session.getTransaction().commit();
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
