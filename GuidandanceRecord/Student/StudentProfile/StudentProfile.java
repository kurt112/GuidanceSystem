package GuidandanceRecord.Student.StudentProfile;

import GuidandanceRecord.DataModel.StudentProfile.Student;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentProfile implements Initializable {

    //If the variable have a s at their last name it means is is primitive data type such as String, Integer, adn Double

    public StudentProfile() {

    }

    private String First_Names,Last_Names,NickNames,BirthDates,Ages,Mother_Names,Occupation_Mothers,Occupation_Fathers,Father_Names,
                Guardian_Names,Streets,Barangays,Provinces,Guardian_Contacts,Contact_Numbers,Email_Addresss;

    @FXML private VBox Hboxs;
    @FXML private JFXTextField First_Name,Last_Name,NickName,BirthDate,Age,Mother_Name,Occupation_Mother,Occupation_Father,Father_Name,
            Guardian_Name,Street,Barangay,Province,Guardian_Contact,Contact_Number,Email_Address;
    private int Bully, Cutting, Vandalism, Stealing, Disrespect, Hair,Shouting, Bad_Words, No_Id, Offense_10;
    @FXML private Text Done_Text;
    @FXML private Label Good_Moral,Form_137,Picture,Nso;
    private Student student;
    //This method will get the data from the table of student and put it in another form
    public void Update_The_TextField(Student student){
        First_Names = student.getFirstName();
        Last_Names = student.getLastName();
        NickNames = "Nan";
        BirthDates=student.getBirthDate();
        Ages=student.getAge();
        Mother_Names="Nan";
        Father_Names="Nan";
        Father_Names ="Nan";
        Guardian_Names = student.getGuardianName();
        Streets="Nan";
        Barangays="Nan";
        Provinces="Nan";
        Guardian_Contacts="Nan";
        Contact_Numbers="Nan";
        Email_Addresss="Nan";
    }


    public void Student_Index(Student student){
        First_Name.setText(student.getFirstName());
        Last_Name.setText(student.getLastName());
        NickName.setText("Nan");
        BirthDate.setText(student.getBirthDate());
        Age.setText(student.getAge());
        Mother_Name.setText("Nan");
        Mother_Name.setText("Nan");
        Father_Name.setText("Nan");
        Father_Name.setText("Nan");
        Guardian_Name.setText(student.getGuardianName());
        Street.setText("Nan");
        Barangay.setText("Nan");
        Province.setText("Nan");
        Guardian_Contact.setText(student.getGuardianContact());
        Contact_Number.setText("Nan");
        Email_Address.setText("Nan");

        Bully = Integer.parseInt(student.getBuly());
        Cutting = Integer.parseInt(student.getCutting());
        Vandalism = Integer.parseInt(student.getVandalism());
        Stealing = Integer.parseInt(student.getStealing());
        Disrespect = Integer.parseInt(student.getDisrespect());
        Hair = Integer.parseInt(student.getHair());
        Shouting = Integer.parseInt(student.getShouting());
        Bad_Words = Integer.parseInt(student.getBadWords());
        No_Id = Integer.parseInt(student.getNoId());

//        Determine_The_Value(Bully, Offense1_Rd,Offense1_Rd1,Offense1_Rd2);
//        Determine_The_Value(Cutting, Offense2_Rd,Offense2_Rd1,Offense2_Rd2);
//        Determine_The_Value(Vandalism, Offense3_Rd,Offense3_Rd1,Offense3_Rd2);
//        Determine_The_Value(Stealing, Offense4_Rd,Offense4_Rd1,Offense4_Rd2);
//        Determine_The_Value(Disrespect, Offense5_Rd,Offense5_Rd1,Offense5_Rd2);
//        Determine_The_Value(Hair, Offense6_Rd,Offense6_Rd1,Offense6_Rd2);
//        Determine_The_Value(Shouting, Offense7_Rd,Offense7_Rd1,Offense7_Rd2);
//        Determine_The_Value(Bad_Words, Offense8_Rd,Offense8_Rd1,Offense8_Rd2);
//        Determine_The_Value(No_Id, Offense9_Rd,Offense9_Rd1,Offense9_Rd2);
//        Determine_The_Value(Offense_10, Offense10_Rd,Offense10_Rd1,Offense10_Rd2);
    }

    //This function will trigger the textfield to become editable
    @FXML public void Edit_Button(){
        First_Name.setEditable(true);Last_Name.setEditable(true);
        NickName.setEditable(true);BirthDate.setEditable(true);
        Age.setEditable(true);Mother_Name.setEditable(true);
        Father_Name.setEditable(true);Father_Name.setEditable(true);
        Guardian_Name.setEditable(true);Street.setEditable(true);
        Barangay.setEditable(true);Province.setEditable(true);
        Guardian_Contact.setEditable(true);Contact_Number.setEditable(true);
        Email_Address.setEditable(true);Mother_Name.setEditable(true);

        First_Name.setMouseTransparent(false);Last_Name.setMouseTransparent(false);
        NickName.setMouseTransparent(false);BirthDate.setMouseTransparent(false);
        Age.setMouseTransparent(false);Mother_Name.setMouseTransparent(false);
        Father_Name.setMouseTransparent(false);Father_Name.setMouseTransparent(false);
        Guardian_Name.setMouseTransparent(false);Street.setMouseTransparent(false);
        Barangay.setMouseTransparent(false);Province.setMouseTransparent(false);
        Guardian_Contact.setMouseTransparent(false);Contact_Number.setMouseTransparent(false);
        Email_Address.setMouseTransparent(false);
        //Edit_Button1();
        Done_Text.setVisible(true);Mother_Name.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final BooleanProperty firstTime = new SimpleBooleanProperty(true);
        First_Name.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
            if(newValue && firstTime.get()){
                Hboxs.requestFocus(); // Delegate the focus to container
                firstTime.setValue(false); // Variable value changed for future references
            }
        });
    }

    @FXML void Done_Button(){

        Done_Text.setVisible(false);First_Name.setEditable(false);
        Last_Name.setEditable(false);NickName.setEditable(false);
        BirthDate.setEditable(false);Age.setEditable(false);
        Mother_Name.setEditable(false);Father_Name.setEditable(false);
        Father_Name.setEditable(false);Guardian_Name.setEditable(false);
        Street.setEditable(false);Barangay.setEditable(false);
        Province.setEditable(false);Guardian_Contact.setEditable(false);
        Contact_Number.setEditable(false);Email_Address.setEditable(false);
        Mother_Name.setEditable(false);
        First_Name.setMouseTransparent(true);Last_Name.setMouseTransparent(true);
        NickName.setMouseTransparent(true);BirthDate.setMouseTransparent(true);
        Age.setMouseTransparent(true);Mother_Name.setMouseTransparent(true);
        Father_Name.setMouseTransparent(true);Father_Name.setMouseTransparent(true);
        Guardian_Name.setMouseTransparent(true);Street.setMouseTransparent(true);
        Barangay.setMouseTransparent(true);Province.setMouseTransparent(true);
        Guardian_Contact.setMouseTransparent(true);Contact_Number.setMouseTransparent(true);
        Email_Address.setMouseTransparent(true);Mother_Name.setMouseTransparent(true);

//        Offense1_Add_Sign.setVisible(false); Offense1_Minus_Sign.setVisible(false);
//        Offense2_Add_Sign.setVisible(false); Offense2_Minus_Sign.setVisible(false);
//        Offense3_Add_Sign.setVisible(false); Offense3_Minus_Sign.setVisible(false);
//        Offense4_Add_Sign.setVisible(false); Offense4_Minus_Sign.setVisible(false);
//        Offense5_Add_Sign.setVisible(false); Offense5_Minus_Sign.setVisible(false);
//        Offense6_Add_Sign.setVisible(false); Offense6_Minus_Sign.setVisible(false);
//        Offense7_Add_Sign.setVisible(false); Offense7_Minus_Sign.setVisible(false);
//        Offense8_Add_Sign.setVisible(false); Offense8_Minus_Sign.setVisible(false);
//        Offense9_Add_Sign.setVisible(false); Offense9_Minus_Sign.setVisible(false);
//        Offense10_Add_Sign.setVisible(false); Offense10_Minus_Sign.setVisible(false);
//        Good_Moral_Check_Sign.setVisible(false);Good_Moral_X_Sign.setVisible(false);
//        Form_137_Check_Sign.setVisible(false);Form_137_X_Sign.setVisible(false);
//        Picture_Check_Sign.setVisible(false);Picture_X_Sign.setVisible(false);
//        Birth_Check_Sign.setVisible(false);Birth_X_Sign.setVisible(false);
    }





    /*
    This Second layer of Code is for the next page of the fxml


    Because this the second page of the code is so long that's why


    i seperate the two.


     */



    @FXML
    private JFXRadioButton Offense1_Rd,Offense1_Rd1,Offense1_Rd2,
                           Offense2_Rd,Offense2_Rd1,Offense2_Rd2,
                           Offense3_Rd,Offense3_Rd1 ,Offense3_Rd2,
                           Offense4_Rd,Offense4_Rd1,Offense4_Rd2,
                           Offense5_Rd,Offense5_Rd1,Offense5_Rd2,
                           Offense6_Rd,Offense6_Rd1,Offense6_Rd2,
                           Offense7_Rd,Offense7_Rd1,Offense7_Rd2,
                           Offense8_Rd,Offense8_Rd1,Offense8_Rd2,
                           Offense9_Rd,Offense9_Rd1,Offense9_Rd2,
                           Offense10_Rd,Offense10_Rd1,Offense10_Rd2;
    @FXML
    private ImageView Offense1_Add_Sign,Offense1_Minus_Sign,
                      Offense2_Add_Sign,Offense2_Minus_Sign,
                      Offense3_Add_Sign,Offense3_Minus_Sign,
                      Offense4_Add_Sign, Offense4_Minus_Sign,
                      Offense5_Add_Sign, Offense5_Minus_Sign,
                      Offense6_Add_Sign, Offense6_Minus_Sign,
                      Offense7_Add_Sign, Offense7_Minus_Sign,
                      Offense8_Add_Sign, Offense8_Minus_Sign,
                      Offense9_Add_Sign, Offense9_Minus_Sign,
                      Offense10_Add_Sign,Offense10_Minus_Sign,
                      Good_Moral_Check_Sign, Good_Moral_X_Sign,
                      Form_137_Check_Sign, Form_137_X_Sign,
                      Picture_Check_Sign, Picture_X_Sign,
                      Birth_Check_Sign,Birth_X_Sign;

    private void Edit_Button1() {
        Offense1_Add_Sign.setVisible(true); Offense1_Minus_Sign.setVisible(true);
        Offense2_Add_Sign.setVisible(true); Offense2_Minus_Sign.setVisible(true);
        Offense3_Add_Sign.setVisible(true); Offense3_Minus_Sign.setVisible(true);
        Offense4_Add_Sign.setVisible(true); Offense4_Minus_Sign.setVisible(true);
        Offense5_Add_Sign.setVisible(true); Offense5_Minus_Sign.setVisible(true);
        Offense6_Add_Sign.setVisible(true); Offense6_Minus_Sign.setVisible(true);
        Offense7_Add_Sign.setVisible(true); Offense7_Minus_Sign.setVisible(true);
        Offense8_Add_Sign.setVisible(true); Offense8_Minus_Sign.setVisible(true);
        Offense9_Add_Sign.setVisible(true); Offense9_Minus_Sign.setVisible(true);
        Offense10_Add_Sign.setVisible(true); Offense10_Minus_Sign.setVisible(true);
        Good_Moral_Check_Sign.setVisible(true);Good_Moral_X_Sign.setVisible(true);
        Form_137_Check_Sign.setVisible(true);Form_137_X_Sign.setVisible(true);
        Picture_Check_Sign.setVisible(true);Picture_X_Sign.setVisible(true);
        Birth_Check_Sign.setVisible(true);Birth_X_Sign.setVisible(true);


    }




    @FXML
    void Offense10_Add_Sign() {
        Offense_10++;
        if(Offense_10 >3){
            Offense_10 =3;
        }
        Add_Offense_Function(Offense_10, Offense10_Rd,Offense10_Rd1,Offense10_Rd2);
    }

    @FXML
    void Offense10_Minus_Sign() {
        Offense_10--;
        if(Offense_10 <0){
            Offense_10 =0;
        }
        Minus_Offese_Function(Offense_10, Offense10_Rd,Offense10_Rd1,Offense10_Rd2);
    }

    @FXML
    void Offense1_Add_Sign() {
        Bully++;
        if(Bully >3){
            Bully =3;
        }
        Add_Offense_Function(Bully, Offense1_Rd,Offense1_Rd1,Offense1_Rd2);
    }

    @FXML
    void Offense1_Minus_Sign() {
        Bully--;
        if(Bully <0){
            Bully=0;
        }
        Minus_Offese_Function(Bully, Offense1_Rd,Offense1_Rd1,Offense1_Rd2);
    }

    @FXML
    void Offense2_Add_Sign() {
       Cutting++;
        if(Cutting >3){
            Cutting=3;
        }
        Add_Offense_Function(Cutting, Offense2_Rd,Offense2_Rd1,Offense2_Rd2);
    }

    @FXML
    void Offense2_Minus_Sign() {
        Cutting--;
        if(Cutting <0){
            Cutting=0;
        }
        Minus_Offese_Function(Cutting, Offense2_Rd,Offense2_Rd1,Offense2_Rd2);
    }

    @FXML
    void Offense3_Add_Sign()
    {
        Vandalism++;
        if(Vandalism >3){
            Vandalism=3;
        }
        Add_Offense_Function(Vandalism,Offense3_Rd,Offense3_Rd1,Offense3_Rd2);
    }

    @FXML
    void Offense3_Minus_Sign() {
        Vandalism--;
        if(Vandalism <0){
            Vandalism=0;
        }
       Minus_Offese_Function(Vandalism, Offense3_Rd,Offense3_Rd1,Offense3_Rd2);
    }

    @FXML
    void Offense4_Add_Sign() {
        Stealing++;
        if(Stealing >3){
            Stealing=3;
        }
        Add_Offense_Function(Stealing,Offense4_Rd,Offense4_Rd1,Offense4_Rd2);
    }

    @FXML
    void Offense4_Minus_Sign()
    {
        Stealing--;
        if(Stealing <0){
            Stealing=0;
        }
        Minus_Offese_Function(Stealing, Offense4_Rd,Offense4_Rd1,Offense4_Rd2);
    }

    @FXML
    void Offense5_Add_Sign() {
        Disrespect++;
        if(Disrespect>3){
            Disrespect=3;
        }
        Add_Offense_Function(Disrespect,Offense5_Rd,Offense5_Rd1,Offense5_Rd2);
    }

    @FXML
    void Offense5_Minus_Sign() {
        Disrespect--;
        if(Disrespect <0){
            Disrespect=0;
        }
       Minus_Offese_Function(Disrespect,Offense5_Rd,Offense5_Rd1,Offense5_Rd2);
    }

    @FXML
    void Offense6_Add_Sign() {
        Hair++;
        if(Hair >3){
            Hair=3;
        }
        Add_Offense_Function(Hair,Offense6_Rd,Offense6_Rd1,Offense6_Rd2);
    }

    @FXML
    void Offense6_Minus_Sign() {
        Hair--;
        if(Hair <0){
            Hair=0;
        }
        Minus_Offese_Function(Hair,Offense6_Rd,Offense6_Rd1,Offense6_Rd2);
    }

    @FXML
    void Offense7_Add_Sign() {
        Shouting++;
        if(Shouting >3){
            Shouting=3;
        }
        Add_Offense_Function(Shouting,Offense7_Rd,Offense7_Rd1,Offense7_Rd2);
    }

    @FXML
    void Offense7_Minus_Sign() {
        Shouting--;
        if(Shouting <0){
            Shouting=0;
        }
        Minus_Offese_Function(Shouting,Offense7_Rd,Offense7_Rd1,Offense7_Rd2);
    }

    @FXML
    void Offense8_Add_Sign() {
        Bad_Words++;
        if(Bad_Words >3){
            Bad_Words=3;
        }
        Add_Offense_Function(Bad_Words,Offense8_Rd,Offense8_Rd1,Offense8_Rd2);
    }

    @FXML
    void Offense8_Minus_Sign() {
        Bad_Words--;
        if(Bad_Words <0){
            Bad_Words=0;
        }
       Minus_Offese_Function(Bad_Words,Offense8_Rd,Offense8_Rd1,Offense8_Rd2);
    }

    @FXML
    void Offense9_Add_Sign() {
        No_Id++;
        if(No_Id >3){
            No_Id=3;
        }
        Add_Offense_Function(No_Id,Offense9_Rd,Offense9_Rd1,Offense9_Rd2);
    }

    @FXML
    void Offense9_Minus_Sign()
    {
        No_Id--;
        if(No_Id <0){
            No_Id=0;
        }
        Minus_Offese_Function(No_Id,Offense9_Rd,Offense9_Rd1,Offense9_Rd2);
    }

    private String complete = "Complete!", Incomplete="Incomplete!";


    @FXML public void Birth_X_Sign() {
        Nso.setText(complete);
    }

    @FXML public void Picture_X_Sign() {
        Picture.setText(Incomplete);
    }

    @FXML public void Birth_Check_Sign() {
        Nso.setText(Incomplete);
    }

    @FXML public void Picture_Check_Sign() {
        Picture.setText(complete);
    }
    @FXML public void Form_137_Check_Sign() {
        Form_137.setText(complete);
    }

    @FXML public void Form_137_x_Sign() {
        Form_137.setText(Incomplete);
    }

    @FXML public void Good_Moral_Check_Sign() {
        Good_Moral.setText(complete);
    }

    @FXML public void Good_Moral_X_Sign() {
        Good_Moral.setText(Incomplete);
    }

    private void select(RadioButton radioButton){
        radioButton.setSelected(true);
        radioButton.setDisable(false);
    }

    private void select(RadioButton radioButton, RadioButton radioButton1){
        radioButton.setSelected(true);
        radioButton.setDisable(false);

        radioButton1.setSelected(true);
        radioButton1.setDisable(false);

    }

    private void select(RadioButton radioButton, RadioButton radioButton1, RadioButton radioButton2){
        radioButton.setSelected(true);
        radioButton.setDisable(false);

        radioButton1.setSelected(true);
        radioButton1.setDisable(false);

        radioButton2.setSelected(true);
        radioButton2.setDisable(false);

    }

    private void Diselect(RadioButton radioButton){
        radioButton.setSelected(false);
        radioButton.setDisable(true);
    }

    private void Diselect(RadioButton radioButton, RadioButton radioButton1){
        radioButton.setSelected(false);
        radioButton.setDisable(true);

        radioButton1.setSelected(false);
        radioButton1.setDisable(true);

    }

    private void Add_Offense_Function(int num, JFXRadioButton rd1, JFXRadioButton rd2, JFXRadioButton rd3){
        if(num <=0){
            num=0;
        }else if(num == 1){
            select(rd1);
        }else if(num == 2){
            select(rd2);
        }else if(num==3){
            select(rd3);
        }else if(num >3){
            num =3;
        }
        System.out.println("Num Value = " + num);
    }
    private void Minus_Offese_Function(int num, JFXRadioButton rd1, JFXRadioButton rd2, JFXRadioButton rd3){
        if(num<0){
            num=0;
        }
        if(num == 0){
            Diselect(rd1);
        }
        else if(num ==1){
            Diselect(rd3,rd2);
        }
        else if(num==2){
            Diselect(rd3);
        }
        else if(num==3){
            num=3;
        }
        System.out.println("Num Value Minus = " + num);
    }
    private void Determine_The_Value(int offense,RadioButton radioButton, RadioButton radioButton1, RadioButton radioButton2){
        if(offense ==1){
            select(radioButton);
        }else if(offense == 2){
            select(radioButton,radioButton1);
        }else if(offense ==3){
            select(radioButton,radioButton1,radioButton2);
        }
    }

}
