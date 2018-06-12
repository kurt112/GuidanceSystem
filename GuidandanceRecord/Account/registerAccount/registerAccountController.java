package GuidandanceRecord.Account.registerAccount;
import Database.DatabaseCommands;
import GuidandanceRecord.Account.TableAccount.TableOfAccounts;
import GuidandanceRecord.Alert.AlertType;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class registerAccountController implements Initializable {
    @FXML private Button register;
    @FXML private Button back;
    @FXML private JFXTextField first_Name, user_Name, Contact, last_Name;

    @FXML private JFXPasswordField password, Rpassword;
    private int validation_To_Proceed = 0;




    private int proceed =0;

    Stage stage;
    private RequiredFieldValidator Fname_Validate = new RequiredFieldValidator();
    private RequiredFieldValidator Lname_Validate = new RequiredFieldValidator();
    private RequiredFieldValidator User_nameValidate = new RequiredFieldValidator();
    private RequiredFieldValidator Rawpass_Validate = new RequiredFieldValidator();
    private RequiredFieldValidator Re_Enter_Passwrd_FnameValidate = new RequiredFieldValidator();


    private void checkPass(String message){
        password.getValidators().add(Rawpass_Validate);
        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                Rawpass_Validate.setMessage(message);
                password.validate();
            }
        });

        Rpassword.getValidators().add(Re_Enter_Passwrd_FnameValidate);
        Rpassword.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                Re_Enter_Passwrd_FnameValidate.setMessage(message);
                Rpassword.validate();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        first_Name.getValidators().add(Fname_Validate);
        first_Name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                Fname_Validate.setMessage(AlertType.RequiredInput());
                first_Name.validate();
            }
        });
        last_Name.getValidators().add(Lname_Validate);
        last_Name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                Lname_Validate.setMessage(AlertType.RequiredInput());
                last_Name.validate();
            }
        });

        user_Name.getValidators().add(User_nameValidate);
        user_Name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                User_nameValidate.setMessage(AlertType.RequiredInput());
                user_Name.validate();
            }
        });
        checkPass(AlertType.RequiredInput());
    }
    private static int long_Contact_Number = 1;
    private static int password_Number = 1;

    public void register() throws IOException{
        if(first_Name.getText().trim().isEmpty() || last_Name.getText().trim().isEmpty()
                || user_Name.getText().trim().isEmpty() || Contact.getText().trim().isEmpty() || password.getText()
                .isEmpty() || Rpassword.getText().trim().isEmpty()){
            AlertType.notSuccessfulTextMessage();
        }
       RequiredFieldValidator MissMatch = new RequiredFieldValidator();
        if(password.getText().equals(Rpassword.getText())) {
            password_Number -= proceed;
            proceed += password_Number;
            password_Number--;
            password_Number=1;
            validation_To_Proceed++;
            System.out.println("asdf" + proceed);
            System.out.println("as" + password_Number);
        }else if(!password.getText().equals(Rpassword.getText())){
            if(proceed ==1){
                proceed=1;
            }
            AlertType.PasswordWasNotMatch();
            MissMatch.setMessage("Password do not match");
        }
         try{
             long newContact = Long.parseLong(Contact.getText());
            if(Contact.getText().trim().length() == 11){
                if(Contact.getText().startsWith("09")){
                    if(validation_To_Proceed >=1){
                        if(long_Contact_Number-proceed==0) {
                            System.out.println("the long contact" + long_Contact_Number);
                            System.out.println("The proceed in 2 " + proceed);
                        }
                        if(long_Contact_Number ==1){
                            proceed += long_Contact_Number ;
                            long_Contact_Number--;
                            long_Contact_Number=1;
                            System.out.println("the long contact" + long_Contact_Number);
                            System.out.println("The proceed in 2 " + proceed);
                        }
                    }
                }
                else {
                    AlertType.Contact_Number();
                }

            }
            else if(Contact.getText().trim().length() < 11 || Contact.getText().trim().length() > 11){
                AlertType.Contact_Number();
              if(validation_To_Proceed <1){
                  if(proceed == 1){
                      proceed = 0;
                  }else {
                      proceed = 0;
                  }
              }
              else if(validation_To_Proceed >=1){
                  if(proceed == 1){
                      proceed = 1;
                  }else if(proceed >= 2){
                      proceed = 1;
                  }
              }
         }
         if(proceed ==2){
             if( DatabaseCommands.register(first_Name.getText(),last_Name.getText(), user_Name.getText()
                     ,password.getText(), Rpassword.getText(), Contact.getText())){
                 AlertType.SuccessfulAddAccount();
                 clearDataInput();
                 FXMLLoader Table_Of_Accounts = new FXMLLoader(getClass().getResource("../TableAccount/Table_Of_Accounts.fxml"));
                 Parent anchorPane = Table_Of_Accounts.load();
                 TableOfAccounts tableOfAccounts= Table_Of_Accounts.getController();
                 tableOfAccounts.update_The_Controller();
             }else{
                 AlertType.NotSuccessfulAddAccount();
             }
         }

         }catch (NumberFormatException e){
             AlertType.Contact_Number();
        }

    }

    @FXML public void back() throws IOException {
        back.getScene().getWindow().hide();
    }

    private void clearDataInput(){
        first_Name.setText("");
        last_Name.setText("");
        user_Name.setText("");
        password.setText("");
        Rpassword.setText("");
        Contact.setText("");
    }

}



