package GuidandanceRecord.DataModel.StudentProfile;

import javafx.beans.property.SimpleStringProperty;

public class Student {

    //The data of the Student
    private SimpleStringProperty No = new SimpleStringProperty("");
    private SimpleStringProperty  lastName = new SimpleStringProperty("");
    private SimpleStringProperty  firstName = new SimpleStringProperty("");
    private SimpleStringProperty adviser = new SimpleStringProperty("");
    private SimpleStringProperty grade = new SimpleStringProperty("");
    private SimpleStringProperty  section = new SimpleStringProperty("");
    private SimpleStringProperty lrn = new SimpleStringProperty("");
    private SimpleStringProperty guardianName = new SimpleStringProperty("");
    private SimpleStringProperty guardianContact = new SimpleStringProperty("");
    private SimpleStringProperty age = new SimpleStringProperty("");
    private SimpleStringProperty Sex = new SimpleStringProperty("");
    private SimpleStringProperty BirthDate = new SimpleStringProperty("");

    public String getLastName() {
        return lastName.get();
    }

    public String getSex() {
        return Sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return Sex;
    }

    public String getBirthDate() {
        return BirthDate.get();
    }

    public SimpleStringProperty birthDateProperty() {
        return BirthDate;
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() { return firstName.get(); }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
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

    public String getSection() {
        return section.get();
    }

    public SimpleStringProperty sectionProperty() {
        return section;
    }

    public void setSection(String section) {
        this.section.set(section);
    }

    public String getLrn() {
        return lrn.get();
    }

    public SimpleStringProperty lrnProperty() {
        return lrn;
    }

    public void setLrn(String lrn) {
        this.lrn.set(lrn);
    }

    public String getGuardianName() {
        return guardianName.get();
    }

    public SimpleStringProperty guardianNameProperty() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName.set(guardianName);
    }

    public String getGuardianContact() {
        return guardianContact.get();
    }

    public SimpleStringProperty guardianContactProperty() {
        return guardianContact;
    }

    public void setGuardianContact(String guardianContact) {
        this.guardianContact.set(guardianContact);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getNo() {
        return No.get();
    }

    public SimpleStringProperty noProperty() {
        return No;
    }


    //The Record in the guidance of the Student
    private SimpleStringProperty PathOfExcel = new SimpleStringProperty("");

    public String getPathOfExcel() {
        return PathOfExcel.get();
    }

    public SimpleStringProperty pathOfExcelProperty() {
        return PathOfExcel;
    }

    public void setPathOfExcel(String pathOfExcel) {
        this.PathOfExcel.set(pathOfExcel);
    }

    //
    //The Record of the Student in the guidance;
    //

    private SimpleStringProperty  Buly       = new SimpleStringProperty();
    private SimpleStringProperty  Cutting    = new SimpleStringProperty();
    private SimpleStringProperty  Vandalism  = new SimpleStringProperty();
    private SimpleStringProperty  Stealing   = new SimpleStringProperty();
    private SimpleStringProperty  Disrespect = new SimpleStringProperty();
    private SimpleStringProperty  Hair       = new SimpleStringProperty();
    private SimpleStringProperty  Shouting      = new SimpleStringProperty();
    private SimpleStringProperty  BadWords      = new SimpleStringProperty();
    private SimpleStringProperty  NoId     = new SimpleStringProperty();


    public void setNo(String no) {
        this.No.set(no);
    }

    public String getBuly() {
        return Buly.get();
    }

    public SimpleStringProperty bulyProperty() {
        return Buly;
    }

    public void setBuly(String buly) {
        this.Buly.set(buly);
    }

    public String getCutting() {
        return Cutting.get();
    }

    public SimpleStringProperty cuttingProperty() {
        return Cutting;
    }

    public void setCutting(String cutting) {
        this.Cutting.set(cutting);
    }

    public String getVandalism() {
        return Vandalism.get();
    }

    public SimpleStringProperty vandalismProperty() {
        return Vandalism;
    }

    public void setVandalism(String vandalism) {
        this.Vandalism.set(vandalism);
    }

    public String getStealing() {
        return Stealing.get();
    }

    public SimpleStringProperty stealingProperty() {
        return Stealing;
    }

    public void setStealing(String stealing) {
        this.Stealing.set(stealing);
    }

    public String getDisrespect() {
        return Disrespect.get();
    }

    public SimpleStringProperty disrespectProperty() {
        return Disrespect;
    }

    public void setDisrespect(String disrespect) {
        this.Disrespect.set(disrespect);
    }

    public String getHair() {
        return Hair.get();
    }

    public SimpleStringProperty hairProperty() {
        return Hair;
    }

    public void setHair(String hair) {
        this.Hair.set(hair);
    }



    public Student() {

    }

    public Student(String No, String firstName, String lastName, String adviser, String grade, String section, String lrn,
                   String guardianName, String guardianContact, String age,String PathOfExcel, String Sex, String BirthDate,
                   String Buly, String Cutting, String Vandalism, String Stealing, String Disrespect, String Hair, String Shouting, String BadWords, String NoId){
        this.Sex.set(Sex);
        this.BirthDate.set(BirthDate);
        this.No.set(No);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.adviser.set(adviser);
        this.grade.set(grade);
        this.section.set(section);
        this.lrn.set(lrn);
        this.guardianName.set(guardianName);
        this.guardianContact.set(guardianContact);
        this.age.set(age);
        this.PathOfExcel.set(PathOfExcel);
        this.Buly.set(Buly);
        this.Cutting.set(Cutting);
        this.Vandalism.set(Vandalism);
        this.Stealing.set(Stealing);
        this.Disrespect.set(Disrespect);
        this.Hair.set(Hair);
        this.Shouting.set(Shouting);
        this.BadWords.set(BadWords);
        this.NoId.set(NoId);
    }

    public String getShouting() {
        return Shouting.get();
    }

    public SimpleStringProperty shoutingProperty() {
        return Shouting;
    }

    public void setShouting(String shouting) {
        this.Shouting.set(shouting);
    }

    public String getBadWords() {
        return BadWords.get();
    }

    public SimpleStringProperty badWordsProperty() {
        return BadWords;
    }

    public void setBadWords(String badWords) {
        this.BadWords.set(badWords);
    }

    public String getNoId() {
        return NoId.get();
    }

    public SimpleStringProperty noIdProperty() {
        return NoId;
    }

    public void setNoId(String noId) {
        this.NoId.set(noId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName=9" + lastName +
                ", firstName=" + firstName +
                ", adviser=" + adviser +
                ", grade=" + grade +
                ", section=" + section +
                ", lrn=" + lrn +
                ", guardianName=" + guardianName +
                ", guardianContact=" + guardianContact +
                '}';
    }
}