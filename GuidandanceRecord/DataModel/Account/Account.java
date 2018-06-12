package GuidandanceRecord.DataModel.Account;

import javafx.beans.property.SimpleStringProperty;

public class Account {
    private SimpleStringProperty No = new SimpleStringProperty("");
    private SimpleStringProperty First_Name = new SimpleStringProperty("");
    private SimpleStringProperty Last_Name = new SimpleStringProperty("");
    private SimpleStringProperty UserName = new SimpleStringProperty("");
    private SimpleStringProperty Password = new SimpleStringProperty("");
    private SimpleStringProperty Re_EnterPassword = new SimpleStringProperty("");
    private SimpleStringProperty ContactNumber = new SimpleStringProperty("");
    private SimpleStringProperty Date = new SimpleStringProperty("");
    private SimpleStringProperty Admin = new SimpleStringProperty("");

    public Account(){

    }
    public Account(String No, String First_Name, String Last_Name, String UserName, String Password,
                   String Re_EnterPassword, String ContactNumber, String Date){
        this.No.set(No);
        this.First_Name.set(First_Name);
        this.Last_Name.set(Last_Name);
        this.UserName.set(UserName);
        this.Password.set(Password);
        this.Re_EnterPassword.set(Re_EnterPassword);
        this.ContactNumber.set(ContactNumber);
        this.Date.set(Date);

    }

    public String getNo() {
        return No.get();
    }

    public SimpleStringProperty noProperty() {
        return No;
    }

    public void setNo(String no) {
        this.No.set(no);
    }

    public String getFirst_Name() {
        return First_Name.get();
    }

    public SimpleStringProperty first_NameProperty() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.First_Name.set(first_Name);
    }

    public String getLast_Name() {
        return Last_Name.get();
    }

    public SimpleStringProperty last_NameProperty() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.Last_Name.set(last_Name);
    }

    public String getUserName() {
        return UserName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName.set(userName);
    }

    public String getPassword() {
        return Password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password.set(password);
    }

    public String getRe_EnterPassword() {
        return Re_EnterPassword.get();
    }

    public SimpleStringProperty re_EnterPasswordProperty() {
        return Re_EnterPassword;
    }

    public void setRe_EnterPassword(String re_EnterPassword) {
        this.Re_EnterPassword.set(re_EnterPassword);
    }

    public String getContactNumber() {
        return ContactNumber.get();
    }

    public SimpleStringProperty contactNumberProperty() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.ContactNumber.set(contactNumber);
    }

    public String getDate() {
        return Date.get();
    }

    public SimpleStringProperty dateProperty() {
        return Date;
    }

    public void setDate(String date) {
        this.Date.set(date);
    }

    public String getAdmin() {
        return Admin.get();
    }

    public SimpleStringProperty adminProperty() {
        return Admin;
    }

    public void setAdmin(String admin) {
        this.Admin.set(admin);
    }
}
