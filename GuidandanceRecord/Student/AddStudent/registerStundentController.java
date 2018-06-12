    package GuidandanceRecord.Student.AddStudent;


    import Database.DatabaseCommands;

    import GuidandanceRecord.Account.HistoryOfLogin.HistoryOfLogin;
    import GuidandanceRecord.Login.LoginUserName;
    import com.jfoenix.controls.*;
    import com.jfoenix.validation.NumberValidator;
    import com.jfoenix.validation.RequiredFieldValidator;
    import javafx.application.Platform;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.layout.AnchorPane;
    import javafx.scene.layout.BorderPane;
    import javafx.stage.Stage;
    import java.io.IOException;
    import java.net.URL;
    import java.util.*;


    public class registerStundentController implements Initializable   {
        @FXML private JFXButton back;
        @FXML private JFXButton logout,updateStudent,deleteStudent, addStudent, generateForm, addOffense;
        private Stage stage;
        @FXML private JFXTextField Age,firstName,lastName, lrn, guardian, guardianNumber;
        @FXML private Label SexLabel,Firstname, Lastname, Adviser, Section,Lrn, Guardian, GuardianNumber, Date;
        @FXML private JFXDatePicker dates;
        @FXML private JFXRadioButton Male, Female;
        @FXML private JFXDatePicker DateStudent;
        @FXML private JFXComboBox Grades, Adviser_ComboBox, Section_ComboBox;


        private static String name;
        private static String ToStinrg;


        LoginUserName loginUserName = new LoginUserName();


        @Override
        public void initialize(URL location, ResourceBundle resources) {
           // DatabaseCommands.Get_Item();
            //verify(Age, firstName, lastName, lrn, guardian, guardianNumber);
            //add();
        }

        private void add(){
            ObservableList graded = FXCollections.observableArrayList();
            ObservableList Adviser_Names= FXCollections.observableArrayList();
            ObservableList Section = FXCollections.observableArrayList();
            for(int i=0; i<DatabaseCommands.getMenuItem().size(); i++) {
                graded.add(DatabaseCommands.getMenuItem().get(i).getGrade());
                Adviser_Names.add(DatabaseCommands.getMenuItem().get(i).getAdviser());
                Section.add(DatabaseCommands.getMenuItem().get(i).getSection());
            }
            Section_ComboBox.setItems(Section);
            Adviser_ComboBox.setItems(Adviser_Names);
            Grades.setItems(graded);
            //Student student = studentTable.getSelectionModel().getSel ectedItem();

        }

        private void verify(JFXTextField Age, JFXTextField firstName, JFXTextField lastName,
                           JFXTextField lrn, JFXTextField guardian,
                           JFXTextField guardianNumber) {

            RequiredFieldValidator validator = new RequiredFieldValidator();
            RequiredFieldValidator validator1 = new RequiredFieldValidator();
            RequiredFieldValidator validator2 = new RequiredFieldValidator();
            RequiredFieldValidator validator3 = new RequiredFieldValidator();
            RequiredFieldValidator validator4 = new RequiredFieldValidator();


            NumberValidator numberValidator1 = new NumberValidator();
            NumberValidator numberValidator2 = new NumberValidator();
            NumberValidator numberValidator3 = new NumberValidator();
            NumberValidator numberValidator4 = new NumberValidator();

            firstName.getValidators().add(validator);
            firstName.focusedProperty().addListener((observable, oldValue, newValue) -> {
                String fname = firstName.getText();
                Firstname.setText(fname);

                if(!newValue){
                    firstName.validate();
                }
            });
            validator.setMessage("This Field is Required");

            lastName.getValidators().add(validator1);
            lastName.focusedProperty().addListener((observable, oldValue, newValue) -> {

                if(!newValue){
                    lastName.validate();
                }
                String lastNam = lastName.getText();
                Lastname.setText(lastNam);

            });
            validator1.setMessage("This Fiel is Required");

            Adviser_ComboBox.focusedProperty().addListener((observable, oldValue, newValue) -> {

                try {
                    Adviser.setText(Adviser_ComboBox.getSelectionModel().getSelectedItem().toString());
                }catch (NullPointerException e){

                }
            });
            validator2.setMessage("This Field is Required");

            guardian.getValidators().add(validator4);
            guardian.focusedProperty().addListener((observable, oldValue, newValue) -> {

                String guard = guardian.getText();
                Guardian.setText(guard);

                if(!newValue){
                    guardian.validate();
                }else if(newValue == oldValue){
                    System.out.println("guardina name");
                }
            });
            validator4.setMessage("This Field is Required");

            RequiredFieldValidator validator5 = new RequiredFieldValidator();


            Section_ComboBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue){
                    return;
                }
                try{
                    String section= Section_ComboBox.getSelectionModel().getSelectedItem().toString();
                    Section.setText(section);
                }catch (NullPointerException e){

                }
            });

            validator5.setMessage("This Field is Required");
            NumberValidator numberValidator = new NumberValidator();

            guardianNumber.getValidators().add(numberValidator);
            guardianNumber.focusedProperty().addListener((observable, oldValue, newValue) -> {

                if(newValue.toString().trim().length() >=12){
                    guardianNumber.validate();
                }
                String guard = guardianNumber.getText();
                GuardianNumber.setText(guard);

            });
            numberValidator.setMessage("This field Required Number");

            Age.getValidators().add(numberValidator1);
            Age.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue){
                    Age.validate();
                }

    //
    // String guard = guardianNumber.getText();
    //            GuardianNumber.setText(guard);
            });
            //numberValidator1.setMessage("This field Required Number");

            lrn.getValidators().add(numberValidator2);
            lrn.focusedProperty().addListener((observable, oldValue, newValue) -> {
//                if(!newValue){
//                    lrn.validate();
//                }


                String fname = lrn.getText();
                Lrn.setText(fname);
            });
            numberValidator2.setMessage("This field Required Number");


        }

        @FXML public void registers(){
           Grades.getSelectionModel().getSelectedItem();
            DatabaseCommands.registerStudent(firstName.getText(), lastName.getText(),"","",""
            ,"","","","","","","","");
            System.out.println();
             firstName.setText("");
            lastName.setText("");
            lrn.setText("");
            guardian.setText("");
            guardianNumber.setText("");
            Age.setText("");
            Grades.setPromptText("Grade");
        }

        @FXML public void back() {
            back.getScene().getWindow().hide();
           DatabaseCommands.getDBCommands().close();
        }

        @FXML public void logouts() {
            Runnable runnable = () ->{
                Platform.runLater(() ->{
                    try {
                        stage = (Stage) logout.getScene().getWindow();
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("../../Login/LoginUserName.fxml"));
                        Scene scene = new Scene(pane);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.centerOnScreen();

                    } catch (IOException e) {
                        e.getCause();
                    }
                });
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }

        @FXML public void studentTables() {
         Runnable runnable = () -> Platform.runLater(()->{
             try{
                 stage = (Stage) addStudent.getScene().getWindow();
                 Parent pane = FXMLLoader.load(getClass().getResource("../../Student/Body/AfterLogin.fxml"));
                 Scene scene = new Scene(pane);
                 stage.setScene(scene);
                stage.centerOnScreen();
                 stage.show();
             }catch (IOException e){
                 e.printStackTrace();
             }
         });
         Thread thread = new Thread(runnable);
         thread.start();
        }

        @FXML public void generateForms() {
          if(loginUserName.getAdmin() == false){
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Canot go to the Admin area");
              alert.setContentText("you have only a free trial of this System");
              alert.show();

          }else if(loginUserName.getAdmin()== true){
              Runnable runnable = () -> Platform.runLater(()->{
                  try{
                      stage = (Stage) addStudent.getScene().getWindow();
                      Parent pane = FXMLLoader.load(getClass().getResource("../../Account/TableAccount/Table_Of_Accounts.fxml"));
                      Scene scene = new Scene(pane);
                      stage.centerOnScreen();
                      stage.setScene(scene);
                  }catch (IOException e){
                      e.printStackTrace();
                  }
              });
              Thread thread = new Thread(runnable);
              thread.start();
          }
        }

        @FXML public void deleteStudents() {
        generateForms();
        }

       @FXML public void updateStudents() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You can't update on Register Area");
            alert.setTitle("Can't Update");
            alert.showAndWait();
        }

        @FXML public void addOffenses() {
            if(loginUserName.getAdmin() == true){
                Runnable runnable = () -> Platform.runLater(()->{
                    try{
                        stage = (Stage) addStudent.getScene().getWindow();
                        Parent pane = FXMLLoader.load(getClass().getResource("../../Account/HistoryOfLogin/HistoryOfLogin.fxml"));
                        Scene scene = new Scene(pane);
                        stage.centerOnScreen();
                        stage.setScene(scene);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                });
                Thread thread = new Thread(runnable);
                thread.start();

            }else if(loginUserName.getAdmin() == false){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Canot go to the Admin area");
                alert.setContentText("you have only a free trial of this System");
                alert.show();
            }
        }

        @FXML public void Female() {
            SexLabel.setText(Female.getText());
            name = Female.getText();
        }

        public void Male() {
            SexLabel.setText(Male.getText());
            name = Male.getText();

        }

        public void PickDate(){
            ToStinrg = DateStudent.getValue().toString();
            Date.setText(ToStinrg);
        }

        /*
        This Method will send a Message
        to a specific Person
         */
      @FXML  public void SendMessage() {
          HistoryOfLogin historyOfLogin = new HistoryOfLogin();
          historyOfLogin.Message();
      }
    }