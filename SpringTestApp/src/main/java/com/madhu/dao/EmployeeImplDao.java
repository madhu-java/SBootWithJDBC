package com.madhu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhu.model.Employee;
@Repository(value="empdao")
public class EmployeeImplDao implements IEmployeeDao {
	
	private static final String SQL_SELECT_QUERY2 = "select eid,ename,eaddr,esal from employee";
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		System.out.println("from get all emps...");
		
		List<Employee> empList=null;
		
		try(Connection connection = dataSource.getConnection();
				PreparedStatement pstmt=connection.prepareStatement(SQL_SELECT_QUERY2);
					ResultSet resultSet= pstmt.executeQuery();	){
			empList= new ArrayList<>()	;
			
			while(resultSet.next()) {
				Employee emp = new Employee();
				emp.setEid(resultSet.getInt(1));
				emp.setEname(resultSet.getNString(2));
				emp.setEsal(resultSet.getInt(4));
				emp.setEaddr(resultSet.getString(3));
				empList.add(emp);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}

}
