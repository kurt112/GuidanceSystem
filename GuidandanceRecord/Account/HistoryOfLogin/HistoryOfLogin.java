package GuidandanceRecord.Account.HistoryOfLogin;

import Database.DatabaseCommands;
import GuidandanceRecord.DataModel.Account.Account;
import GuidandanceRecord.DataModel.StudentProfile.Student;
import GuidandanceRecord.Login.LoginUserName;
import GuidandanceRecord.Student.Body.AfterLogin;
import GuidandanceRecord.TextMessage.MessageUi;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HistoryOfLogin implements Initializable {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label status;

    @FXML
    private JFXButton StudentTables;

    @FXML
    private Label UserName;

    @FXML
    private JFXButton Addstudent, tb, logout;

    @FXML
    private TableView<Account> AccountTables;

    @FXML
    private TableColumn<Account, Account> No,fName,lName,user,password,ContactNumber,Date;

    private Stage stage;

    LoginUserName loginUserName = new LoginUserName();

    private FilteredList filteredList = new FilteredList(DatabaseCommands.getDBCommands().getAccountsHistory());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        UserName.setText(loginUserName.usersName());
        AccountTables.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                Account account = AccountTables.getSelectionModel().getSelectedItem();
                Firstname.setText(account.getFirst_Name());
                Lastname.setText(account.getLast_Name());
                Adviser.setText(account.getUserName());
                Password.setText(account.getPassword());
                Contact.setText(account.getContactNumber());
                Dates.setText(account.getDate());
            }
        });

        fName.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
        lName.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
        user.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        ContactNumber.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        AccountTables.setItems(DatabaseCommands.getDBCommands().getAccountsHistory());
    }

    @FXML
    private TextField search;

    @FXML
    private Label Firstname;

    @FXML
    private Label Lastname;

    @FXML
    private Label Adviser;

    @FXML
    private Label Contact;

    @FXML
    private Label Password;

    @FXML
    private Label Dates;

    @FXML
    private Label GuardianNumber;

    @FXML
   public void Message() {
        Account acc = AccountTables.getSelectionModel().getSelectedItem();

        Runnable runnable = () -> Platform.runLater(() ->{
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainBorderPane.getScene().getWindow());
            FXMLLoader fxmlLoader = new FXMLLoader();
            dialog.setTitle("Update A student");
            fxmlLoader.setLocation(getClass().getResource("../../TextMessage/MessageUi.fxml"));

            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            MessageUi message = fxmlLoader.getController();
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Optional<ButtonType> result = dialog.showAndWait();

            if(result.isPresent() && result.get() == ButtonType.OK){

                DatabaseCommands.getDBCommands().open();
                java.util.Date date = new Date();
                date.equals(LocalDate.now());
                date.toString();
                try(Statement statement = DatabaseCommands.getDBCommands().getConn().createStatement()){
                    statement.execute("INSERT  INTO " + DatabaseCommands.getDBCommands().getMessageTable()
                            + " VALUES ('" + message.getText()
                            + "', '" + message.getNumber()
                            + "', '" + date
                            +"')");
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                DatabaseCommands.getDBCommands().close();
            }
        });
        Thread theard = new Thread(runnable);
        theard.start();
    }

    @FXML
    void Search() {

            search.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                filteredList.setPredicate((Predicate<? super Account>) (Account acount) -> {
                    search.getText().toLowerCase();
                    oldValue.toLowerCase();
                    newValue.toLowerCase();
                    if (newValue.isEmpty() || newValue == null) {
                        return true;
                    }
                    if (acount.getFirst_Name().toLowerCase().trim().contains(newValue)) {
                        return true;
                    }
                    if (acount.getLast_Name().toLowerCase().trim().contains(newValue)) {
                        return true;
                    }
                    if (acount.getContactNumber() == null) {
                        return false;
                    }
                    if (acount.getContactNumber().toLowerCase().trim().contains(newValue)) {
                        return true;
                    }
                    if (acount.getPassword().toLowerCase().trim().contains(newValue)) {
                        return true;
                    }
                    if (acount.getUserName().toLowerCase().trim().contains(newValue)) {
                        return true;
                    }
                    if (acount.getDate() == null) {
                        return false;
                    }
                    if (acount.getDate().toLowerCase().trim().contains(newValue)) {
                        return true;
                    }

                    if (acount.getNo().toLowerCase().trim().contains(newValue)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList sortedList = new SortedList(filteredList);
            sortedList.comparatorProperty().bind(AccountTables.comparatorProperty());
            AccountTables.setItems(sortedList);
            AccountTables.getSelectionModel().selectFirst();
        }

    @FXML
    void Student_Table(ActionEvent event) {
        Runnable runnable = () -> Platform.runLater(()->{
            try {
                stage = (Stage) Addstudent.getScene().getWindow();
                BorderPane pane = FXMLLoader.load(getClass().getResource("../../Student/AddStudent/registerStudent.fxml"));
                Scene scene = new Scene(pane);
                stage.setScene(scene);
                stage.setTitle("Student Table");

            }catch (IOException e){
                e.getCause();
            }
        });

        Thread thread = new Thread(runnable);
        thread.start();
    }

    @FXML void TableButton() {
        Runnable runnable = () -> Platform.runLater(()->{
            try {
                stage = (Stage)tb.getScene().getWindow();
                BorderPane pane = FXMLLoader.load(getClass().getResource("../../Account/TableAccount/Table_Of_Accounts.fxml"));
                Scene scene = new Scene(pane);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setTitle("Table Accounts");

            }catch (IOException e){
                e.getCause();
            }
        });

        Thread thread = new Thread(runnable);
        thread.start();
    }

    @FXML public void Logout() {
        Runnable runnable =() -> Platform.runLater(()->{
            try {
                stage = (Stage) logout.getScene().getWindow();
                Parent parent = FXMLLoader.load(getClass().getResource("../../Login/LoginUserName.fxml"));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Login Username");
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @FXML public void addStudent() {
        Runnable runnable = () -> Platform.runLater(()->{
            try {
                stage = (Stage)Addstudent.getScene().getWindow();
                Parent parent = FXMLLoader.load(getClass().getResource("../../Student/AddStudent/registerStudent.fxml"));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Add Student");
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
