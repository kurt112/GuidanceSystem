package GuidandanceRecord.Account.TableAccount;

import Database.DatabaseCommands;
import GuidandanceRecord.Alert.AlertType;
import GuidandanceRecord.Dashboard.dashboard;
import GuidandanceRecord.DataModel.Account.Account;
import GuidandanceRecord.TextMessage.MessageUi;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TableOfAccounts implements Initializable {

    @FXML private TextField search;
    @FXML private TableView<Account> AccountTable;
    @FXML private TableColumn<Account, String> fName, lName, user, password, ContactNumber, Date;
    @FXML private VBox Parent_Table_Of_Accounts;
    private FilteredList filteredList = new FilteredList(DatabaseCommands.getAccount());
    private Account account;
    private dashboard dashboards = new dashboard();
    private MessageUi messageUi = new MessageUi();


    /*
     This method Will Excecute after you run this program
     And inesrt a Data into Table
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fName.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
        lName.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
        user.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        ContactNumber.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));

        AccountTable.setItems(DatabaseCommands.getDBCommands().getAccountStatuts("no"));
        AccountTable.getItems().clear();
        AccountTable.setItems(DatabaseCommands.getDBCommands().getAccountStatuts("no"));
        AccountTable.refresh();
    }

    /*
    This Method will text a Message to
    a Specific Person
    */

    @FXML
    public void TextMessage() throws IOException {
        account = AccountTable.getSelectionModel().getSelectedItem();
        String path = "../TextMessage/MessageUi.fxml";
        dashboards.pop_Up(path, Parent_Table_Of_Accounts, "Text A Message");
        FXMLLoader Text_Message = new FXMLLoader(getClass().getResource("../../TextMessage/MessageUi.fxml"));
        Parent anchorPane = Text_Message.load();
        MessageUi messageUi= Text_Message.getController();
        messageUi.setContactNumber(account.getContactNumber());
    }

    /*
    This Method will Search A data into Table
    And It will return a Set Of All Data
    */

    public void Search() {

        search.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filteredList.setPredicate((Predicate<? super Account>) (Account acount) -> {
                String Val = newValue.toLowerCase();
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                if (acount.getFirst_Name().toLowerCase().trim().contains(Val)) {
                    return true;
                }
                if (acount.getLast_Name().toLowerCase().trim().contains(Val)) {
                    return true;
                }
                if (acount.getContactNumber() == null) {
                    return false;
                }
                if (acount.getContactNumber().toLowerCase().trim().contains(Val)) {
                    return true;
                }

                if (acount.getUserName().toLowerCase().trim().contains(Val)) {
                    return true;
                }
                if (acount.getDate() == null) {
                    return false;
                }
                if (acount.getDate().toLowerCase().trim().contains(Val)) {
                    return true;
                }

                if (acount.getNo().toLowerCase().trim().contains(Val)) {
                    return true;
                }
                return false;
            });
        });
        SortedList sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(AccountTable.comparatorProperty());
        AccountTable.setItems(sortedList);
        AccountTable.getSelectionModel().selectFirst();
    }

    /*
    This method will return the list of
    the EnableStudent
     */
    @FXML
    public void showEnable() {
        AccountTable.getItems().clear();
        AccountTable.setItems(DatabaseCommands.getDBCommands().getAccountStatuts("no"));
        AccountTable.refresh();
        if(AccountTable == null){
            return;
        }
    }

    /*
    This Method will return the list of the
    DisableStudnet
     */
    @FXML
    public void showDisable() {
        AccountTable.getItems().clear();
        AccountTable.setItems(DatabaseCommands.getDBCommands().getAccountStatuts("yes"));
        AccountTable.refresh();
        if(AccountTable == null){
            return;
        }

    }

    /*
    This Method will Iterate all data in
    table of Student
     */
    @FXML
    public void ViewAll() {
        AccountTable.getItems().clear();
        AccountTable.setItems(DatabaseCommands.getDBCommands().getAccountData());
        AccountTable.getSelectionModel().selectFirst();
        AccountTable.refresh();
    }


    /*
    This Method will Enable Account
    in the Database
     */
    @FXML
    public void EnableAccount() {
        Account account = AccountTable.getSelectionModel().getSelectedItem();
        DatabaseCommands.getDBCommands().EnableAccount(account.getNo());
    }

    /*
  This Method will Disable Account
  in the Database
  */
    @FXML
    public void DisableAccount() {

        if( AlertType.Delete_Item("Account")){
            Account account = AccountTable.getSelectionModel().getSelectedItem();
            DatabaseCommands.getDBCommands().DisableAccount(account.getNo());
            showEnable();
        }

    }

    @FXML
    public void UpdateAccount() throws IOException {

        Account Account_Select = AccountTable.getSelectionModel().getSelectedItem();
        dashboard dashboards = new dashboard();

        dashboards.pop_Up_Update_Account(Parent_Table_Of_Accounts, "Update Account", Account_Select);

    }


    @FXML public void AddAccount() throws IOException{
        dashboards.pop_Up("../Account/registerAccount/Register.fxml", Parent_Table_Of_Accounts,"Add Account");

    }

   @FXML public void Search_Function() {
        Search();
    }

   public  void update_The_Controller(){
           AccountTable.getItems().clear();
           AccountTable.setItems(DatabaseCommands.getDBCommands().getAccountStatuts("no"));
           AccountTable.refresh();


   }


}
