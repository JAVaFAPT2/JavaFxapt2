/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAO.ClassDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Classes;
import views.Dashboard;


public class ClassController {

    private Dashboard view;
    private List<Classes> dataList = new ArrayList<>();
    /**
     * The Cl.
     */
    ClassDAO cl = new ClassDAO();

    /**
     * Instantiates a new Class controller.
     */
    public ClassController() {
    }

    /**
     * Instantiates a new Class controller.
     *
     * @param view the view
     */
    public ClassController(Dashboard view) {
        this.view = view;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        int max = cl.getMax();
        return max;
    }

    /**
     * Show new data.
     */
    public void showNewData() {
        dataList = ClassDAO.select();
        showTable();
    }

    /**
     * Show table.
     */
    public void showTable() {
        DefaultTableModel tableModel = view.getTableClass();
        tableModel.setRowCount(0);

        for (Classes classes : dataList) {
            tableModel.addRow(new Object[]{
                classes.getClass_id(),
                classes.getClass_name()
            });
        }
    }

    /**
     * Save class.
     */
    public void saveClass() {
        String Classname = view.getClassName();

        Classes classes = new Classes();
        classes.setClass_name(Classname);

        ClassDAO.insert(classes);
        view.clearClass();
        showNewData();
    }

    /**
     * Update class.
     */
    public void updateClass() {
        int class_id = Integer.parseInt(view.getClassId());
        if (cl.isIDExits(class_id)) {
            String Classname = view.getClassName();

            Classes classes = new Classes();
            classes.setClass_id(class_id);
            classes.setClass_name(Classname);

            ClassDAO.update(classes);
            view.clearClass();
            showNewData();
        } else {
            view.showMessage("Class id doesn't exists");
        }

    }

    /**
     * Delete class.
     */
    public void deleteClass() {
        int class_id = Integer.parseInt(view.getClassId());
        if (cl.isIDExits(class_id)) {
            int yesOrNo = view.showConfirmDeleteDialog("Class records will also be deleted", "Class Delete");
            if (yesOrNo == view.OK_Option()) {
                ClassDAO.delete(class_id);
            }
            showNewData();
            view.clearClass();
        } else {
            view.showMessage("Class id doesn't exists");
        }
    }

    /**
     * Search class.
     */
    public void searchClass() {
        String searchTxt = view.getSearchClass();
        dataList = ClassDAO.search(searchTxt);
        showTable();
    }
}
