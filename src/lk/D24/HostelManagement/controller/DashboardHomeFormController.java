package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/19/2022
 * Time :11:44 PM
 */

public class DashboardHomeFormController {

    public Label lblUserShow;
    public Label lblHomeTitleShow;
    public Rectangle icnRecSide;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane apnMainPane;
    public AnchorPane apnSideNamePane;
    public JFXButton btnSettings;
    public AnchorPane clockPane;
    public Label lblForStage;


    public void initialize(){
        apnSideNamePane.setVisible(false);
    }

    public void iconSideMouseEnteredOnAction(MouseEvent mouseEvent) {
        apnSideNamePane.setVisible(true);
    }

    public void apnNameMouseExitedOnAction(MouseEvent mouseEvent) {
        apnSideNamePane.setVisible(false);
    }

    public void buttonsClickOnAction(MouseEvent mouseEvent) throws IOException {
        Object o = mouseEvent.getSource();

        if (o instanceof JFXButton){
            JFXButton button= (JFXButton) o;

            if(button.getId().equals("dashBoardButton")){

            }if(button.getId().equals("studentButton")){
                setUI("StudentForm");

            }if(button.getId().equals("roomButton")){
                setUI("RoomForm");

            }if(button.getId().equals("registerStudentButton")){
                setUI("StudentRegistrationForm");

            }if(button.getId().equals("reservationDetailButton")){
                setUI("RegisterDetailForm");

            }if(button.getId().equals("LogoutButton")){

            }

        }

    }

    public void setUI(String URI) throws IOException {
        apnMainPane.getChildren().clear();
        apnMainPane.getChildren().add(FXMLLoader.load(getClass().getResource("/lk/D24/HostelManagement/view/" + URI + ".fxml")));

    }

    public void clockStartOnAction(MouseEvent mouseEvent) throws Exception {

    }

    String userName;
    public void getAllData(String text) {
        userName=text;
        lblUserShow.setText(userName);
    }
}
