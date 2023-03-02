package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);}

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {

        Timesheet timesheet = dao.getTimesheet(1);

        assertTimesheetsMatch(TIMESHEET_1, timesheet);

        timesheet = dao.getTimesheet(2);

        assertTimesheetsMatch(TIMESHEET_2, timesheet);

    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {

        Timesheet timesheet = dao.getTimesheet(99);
        Assert.assertNull(timesheet);


    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
       //Act
       List<Timesheet> results = dao.getTimesheetsByEmployeeId(1);

       //Assert- make sure we have 2 timesheets for employee 1
        //like we see int h test data sql or in the constants above
        Assert.assertEquals(2, results.size());



    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> results = dao.getTimesheetsByProjectId(1);

        Assert.assertEquals(3, results.size());

    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {

        Timesheet newTimesheet = new Timesheet(2,2,2, LocalDate.parse("2023-03-02"),3.0, true, "Timesheet 5");

        Timesheet createdTimesheet = dao.createTimesheet(newTimesheet);

        Assert.assertTrue(createdTimesheet.getTimesheetId() > 0);

        newTimesheet.setTimesheetId(createdTimesheet.getTimesheetId());

        assertTimesheetsMatch(newTimesheet, createdTimesheet);


    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet newTimesheet = new Timesheet(2,2,2, LocalDate.parse("2023-03-02"),3.0, true, "Timesheet 5");
        Timesheet createdTimesheet = dao.createTimesheet(newTimesheet);
        Timesheet retrievedTimesheet = dao.getTimesheet(createdTimesheet.getTimesheetId());
        assertTimesheetsMatch(createdTimesheet, retrievedTimesheet);
    }


    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
       Timesheet timesheetToUpdate = dao.getTimesheet(1);
       timesheetToUpdate.setEmployeeId(1);
       timesheetToUpdate.setProjectId(1);
       timesheetToUpdate.setDateWorked(LocalDate.parse("2021-01-02"));
       timesheetToUpdate.setBillable(false);
       timesheetToUpdate.setHoursWorked(2.0);
       timesheetToUpdate.setDescription("Timesheet 1");

       dao.updateTimesheet(timesheetToUpdate);
       Timesheet retrievedTimesheet = dao.getTimesheet(1);
       assertTimesheetsMatch(timesheetToUpdate, retrievedTimesheet );
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
       dao.deleteTimesheet(2);

       Timesheet retrievedTimesheet = dao.getTimesheet(2);
       Assert.assertEquals(null, retrievedTimesheet);

       List<Timesheet> timesheet = dao.getTimesheetsByEmployeeId(2);
       Assert.assertEquals(2, timesheet.size());
       assertTimesheetsMatch(TIMESHEET_3, timesheet.get(0));
    }

    @Test
    public void getBillableHours_returns_correct_total() {

        double billableHours = dao.getBillableHours(1,1);

        Assert.assertEquals(0, billableHours,2.5 );


    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
