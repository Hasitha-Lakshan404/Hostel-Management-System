package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.D24.HostelManagement.bo.custom.RoomBO;
import lk.D24.HostelManagement.bo.custom.impl.RoomBOImpl;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.view.tdm.RoomTM;

import java.io.IOException;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/21/2022
 * Time :5:03 PM
 */

public class RoomFormController {
    public TableView<RoomTM> tblRoom;
    public JFXTextField txtRoomId;
    public JFXButton btnAdd;
    public TextField txtSearchRoom;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;

    RoomBO roomBO = new RoomBOImpl();

    public void initialize() throws IOException {
        tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadAllRooms();
    }

    public void loadAllRooms() throws IOException {
        for (RoomDTO roomDTO : roomBO.getAllRoom()) {
            tblRoom.getItems().add(new RoomTM(
                    roomDTO.getRoomTypeId(),
                    roomDTO.getType(),
                    roomDTO.getKeyMoney(),
                    roomDTO.getQty()
            ));
        }

    }

    public void menuEditOnAction(ActionEvent actionEvent) {
    }

    public void menuDeleteOnAction(ActionEvent actionEvent) {
    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
    }

    public void RoomAddOnAction(ActionEvent actionEvent) {
    }

    public void RoomClearOnAction(ActionEvent actionEvent) {
    }

    public void searchDetails(KeyEvent keyEvent) {
    }
}
