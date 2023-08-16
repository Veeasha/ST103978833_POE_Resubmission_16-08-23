/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POE_RESUBMISSION;

/**
 *
 * @author Veeasha
 */
public class Task {

    private String taskName;
    private String taskDescription;
    private String developerName;
    private String taskID;
    private int taskDuration;
    private int taskNumber;
    private String taskStatus;
    
    
// Getter and Setter methods for taskName
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
// Getter and Setter methods for taskDescription
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    // Getter and Setter methods for developerName

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }
// Getter and Setter methods for taskID
    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
// Getter and Setter methods for taskDuration
    public int getHours() {
        return taskDuration;
    }

    public void setHours(int taskDuration) {
        this.taskDuration = taskDuration;
    }
// Getter and Setter methods for taskNumber
    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }
// Getter and Setter methods for taskStatus
    public String getStatus() {
        return taskStatus;
    }

    public void setStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
//makes sure the description is not longer than 50 characters
    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;

    }
// builds a task ID
    public String createTaskID() {

        taskID = taskName.substring(0, 2) + ":"
                + Integer.toString(taskNumber) + ":" + developerName.substring(developerName.length() - 3);

        return taskID.toUpperCase();

    }
//this prints the details of the task we capture from the input of the user
    public String printTaskDetails() {

        String printValue = taskName + " " + Integer.toString(taskNumber) + " " + taskDescription
                + " " + developerName + " " + Integer.toString(taskDuration) + " " + taskID + " " + taskStatus;

        return printValue;

    }

    

    

}
