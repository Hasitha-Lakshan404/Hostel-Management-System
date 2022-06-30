package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.D24.HostelManagement.bo.custom.ReserveDetailBO;
import lk.D24.HostelManagement.bo.custom.impl.ReserveDetailBOImpl;
import lk.D24.HostelManagement.dto.CustomDTO;
import lk.D24.HostelManagement.view.tdm.ReserveDetailTM;

import java.io.IOException;
import java.util.ArrayList;

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

    ReserveDetailBO reserveDetailBO = new ReserveDetailBOImpl();

    public void initialize() throws IOException {
        loadAllReservation();

        tblReserve.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("resId"));
        tblReserve.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblReserve.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblReserve.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblReserve.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));
        tblReserve.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("remainKeyMoney"));
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
    }

    public void menuDeleteOnAction(ActionEvent actionEvent) {
    }

    public void RoomClearOnAction(ActionEvent actionEvent) {
    }

    public void btnReserveUpdateOnAction(ActionEvent actionEvent) {
    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
    }
}
