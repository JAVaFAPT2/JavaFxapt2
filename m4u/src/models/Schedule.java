/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;



public class Schedule {
    private int scheduleId;
    private int teacherId;
    private int classId;
    private int studentId;
    private String courseName;
    private String startTime;
    private String endTime;
    private String dateOfWeek;
    private String timeOfDay;

    /**
     * Instantiates a new Schedule.
     */
    public Schedule() {
    }

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets student id.
     *
     * @param studentId the student id
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Instantiates a new Schedule.
     *
     * @param scheduleId the schedule id
     * @param studentId  the student id
     */
    public Schedule(int scheduleId, int studentId) {
        this.scheduleId = scheduleId;
        this.studentId = studentId;
    }


    /**
     * Instantiates a new Schedule.
     *
     * @param scheduleId the schedule id
     * @param teacherId  the teacher id
     * @param classId    the class id
     * @param courseName the course name
     * @param startTime  the start time
     * @param endTime    the end time
     * @param dateOfWeek the date of week
     * @param timeOfDay  the time of day
     */
    public Schedule(int scheduleId, int teacherId, int classId, String courseName, String startTime, String endTime, String dateOfWeek, String timeOfDay) {
        this.scheduleId = scheduleId;
        this.teacherId = teacherId;
        this.classId = classId;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfWeek = dateOfWeek;
        this.timeOfDay = timeOfDay;
    }

    /**
     * Instantiates a new Schedule.
     *
     * @param teacherId  the teacher id
     * @param classId    the class id
     * @param courseName the course name
     * @param startTime  the start time
     * @param endTime    the end time
     * @param dateOfWeek the date of week
     * @param timeOfDay  the time of day
     */
    public Schedule(int teacherId, int classId, String courseName, String startTime, String endTime, String dateOfWeek, String timeOfDay) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfWeek = dateOfWeek;
        this.timeOfDay = timeOfDay;
    }

    /**
     * Gets schedule id.
     *
     * @return the schedule id
     */
    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * Sets schedule id.
     *
     * @param scheduleId the schedule id
     */
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * Gets teacher id.
     *
     * @return the teacher id
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Sets teacher id.
     *
     * @param teacherId the teacher id
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * Gets class id.
     *
     * @return the class id
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Sets class id.
     *
     * @param classId the class id
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * Gets course name.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets course name.
     *
     * @param courseName the course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets date of week.
     *
     * @return the date of week
     */
    public String getDateOfWeek() {
        return dateOfWeek;
    }

    /**
     * Sets date of week.
     *
     * @param dateOfWeek the date of week
     */
    public void setDateOfWeek(String dateOfWeek) {
        this.dateOfWeek = dateOfWeek;
    }

    /**
     * Gets time of day.
     *
     * @return the time of day
     */
    public String getTimeOfDay() {
        return timeOfDay;
    }

    /**
     * Sets time of day.
     *
     * @param timeOfDay the time of day
     */
    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
    
    
   
}

