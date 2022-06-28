package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import lk.D24.HostelManagement.bo.custom.RoomBO;
import lk.D24.HostelManagement.bo.custom.impl.RoomBOImpl;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.view.tdm.RoomTM;
import lk.D24.HostelManagement.view.tdm.StudentTM;

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
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    public JFXComboBox<String> cmbRoomType;
    public JFXTextField txtRoomId1;
    public JFXButton btnAddRoomType;
    public JFXCheckBox checkRoomType;
    public JFXCheckBox checkRoomId;
    public JFXButton btnAddRoomId;
    public JFXComboBox<String> cmbRoomId;
    public JFXTextField txtRoomType;
    public Rectangle recType;
    public Rectangle recId;

    RoomBO roomBO = new RoomBOImpl();

    public void initialize() throws IOException {
        tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));


        btnAddRoomType.setDisable(true);
        txtRoomType.setDisable(true);
        recType.setDisable(true);

        btnAddRoomId.setDisable(true);
        txtRoomId.setDisable(true);
        recId.setDisable(true);



        loadAllRooms();
        cmbRoomType.getItems().setAll("Non-AC","Non-AC/Food","AC","AC/Food");


        enableDisableCheckBox(checkRoomType, btnAddRoomType, txtRoomType, recType);

        enableDisableCheckBox(checkRoomId, btnAddRoomId, txtRoomId, recId);
    }

    private void enableDisableCheckBox(JFXCheckBox checkBox, JFXButton btnAdd, JFXTextField txtRoom, Rectangle rectangle) {
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                btnAdd.setDisable(false);
                txtRoom.setDisable(false);
                rectangle.setDisable(false);
            }else{
                btnAdd.setDisable(true);
                txtRoom.setDisable(true);
                rectangle.setDisable(true);
            }
        });
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

    public void menuDeleteOnAction(ActionEvent actionEvent) throws IOException {
        RoomTM selectedItem = tblRoom.getSelectionModel().getSelectedItem();


        if (roomBO.deleteRoom(selectedItem.getRoomTypeId())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted SuccessFully").show();
            loadAllRooms();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Went Wring !!").show();

        }
    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
    }

    public void RoomAddOnAction(ActionEvent actionEvent) throws IOException {
        roomBO.saveRoom(new RoomDTO(
                txtRoomId.getText(),
                cmbRoomType.getValue(),
                Double.parseDouble(txtKeyMoney.getText()),
                Integer.parseInt(txtQty.getText())
        ));
    }

    public void RoomClearOnAction(ActionEvent actionEvent) {
    }

    public void searchDetails(KeyEvent keyEvent) {
    }
}
