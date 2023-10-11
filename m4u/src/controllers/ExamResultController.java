/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.ExamResult;
import DAO.ExamResultDAO;
import views.StudentView;
import views.TeacherView;

/**
 * The type Exam result controller.
 *
 * @author GreenRain
 */
public class ExamResultController {

    private TeacherView view;
    private StudentView stdview;
    /**
     * The Exa.
     */
    ExamResultDAO exa = new ExamResultDAO();
    private List<ExamResult> dataList = new ArrayList<>();
    /**
     * The Ex.
     */
    ExamResult ex = new ExamResult();

    /**
     * Instantiates a new Exam result controller.
     */
    public ExamResultController() {
    }

    /**
     * Instantiates a new Exam result controller.
     *
     * @param view the view
     */
    public ExamResultController(TeacherView view) {
        this.view = view;
    }

    /**
     * Instantiates a new Exam result controller.
     *
     * @param stdview the stdview
     */
    public ExamResultController(StudentView stdview) {
        this.stdview = stdview;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        int max = exa.getMax();
        return max;
    }

    /**
     * Gets details.
     *
     * @param sid        the sid
     * @param semesterNo the semester no
     * @return the details
     */
    public boolean getDetails(int sid, int semesterNo) {
        return exa.getDetails(sid, semesterNo);
    }

    /**
     * Is id exist boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean isIdExist(int id) {
        return exa.isIdExists(id);
    }

    /**
     * Is id student exist boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean isIdStudentExist(int id) {
        return exa.isIdStudentExists(id);
    }

    /**
     * Is course name exist boolean.
     *
     * @param courseName the course name
     * @return the boolean
     */
    public boolean isCourseNameExist(String courseName) {
        return exa.isCourseNameExist(courseName);
    }

    /**
     * Gets courses by student and semester.
     *
     * @param studentId  the student id
     * @param semesterId the semester id
     * @return the courses by student and semester
     */
    public List<String> getCoursesByStudentAndSemester(int studentId, int semesterId) {
        ExamResultDAO examResultDAO = new ExamResultDAO();
        return examResultDAO.getCoursesByStudentAndSemester(studentId, semesterId);
    }

    /**
     * Gets total point.
     *
     * @param ltPoint the lt point
     * @param thPoint the th point
     * @return the total point
     */
    public float getTotalPoint(float ltPoint, float thPoint) {
        return ex.getTotalPoint(ltPoint, thPoint);
    }

    /**
     * Save score.
     */
    public void saveScore() {
        int student_id = Integer.parseInt(view.getStudentIDScore());
        int semester_id = Integer.parseInt(view.getSemesterIDScore());
        String course_name = view.getCourse();
        float lt_point1 = Float.parseFloat(view.getTScore1());
        float th_point1 = Float.parseFloat(view.getPScore1());
        float lt_point2;
        float th_point2;
        if (lt_point1 >= 4 && th_point1 >= 4) {
            lt_point2 = 0;
            th_point2 = 0;
        } else {
            lt_point2 = Float.parseFloat(view.getTScore2());
            th_point2 = Float.parseFloat(view.getPScore2());
        }
        float total_point1 = ex.getTotalPoint(lt_point1, th_point1);
        float total_point2 = ex.getTotalPoint(lt_point2, th_point2);

        ex.setStudentId(student_id);
        ex.setSemesterId(semester_id);
        ex.setCourseName(course_name);
        ex.setLtPoint1(lt_point1);
        ex.setThPoint1(th_point1);
        ex.setLtPoint2(lt_point2);
        ex.setThPoint2(th_point2);
        ex.setTotalPoint1(total_point1);
        ex.setTotalPoint2(total_point2);

        ExamResultDAO.insert(ex);
        view.clearScore();
        showNewData();
    }

    /**
     * Update score.
     */
    public void updateScore() {
        int result_id = Integer.parseInt(view.getIdScore());
        if (exa.isIdExists(result_id)) {
            int student_id = Integer.parseInt(view.getStudentIDScore());
            int semester_id = Integer.parseInt(view.getSemesterIDScore());
            String course_name = view.getCourse();
            float lt_point1 = Float.parseFloat(view.getTScore1());
            float th_point1 = Float.parseFloat(view.getPScore1());
            float lt_point2;
            float th_point2;
            if (lt_point1 >= 4 && th_point1 >= 4) {
                lt_point2 = 0;
                th_point2 = 0;
            } else {
                lt_point2 = Float.parseFloat(view.getTScore2());
                th_point2 = Float.parseFloat(view.getPScore2());
            }
            float total_point1 = ex.getTotalPoint(lt_point1, th_point1);
            float total_point2 = ex.getTotalPoint(lt_point2, th_point2);

            ex.setExamResultId(result_id);
            ex.setStudentId(student_id);
            ex.setSemesterId(semester_id);
            ex.setCourseName(course_name);
            ex.setLtPoint1(lt_point1);
            ex.setThPoint1(th_point1);
            ex.setLtPoint2(lt_point2);
            ex.setThPoint2(th_point2);
            ex.setTotalPoint1(total_point1);
            ex.setTotalPoint2(total_point2);

            ExamResultDAO.update(ex);
            view.clearScore();
            showNewData();

        } else {
            view.showMessage("Result id doesn't exists");
        }
    }

    /**
     * Show new data.
     */
    public void showNewData() {
        dataList = ExamResultDAO.select();
        showTable();
    }

    /**
     * Show table.
     */
    public void showTable() {
        DefaultTableModel tableModel = view.getTableScore();
        tableModel.setRowCount(0);

        for (ExamResult exams : dataList) {
            tableModel.addRow(new Object[]{
                exams.getExamResultId(),
                exams.getStudentId(),
                exams.getSemesterId(),
                exams.getCourseName(),
                exams.getLtPoint1(),
                exams.getThPoint1(),
                exams.getLtPoint2(),
                exams.getThPoint2(),
                exams.getTotalPoint1(),
                exams.getTotalPoint2()
            });
        }
    }

    /**
     * Search score.
     */
    public void searchScore() {
        String searchTxt = view.getSearchScore();
        dataList = ExamResultDAO.search(searchTxt);
        showTable();
    }

    /**
     * Show cgpa float.
     *
     * @return the float
     */
    public float showCGPA() {
        int studentId = Integer.parseInt(view.getSearchGPA());
        dataList = ExamResultDAO.getScoreValue(studentId);
        float cgpa = calculateCGPA(dataList);
        return cgpa;
    }

    /**
     * Show new data gpa.
     */
    public void showNewDataGPA() {
        int studentId = Integer.parseInt(view.getSearchGPA());
        dataList = ExamResultDAO.getScoreValue(studentId);
        showTableGPA();
    }

    /**
     * Show table gpa.
     */
    public void showTableGPA() {
        DefaultTableModel tableModel = view.getTableScoreGPA();
        tableModel.setRowCount(0);

        for (ExamResult exams : dataList) {
            tableModel.addRow(new Object[]{
                exams.getStudentId(),
                exams.getSemesterId(),
                exams.getCourseName(),  
                exams.getTotalPoint1(),
                exams.getTotalPoint2()
            });
        }
    }

    /**
     * Show cgp astd float.
     *
     * @return the float
     */
    public float showCGPAstd() {
        int studentId = Integer.parseInt(stdview.getSearchGPA());
        dataList = ExamResultDAO.getScoreValue(studentId);
        float cgpa = calculateCGPA(dataList);
        return cgpa;
    }

    /**
     * Show new data gp astd.
     */
    public void showNewDataGPAstd() {
        int studentId = Integer.parseInt(stdview.getSearchGPA());
        dataList = ExamResultDAO.getScoreValue(studentId);
        showTableGPAstd();
    }

    /**
     * Show table gp astd.
     */
    public void showTableGPAstd() {
        DefaultTableModel tableModel = stdview.getTableScoreGPA();
        tableModel.setRowCount(0);

        for (ExamResult exams : dataList) {
            tableModel.addRow(new Object[]{
                exams.getStudentId(),
                exams.getSemesterId(),
                exams.getCourseName(),  
                exams.getTotalPoint1(),
                exams.getTotalPoint2()
            });
        }
    }
    
    private float calculateCGPA(List<ExamResult> examResults) {
        float totalGradePoints = 0;
        float totalCredits = 0;

        for (ExamResult examResult : examResults) {
            float totalPoint = examResult.getTotalPoint1();

            // Sử dụng total point 2 nếu total point 1 < 4
            if (totalPoint < 4) {
                totalPoint = examResult.getTotalPoint2();
            }

            totalGradePoints += totalPoint;

            totalCredits++;
        }

        // Tính CGPA
        if (totalCredits > 0) {
            float cgpa = totalGradePoints / totalCredits;
            return cgpa;
        } else {
            return 0;
        }
    }
}
