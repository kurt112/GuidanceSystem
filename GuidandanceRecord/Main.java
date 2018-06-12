package GuidandanceRecord;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;
        import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //to Login username = AddStudent/registerStudent.fxml "Body/AfterLogin.fxml" Login/LoginUserName.fxml
        // Account/TableAccount/Table_Of_Accounts.fxml
        //Account/HistoryOfLogin/HistoryOfLogin.fxml
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard/dashboard.fxml"));
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("LoginUserName Now");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(1200);
        primaryStage.setMinWidth(1200);
        primaryStage.show();
        primaryStage.setTitle("LoginUserName");
    }
    public static void main(String[] args) {
        launch(args);
    }


}

