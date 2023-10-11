/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 * The type Course.
 *
 * @author GreenRain
 */
public class Course {

    private int course_id;
    private int student_id;
    private int semester_id;
    private String course1;
    private String course2;
    private String course3;
    private String course4;
    private String course5;
    private int teacher_id;

    /**
     * Instantiates a new Course.
     */
    public Course() {
    }

    /**
     * Instantiates a new Course.
     *
     * @param course_id   the course id
     * @param student_id  the student id
     * @param semester_id the semester id
     * @param course1     the course 1
     * @param course2     the course 2
     * @param course3     the course 3
     * @param course4     the course 4
     * @param course5     the course 5
     * @param teacher_id  the teacher id
     */
    public Course(int course_id, int student_id, int semester_id, String course1, String course2, String course3, String course4, String course5, int teacher_id) {
        this.course_id = course_id;
        this.student_id = student_id;
        this.semester_id = semester_id;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
        this.course5 = course5;
        this.teacher_id = teacher_id;
    }

    /**
     * Instantiates a new Course.
     *
     * @param student_id  the student id
     * @param semester_id the semester id
     * @param course1     the course 1
     * @param course2     the course 2
     * @param course3     the course 3
     * @param course4     the course 4
     * @param course5     the course 5
     * @param teacher_id  the teacher id
     */
    public Course(int student_id, int semester_id, String course1, String course2, String course3, String course4, String course5, int teacher_id) {
        this.student_id = student_id;
        this.semester_id = semester_id;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
        this.course5 = course5;
        this.teacher_id = teacher_id;
    }

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public int getCourse_id() {
        return course_id;
    }

    /**
     * Sets course id.
     *
     * @param course_id the course id
     */
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "course_id=" + course_id + ", student_id=" + student_id + ", semester_id=" + semester_id + ", course1=" + course1 + ", course2=" + course2 + ", course3=" + course3 + ", course4=" + course4 + ", course5=" + course5 + ", teacher_id=" + teacher_id;
    }

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public int getStudent_id() {
        return student_id;
    }

    /**
     * Sets student id.
     *
     * @param student_id the student id
     */
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    /**
     * Gets semester id.
     *
     * @return the semester id
     */
    public int getSemester_id() {
        return semester_id;
    }

    /**
     * Sets semester id.
     *
     * @param semester_id the semester id
     */
    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    /**
     * Gets course 1.
     *
     * @return the course 1
     */
    public String getCourse1() {
        return course1;
    }

    /**
     * Sets course 1.
     *
     * @param course1 the course 1
     */
    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    /**
     * Gets course 2.
     *
     * @return the course 2
     */
    public String getCourse2() {
        return course2;
    }

    /**
     * Sets course 2.
     *
     * @param course2 the course 2
     */
    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    /**
     * Gets course 3.
     *
     * @return the course 3
     */
    public String getCourse3() {
        return course3;
    }

    /**
     * Sets course 3.
     *
     * @param course3 the course 3
     */
    public void setCourse3(String course3) {
        this.course3 = course3;
    }

    /**
     * Gets course 4.
     *
     * @return the course 4
     */
    public String getCourse4() {
        return course4;
    }

    /**
     * Sets course 4.
     *
     * @param course4 the course 4
     */
    public void setCourse4(String course4) {
        this.course4 = course4;
    }

    /**
     * Gets course 5.
     *
     * @return the course 5
     */
    public String getCourse5() {
        return course5;
    }

    /**
     * Sets course 5.
     *
     * @param course5 the course 5
     */
    public void setCourse5(String course5) {
        this.course5 = course5;
    }

    /**
     * Gets teacher id.
     *
     * @return the teacher id
     */
    public int getTeacher_id() {
        return teacher_id;
    }

    /**
     * Sets teacher id.
     *
     * @param teacher_id the teacher id
     */
    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

}
