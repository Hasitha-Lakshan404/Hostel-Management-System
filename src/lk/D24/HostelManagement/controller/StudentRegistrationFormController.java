package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/24/2022
 * Time :2:50 PM
 */

public class StudentRegistrationFormController {
    public JFXComboBox cmbSelectStudent;
    public JFXComboBox cmbSelectRoom;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXDatePicker dateDOB;
    public JFXComboBox cmbGender;
    public JFXTextField txtRegistrationId;
    public JFXButton btnRegister;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
    }

    public void RegisterOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
    }
}
