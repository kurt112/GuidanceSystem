package GuidandanceRecord.Dashboard;
import GuidandanceRecord.Account.UpdateAccount.UpdateAccount;
import GuidandanceRecord.DataModel.Account.Account;
import GuidandanceRecord.DataModel.StudentProfile.Student;
import GuidandanceRecord.Student.StudentProfile.StudentProfile;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboard implements Initializable {

    @FXML private VBox Vbox_Change, Right, Vbox_Right;
    @FXML private Button Table_Account, Add_Account, Student_Table;
    private static final String Student_Table_Path = "../Student/Body/AfterLogin.fxml";
    private static final String DashBoardItem = "dashBoardItem.fxml";
    private static final String TestVbox = "vbox1.fxml";
    private static final String Right_Vbox ="../Student/Body/AfterLoginRight.fxml";
    private static final String Account_Table_Path ="../Account/TableAccount/Table_Of_Accounts.fxml";
    private static final String Student_Register_Path = "../Student/AddStudent/registerStudent.fxml";
    private static final String Account_Register_Path ="../Account/registerAccount/Register.fxml";
    private static final String Message_Path = "../TextMessage/MessageUi.fxml";
    private static final String Student_Profile_Path = "../Student/StudentProfile/Student_All_Information.fxml";
    private static final String Account_Update_Path = "../Account/UpdateAccount/UpdateAccount.fxml";

    @FXML private Pane Account_Table_Button, Add_Account_Button, Student_Table_Button, Add_Student_Button, Message_Button,
    Guidance_Button, Record_Button, Setting_Button;
    @FXML private Label Account_Table_Label, Add_Account_Label, Student_Table_Label, Add_Student_Label, Message_Label,
            Guidance_Label, Record_Label, Setting_Label;
    @FXML private JFXTextField Search_left;
    @FXML private BorderPane MainParent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DashBoardItem(DashBoardItem);
    }
    private void DashBoardItem(String Path){
        Vbox_Change.getChildren().clear();
        Vbox_Change.getChildren().setAll(Goto_Another_Vbox(Path));
    }

    private VBox Goto_Another_Vbox (String Path){
        VBox vBox =null;
        try {
            vBox = FXMLLoader.load(getClass().getResource(Path));
            return vBox;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Runnable Home_DashBoard_Thread =() -> Platform.runLater(() -> DashBoardItem(DashBoardItem));


    private Runnable AfterLogin_Thread = () -> Platform.runLater(()-> DashBoardItem(Student_Table_Path));

    private Runnable Account_Table_Thread = ()-> Platform.runLater(()-> DashBoardItem(Account_Table_Path));

    private Runnable Add_Student_Thread = ()-> Platform.runLater(()-> DashBoardItem(Student_Register_Path));

    private Runnable Register_Account_Thread = () -> Platform.runLater(() ->{
        try {
            pop_Up(Account_Register_Path,MainParent, "Account Register");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    private Runnable Register_Student_Thread = ()-> Platform.runLater(() ->{
        try {
            pop_Up(Student_Register_Path,MainParent, "Register Student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    private Runnable Message_Thread =() -> Platform.runLater(() ->{
        try {
            pop_Up(Message_Path,MainParent, "Send Message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    private static Thread New_Thread(Runnable runnable){
        Thread thread = new Thread(runnable);
        return thread;
    }




    private void Set_Right_To_Visible(boolean visible){
//        System.out.println(visible);
//        if(visible){
//            Right.setVisible(true);
//            Right.setMaxWidth(200);
//            Right.setMinWidth(200);
//        }else {
//            Right.setVisible(false);
//            Right.setMaxWidth(0);
//            Right.setMinWidth(0);
//        }
    }


    @FXML
    void Account_Table() {
        New_Thread(Account_Table_Thread).start();
    }


    @FXML
    void Add_Account() {
        New_Thread(Register_Account_Thread).start();
    }

    @FXML
    void Student_Table() {
        New_Thread(AfterLogin_Thread).start();
    }

    @FXML
    public void Hb1Enter(MouseEvent event){
            Account_Table_Label.setText("");
            Account_Table_Button.setPrefWidth(300);

    }
    @FXML
    public void Hb1Exit(){
        Account_Table_Label.setText("Account Table");
        Account_Table_Button.setPrefWidth(33);
    }

    @FXML
    public void Setting(MouseEvent mouseEvent) {
    }



    @FXML
    public void Home(MouseEvent mouseEvent) {
        New_Thread(Home_DashBoard_Thread).start();
    }

    @FXML
    public void Guidance(MouseEvent mouseEvent) {
    }

    @FXML
    public void Message_Button() {
        New_Thread(Message_Thread).start();
    }

    @FXML
    public void Add_Student(MouseEvent mouseEvent) throws IOException {
        New_Thread(Register_Student_Thread).start();
    }

    public void Hb2Enter(MouseEvent mouseEvent) {
        Add_Account_Label.setText("");
        Add_Account_Button.setPrefWidth(300);
    }

    public void Hb2Exit(MouseEvent mouseEvent) {

        Add_Account_Label.setText("Add Account");
        Add_Account_Button.setPrefWidth(33);
    }

    public void Hb3Exit(MouseEvent mouseEvent) {

        Student_Table_Label.setText("Student Table");
        Student_Table_Button.setPrefWidth(33);
    }

    public void Hb3Enter(MouseEvent mouseEvent) {
        Student_Table_Label.setText("");
        Student_Table_Button.setPrefWidth(300);
    }

    public void Hb4Enter(MouseEvent mouseEvent) {
        Add_Student_Label.setText("");
        Add_Student_Button.setPrefWidth(300);
    }

    public void Hb4Exit(MouseEvent mouseEvent) {

        Add_Student_Label.setText("Add Student");
        Add_Student_Button.setPrefWidth(33);
    }

    public void Hb5Enter(MouseEvent mouseEvent) {
        Message_Label.setText("");
        Message_Button.setPrefWidth(300);
    }

    public void Hb5Exit(MouseEvent mouseEvent) {

        Message_Label.setText("Message");
        Message_Button.setPrefWidth(33);
    }

    public void Hb6Enter(MouseEvent mouseEvent) {
        Guidance_Label.setText("");
        Guidance_Button.setPrefWidth(300);
    }

    public void Hb6Exit(MouseEvent mouseEvent) {

        Guidance_Label.setText("Guidance");
        Guidance_Button.setPrefWidth(33);
    }

    public void Hb7Enter(MouseEvent mouseEvent) {
        Record_Label.setText("");
        Record_Button.setPrefWidth(300);
    }

    public void Hb7Exit(MouseEvent mouseEvent) {

        Record_Label.setText("Home");
        Record_Button.setPrefWidth(33);
    }

    public void Hb8Enter(MouseEvent mouseEvent) {
        Setting_Label.setText("");
        Setting_Button.setPrefWidth(300);
    }

    public void Hb8Exit(MouseEvent mouseEvent) {

        Setting_Label.setText("Settings");
        Setting_Button.setPrefWidth(33);
    }
    @FXML
    public void Search_left(){

    }

    public void pop_Up(String path, Parent parents, String name_Of_Window) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Stage stage = new Stage();
        stage.initOwner(parents.getScene().getWindow());
        fxmlLoader.setLocation(getClass().getResource(path));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle(name_Of_Window);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void pop_Up_Update_Student(Parent parents, String name_Of_Window, Student student) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Stage stage = new Stage();
        stage.initOwner(parents.getScene().getWindow());
        fxmlLoader.setLocation(getClass().getResource(Student_Profile_Path));
        Scene scene = new Scene(fxmlLoader.load());
        StudentProfile studentProfile = fxmlLoader.getController();
        studentProfile.Student_Index(student);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Update Account");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void pop_Up_Update_Account(Parent parents, String name_Of_Window, Account account) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Stage stage = new Stage();
        stage.initOwner(parents.getScene().getWindow());
        fxmlLoader.setLocation(getClass().getResource(Account_Update_Path));
        Scene scene = new Scene(fxmlLoader.load());
        UpdateAccount updateAccount = fxmlLoader.getController();
        updateAccount.UpdateIt(account);
        updateAccount.getData(account);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Update Account");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static String getStudent_Table_Path() {
        return Student_Table_Path;
    }

    public static String getDashBoardItem() {
        return DashBoardItem;
    }

    public static String getTestVbox() {
        return TestVbox;
    }

    public static String getRight_Vbox() {
        return Right_Vbox;
    }

    public static String getAccount_Table_Path() {
        return Account_Table_Path;
    }

    public static String getStudent_Register_Path() {
        return Student_Register_Path;
    }

    public static String getAccount_Register_Path() {
        return Account_Register_Path;
    }

    public static String getMessage_Path() {
        return Message_Path;
    }
}


