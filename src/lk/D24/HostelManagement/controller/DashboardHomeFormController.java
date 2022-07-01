package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.D24.HostelManagement.bo.custom.UserBO;
import lk.D24.HostelManagement.bo.custom.impl.UserBOImpl;
import lk.D24.HostelManagement.dto.UserDTO;
import lk.D24.HostelManagement.entity.User;

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
    public JFXButton btnCustomer;
    public JFXButton btnItem;
    public JFXButton btnDashboard;
    public AnchorPane txtDownPane;
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;
    public FontAwesomeIconView icnEye;
    public JFXTextField txtPassword;
    public JFXButton btnUpdate;
    public JFXTextField txtOldPassword;

    UserBO userBO=new UserBOImpl();

    public void initialize(){
        apnSideNamePane.setVisible(false);
        txtDownPane.setVisible(false);

        //copy values for passwordField
        txtPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            pwdPassword.setText(newValue);
        });

        txtUserName.setEditable(false);

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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginForm.fxml"));
                Parent parent= loader.load();
                Stage stage =new Stage(StageStyle.DECORATED);
                stage.setTitle("Login");
                stage.setScene(new Scene(parent));
                stage.show();

                Stage stage1 = (Stage) btnCustomer.getScene().getWindow();
                stage1.close();
            }

        }

    }

    public void setUI(String URI) throws IOException {
        apnMainPane.getChildren().clear();
        apnMainPane.getChildren().add(FXMLLoader.load(getClass().getResource("/lk/D24/HostelManagement/view/" + URI + ".fxml")));

    }

    String userName;
    String pas;

    public void getAllData(String text, String password) {
        userName=text;
        lblUserShow.setText(userName);
        txtUserName.setText(lblUserShow.getText());

        pas=password;

    }

    public void signInOnAction(ActionEvent actionEvent) {
        
    }

    public void eyeClickOnAction(MouseEvent mouseEvent) {
        if (icnEye.getGlyphName().equals("EYE_SLASH")) { // must show password
            icnEye.setGlyphName("EYE");

            txtPassword.setText(pwdPassword.getText()); //copy PwdPassword data to  txtPW
            pwdPassword.setVisible(false);  //PWField hidden
            txtPassword.setVisible(true);   //txtField Shown

        } else if (icnEye.getGlyphName().equals("EYE")) {  // must hide  password
            icnEye.setGlyphName("EYE_SLASH");

            pwdPassword.setText(txtPassword.getText());
            txtPassword.setVisible(false); //txtField hide
            pwdPassword.setVisible(true);  //PWField shown

        }
    }

    public void upDownClickOnAction(MouseEvent mouseEvent) throws IOException {
        txtDownPane.setVisible(true);

        for (UserDTO userDTO : userBO.getAllUser()) {

            if(txtUserName.getText().equals(userDTO.getUserName()) ){

                txtOldPassword.setText(userDTO.getPassword());
            }
        }

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        txtOldPassword.setText(pas);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {

        for (UserDTO userDTO : userBO.getAllUser()) {

            if(txtUserName.getText().equals(userDTO.getUserName()) && txtOldPassword.getText().equals(userDTO.getPassword())){

                System.out.println(userDTO.getUserId()+" - "+userDTO.getName()+" - "+userDTO.getUserName() +" - "+userDTO.getPassword());

                userBO.updateUser(new UserDTO(
                        userDTO.getUserId(),
                        userDTO.getName(),
                        userDTO.getUserName(),
                        pwdPassword.getText()
                ));

                pwdPassword.clear();
                txtPassword.clear();

            }
        }

    }

    public void centerPaneClickOnAction(MouseEvent mouseEvent) {
        txtDownPane.setVisible(false);
    }
}
