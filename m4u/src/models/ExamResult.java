/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 * The type Exam result.
 *
 * @author GreenRain
 */
public class ExamResult {

    private int examResultId;
    private int studentId;
    private int semesterId;
    private String courseName;
    private float ltPoint1;
    private float thPoint1;
    private float ltPoint2;
    private float thPoint2;
    private float totalPoint1;
    private float totalPoint2;


    /**
     * Instantiates a new Exam result.
     */
    public ExamResult() {
    }

    /**
     * Instantiates a new Exam result.
     *
     * @param examResultId the exam result id
     * @param studentId    the student id
     * @param semesterId   the semester id
     * @param courseName   the course name
     * @param ltPoint1     the lt point 1
     * @param thPoint1     the th point 1
     * @param ltPoint2     the lt point 2
     * @param thPoint2     the th point 2
     * @param totalPoint1  the total point 1
     * @param totalPoint2  the total point 2
     */
    public ExamResult(int examResultId, int studentId, int semesterId, String courseName, float ltPoint1, float thPoint1, float ltPoint2, float thPoint2, float totalPoint1, float totalPoint2) {
        this.examResultId = examResultId;
        this.studentId = studentId;
        this.semesterId = semesterId;
        this.courseName = courseName;
        this.ltPoint1 = ltPoint1;
        this.thPoint1 = thPoint1;
        this.ltPoint2 = ltPoint2;
        this.thPoint2 = thPoint2;
        this.totalPoint1 = totalPoint1;
        this.totalPoint2 = totalPoint2;
    }

    /**
     * Instantiates a new Exam result.
     *
     * @param studentId   the student id
     * @param semesterId  the semester id
     * @param courseName  the course name
     * @param ltPoint1    the lt point 1
     * @param thPoint1    the th point 1
     * @param ltPoint2    the lt point 2
     * @param thPoint2    the th point 2
     * @param totalPoint1 the total point 1
     * @param totalPoint2 the total point 2
     */
    public ExamResult(int studentId, int semesterId, String courseName, float ltPoint1, float thPoint1, float ltPoint2, float thPoint2, float totalPoint1, float totalPoint2) {
        this.studentId = studentId;
        this.semesterId = semesterId;
        this.courseName = courseName;
        this.ltPoint1 = ltPoint1;
        this.thPoint1 = thPoint1;
        this.ltPoint2 = ltPoint2;
        this.thPoint2 = thPoint2;
        this.totalPoint1 = totalPoint1;
        this.totalPoint2 = totalPoint2;
    }

    /**
     * Instantiates a new Exam result.
     *
     * @param studentId   the student id
     * @param semesterId  the semester id
     * @param courseName  the course name
     * @param totalPoint1 the total point 1
     * @param totalPoint2 the total point 2
     */
    public ExamResult(int studentId, int semesterId, String courseName, float totalPoint1, float totalPoint2) {
        this.studentId = studentId;
        this.semesterId = semesterId;
        this.courseName = courseName;
        this.totalPoint1 = totalPoint1;
        this.totalPoint2 = totalPoint2;
    }


    /**
     * Gets exam result id.
     *
     * @return the exam result id
     */
    public int getExamResultId() {
        return examResultId;
    }

    /**
     * Sets exam result id.
     *
     * @param examResultId the exam result id
     */
    public void setExamResultId(int examResultId) {
        this.examResultId = examResultId;
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
     * Gets semester id.
     *
     * @return the semester id
     */
    public int getSemesterId() {
        return semesterId;
    }

    /**
     * Sets semester id.
     *
     * @param semesterId the semester id
     */
    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
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
     * Gets lt point 1.
     *
     * @return the lt point 1
     */
    public float getLtPoint1() {
        return ltPoint1;
    }

    /**
     * Sets lt point 1.
     *
     * @param ltPoint1 the lt point 1
     */
    public void setLtPoint1(float ltPoint1) {
        this.ltPoint1 = ltPoint1;
    }

    /**
     * Gets th point 1.
     *
     * @return the th point 1
     */
    public float getThPoint1() {
        return thPoint1;
    }

    /**
     * Sets th point 1.
     *
     * @param thPoint1 the th point 1
     */
    public void setThPoint1(float thPoint1) {
        this.thPoint1 = thPoint1;
    }

    /**
     * Gets lt point 2.
     *
     * @return the lt point 2
     */
    public float getLtPoint2() {
        return ltPoint2;
    }

    /**
     * Sets lt point 2.
     *
     * @param ltPoint2 the lt point 2
     */
    public void setLtPoint2(float ltPoint2) {
        this.ltPoint2 = ltPoint2;
    }

    /**
     * Gets th point 2.
     *
     * @return the th point 2
     */
    public float getThPoint2() {
        return thPoint2;
    }

    /**
     * Sets th point 2.
     *
     * @param thPoint2 the th point 2
     */
    public void setThPoint2(float thPoint2) {
        this.thPoint2 = thPoint2;
    }

    /**
     * Gets total point 1.
     *
     * @return the total point 1
     */
    public float getTotalPoint1() {
        return totalPoint1;
    }

    /**
     * Sets total point 1.
     *
     * @param totalPoint1 the total point 1
     */
    public void setTotalPoint1(float totalPoint1) {
        this.totalPoint1 = totalPoint1;
    }

    /**
     * Gets total point 2.
     *
     * @return the total point 2
     */
    public float getTotalPoint2() {
        return totalPoint2;
    }

    /**
     * Sets total point 2.
     *
     * @param totalPoint2 the total point 2
     */
    public void setTotalPoint2(float totalPoint2) {
        this.totalPoint2 = totalPoint2;
    }

    /**
     * Gets total point.
     *
     * @param a the a
     * @param b the b
     * @return the total point
     */
    public float getTotalPoint(float a, float b) {
        return (a+b)/2;
    }
}
