/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Course;
import DAO.CourseDAO;
import views.TeacherView;


public class CourseController {

    private TeacherView view;
    /**
     * The Cou.
     */
    CourseDAO cou = new CourseDAO();
    private List<Course> dataList = new ArrayList<>();

    /**
     * Instantiates a new Course controller.
     */
    public CourseController() {
    }

    /**
     * Instantiates a new Course controller.
     *
     * @param view the view
     */
    public CourseController(TeacherView view) {
        this.view = view;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        int max = cou.getMax();
        return max;
    }

    /**
     * Gets id.
     *
     * @param id the id
     * @return the id
     */
    public boolean getID(int id) {
        return cou.getID(id);
    }

    /**
     * Count semester int.
     *
     * @param id the id
     * @return the int
     */
    public int countSemester(int id) {
        int total = cou.countSemester(id);
        return total;
    }

    /**
     * Is semester exists boolean.
     *
     * @param sid        the sid
     * @param semesterNo the semester no
     * @return the boolean
     */
    public boolean isSemesterExists(int sid, int semesterNo) {
        return cou.isSemesterExists(sid, semesterNo);
    }

    /**
     * Is course exists boolean.
     *
     * @param course_id the course id
     * @param courseNo  the course no
     * @param course    the course
     * @return the boolean
     */
    public boolean isCourseExists(int course_id, String courseNo, String course) {
        return cou.isCourseExists(course_id, courseNo, course);
    }

    /**
     * Save course.
     */
    public void saveCourse() {
        int student_id = Integer.parseInt(view.getStudentID());
        int semester_id = Integer.parseInt(view.getSemesterID());
        String course1 = view.getCourse1();
        String course2 = view.getCourse2();
        String course3 = view.getCourse3();
        String course4 = view.getCourse4();
        String course5 = view.getCourse5();
        int teacher_id = Integer.parseInt(view.getTeacherID());

        Course cou = new Course();
        cou.setStudent_id(student_id);
        cou.setSemester_id(semester_id);
        cou.setCourse1(course1);
        cou.setCourse2(course2);
        cou.setCourse3(course3);
        cou.setCourse4(course4);
        cou.setCourse5(course5);
        cou.setTeacher_id(teacher_id);
        
        CourseDAO.insert(cou);
        view.clearCourse();
        showNewData();
    }

    /**
     * Show new data.
     */
    public void showNewData() {
        dataList = CourseDAO.select();
        showTable();
    }

    /**
     * Show table.
     */
    public void showTable() {
        DefaultTableModel tableModel = view.getTableCourse();
        tableModel.setRowCount(0);

        for (Course courses : dataList) {
            tableModel.addRow(new Object[]{
                courses.getCourse_id(),
                courses.getStudent_id(),
                courses.getSemester_id(),
                courses.getCourse1(),
                courses.getCourse2(),
                courses.getCourse3(),
                courses.getCourse4(),
                courses.getCourse5(),
                courses.getTeacher_id()
            });
        }
    }

    /**
     * Search course.
     */
    public void searchCourse() {
        String searchTxt = view.getSearchCourse();
        dataList = CourseDAO.search(searchTxt);
        showTable();
    }
}
