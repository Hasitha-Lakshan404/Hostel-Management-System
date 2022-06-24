package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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
    public JFXComboBox cmbGender;
    public TableView tblStudent;
    public JFXButton btnAdd;
    public TableView tblRoom;
    public JFXTextField txtRoomId;
    public TextField txtSearchRoom;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
    }

    public void studentAddOnAction(ActionEvent actionEvent) {
    }

    public void StudentClearOnAction(ActionEvent actionEvent) {
    }

    public void menuEditOnAction(ActionEvent actionEvent) {
    }

    public void menuDeleteOnAction(ActionEvent actionEvent) {
    }

    public void RoomAddOnAction(ActionEvent actionEvent) {
    }

    public void RoomClearOnAction(ActionEvent actionEvent) {
    }

    public void searchDetails(KeyEvent keyEvent) {
    }
}
