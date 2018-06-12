package GuidandanceRecord.Alert;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public final class AlertType {
    private AlertType(){

    }

    public static void EmptyTable(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(" There are no Contact ");
        alert.setHeaderText(null);
        alert.setContentText(" You table is empty ");
        alert.showAndWait();
    }

    public static void SuccessfulUpdate(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Successful ");
        alert.setHeaderText(null);
        alert.setContentText(" Update Successful ");
        alert.show();
    }

    public static void NotSuccessfulUpdate(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(" Something went wrong ");
        alert.setHeaderText(null);
        alert.setContentText(" Update not Successful");
        alert.show();
    }

    public static void SuccessfulAddStudent(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Successful ");
        alert.setHeaderText(null);
        alert.setContentText(" Add Student Successful ");
        alert.show();
    }

    public static void NotSuccessfulAddStudent(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Something went Wrong ");
        alert.setHeaderText(null);
        alert.setContentText(" Add Studnet not Succesful ");
        alert.show();
    }

    public static void SuccessfulTextMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Success ");
        alert.setHeaderText(null);
        alert.setContentText(" Text Message Success ");
        alert.show();

    }

    public static void notSuccessfulTextMessage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(" Something went Wrong ");
        alert.setHeaderText(" Please repeat the process");
        alert.show();
    }

    public static void notAdmin(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" This Section is for Admin ");
        alert.setContentText(" You must buy this System to access this feature ");
        alert.setHeaderText(null);
        alert.show();
    }

    public static void AddRecordSuccessful(String name){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(" Successful ");
        alert.setContentText(" Updating record of " + name + " is Successful");
        alert.show();
    }

    public static void AddRecordUnSuccessful(String name){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(" Not Successful ");
        alert.setContentText(" Updating record of " + name + " is Not Successful");
        alert.show();

    }

    public static void SuccessfulAddAccount(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Successful ");
        alert.setHeaderText(null);
        alert.setContentText(" Add Account Successful ");
        alert.show();
    }

    public static void NotSuccessfulAddAccount(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Something went Wrong ");
        alert.setHeaderText(null);
        alert.setContentText(" Add Account not Succesful ");
        alert.show();
    }
    public static void OpenNoteCredits() {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\Abby Orioque\\Desktop\\GuidanceRecord\\src\\GuidandanceRecord\\Credits.txt"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean Delete_Item (String Property){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(" Delete " + Property);
        alert.setHeaderText(null);
        alert.setContentText(" Are you sure do you want to Delete this " + Property);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        }
        return  false;
    }

    /*
    This Method Will load the Guide
    Of the System
     */

    public static void Notes() {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\Abby Orioque\\Desktop\\GuidanceRecord\\src\\GuidandanceRecord\\Note fort this System.txt"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void PasswordWasNotMatch(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Not Match ");
        alert.setHeaderText(null);
        alert.setContentText(" Your password not match ");
        alert.show();
    }

    public static String RequiredInput(){
        return "This Field is required";
    }

    public static String ErrorPassword(){
        return "Your Password does not Match";
    }

    public static String NumberValidator(){
        return "This Field Required Number";
    }

    public static void Contact_Number(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Already Exist or Not Valid Contact Number");
        alert.setHeaderText(null);
        alert.setContentText(" Try something new ");
        alert.show();
    }


}
