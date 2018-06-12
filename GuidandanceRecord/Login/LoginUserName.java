package GuidandanceRecord.Login;

import Database.DatabaseCommands;
import com.jfoenix.controls.JFXCheckBox;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginUserName{
    @FXML
    private Hyperlink register;
    @FXML
    private Button Next;
    @FXML private JFXCheckBox Admin;
    @FXML private  TextField  user;
    @FXML private AnchorPane AnchorPane;
    private Stage stage;
    @FXML
    private Label errors;

    private static boolean admin;
//    private String finalUser = user.getText();
    private void goToLoginPassword(){
        try {
            stage = (Stage) Next.getScene().getWindow();
            FXMLLoader passwordForm = new FXMLLoader(getClass().getResource("LoginPassword.fxml"));
            Parent anchorPane = passwordForm.load();
            LoginPassword loginPassword= passwordForm.getController();
            System.out.println(loginPassword + "kurt");

//            loginPassword.setUsername(user.getText().trim());
//            stage.setScene(new Scene(anchorPane));
//            stage.setTitle("Password");
//            stage.show();
//            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @FXML
    public void Next() {
        goToLoginPassword();
        if(DatabaseCommands.getDBCommands().LoginUserName(Admin.isSelected(), user.getText())){
            if(Admin.isSelected()){
             admin =true;
                 goToLoginPassword();
             return;
            }
            goToLoginPassword();
            System.out.println("asf");
        }else{
            errors.setVisible(true);
            System.out.println("asdfsdf");
        }
    }
    //databaseCommands.close();

    //}
    @FXML public void register(){
        Goto_Register();
    }

    private void Goto_Register(){
        Runnable runnable = () -> Platform.runLater(() ->{
            try{
                stage = (Stage) register.getScene().getWindow();
                AnchorPane root = FXMLLoader.load(getClass().getResource("../Account/registerAccount/Register.fxml"));
                Scene scene = new Scene(root);
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.setTitle("Register here");
                stage.setHeight(550);
                stage.setWidth(800);
            }
            catch ( IOException e){
                e.printStackTrace();
            }
        });

        Thread thread = new Thread(runnable);
        thread.start();
    }

    @FXML public void inputs(){
        String text = user.getText();
        boolean disable = text.isEmpty() || text.trim().isEmpty();
        Next.setDisable(disable);
    }

    @FXML public void Enter(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) { Next(); }
    }
    public TextField getUser() {
        return user;
    }
    public void setTheUserName(String value){
        user.setText(value);
    }
    public boolean getAdmin(){ return admin; }

    public AnchorPane anchorPane(){
        return this.AnchorPane;
    }

}