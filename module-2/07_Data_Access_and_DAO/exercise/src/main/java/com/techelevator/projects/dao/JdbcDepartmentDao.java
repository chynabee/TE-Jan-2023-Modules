package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int id) {

			Department department = null;

			String sql = "select department_id, name\n" +
					"from department\n" +
					"where department_id = ?;";

			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

			while(results.next()) {
				department = new Department();

				int departmentIdFromDB = results.getInt("department_id");
				department.setId(departmentIdFromDB);

				String name = results.getString("name");
				department.setName(name);
			}

		return department;
	}

	@Override
	public List<Department> getAllDepartments() {

		List<Department> departments = new ArrayList<>();

		String sql = "SELECT department_id, name\n" +
				"FROM department;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while(results.next()) {
			Department department = mapRowToDepartment(results);

			departments.add(department);
		}

		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {

		String sql = "UPDATE department\n" +
				"SET name = ?\n" +
				"WHERE department_id = ?;";

		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());



	}

	public Department mapRowToDepartment (SqlRowSet results){
		Department department = new Department();

		int departmentIdFromDB = results.getInt("department_id");
		department.setId(departmentIdFromDB);

		String name = results.getString("name");
		department.setName(name);

		return department;
	}



}
