package GuidandanceRecord.TextMessage;

import GuidandanceRecord.Alert.AlertType;
import GuidandanceRecord.DataModel.StudentProfile.Student;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MessageUi{
    @FXML private JFXButton back;
    @FXML private TextField ContactNumber;
    @FXML private TextArea Message;

    public void SendMessage(){
            if(ContactNumber.getText().startsWith("09")){
                if(ContactNumber.getText().trim().length() == 11){
                    try{
                        String email = URLEncoder.encode("kurtorioque112@gmail.com","UTF-8");
                        String password= URLEncoder.encode("orioque35", "UTF-8");

                        String device = URLEncoder.encode("81483", "UTF-8");
                        String nubmber = URLEncoder.encode(ContactNumber.getText(),"UTF-8");
                        String message = URLEncoder.encode(Message.getText(),"UTF-8");

                        String smsgateway = "http://smsgateway.me/api/v3/messages/send?";


                        smsgateway += "email=" +email;
                        smsgateway += "&password=" +password;
                        smsgateway += "&device=" +device;
                        smsgateway += "&number=" +nubmber;
                        smsgateway += "&message=" +message;

                        URL url = new URL(smsgateway);
                        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                        connection.setRequestMethod("POST");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Message Send Successful");
                        alert.setContentText("Your Message was sent On" + ContactNumber.getText());
                        alert.show();
                        connection.getResponseMessage();
                        connection.getRequestMethod();
                        connection.getResponseCode();
                        AlertType.SuccessfulTextMessage();

                    }catch (Exception e){
                        AlertType.notSuccessfulTextMessage();
                    }
                }
                    }else {
                AlertType.notSuccessfulTextMessage();
                }
    }



    public void updateField_Student(Student student){
        if(student.getGuardianContact() == null){
            ContactNumber.setText("09");
        }
            ContactNumber.setText(student.getGuardianContact());
    }

    public String getNumber(){
        return  ContactNumber.getText();
    }

    public String getText(){ return Message.getText(); }

    @FXML public void back() {
        back.getScene().getWindow().hide();
    }

    @FXML public void setContactNumber(String contactNumber) {
        this.ContactNumber.setText(contactNumber);
        System.out.println(contactNumber);
    }
}
