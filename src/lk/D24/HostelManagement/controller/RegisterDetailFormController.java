package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.D24.HostelManagement.bo.custom.ReserveDetailBO;
import lk.D24.HostelManagement.bo.custom.impl.ReserveDetailBOImpl;
import lk.D24.HostelManagement.dto.CustomDTO;
import lk.D24.HostelManagement.dto.ReserveDTO;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;
import lk.D24.HostelManagement.view.tdm.ReserveDetailTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/30/2022
 * Time :2:29 PM
 */


public class RegisterDetailFormController {

    public TableView<ReserveDetailTM> tblReserve;
    public JFXComboBox<String> cmbSearchRoomId;
    public JFXTextField txtUpdateStatus;
    public JFXComboBox<String> cmbRoomType;
    public JFXComboBox<String> cmbUpdateSelectStudent;
    public JFXComboBox<String> cmbUpdateSelectRoom;
    public JFXTextField txtReserveID;
    public JFXButton btnUpdate;
    public JFXCheckBox checkPaid;
    public JFXCheckBox checkNonPaid;
    public JFXCheckBox checkOtherPayment;

    LocalDate date;

    ReserveDetailBO reserveDetailBO = new ReserveDetailBOImpl();

    public void initialize() throws IOException {
        loadAllReservation();

        tblReserve.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("resId"));
        tblReserve.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblReserve.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblReserve.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblReserve.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));
        tblReserve.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("remainKeyMoney"));

        loadCmbData();
        loadSearchReserve();
        addCheckBoxListener();
    }


    public void loadAllReservation() throws IOException {
        tblReserve.getItems().clear();

        ArrayList<CustomDTO> allRes = reserveDetailBO.getAllReservationDetails();


        for (CustomDTO all : allRes) {

            String remain = "";
            String status = all.getStatus();

            if (status.equalsIgnoreCase("Paid")) {
                remain = "---";
            } else if (status.equalsIgnoreCase("Non-Paid")) {
                remain = String.valueOf(all.getKeyMoney());
            } else {
                if (!status.equals("")) {
                    double paid = Double.parseDouble(status);
                    remain = String.valueOf(all.getKeyMoney() - paid);
                }
            }


            tblReserve.getItems().add(new ReserveDetailTM(
                    all.getResId(),
                    all.getDate(),
                    all.getRegStudentId().getStudentId(),
                    all.getRegRoomId().getRoomTypeId(),
                    all.getStatus(),
                    remain
            ));

        }

    }

    public void menuEditOnAction(ActionEvent actionEvent) {

        ReserveDetailTM selectedItem = tblReserve.getSelectionModel().getSelectedItem();

        txtReserveID.setText(selectedItem.getResId());
        txtReserveID.setEditable(false);
        date = selectedItem.getDate();
        cmbUpdateSelectStudent.getSelectionModel().select(selectedItem.getStudentId());
        cmbUpdateSelectRoom.getSelectionModel().select(selectedItem.getRoomId());

        txtUpdateStatus.setText(selectedItem.getStatus());

    }

    private void loadCmbData() throws IOException {
        for (RoomDTO roomDTO : reserveDetailBO.getAllRoom()) {
            cmbUpdateSelectRoom.getItems().add(roomDTO.getRoomTypeId());
            cmbSearchRoomId.getItems().add(roomDTO.getRoomTypeId());
            cmbRoomType.getItems().add(roomDTO.getType());
        }

        for (StudentDTO dto : reserveDetailBO.getAllStudent()) {
            cmbUpdateSelectStudent.getItems().add(dto.getStudentId());
        }


    }


    private void loadSearchReserve(){
        cmbSearchRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                tblReserve.getItems().clear();
                try {
                    List<ReserveDTO> reserveDTOS = reserveDetailBO.searchReservedRoomById(newValue);


                    for (ReserveDTO reserveDTO : reserveDTOS) {
                        cmbRoomType.getSelectionModel().select(reserveDTO.getRoomId().getType());

                        String remain = "";
                        String status = reserveDTO.getStatus();

                        if (status.equalsIgnoreCase("Paid")) {
                            remain = "---";
                        } else if (status.equalsIgnoreCase("Non-Paid")) {
                            remain = String.valueOf(reserveDTO.getRoomId().getKeyMoney());
                        } else {
                            if (!status.equals("")) {
                                double paid = Double.parseDouble(status);
                                remain = String.valueOf(reserveDTO.getRoomId().getKeyMoney() - paid);
                            }
                        }



                        tblReserve.getItems().add(new ReserveDetailTM(
                                reserveDTO.getResId(),
                                reserveDTO.getDate(),
                                reserveDTO.getStudentId().getStudentId(),
                                reserveDTO.getRoomId().getRoomTypeId(),
                                reserveDTO.getStatus(),
                                remain
                        ));

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }


    public void menuDeleteOnAction(ActionEvent actionEvent) {
    }

    public void RoomClearOnAction(ActionEvent actionEvent) {
    }

    public void btnReserveUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Student student = new Student();
        student.setStudentId(cmbUpdateSelectStudent.getValue());

        Room room = new Room();
        room.setRoomTypeId(cmbUpdateSelectRoom.getValue());

        boolean b = reserveDetailBO.updateReservation(new ReserveDTO(
                txtReserveID.getText(),
                date,
                student,
                room,
                txtUpdateStatus.getText()));

        if(b){
            new Alert(Alert.AlertType.INFORMATION,"Reservation Updated!!").show();
            loadAllReservation();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Something Went Wrong").show();

        }
    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
    }

    public void clearFilerOnAction(ActionEvent actionEvent) throws IOException {
        loadAllReservation();
        cmbSearchRoomId.setValue(null);
        cmbRoomType.setValue(null);
    }


    private void addCheckBoxListener(){
        checkPaid.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                System.out.println("Paid clicked");
                
            }else{
                System.out.println("Paid clicked oFF");
            }

        });

        checkNonPaid.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                System.out.println("Non-Paid clicked");

            }else{
                System.out.println("Non-Paid clicked oFF");
            }

        });

        checkOtherPayment.selectedProperty().addListener((observable, oldValue, newValue) -> {
//            checkRoomType.selectedProperty().setValue(false);
            if(newValue!=null){
                System.out.println("Other-Paid clicked");

            }else{
                System.out.println("Other clicked oFF");
            }

        });
    }

    public void checkOnAction(ActionEvent actionEvent) {

    }

    public void checkNonPaidOnAction(ActionEvent actionEvent) {
    }

    public void checkOtherPayment(ActionEvent actionEvent) {
    }
}
