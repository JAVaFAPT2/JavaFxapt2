/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAO.ScheduleDAO;
import models.Schedule;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import views.StudentView;
import views.TeacherView;


public class ScheduleController {

    private TeacherView view;
    private StudentView stdview;
    private List<Schedule> dataList = new ArrayList<>();
    /**
     * The Sch dao.
     */
    ScheduleDAO schDAO = new ScheduleDAO();

    /**
     * Instantiates a new Schedule controller.
     */
    public ScheduleController() {
    }

    /**
     * Instantiates a new Schedule controller.
     *
     * @param view the view
     */
    public ScheduleController(TeacherView view) {
        this.view = view;
    }

    /**
     * Instantiates a new Schedule controller.
     *
     * @param stdview the stdview
     */
    public ScheduleController(StudentView stdview) {
        this.stdview = stdview;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        int max = schDAO.getMax();
        return max;
    }

    /**
     * Is id exist boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean isIdExist(int id) {
        return schDAO.isIDExits(id);
    }

    /**
     * Is schedule id registered boolean.
     *
     * @param studentId  the student id
     * @param scheduleId the schedule id
     * @return the boolean
     */
    public boolean isScheduleIdRegistered(int studentId, int scheduleId) {
        return schDAO.isScheduleIdRegistered(studentId, scheduleId);
    }

    /**
     * Show new data.
     */
    public void showNewData() {
        dataList = schDAO.getAllSchedules();
        showTable();
    }

    /**
     * Show table.
     */
    public void showTable() {
        DefaultTableModel tableModel = view.getTableSchedule();
        tableModel.setRowCount(0);

        for (Schedule schedule : dataList) {
            tableModel.addRow(new Object[]{
                schedule.getScheduleId(),
                schedule.getTeacherId(),
                schedule.getClassId(),
                schedule.getCourseName(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getDateOfWeek(),
                schedule.getTimeOfDay()
            });
        }
    }

    /**
     * Show new data std.
     */
    public void showNewDataSTD() {
        dataList = schDAO.getAllSchedules();
        showTableSTD();
    }

    /**
     * Show table std.
     */
    public void showTableSTD() {
        DefaultTableModel tableModel = stdview.getTableSchedule();
        tableModel.setRowCount(0);

        for (Schedule schedule : dataList) {
            tableModel.addRow(new Object[]{
                schedule.getScheduleId(),
                schedule.getTeacherId(),
                schedule.getClassId(),
                schedule.getCourseName(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getDateOfWeek(),
                schedule.getTimeOfDay()
            });
        }
    }

    /**
     * Show new data register.
     */
    public void showNewDataRegister() {
        int student_id = stdview.getUser_id();
        dataList = schDAO.getRegisteredByStudent(student_id);
        showTableRegister();
    }

    /**
     * Show table register.
     */
    public void showTableRegister() {
        DefaultTableModel tableModel = stdview.getTableRegisterSchedule();
        tableModel.setRowCount(0);

        for (Schedule schedule : dataList) {
            tableModel.addRow(new Object[]{
                schedule.getScheduleId(),
                schedule.getTeacherId(),
                schedule.getClassId(),
                schedule.getCourseName(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getDateOfWeek(),
                schedule.getTimeOfDay()
            });
        }
    }

    /**
     * Save schedule.
     */
    public void saveSchedule() {
        int teacherId = Integer.parseInt(view.getTeacherId());
        int classId = Integer.parseInt(view.getClassId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String courseName = view.getCourseName();
        String startTime = dateFormat.format(view.getStartTime());
        String endTime = dateFormat.format(view.getEndTime());
        String dateOfWeek = view.getDateOfWeek();
        String timeOfDay = view.getTimeOfDay();

        Schedule schedule = new Schedule();
        schedule.setTeacherId(teacherId);
        schedule.setClassId(classId);
        schedule.setCourseName(courseName);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setDateOfWeek(dateOfWeek);
        schedule.setTimeOfDay(timeOfDay);
        
        schDAO.addSchedule(schedule);
        view.showMessage("Add Schedule Successfully!");
        view.clearSchedule();
        showNewData();
    }

    /**
     * Register schedule.
     */
    public void registerSchedule() {
        int schedule_id = Integer.parseInt(stdview.getScheduleId());
        int student_id = stdview.getUser_id();

        Schedule schedule = new Schedule();
        schedule.setScheduleId(schedule_id);
        schedule.setStudentId(student_id);
        
        schDAO.addScheduleStudent(schedule);
        showNewDataRegister();
        stdview.showMessage("Register Successfully!");
        stdview.clearScheduleStudent();
    }

    /**
     * Update schedule.
     */
    public void updateSchedule() {
        int scheduleId = Integer.parseInt(view.getScheduleId());
        if (schDAO.isIDExits(scheduleId)) {
            int teacherId = Integer.parseInt(view.getTeacherId());
            int classId = Integer.parseInt(view.getClassId());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String courseName = view.getCourseName();
            String startTime = dateFormat.format(view.getStartTime());
            String endTime = dateFormat.format(view.getEndTime());
            String dateOfWeek = view.getDateOfWeek();
            String timeOfDay = view.getTimeOfDay();

            Schedule schedule = new Schedule();
            schedule.setScheduleId(scheduleId);
            schedule.setTeacherId(teacherId);
            schedule.setClassId(classId);
            schedule.setCourseName(courseName);
            schedule.setStartTime(startTime);
            schedule.setEndTime(endTime);
            schedule.setDateOfWeek(dateOfWeek);
            schedule.setTimeOfDay(timeOfDay);

            schDAO.updateSchedule(schedule);
            view.showMessage("Update Schedule Successfully!");
            view.clearSchedule();
            showNewData();
        } else {
            view.showMessage("Schedule id doesn't exists");
        }
    }

    /**
     * Delete schedule.
     */
    public void deleteSchedule() {
        int scheduleId = Integer.parseInt(view.getScheduleId());

        if (schDAO.isIDExits(scheduleId)) {
            int yesOrNo = view.showConfirmDeleteDialog("Schedule records will also be deleted", "Schedule Delete");
            if (yesOrNo == view.OK_Option()) {
                schDAO.removeSchedule(scheduleId);
            }
            showNewData();
            view.showMessage("Delete Schedule Successfully!");
            view.clearStudent();
        } else {
            view.showMessage("Schedule id doesn't exists");
        }
        view.clearSchedule();
        showNewData();
    }

    /**
     * Search schedule by search.
     */
    public void searchScheduleBySearch() {
        String txtsearch = view.getSearchShedule();
        dataList = schDAO.getScheduleBySearch(txtsearch);
        showTable();
    }

    /**
     * Search schedule by search std.
     */
    public void searchScheduleBySearchSTD() {
        String txtsearch = stdview.getSearchShedule();
        dataList = schDAO.getScheduleBySearch(txtsearch);
        showTableSTD();
    }
}
