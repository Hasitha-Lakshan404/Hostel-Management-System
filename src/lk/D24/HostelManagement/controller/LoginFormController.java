package lk.D24.HostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.D24.HostelManagement.bo.custom.UserBO;
import lk.D24.HostelManagement.bo.custom.impl.UserBOImpl;
import lk.D24.HostelManagement.dto.UserDTO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :7/1/2022
 * Time :3:07 PM
 */

public class LoginFormController {

    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;
    public FontAwesomeIconView icnEye;
    public JFXTextField txtPassword;
    public JFXButton btnS;

    public AnchorPane apnMain;

    UserBO userBO=new UserBOImpl();

    public  void initialize(){
        txtPassword.setVisible(false);

        //copy values for passwordField
        txtPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            pwdPassword.setText(newValue);
        });
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

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        ArrayList<UserDTO> allUser = userBO.getAllUser();

        for (UserDTO userDTO : allUser) {

            if(userDTO.getUserName().equals(txtUserName.getText()) && userDTO.getPassword().equals(pwdPassword.getText())){
                lordWindow();
            }else{
                new Alert(Alert.AlertType.ERROR,"Login Failed..").show();
            }
        }

    }

    /*public void setUI(String URI) throws IOException {
        Stage stage = (Stage) btnS.getScene().getWindow();
        stage.close();


        apnMainPane.getChildren().clear();
        apnMainPane.getChildren().add(FXMLLoader.load(getClass().getResource("/lk/D24/HostelManagement/view/" + URI + ".fxml")));

    }*/



    public void lordWindow() throws IOException {

        Stage stage = (Stage) apnMain.getScene().getWindow();
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/lk/D24/HostelManagement/view/DashboardHomeForm.fxml"));

        Parent root1 = loader1.load();
        Scene scene1 = new Scene(root1);

        stage.setScene(scene1);

        DashboardHomeFormController controller = loader1.getController();
        controller.getAllData(txtUserName.getText(),pwdPassword.getText());

        stage.centerOnScreen();

    }

}
