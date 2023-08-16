/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package POE_RESUBMISSION;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Ethan
 */
public class TaskTest {

    Task myTask = new Task();

    public TaskTest() {
    }

    @Test
    public void taskDescriptionDoesNotMeetLength() {
        String expected = "Please enter a task description of less than 50 characters";
        myTask.setTaskDescription("To Create an add Tasks Feature to add tasks of users");
        myTask.checkTaskDescription();
        assertEquals(expected, myTask.getErrMsg());

    }

    @Test
    public void taskDescriptionMeetsLength() {
        String expected = "Task successfully captured";
        myTask.setTaskDescription("Create add Task Feature to add task users");
        myTask.checkTaskDescription();
        assertEquals(expected, myTask.getErrMsg());

    }

    @Test
    public void testTaskIDs_Case1() {
        myTask.setTaskName("Login Feature");
        myTask.setTaskDescription("Create Login to authenticate users");
        myTask.setDevDetails("Robyn Harrison");
        myTask.setTaskHours(8);
        myTask.setTaskStatus("To Do");
        String expected = "LO:0:BYN";

        assertEquals(expected, myTask.createTaskID());

    }

    @Test
    public void testTaskIDs() {
        String taskName = "Add Task Features";
        myTask.setTaskName(taskName);
        String[] devDetails = {"Mike Smith", "Richard Flemming", "Martha Kent", "Hammond Richard"};
        String[] taskIDsExpected = {"AD:0:IKE", "AD:1:ARD", "AD:2:THA", "AD:3:OND"};
        int size = 5;
        for (int i = 0; i < size - 1; i++) {
            myTask.setDevDetails(devDetails[i]);
            myTask.setTaskNumber(i);
            assertEquals(taskIDsExpected[i], myTask.createTaskID());
        }
    }

    @Test
    public void totalHoursAccumulated1() {
        int[] taskDuration = {8, 10};
        int size = 2;
        int expectedVal = 18;
        for (int i = 0; i <= size - 1; i++) {
            myTask.setTaskHours(taskDuration[i]);
            myTask.returnTotalHours();

        }
        assertEquals(expectedVal, myTask.getTotalHours());
    }

    @Test
    public void totalHoursAccumulated2() {
        int[] taskDuration = {10, 12, 55, 11, 1};
        int numTasks = 5;
        myTask.setNumberOfTasks(numTasks);
        int expectedVal = 89;
        for (int i = 0; i <= myTask.getNumberOfTasks() - 1; i++) {
            myTask.setTaskHours(taskDuration[i]);
            myTask.returnTotalHours();

        }
        assertEquals(expectedVal, myTask.getTotalHours());
    }

    @Test
    public void testLongestDuration() {
        String expected = "Glenda Oberholzer, 11";
        myTask.setDevDetails("Glenda Oberholzer");
        myTask.setTaskHours(11);
        myTask.populateTaskArrays();
        String actual = myTask.displayLongestDuration();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchTask() {
        myTask.initialiseTaskArrays();
        String expected = "Mike Smith, Create Login";
        myTask.setDevDetails("Mike Smith");
        myTask.setTaskName("Create Login");
        myTask.populateTaskArrays();
        String actual = myTask.searchTaskName("Create Login");
        assertEquals(expected, actual);

    }

    @Test
    public void testSearchAllTasks() {
        myTask.initialiseTaskArrays();
        String expected = "Create Reports";
        myTask.setDevDetails("Samantha Paulson");
        myTask.setTaskName("Create Reports");
        myTask.setTaskHours(5);
        myTask.setTaskStatus("To Do");
        myTask.populateTaskArrays();
        String actual = myTask.searchAllTasksOfDeveloper("Samantha Paulson");
        assertEquals(expected, actual);

    }

    @Test
    public void testDeleteFromArrays() {
        myTask.initialiseTaskArrays();
        String expected = "Entry 'Create Reports' successfully deleted";
        myTask.setTaskName("Create Reports");
        myTask.populateTaskArrays();
        String actual = myTask.deleteTaskName("Create Reports");
        assertEquals(expected, actual);
    }

    @Test
    public void testArrayPopulatedCorrectly() {
        int i = 0;
        String[] developerNames = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
        String expected = "'Mike Smith', 'Edward Harrington', 'Samantha Paulson', 'Glenda Oberholzer'";
        myTask.initialiseTaskArrays();
        while (i <= 3) {
            myTask.setDevDetails(developerNames[i]);
            myTask.populateTaskArrays();
            i++;
        }
        assertEquals(expected, myTask.displayDevArray());
    }

}
