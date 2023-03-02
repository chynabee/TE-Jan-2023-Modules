package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProjectDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Project getProject(int projectId) {

        Project project = null;
        String sql ="SELECT project_id, name, from_date, to_date\n" +
                "FROM project\n" +
                "WHERE project_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

        while(results.next()) {
          project = mapRowToProject(results);

        }

        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();

        String sql = "SELECT project_id, name, from_date, to_date\n" +
                "FROM project;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Project project = mapRowToProject(results);

            projects.add(project);
        }

        return projects;

    }

    @Override
    public Project createProject(Project newProject) {

        String sql = "INSERT INTO project (project_id, name, from_date, to_date)\n" +
                "VALUES (?,?,?,?) RETURNING project_id;";

        int projectId = jdbcTemplate.queryForObject(sql, int.class,
                newProject.getId(),
                newProject.getName(),
                newProject.getFromDate(),
                newProject.getToDate());

        return getProject(projectId);
    }

    @Override
    public void deleteProject(int projectId) {

        String sql1 = "DELETE\n" +
                "FROM project_employee\n" +
                "WHERE project_id = ?;";
        jdbcTemplate.update(sql1, projectId);

        String sql2 = "DELETE\n" +
                "FROM project\n" +
                "WHERE project_id = ?;";

        jdbcTemplate.update(sql2, projectId);

    }

    private Project mapRowToProject (SqlRowSet results) {
        Project project = new Project();

        int projectIdFromDB = results.getInt("project_id");
        project.setId(projectIdFromDB);

        String name = results.getString("name");
        project.setName(name);

        Date fromDate = results.getDate("from_date");
        if (fromDate != null) {
            project.setFromDate(fromDate.toLocalDate());
        }

        Date toDate = results.getDate("to_date");
        if(toDate != null) {
            project.setToDate(toDate.toLocalDate());
        }

        return project;
    }


}
	


