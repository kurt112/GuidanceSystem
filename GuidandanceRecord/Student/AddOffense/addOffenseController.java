package GuidandanceRecord.Student.AddOffense;

import Database.DatabaseCommands;
import GuidandanceRecord.DataModel.StudentProfile.Student;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addOffenseController implements Initializable{
    ObservableList<Integer> numbers = FXCollections.observableArrayList();
    @FXML private ComboBox<Integer>bully,disrespect, cutting, vandalism, badWords,stealing,shouting,Id,hair;
    @FXML private JFXTextField section, Adviser,grade,name;
    private int bullyCount, disrespectCount,cuttingCount,vandalismCount,badWordsCount,stealingCount,shoutingCount,IdCount,hairCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hair.getSelectionModel().selectFirst();
        Id.getSelectionModel().selectFirst();
        shouting.getSelectionModel().selectFirst();
        stealing.getSelectionModel().selectFirst();
        vandalism.getSelectionModel().selectFirst();
        badWords.getSelectionModel().selectFirst();
        cutting.getSelectionModel().selectFirst();
        disrespect.getSelectionModel().selectFirst();
        bully.getSelectionModel().selectFirst();

        add();

    }
    public void putIt(Student student){
        name.setText(student.getFirstName() +" "+ student.getLastName());
        grade.setText(student.getSection());
        Adviser.setText(student.getAdviser());
        section.setText(student.getGrade());
      if(Integer.parseInt(student.getDisrespect()) == 1){
            disrespect.getSelectionModel().select(1);
        } else if(Integer.parseInt(student.getDisrespect()) == 2){
            disrespect.getSelectionModel().select(2);
        } else if(Integer.parseInt(student.getDisrespect()) ==3){
            disrespect.getSelectionModel().select(3);
        }else  {
             disrespect.getSelectionModel().selectFirst();
        }

        if(Integer.parseInt(student.getBuly())== 1){
            bully.getSelectionModel().select(1);
        }else if(Integer.parseInt(student.getBuly())==2){
            bully.getSelectionModel().select(2);
        } else if(Integer.parseInt(student.getBuly())==3){
            bully.getSelectionModel().select(3);
        }else {
            bully.getSelectionModel().selectFirst();
        }

        if(Integer.parseInt(student.getCutting()) == 1){
            cutting.getSelectionModel().select(1);
        }else if(Integer.parseInt(student.getCutting())==2){
            cutting.getSelectionModel().select(2);
        } else if(Integer.parseInt(student.getCutting())==3){
            cutting.getSelectionModel().select(3);
        }else {
            cutting.getSelectionModel().selectFirst();
        }

        if(Integer.parseInt(student.getVandalism())== 1){
            vandalism.getSelectionModel().select(1);
        }else if (Integer.parseInt(student.getVandalism())== 2){
            vandalism.getSelectionModel().select(2);
        }else if(Integer.parseInt(student.getVandalism())== 3){
            vandalism.getSelectionModel().select(3);
        }else {vandalism.getSelectionModel().selectFirst();}

        if(Integer.parseInt(student.getBadWords())==1){
            badWords.getSelectionModel().select(1);
        }else if(Integer.parseInt(student.getBadWords())==2){
            badWords.getSelectionModel().select(2);
        }else if(Integer.parseInt(student.getBadWords())==3){
            badWords.getSelectionModel().select(3);
        }else {badWords.getSelectionModel().selectFirst();}

        if(Integer.parseInt(student.getStealing())==1){
            stealing.getSelectionModel().select(1);
        }else if(Integer.parseInt(student.getStealing())==2){
            stealing.getSelectionModel().select(2);
        }else if(Integer.parseInt(student.getStealing())==3){
            stealing.getSelectionModel().select(3);
        }else { stealing.getSelectionModel().selectFirst(); }

        if(Integer.parseInt(student.getShouting())==1) {
            shouting.getSelectionModel().select(1);
        }else if (Integer.parseInt(student.getShouting())==2){
            shouting.getSelectionModel().select(2);
        }else if(Integer.parseInt(student.getShouting())==3){
            shouting.getSelectionModel().select(3);
        }else {shouting.getSelectionModel().selectFirst();}

        if(Integer.parseInt(student.getNoId())==1){
            Id.getSelectionModel().select(1);
        }else if (Integer.parseInt(student.getNoId())==2){
            Id.getSelectionModel().select(2);
        }else if(Integer.parseInt(student.getNoId())==3){
            Id.getSelectionModel().select(3);
        }else {Id.getSelectionModel().selectFirst();}

        if(Integer.parseInt(student.getHair())==1){
            hair.getSelectionModel().select(1);
        }else if(Integer.parseInt(student.getHair())==2){
            hair.getSelectionModel().select(2);
        }else if(Integer.parseInt(student.getHair())==3){
            hair.getSelectionModel().select(3);
        }else { hair.getSelectionModel().selectFirst(); }

        //(Integer.parseInt(student.getDisrespect()));
        //vandalism.getSelectionModel().select(Integer.parseInt(student.getVandalism()));
        //badWords.getSelectionModel().select(Integer.parseInt(student.getBadWords()));
        //stealing.getSelectionModel().select(Integer.parseInt(student.getStealing()));
//        shouting.getSelectionModel().select(Integer.parseInt(student.getShouting()));
//         Id.getSelectionModel().select(Integer.parseInt(student.getNoId()));
//        hair.getSelectionModel().select(Integer.parseInt(student.getHair()));

    }
    public void add(){
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        bully.setItems(numbers);
        disrespect.setItems(numbers);
        cutting.setItems(numbers);
        vandalism.setItems(numbers);
        badWords.setItems(numbers);
        stealing.setItems(numbers);
        shouting.setItems(numbers);
        Id.setItems(numbers);
        hair.setItems(numbers);
    }
    public void verify() {
        this.disrespectCount = disrespect.getValue() ;
        this.bullyCount = bully.getValue();
        this.cuttingCount = cutting.getValue();
        this.vandalismCount = vandalism.getValue();
        this.badWordsCount = badWords.getValue();
        this.stealingCount = stealing.getValue();
        this.IdCount = Id.getValue();
        this.hairCount = hair.getValue();
    }
    @FXML public void Bully(){
 //       System.out.println(bully.getValue());

    }

    @FXML public void Disrespect() {
   //      System.out.println(disrespect.getValue());
    }

    public int getBullyCount() {
        return bully.getValue();
    }

    public int getDisrespectCount() {
        return disrespect.getValue();
    }

    public int getCuttingCount() {
         return cutting.getValue();
    }

    public int getVandalismCount() {
        return vandalism.getValue();
    }

    public int getBadWordsCount() {
        return badWords.getValue();
    }

    public int getStealingCount() {
        return stealing.getValue();
    }

    public int getShoutingCount() {
        return shouting.getValue();
    }

    public int getIdCount() {
        return Id.getValue(); }

    public int getHairCount() {
        return hair.getValue();
    }
}
