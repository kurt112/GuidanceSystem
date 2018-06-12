package GuidandanceRecord.Login;

import Database.DatabaseCommands;
import GuidandanceRecord.Student.Body.AfterLogin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPassword implements Initializable{

    private String username;
    @FXML
    private Button Next;
    private Stage stage;
    @FXML
    public JFXPasswordField passwords;

    @FXML
    private Label errors;
    @FXML
    private JFXButton Back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        LoginUserName loginUserName = new LoginUserName();
//        System.out.println(loginUserName.getUserName());
  }

    @FXML
    public void Next() {
        if(DatabaseCommands.LoginPassword(this.username, passwords.getText())){
            goToNext();
        }else{
            errors.setVisible(true);
        }
    }

    private void goToNext() {
        try {
            stage = (Stage) Next.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Student/Body/AfterLogin.fxml"));
            Parent parent = fxmlLoader.load();
            AfterLogin afterLogin = fxmlLoader.getController();
            stage.setScene(new Scene(parent));
            stage.setMaximized(true);
            stage.setTitle("Student Table");
            stage.setMinWidth(1000);
            stage.show();
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void Enter(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            Next();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //This method is for forgot Password it wil
    //Text you a message in your phone bue
    @FXML
    public void forgot() {
        DatabaseCommands.ForgotPassword(this.username);
    }
    @FXML
    public void Back() {
     PrivateBack();
    }

    private void PrivateBack(){
        Runnable runnable = () -> Platform.runLater(() -> {
            try {
                stage = (Stage) Back.getScene().getWindow();
                FXMLLoader passwordForm = new FXMLLoader(getClass().getResource("LoginUserName.fxml"));
                Parent anchorPane = passwordForm.load();
                LoginUserName loginPassword= passwordForm.getController();
                loginPassword.setTheUserName(username);
                stage.setScene(new Scene(anchorPane));
                stage.setTitle("Password");
                stage.show();
                stage.centerOnScreen();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
