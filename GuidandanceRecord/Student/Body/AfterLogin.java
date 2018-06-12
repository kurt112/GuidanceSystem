package GuidandanceRecord.Student.Body;
import Database.DatabaseCommands;
import GuidandanceRecord.Dashboard.dashboard;
import GuidandanceRecord.DataModel.StudentProfile.Student;
import GuidandanceRecord.Main;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.function.Predicate;

public class AfterLogin {
    @FXML private VBox MainParent;
    @FXML TableColumn<Student, String> fName, lName, grade, section, adviser, lrn, guardian, guardianNumber;

    @FXML private TextField search;

    @FXML private TableView<Student> studentTable;
    dashboard dashboards = new dashboard();
    private FilteredList filteredList = new FilteredList(DatabaseCommands.getStudentStatus(""));
    public void initialize() {
        fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        section.setCellValueFactory(new PropertyValueFactory<>("section"));
        adviser.setCellValueFactory(new PropertyValueFactory<>("adviser"));
        lrn.setCellValueFactory(new PropertyValueFactory<>("lrn"));
        guardian.setCellValueFactory(new PropertyValueFactory<>("guardianName"));
        guardianNumber.setCellValueFactory(new PropertyValueFactory<>("guardianContact"));

        //No.setCellValueFactory(new PropertyValueFactory<>("No"));
        studentTable.setItems(DatabaseCommands.getStudentStatus("no"));
        studentTable.getItems().clear();
        studentTable.setItems(DatabaseCommands.getStudentStatus("no"));

        studentTable.refresh();
    }



    @FXML
    public void click(MouseEvent mouseEvent) throws  IOException{
        dashboard dashboards = new dashboard();
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (mouseEvent.getClickCount() == 2) {
            dashboards.pop_Up_Update_Student(MainParent,"Update Studnet", null);
        }
    }

    /*
        This is For searching data
    in Table
     */
    @FXML
    public void search() {

        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate((Predicate<? super Student>) (Student std) -> {
                String new_Value_lowerCase = newValue.toLowerCase();
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                } else if (std.getFirstName().toLowerCase().trim().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getLastName().trim().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getAdviser().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getSection().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getAge().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getGuardianContact().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getGuardianName().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getLrn().contains(new_Value_lowerCase)) {
                    return true;
                } else if (std.getGrade().contains(new_Value_lowerCase)) {
                    return true;
                }
                return false;
            });

        });

        SortedList sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(studentTable.comparatorProperty());
        studentTable.setItems(sortedList);
        studentTable.getSelectionModel().selectFirst();

    }



    /*
    Thi method will show
    to view all data even it it disable or
    enable
     */

    public void ViewAll() {
        studentTable.getItems().clear();
        studentTable.setItems(DatabaseCommands.getDBCommands().getStudentStatus(""));
        studentTable.getSelectionModel().selectFirst();
        studentTable.refresh();
    }

    /*
    This Method will show The list
    of lal disable Student
     */

    public void showDisable() {
        studentTable.getItems().clear();
        studentTable.setItems(DatabaseCommands.getDBCommands().getStudentStatus("yes"));
        studentTable.getSelectionModel().selectFirst();
        studentTable.refresh();
    }

    /*
    This Method will show the list of all enable Student
     */

    public void showEnable() {
        studentTable.setItems(DatabaseCommands.getStudentStatus("no"));
    }


  /*  public void EnableStudent() {
        Student student = studentTable.getSelectionModel().getSelectedItem();
        DatabaseCommands.getDBCommands().EnableStudent(student.getNo());

    }*/

    /*public void ContextDisable() {
        Student student = studentTable.getSelectionModel().getSelectedItem();
        DatabaseCommands.getDBCommands().DisableStudent(student.getNo());
    }*/

    @FXML public void Text_Guardian() {
    }

    @FXML public void Delete_Student() {
    }

    @FXML public void Update_Student() throws IOException{
        Student student = studentTable.getSelectionModel().getSelectedItem();
        dashboards.pop_Up_Update_Student(MainParent, "Update Student", student);
    }

    @FXML public void Add_Student() throws IOException{
        String path = "../Student/AddStudent/registerStudent.fxml";
        dashboards.pop_Up(path, MainParent, "Add Student");
    }
}


