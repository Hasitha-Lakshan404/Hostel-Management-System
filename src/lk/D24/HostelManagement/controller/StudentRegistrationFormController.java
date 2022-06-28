package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import lk.D24.HostelManagement.bo.custom.ReservationBO;
import lk.D24.HostelManagement.bo.custom.RoomBO;
import lk.D24.HostelManagement.bo.custom.impl.ReservationBOImpl;
import lk.D24.HostelManagement.bo.custom.impl.RoomBOImpl;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;

import java.io.IOException;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/24/2022
 * Time :2:50 PM
 */

public class StudentRegistrationFormController {
    public JFXComboBox<String> cmbSelectStudent;
    public JFXComboBox<String> cmbSelectRoom;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXDatePicker dateDOB;
    public JFXComboBox<String> cmbGender;
    public JFXTextField txtRegistrationId;
    public JFXButton btnRegister;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;


    ReservationBO reservationBO=new ReservationBOImpl();

    public void initialize() throws IOException {

        cmbGender.getItems().addAll("Male","FeMale");

        for (StudentDTO dto : reservationBO.getAllStudent()) {
            cmbSelectStudent.getItems().add(dto.getStudentId());
        }

        for (RoomDTO roomDTO : reservationBO.getAllRoom()) {
            cmbSelectRoom.getItems().add(roomDTO.getRoomTypeId());
        }

        cmbSelectRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                Room room = null;
                try {
                    room = reservationBO.getRoom(newValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                txtRoomType.setText(room.getType());
                txtKeyMoney.setText(String.valueOf(room.getKeyMoney()));
                txtQty.setText(String.valueOf(room.getQty()));
            }


        });

        cmbSelectStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                Student student = null;
                try {
                    student = reservationBO.getStudent(newValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                txtStudentName.setText(student.getName());
                txtAddress.setText(student.getAddress());
                cmbGender.getSelectionModel().select(student.getGender());
                dateDOB.setValue(student.getDob());
            }


        });
    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {

    }

    public void RegisterOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
    }
}
