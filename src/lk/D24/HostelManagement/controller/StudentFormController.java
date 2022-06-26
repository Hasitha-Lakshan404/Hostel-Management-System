package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.D24.HostelManagement.bo.custom.StudentBO;
import lk.D24.HostelManagement.bo.custom.impl.StudentBOImpl;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.view.tdm.StudentTM;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/21/2022
 * Time :2:31 PM
 */

public class StudentFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtTellNo;
    public JFXDatePicker dateDOB;
    public JFXComboBox<String> cmbGender;
    public TableView<StudentTM> tblStudent;
    public JFXButton btnAdd;

    StudentBO studentBO = new StudentBOImpl();

    public void initialize() throws IOException {

        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("telNo"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));


        cmbGender.getItems().addAll("Male", "Female");

        getAllStudent();

    }


    public void getAllStudent() throws IOException {
        ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();

        tblStudent.getItems().clear();

        for (StudentDTO studentDTO : allStudent) {
            tblStudent.getItems().add(new StudentTM(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getTelNo(),
                    studentDTO.getDob(),
                    studentDTO.getGender()
            ));
        }

    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {

    }

    public void studentAddOnAction(ActionEvent actionEvent) throws IOException {

        if(btnAdd.getText().equals("Add Student")){
            boolean b = studentBO.saveStudent(new StudentDTO(
                    txtStudentId.getText(),
                    txtStudentName.getText(),
                    txtAddress.getText(),
                    txtTellNo.getText(),
                    dateDOB.getValue(),
                    cmbGender.getValue()
            ));

            if (b) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Added SuccessFully").show();

                tblStudent.getItems().add(new StudentTM(
                        txtStudentId.getText(),
                        txtStudentName.getText(),
                        txtAddress.getText(),
                        txtTellNo.getText(),
                        dateDOB.getValue(),
                        cmbGender.getValue()
                ));


            } else {
                new Alert(Alert.AlertType.WARNING, "Something Went Wring !!").show();
            }
        }else{
            studentBO.updateStudent(new StudentDTO(
                    txtStudentId.getText(),
                    txtStudentName.getText(),
                    txtAddress.getText(),
                    txtTellNo.getText(),
                    dateDOB.getValue(),
                    cmbGender.getValue()
            ));
            btnAdd.setText("Add Student");
            txtStudentId.setEditable(true);
            getAllStudent();
        }

    }

    public void StudentClearOnAction(ActionEvent actionEvent) {
        txtStudentId.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtTellNo.clear();
        dateDOB.setValue(null);
        cmbGender.setValue(null);
    }


    public void menuUpdateOnAction(ActionEvent actionEvent) {
        StudentTM selectedItem = tblStudent.getSelectionModel().getSelectedItem();

        txtStudentId.setText(selectedItem.getStudentId());
        txtStudentId.setEditable(false);
        txtStudentName.setText(selectedItem.getName());
        txtAddress.setText(selectedItem.getAddress());
        txtTellNo.setText(selectedItem.getTelNo());
        dateDOB.setValue(selectedItem.getDob());
        cmbGender.setValue(selectedItem.getGender());

        btnAdd.setText("UPDATE");


    }

    public void menuDeleteOnAction(ActionEvent actionEvent) throws IOException {

        StudentTM selectedItem = tblStudent.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem.getStudentId());
        if (studentBO.deleteStudent(selectedItem.getStudentId())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted SuccessFully").show();
            getAllStudent();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Went Wring !!").show();

        }


    }

}
