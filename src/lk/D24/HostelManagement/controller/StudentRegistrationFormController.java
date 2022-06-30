package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import lk.D24.HostelManagement.bo.custom.ReservationBO;
import lk.D24.HostelManagement.bo.custom.RoomBO;
import lk.D24.HostelManagement.bo.custom.impl.ReservationBOImpl;
import lk.D24.HostelManagement.bo.custom.impl.RoomBOImpl;
import lk.D24.HostelManagement.dto.ReserveDTO;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
    public JFXTextField txtStatus;

    public Label lblAvailable;
    public Label lblAllRooms;
    public Label lblUsedRooms;
    public Label lblRemainingRooms;


    ReservationBO reservationBO=new ReservationBOImpl();

    public void initialize() throws IOException {

        lblAvailable.setText("................");
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
                lblAllRooms.setText(String.valueOf(room.getQty()));

                try {
                    List<ReserveDTO> reserveDTOS = reservationBO.searchReservedRoomById(newValue);

                    int count=0;
                    for (ReserveDTO reserveDTO : reserveDTOS) {
                        count++;
                    }

                    int remainQty=Integer.parseInt(txtQty.getText())-count;
                    lblUsedRooms.setText(String.valueOf(count));
                    lblRemainingRooms.setText(String.valueOf(remainQty));

                    if(remainQty==0){
                        lblAvailable.setText("Un-Available");
                    }else{
                        lblAvailable.setText("Available");
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
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

        searchRoomQty();
    }


    private void searchRoomQty(){

    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {

    }

    public void RegisterOnAction(ActionEvent actionEvent) throws IOException {
        if(lblAvailable.getText().equalsIgnoreCase("Available")) {
            Student student = new Student();
            student.setStudentId(cmbSelectStudent.getValue());

            Room room = new Room();
            room.setRoomTypeId(cmbSelectRoom.getValue());
            reservationBO.registerStudent(new ReserveDTO(
                    txtRegistrationId.getText(),
                    LocalDate.now(),
                    student,
                    room,
                    txtStatus.getText()
            ));
            clear();
            lblAllRooms.setText("00");
            lblUsedRooms.setText("00");
            lblRemainingRooms.setText("00");
        }else{
           new  Alert(Alert.AlertType.WARNING,"You Can't Register Student for This Room").show();
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        clear();
    }
    private void clear(){
        cmbSelectStudent.setValue(null);
        cmbSelectRoom.setValue(null);
        txtStatus.clear();
    }
}
