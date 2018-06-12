package GuidandanceRecord.ComboBoxObject;

import javafx.beans.property.SimpleStringProperty;


public class ComboBoxItem {

    private SimpleStringProperty section = new SimpleStringProperty("");
    private SimpleStringProperty adviser = new SimpleStringProperty("");
    private SimpleStringProperty grade  = new SimpleStringProperty("");

    public ComboBoxItem(String adviser, String grade, String section) {
       this.section.set(section);
       this.adviser.set(adviser);
       this.grade.set(grade);
    }

    public String getSection() {
        return section.get();
    }

    public SimpleStringProperty sectionProperty() {
        return section;
    }

    public void setSection(String section) {
        this.section.set(section);
    }

    public String getAdviser() {
        return adviser.get();
    }

    public SimpleStringProperty adviserProperty() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser.set(adviser);
    }

    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }
}
