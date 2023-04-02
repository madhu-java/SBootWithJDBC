package com.madhu;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.madhu.dao.IEmployeeDao;
import com.madhu.model.Employee;

@SpringBootApplication
public class SpringTestAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringTestAppApplication.class, args);
	   
		IEmployeeDao empDao = context.getBean(IEmployeeDao.class);
		System.out.println(empDao.getClass().getName());
		List<Employee> empList =empDao.getAllEmployees();
		empList.forEach(System.out::println);
		
		System.out.println(empDao.getAllEmployees());
		((ConfigurableApplicationContext) context).close();
	
	}

}
