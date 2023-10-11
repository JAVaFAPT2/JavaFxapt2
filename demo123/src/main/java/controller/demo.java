package controller;

import entity.demoClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
public class demo {
*
* @author duong
*/
    public class demo implements Initializable {


        @FXML
        private Label label;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtMobile;

        @FXML
        private TextField txtCourse;

        @FXML
        private TableView<demoClass> table;

        @FXML
        private TableColumn<demoClass, String> IDColmn;

        @FXML
        private TableColumn<demoClass, String> NameColmn;

        @FXML
        private TableColumn<demoClass, String> MobileColmn;

        @FXML
        private TableColumn<demoClass, String> CourseColmn;

        @FXML
        private Button btnAdd;

        @FXML
        private Button btnUpdate;

        @FXML
        private Button btnDelete;

        @FXML
        void Add(ActionEvent event) {

            String stname,mobile,course;
            stname = txtName.getText();
            mobile = txtMobile.getText();
            course = txtCourse.getText();
            try
            {
                pst = con.prepareStatement("insert into registation(name,mobile,course)values(?,?,?)");
                pst.setString(1, stname);
                pst.setString(2, mobile);
                pst.setString(3, course);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("demoClass Registration");


                alert.setHeaderText("demoClass Registration");
                alert.setContentText("Record Added!");

                alert.showAndWait();

                table();

                txtName.setText("");
                txtMobile.setText("");
                txtCourse.setText("");
                txtName.requestFocus();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        public void table()
        {
            Connect();
            ObservableList<demoClass> students = FXCollections.observableArrayList();
            try
            {
                pst = con.prepareStatement("select id,name,mobile,course from registation");
                ResultSet rs = pst.executeQuery();
                {
                    while (rs.next())
                    {
                        demoClass st = new demoClass();
                        st.setId(rs.getString("id"));
                        st.setName(rs.getString("name"));
                        st.setMobile(rs.getString("mobile"));
                        st.setCourse(rs.getString("course"));
                        students.add(st);
                    }
                }
                table.setItems(students);
                IDColmn.setCellValueFactory(f -> f.getValue().idProperty());
                NameColmn.setCellValueFactory(f -> f.getValue().nameProperty());
                MobileColmn.setCellValueFactory(f -> f.getValue().mobileProperty());
                CourseColmn.setCellValueFactory(f -> f.getValue().courseProperty());



            }

            catch (SQLException ex)
            {
                Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
            }

            table.setRowFactory( tv -> {
                TableRow<demoClass> myRow = new TableRow<>();
                myRow.setOnMouseClicked (event ->
                {
                    if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                    {
                        myIndex =  table.getSelectionModel().getSelectedIndex();

                        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                        txtName.setText(table.getItems().get(myIndex).getName());
                        txtMobile.setText(table.getItems().get(myIndex).getMobile());
                        txtCourse.setText(table.getItems().get(myIndex).getCourse());



                    }
                });
                return myRow;
            });


        }

        @FXML
        void Delete(ActionEvent event) {
            myIndex = table.getSelectionModel().getSelectedIndex();

            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));


            try
            {
                pst = con.prepareStatement("delete from registation where id = ? ");
                pst.setInt(1, id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("demoClass Registration");


                alert.setHeaderText("demoClass Registration");
                alert.setContentText("Deleted!");

                alert.showAndWait();
                table();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @FXML
        void Update(ActionEvent event) {

            String stname,mobile,course;

            myIndex = table.getSelectionModel().getSelectedIndex();

            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

            stname = txtName.getText();
            mobile = txtMobile.getText();
            course = txtCourse.getText();
            try
            {
                pst = con.prepareStatement("update registation set name = ?,mobile = ? ,course = ? where id = ? ");
                pst.setString(1, stname);
                pst.setString(2, mobile);
                pst.setString(3, course);
                pst.setInt(4, id);
                pst.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("demoClass Registration");


                alert.setHeaderText("demoClass Registration");
                alert.setContentText("Updated!");

                alert.showAndWait();
                table();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



        Connection con;
        PreparedStatement pst;
        int myIndex;
        int id;



        public void Connect()
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/studcruds","root","");
            } catch (ClassNotFoundException ex) {

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }



        @Override
        public void initialize(URL url, ResourceBundle rb) {
            Connect();
            table();
        }

    }

