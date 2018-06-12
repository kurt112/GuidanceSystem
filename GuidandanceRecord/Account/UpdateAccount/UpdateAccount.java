package GuidandanceRecord.Account.UpdateAccount;


import Database.DatabaseCommands;
import GuidandanceRecord.Account.TableAccount.TableOfAccounts;
import GuidandanceRecord.Alert.AlertType;
import GuidandanceRecord.DataModel.Account.Account;
import GuidandanceRecord.Login.LoginPassword;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class UpdateAccount {
    @FXML private JFXTextField firstName, lastName, userName, Number;
    @FXML private JFXPasswordField  Password, Re_enterPassword;
    String fName, lName, uName, Pass, Re_Pass, Num,No,admin;
    @FXML private static boolean getClick =true;
    public void getData(Account account){
        firstName.setText(account.getFirst_Name());
        lastName.setText(account.getLast_Name());
        userName.setText(account.getUserName());
        Password.setText(account.getPassword());
        Re_enterPassword.setText(account.getRe_EnterPassword());
        Number.setText(account.getContactNumber());

    }

    public void UpdateIt(Account account){
       admin=account.getAdmin();
        No=account.getNo();
        fName = account.getFirst_Name();
        lName = account.getLast_Name();
        uName = account.getUserName();
        Pass = account.getPassword();
        Re_Pass = account.getRe_EnterPassword();
        Num = account.getContactNumber();
    }

    public String getfName() {
        return firstName.getText();
    }

    public String getlName() {
        return lastName.getText();
    }

    public String getuName() {
        return userName.getText();
    }

    public String getPass() {
        return Password.getText();
    }

    public String getRe_Pass() {
        return Re_enterPassword.getText();
    }

    public String getNum() {
        return Number.getText();
    }

    @FXML public void back() {
        Number.getScene().getWindow().hide();
        getClick = false;
    }



    @FXML public boolean Update()throws IOException {
        if(DatabaseCommands.UpdateAccount(firstName.getText(),
                lastName.getText(), userName.getText(), Number.getText(),Password.getText(),
                Re_enterPassword.getText(), No)){

            FXMLLoader Table_Of_Accounts = new FXMLLoader(getClass().getResource("../TableAccount/Table_Of_Accounts.fxml"));
            Parent anchorPane = Table_Of_Accounts.load();
            TableOfAccounts tableOfAccounts= Table_Of_Accounts.getController();
            tableOfAccounts.update_The_Controller();
            AlertType.SuccessfulUpdate();
            return true;
        }
        return false;
    }

    public static boolean isGetClick() {
        return getClick;
    }
}
