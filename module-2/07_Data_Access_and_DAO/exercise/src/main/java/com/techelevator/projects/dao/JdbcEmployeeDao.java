package com.techelevator.projects.dao;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
                "FROM employee;\n";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Employee employee = mapRowToEmployees(results);

            employees.add(employee);
        }

        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {

        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
                "FROM employee\n" +
                "WHERE first_name ILIKE ? AND last_name ILIKE ?;";

        String searchFirstName = "%" + firstNameSearch + "%";
        String searchLastName = "%" + lastNameSearch + "%";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchFirstName, searchLastName);

        while (results.next()) {
            Employee employee = mapRowToEmployees(results);
            employees.add(employee);

        }

        return employees;
    }

    @Override
    public List<Employee> getEmployeesByProjectId(int projectId) {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
                "FROM employee\n" +
                "JOIN project_employee\n" +
                "\tON project_employee.employee_id = employee.employee_id\n" +
                "WHERE project_employee.project_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

        while (results.next()) {
            Employee employee = mapRowToEmployees(results);
            employees.add(employee);
        }



        return employees;
    }

    @Override
    public void addEmployeeToProject(int projectId, int employeeId) {

        String sql = "INSERT INTO project_employee (project_id, employee_id)\n" +
                "VALUES(?,?);";

        jdbcTemplate.update(sql, projectId, employeeId);

    }

    @Override
    public void removeEmployeeFromProject(int projectId, int employeeId) {

        String sql = "DELETE \n" +
                "FROM project_employee\n" +
                "WHERE project_id = ? AND employee_id = ?;";

        jdbcTemplate.update(sql, projectId,employeeId);
    }

    @Override
    public List<Employee> getEmployeesWithoutProjects() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
                "FROM employee\n" +
                "LEFT JOIN project_employee\n" +
                "ON employee.employee_id = project_employee.employee_id\n" +
                "WHERE project_id IS NULL;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Employee employee = mapRowToEmployees(results);
            employees.add(employee);

        }

        return employees;
    }

    private Employee mapRowToEmployees(SqlRowSet results) {
        Employee employee = new Employee();

        int employeeIdFromDB = results.getInt("employee_id");
        employee.setId(employeeIdFromDB);

        int departmentIdFromDB = results.getInt("department_id");
        employee.setDepartmentId(departmentIdFromDB);

        String lastName = results.getString("last_name");
        employee.setLastName(lastName);

        String firstName = results.getString("first_name");
        employee.setFirstName(firstName);

        Date employeeBirthDate = results.getDate("birth_date");
        if (employeeBirthDate != null) {
            employee.setBirthDate(employeeBirthDate.toLocalDate());
        }

        Date employeeHireDate = results.getDate("hire_date");
        if (employeeHireDate != null) {
            employee.setHireDate(employeeHireDate.toLocalDate());
        }

        return employee;
    }


}



