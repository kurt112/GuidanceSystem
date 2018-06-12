package Database;

import GuidandanceRecord.Alert.AlertType;
import GuidandanceRecord.ComboBoxObject.ComboBoxItem;
import GuidandanceRecord.DataModel.Account.Account;
import GuidandanceRecord.DataModel.StudentProfile.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class DatabaseCommands {
    private static ObservableList<Account> account = FXCollections.observableArrayList();
    private static ObservableList<Account> Historyaccounts = FXCollections.observableArrayList();
    private static ObservableList<Student> students = FXCollections.observableArrayList();


    private static DatabaseCommands datebaseCommands = new DatabaseCommands();

    public static DatabaseCommands getDBCommands() {
        return datebaseCommands;
    }
    //Path to dthe database
    private static final String dbName = "DatabaseGuidance.db";
    private static final String dbPath = "jdbc:sqlite:C:\\Users\\Orioque35\\IdeaProjects\\GuidanceRecord\\src\\Database\\" +
            dbName;

    public Connection getConn() {
        return conn;
    }


    //Database of Student
    private static final String Student_Table = "Student";
    private static final String Disable_Student_Table = "Student_Disable";
    private static final String No = "No";
    private static final String SFirstName = "First_Name";
    private static final String SLastName = "Last_Name";
    private static final String Adviser = "Adviser";
    private static final String Grade = "Grade";
    private static final String Section = "Section";
    private static final String lrn = "LRN";
    private static final String GuardianName = "Guardian_Name";
    private static final String Guardian_Contact = "Guardian_Contact";
    private static final String Sage = "Age";
    private static final String Ssex = "Sex";
    private static final String DateOfBirth = "BirthDate";
    private static final String PatfOfExcel = "PathOfFile";
    private static final String Offense_Bully = "Bully";
    private static final String Offense_Cutting = "Cutting";
    private static final String Offense_Vandalism = "Vandalism";
    private static final String Offense_Stealing = "Stealing";
    private static final String Offense_Disrespect = "Disrespect";
    private static final String Offense_Hair = "Hair";
    private static final String Offense_Label = "Shouting";
    private static final String Offense_Label1 = "Bad_Words";
    private static final String Offense_Label2 = "No_Id";
    private static final String Disable = "Disable";

    public static String getDisable() {
        return Disable;
    }

    public static String getPatfOfExcel() {
        return PatfOfExcel;
    }

    public static String getOffense_Bully() {
        return Offense_Bully;
    }

    public static String getOffense_Cutting() {
        return Offense_Cutting;
    }

    public static String getOffense_Vandalism() {
        return Offense_Vandalism;
    }

    public static String getOffense_Stealing() {
        return Offense_Stealing;
    }

    public static String getOffense_Disrespect() {
        return Offense_Disrespect;
    }

    public static String getOffense_Hair() {
        return Offense_Hair;
    }

    public static String getOffense_Label() {
        return Offense_Label;
    }

    public static String getOffense_Label1() {
        return Offense_Label1;
    }

    public static String getOffense_Label2() {
        return Offense_Label2;
    }

    public static String getDisable_Student_Table() {
        return Disable_Student_Table;
    }

    public static String getSsex() {
        return Ssex;
    }

    public static String getDateOfBirth() {
        return DateOfBirth;
    }

    public static String getNo() {
        return No;
    }


    public static String getStudent_Table() {
        return Student_Table;
    }

    public static String getSage() {
        return Sage;
    }

    public static String getSFirstName() {
        return SFirstName;
    }

    public static String getSLastName() {
        return SLastName;
    }

    public static String getAdviser() {
        return Adviser;
    }

    public static String getGrade() {
        return Grade;
    }

    public static String getSection() {
        return Section;
    }

    public static String getLrn() {
        return lrn;
    }

    public static String getGuardianName() {
        return GuardianName;
    }

    public static String getGuardian_Contact() {
        return Guardian_Contact;
    }


    //Database of Accounts
    private static final String AccountTable = "Account";
    public static final String Account_No = "NO";
    private static final String Account_Fname = "First_Name";
    private static final String Account_LastName = "Last_Name";
    private static final String UserName = "UserName";
    private static final String password = "Password";
    private static final String Re_Enter_Password = "Re_enterPassword";
    private static final String Accountdate = "Date";

    private static final String SessionIn = "SessionIn";
    private static final String SessionOut = "SessionOut";

    public static final String Account_Contact_Number = "ContactNumber";
    public static final String Account_Admin = "Admin";

    public static String getAccount_Admin() {
        return Account_Admin;
    }

    public static String getAccount_No() {
        return Account_No;
    }

    public static String getAccount_Contact_Number() {
        return Account_Contact_Number;
    }

    public static String getAccount_Fname() {
        return Account_Fname;
    }

    public static String getAccount_LastName() {
        return Account_LastName;
    }

    public static String getRe_Enter_Password() {
        return Re_Enter_Password;
    }

    public static String getAccountdate() {
        return Accountdate;
    }

    public static String getAccountTable() {
        return AccountTable;
    }

    public static String getAccountUserName() {
        return UserName;
    }

    public static String getAccountPassword() {
        return password;
    }

    public static boolean UpdateAccount(String first_Name, String last_Name, String user, String password,
                                     String re_pass, String contact_Number, String id){
        open();
        try (Statement statement = conn.createStatement()){
            statement.execute(" UPDATE " + AccountTable +
                    " Set " + getAccount_Fname() + " = '" + first_Name + "'," +
                    getAccount_LastName() + " = '" + last_Name + "', " +
                    getAccountUserName() + " = '" + user + "', " +
                    getAccountPassword() + " = '" + password+ "', " +
                    getRe_Enter_Password() + " = '" + re_pass + "', " +
                    getAccount_Contact_Number() + " = '" + contact_Number + "' " +
                    " WHERE " + Account_No + " = '" + id + "'");
            statement.close();

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
        return false;
    }



    //Database of Message
    private static final String MessageTable = "MessageTable";
    private static final String MessageText = "Message";
    private static final String Number = "ContactNumber";
    private static final String MessageDAte = "Date";

    public static String getMessageTable() {
        return MessageTable;
    }

    public static String getMessageText() {
        return MessageText;
    }

    public static String getNumber() {
        return Number;
    }

    public static String getMessageDAte() {
        return MessageDAte;
    }

    private static Connection conn;

    private static ResultSet resultSet;

    //HistoryOfLogin TBName;
    private static final String History = "HistoryOfLogin";

    //for opening the databaes
    public static boolean open() {
        try {
            conn = DriverManager.getConnection(dbPath);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //for cloing the database
    public static void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Database Close");
    }

    //for tracking the login of the user
    public void HistoryOfLogin(String userName) {
        open();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM " + AccountTable
                    + " WHERE " + UserName + " = '" + userName + "'");
            while (resultSet.next()) {
                String fname = resultSet.getString(Account_Fname);
                String lname = resultSet.getString(Account_LastName);
                String user = resultSet.getString(UserName);
                String passwords = resultSet.getString(password);
                String contact = resultSet.getString(Account_Contact_Number);

                java.util.Date date = new Date();
                date.equals(LocalDate.now());
                date.toString();
                resultSet.close();
                statement.close();
                try (Statement statement1 = conn.createStatement()) {
                    statement1.execute("INSERT  INTO " + History
                            + " (" + Account_Fname
                            + ", " + Account_LastName
                            + ", " + UserName
                            + ", " + password
                            + ", " + Account_Contact_Number
                            + ", " + SessionIn
                            + " )"
                            + " VALUES('" + fname
                            + "', '" + lname
                            + "', '" + user
                            + "', '" + passwords
                            + "', '" + contact
                            + "', '" + date

                            + "')");

                    statement1.close();
                    close();
                } catch (SQLException e) { }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getSessionIn() {
        return SessionIn;
    }

    public static String getSessionOut() {
        return SessionOut;
    }

    public static String getHistory() {
        return History;
    }

    /*
    For Disabling Student
     */

    //This method will return a list of user who login in
    public ObservableList<Account> getAccountsHistory() {

        DatabaseCommands.getDBCommands().open();
        try (Statement statement = DatabaseCommands.getDBCommands().getConn().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM " + DatabaseCommands.getDBCommands().getHistory());
            while (resultSet.next()) {
                String a1 = resultSet.getString(DatabaseCommands.getDBCommands().getAccount_No());
                String a = resultSet.getString(DatabaseCommands.getDBCommands().getAccount_Fname());
                String b = resultSet.getString(DatabaseCommands.getDBCommands().getAccount_LastName());
                String c = resultSet.getString(DatabaseCommands.getDBCommands().getAccountUserName());
                String d = resultSet.getString(DatabaseCommands.getDBCommands().getAccountPassword());
                String d1 = resultSet.getString(DatabaseCommands.getDBCommands().getRe_Enter_Password());
                String e = resultSet.getString(DatabaseCommands.getDBCommands().getAccount_Contact_Number());
                String f = resultSet.getString(DatabaseCommands.getDBCommands().getSessionIn());
                Historyaccounts.add(new Account(a1, a, b, c, d, d1, e, f));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseCommands.getDBCommands().close();
        return Historyaccounts;
    }

    //This method will return all Account In database;
    public ObservableList<Account> getAccountData() {
        DatabaseCommands.getDBCommands().open();
        try (Statement statement = DatabaseCommands.getDBCommands().getConn().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM " + DatabaseCommands.getDBCommands().getAccountTable());
            while (resultSet.next()) {
                String a1 = resultSet.getString(getAccount_No());
                String a = resultSet.getString(getAccount_Fname());
                String b = resultSet.getString(getAccount_LastName());
                String c = resultSet.getString(getAccountUserName());
                String d = resultSet.getString(getAccountPassword());
                String d1 = resultSet.getString(getRe_Enter_Password());
                String e = resultSet.getString(getAccount_Contact_Number());
                String f = resultSet.getString(getAccountdate());
                account.add(new Account(a1, a, b, c, d, d1, e, f));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseCommands.getDBCommands().close();
        return account;
    }

    //This method will return all Student in Database


    //This method will return all enable Student in Database
    public static ObservableList<Student> getStudentStatus(String status) {
        open();

        try (Statement statement = conn.createStatement()) {
            if (status == "yes") {
                resultSet = statement.executeQuery("SELECT * FROM " + Student_Table + " WHERE " + Disable + " = '" + "yes" + "'");
            } else if (status == "no") {
                resultSet = statement.executeQuery("SELECT * FROM " + Student_Table + " WHERE " + Disable + " = '" + "no" + "'");
            } else if (status.trim().isEmpty()) {
                resultSet = statement.executeQuery("SELECT * FROM " + Student_Table);
            }
            while (resultSet.next()) {
                String Fname = resultSet.getString(getSFirstName());
                String lastame = resultSet.getString(getSLastName());
                String adviser = resultSet.getString(getAdviser());
                String grade = resultSet.getString(getGrade());
                String section = resultSet.getString(getSection());
                String lrn = resultSet.getString(getLrn());
                String guardian = resultSet.getString(getGuardianName());
                String guardianNumber = resultSet.getString(getGuardian_Contact());
                String age = resultSet.getString(getSage());
                String No = resultSet.getString(getNo());
                String Path = resultSet.getString(getPatfOfExcel());
                String Bully = resultSet.getString(getOffense_Bully());
                String Cutting = resultSet.getString(getOffense_Cutting());
                String Vandalism = resultSet.getString(getOffense_Vandalism());
                String Stealing = resultSet.getString(getOffense_Stealing());
                String Disrespect = resultSet.getString(getOffense_Disrespect());
                String Hair = resultSet.getString(getOffense_Hair());
                String Label = resultSet.getString(getOffense_Label());
                String Label1 = resultSet.getString(getOffense_Label1());
                String Label2 = resultSet.getString(getOffense_Label2());
                String Sex = resultSet.getString(getSsex());
                String dates = resultSet.getString(getDateOfBirth());

                students.add(new Student(No, Fname, lastame, adviser, grade, section, lrn, guardian, guardianNumber, age
                        , Path, Sex, dates, Bully, Cutting, Vandalism, Stealing, Disrespect, Hair, Label, Label1, Label2));


            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return students;
    }

    //This if for LoginHistory
    public ObservableList<Account> getHistoryaccounts() {
        return Historyaccounts;
    }

    //This is for Account DAta
    public static ObservableList<Account> getAccount() {
        return account;
    }

    //This is for Account status
    public static ObservableList<Account> getAccountStatus(String status) {
        DatabaseCommands.getDBCommands().open();
        try (Statement statement = DatabaseCommands.getDBCommands().getConn().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM " + getAccountTable());
            while (resultSet.next()) {
                String a1 = resultSet.getString(getAccount_No());
                String a = resultSet.getString(getAccount_Fname());
                String b = resultSet.getString(getAccount_LastName());
                String c = resultSet.getString(getAccountUserName());
                String d = resultSet.getString(getAccountPassword());
                String d1 = resultSet.getString(getRe_Enter_Password());
                String e = resultSet.getString(getAccount_Contact_Number());
                String f = resultSet.getString(getAccountdate());
                account.add(new Account(a1, a, b, c, d, d1, e, f));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseCommands.getDBCommands().close();
        return account;
    }

    //This is for Studet Data
    public static ObservableList<Student> getStudents() {
        return students;
    }

    //This is for Enabling and Disabling
    public ObservableList<Account> getAccountStatuts(String status) {
        DatabaseCommands.getDBCommands().open();
        try (Statement statement = DatabaseCommands.getDBCommands().getConn().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM " + getAccountTable() + " WHERE " +
                    Disable + " = '" + status + "'");
            while (resultSet.next()) {
                String a11 = resultSet.getString(getAccount_No());
                String a1 = resultSet.getString(DatabaseCommands.getDBCommands().getAccount_Fname());
                String b1 = resultSet.getString(DatabaseCommands.getDBCommands().getAccount_LastName());
                String c1 = resultSet.getString(DatabaseCommands.getDBCommands().getAccountUserName());
                String d1 = resultSet.getString(DatabaseCommands.getDBCommands().getAccountPassword());
                String d11 = resultSet.getString(DatabaseCommands.getDBCommands().getRe_Enter_Password());
                String e1 = resultSet.getString(DatabaseCommands.getDBCommands().getAccount_Contact_Number());
                String f1= resultSet.getString(DatabaseCommands.getDBCommands().getAccountdate());
                account.add(new Account(a11, a1, b1, c1, d1, d11, e1, f1));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseCommands.getDBCommands().close();
        return account;
    }

    /*
    This method Will enable The student in
    the Database
     */
    public void EnableStudent(String id) {
        open();
        try (Statement statement = conn.createStatement()) {
            statement.execute(" UPDATE " + Student_Table + " Set " + Disable + " = '" +
                    "no" + "' " + " WHERE " + No + " = '" + id + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }

    /*
    This method will disable the Student in
    the Database
     */
    public void DisableStudent(String id) {
        open();
        try (Statement statement = conn.createStatement()) {
            statement.execute(" UPDATE " + Student_Table + " Set " + Disable + " = '" +
                    "yes" + "' " + " WHERE " + No + " = '" + id + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }

    /*
    To Enable Account in the Database
     */
    public void EnableAccount(String id) {
        open();
        try (Statement statement = conn.createStatement()) {
            statement.execute(" UPDATE " + AccountTable + " Set " + Disable + " = '" +
                    "no" + "' " + " WHERE " + Account_No + " = '" + id + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }

    /*
    To Disable Account
    in the Database
     */
    public void DisableAccount(String id) {
        open();
        try (Statement statement = conn.createStatement()) {
            statement.execute(" UPDATE " + AccountTable + " Set " + Disable + " = '" +
                    "yes" + "' " + " WHERE " + Account_No + " = '" + id + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }


    /*
    *
    *
    *
    *
    *
    *This are if for the Context Menu
    *
    *
    *
    * */

    private static final String ComboBox_Table = "Combox_Item";

    private static final String ComboBox_Column_Adviser = "Adivser";
    private static final String ComboBox_Column_Section = "Section";
    private static final String ComboBox_Column_Grade = "Grade";


    private static ObservableList<ComboBoxItem> MenuItem = FXCollections.observableArrayList();


    public static ObservableList Get_Item() {
        open();
        try (Statement statement = conn.createStatement()) {
            resultSet = statement.executeQuery("SELECT * FROM " + ComboBox_Table);
            while (resultSet.next()) {
                String adviser = resultSet.getString(ComboBox_Column_Adviser);
                String section = resultSet.getString(ComboBox_Column_Section);
                String grade = resultSet.getString(ComboBox_Column_Grade);
                MenuItem.add(new ComboBoxItem(adviser, grade, section));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return MenuItem;
    }

    public static ObservableList<ComboBoxItem> getMenuItem() {
        return MenuItem;
    }

    /*
         *This is for the Login Form
         *
         */
    public boolean LoginUserName(boolean admin, String name) {
        open();
        try (Statement statement = getConn().createStatement()) {
            String verifyAdmin;
            if (admin) {
                verifyAdmin = "yes";
            } else {
                verifyAdmin = "";
            }
            ResultSet resultSet = statement.executeQuery("SELECT " + getAccountUserName() + " FROM "
                    + getAccountTable() + " WHERE " + getAccountUserName() + " = '" + name + "'"
                    + " and " + getDisable() + " = " + "'no'"
                    + " and " + getAccount_Admin() + " = " + "'" + verifyAdmin + "'");
            while (resultSet.next()) {
                String result1 = resultSet.getString(getAccountUserName());
                //String result2 = resultSet.getString(getAccount_LastName());
                System.out.println(result1);
                statement.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("asdas");
        return false;
    }
    public static boolean LoginPassword(String user, String passwordFromField) {
        open();
        try (Statement statement = conn.createStatement()) {
            StringBuffer password = new StringBuffer(passwordFromField);
            enrypt(password, passwordFromField);
            ResultSet resultSet = statement.executeQuery("SELECT " + getAccountPassword()
                    + " FROM " + getAccountTable() + " WHERE "
                    + getAccountUserName() + " = '" + user + "' " +
                    "and " +
                    getAccountPassword() + " =   '" + password + "'"
                    + " and " + getDisable() + " ='" + "no" + "'");
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return false;
    }

    public static boolean ForgotPassword(String userName) {
        open();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM " + DatabaseCommands.getDBCommands().getAccountTable() +
                    " WHERE " + getAccountUserName() + " = '" + userName + "'");
            if (resultSet.next()) {
                String passwords = resultSet.getString(getAccountPassword());
                String number = resultSet.getString(getAccount_Contact_Number());
                StringBuffer password1 = new StringBuffer(passwords);
                decrypt(password1, passwords);
                try {
                    String email = URLEncoder.encode("kurtorioque112@gmail.com", "UTF-8");
                    String password = URLEncoder.encode("orioque35", "UTF-8");

                    String device = URLEncoder.encode("81483", "UTF-8");
                    String nubmber = URLEncoder.encode(number, "UTF-8");
                    String message = URLEncoder.encode("Your Account Password is " + password1, "UTF-8");

                    String smsgateway = "http://smsgateway.me/api/v3/messages/send?";


                    smsgateway += "email=" + email;
                    smsgateway += "&password=" + password;
                    smsgateway += "&device=" + device;
                    smsgateway += "&number=" + nubmber;
                    smsgateway += "&message=" + message;

                    URL url = new URL(smsgateway);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message Send Successful");
                    alert.setContentText("Your Message was sent On " + nubmber);
                    alert.show();
                    connection.getResponseMessage();
                    connection.getRequestMethod();
                    connection.getResponseCode();
                } catch (Exception e) {
                    AlertType.SuccessfulTextMessage();
                }
            }
        } catch (SQLException e) {
            AlertType.notSuccessfulTextMessage();
        }
        close();
        return false;
    }

    private static void enrypt(StringBuffer pass, String password) {
        for (int i = 0; i < password.length(); i++) {
            int temp = 0;
            temp = (int) pass.charAt(i);
            temp = temp * 9;
            pass.setCharAt(i, (char) temp);
        }

    }

    private static void decrypt(StringBuffer pass, String password) {
        for (int i = 0; i < password.length(); i++) {
            int temp = 0;
            temp = (int) pass.charAt(i);
            temp = temp / 9;
            pass.setCharAt(i, (char) temp);
        }
    }


    /*
    *
    *
    *This method is for the Registering Account
    *
    *
    *
    */

    public static boolean register(String fName, String lName, String UserName, String password, String retypePassword, String ContactNumber) {
        Date date = new Date();
        date.equals(LocalDate.now());
        date.toString();
        StringBuffer passwords = new StringBuffer(password);
        StringBuffer password2 = new StringBuffer(retypePassword);
        enrypt(password2, retypePassword);
        enrypt(passwords, password);
        open();
        try (Statement statement = conn.createStatement()) {
            statement.execute("INSERT  INTO " +getAccountTable() +
                    " (" + getAccount_Fname()
                    + ", " + getAccount_LastName()
                    + ", " + getAccountUserName()
                    + ", " + getAccountPassword()
                    + ", " + getRe_Enter_Password()
                    + ", " + getAccountdate()
                    + ", " + getAccount_Contact_Number()
                    + ", " + getDisable()
                    + " ) "
                    + " VALUES('" + fName
                    + "', '" + lName
                    + "', '" + UserName
                    + "', '" + passwords
                    + "', '" + password2
                    + "', '" + date
                    + "', '" + ContactNumber
                    + "', '" + "no"
                    + "')");
            statement.close();
            return true;
        } catch (SQLException e) {
           AlertType.Contact_Number();
        }
        close();
        return false;
    }

    public static boolean checkLRN(int Lrn){
        open();
        try(Statement statement = conn.createStatement()){
            statement.execute("SELECT  * FROM  " + Student_Table + " WHERE " + getLrn() +" = " + Lrn );
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
        return false;
    }

    public static  boolean checkUserName(String name){
        open();
        try(Statement statement = conn.createStatement()) {
            statement.execute("SELECT  * FROM " + AccountTable + " WHERE " + getAccountUserName() + " = " + name);
            statement.close();
            return true;
            }catch (SQLException e){
            e.printStackTrace();
        }
        close();
        return false;
    }

    public String getTheName(String name){
        open();
        try(Statement statement = conn.createStatement()){
            resultSet = statement.executeQuery("SELECT  * FROM " + AccountTable + " WHERE " +
            Account_Fname + " = " + name );
            while (resultSet.next()){
                String Thename= resultSet.getString(Account_Fname);
                statement.close();
                return Thename;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        close();
        return null;
    }

    /*
     *
     *
     *This method for registering Student
     *
     *
     *
     */

    public static boolean registerStudent(String fnames, String lastnames, String grades, String advisers
            ,String sections,String guardianNumbers,String Ages, String names, String lrn, String Guardian_Name,
                                          String age, String Sex, String dateOfBirth) {
        DatabaseCommands.getDBCommands().open();
        try (Statement statement = conn.createStatement()) {
            statement.execute("INSERT  INTO " + getStudent_Table()
                    + " (" + getSFirstName()
                    + ", " + getSLastName()
                    + ", " + getAdviser()
                    + ", " + getGrade()
                    + ", " + getSection()
                    + ", " + getLrn()
                    + ", " + getGuardianName()
                    + ", " + getGuardian_Contact()
                    + ", " + getSage()
                    + ", " + getSsex()
                    + ", " + getDateOfBirth()
                    + ", " + getDisable()
                    + ", " + getOffense_Bully()
                    + ", " + getOffense_Label1()
                    + ", " + getOffense_Cutting()
                    + ", " + getOffense_Disrespect()
                    + ", " + getOffense_Label2()
                    + ", " + getOffense_Hair()
                    + ", " + getOffense_Label()
                    + ", " + getOffense_Stealing()
                    + ", " + getOffense_Vandalism()
                    + " ) "
                    + " VALUES('" + fnames
                    + "', '" + lastnames
                    + "', '" + advisers
                    + "', '" + grades
                    + "', '" + sections
                    + "', '" + lrn
                    + "', '" + Guardian_Name
                    + "', '" + guardianNumbers
                    + "', '" + Ages
                    + "', '" + Sex
                    + "', '" + dateOfBirth
                    + "', '" + "no"
                    + "', '" + 0
                    + "', '" + 0
                    + "', '" + 0
                    + "', '" + 0
                    + "', '" + 0
                    + "', '" + 0
                    + "', '" + 0
                    + "', '" + 0
                    + "', '" + 0
                    + "')");

            statement.close();
            AlertType.SuccessfulAddStudent();
        } catch (SQLException e) {
           e.printStackTrace();
            // AlertType.NotSuccessfulAddStudent();

        }
        return false;
    }

    /*
            open();
                try(Statement statement = DatabaseCommands.getDBCommands().getConn().createStatement()){
                    statement.execute(" UPDATE " + DatabaseCommands.getDBCommands().getStudent_Table()
                            + " SET "
                            + DatabaseCommands.getDBCommands().getOffense_Bully() + " = " + offense.getBullyCount()   + " ,"
                            + DatabaseCommands.getDBCommands().getOffense_Label1() + " = " + offense.getBadWordsCount()+ " ,"
                            + DatabaseCommands.getDBCommands().getOffense_Cutting() + " = "   + offense.getCuttingCount()  + " ,"
                            + DatabaseCommands.getDBCommands().getOffense_Disrespect() + " = "     + offense.getDisrespectCount() + " ,"
                            + DatabaseCommands.getDBCommands().getOffense_Label2() + " = " + offense.getIdCount() + ","
                            + DatabaseCommands.getDBCommands().getOffense_Hair() + " = " +    offense.getHairCount() + ","
                            + DatabaseCommands.getDBCommands().getOffense_Label() + " = " + offense.getShoutingCount() + ","
                            + DatabaseCommands.getDBCommands().getOffense_Stealing() + " = " + offense.getStealingCount() + ","
                            + DatabaseCommands.getDBCommands().getOffense_Vandalism() + " = " +  offense.getVandalismCount()
                            + " WHERE "
                            + DatabaseCommands.getDBCommands().getNo() + " = " + student.getNo());
                    offense.verify();
                    System.out.println(student.getBuly() +
                            "\n" +student.getBadWords() +
                            "\n" +offense.getCuttingCount()
                            + "\n" + offense.getDisrespectCount() +
                            "\n" + offense.getIdCount()+
                            "\n" + offense.getHairCount()+
                            "\n" + offense.getShoutingCount()+
                            "\n" + offense.getStealingCount()+
                            "\n" + offense.getVandalismCount());
                    AlertType.AddRecordSuccessful(student.getFirstName());

                    if(enable.isSelected()){
                        studentTable.getItems().clear();
                        showEnable();
                    }
                    else if(disable.isSelected()){
                        studentTable.getItems().clear();
                        showDisable();
                    }else if(all.isSelected()) {
                        studentTable.getItems().clear();
                        ViewAll();

                    }
                    DatabaseCommands.getDBCommands().close();
                }catch (SQLException e){
                    AlertType.NotSuccessfulAddAccount();
                }
     */

    //        if (result.isPresent() && result.get() == ButtonType.OK) {
//            try (Statement statement = DatabaseCommands.getDBCommands().getConn().createStatement()) {
//                statement.execute("UPDATE " + DatabaseCommands.getDBCommands().getStudent_Table() + " SET "
//                        + DatabaseCommands.getDBCommands().getSFirstName() + " = '" + studentControll.getName() + "' ,"
//                        + DatabaseCommands.getDBCommands().getSLastName() + " = '" + studentControll.getLname() + "' ,"
//                        + DatabaseCommands.getDBCommands().getAdviser() + " = '" + studentControll.getAdvisers() + "' ,"
//                        + DatabaseCommands.getDBCommands().getGrade() + " = '" + studentControll.getGrade() + "' ,"
//                        + DatabaseCommands.getDBCommands().getSection() + " = '" + studentControll.getSetions() + "',"
//                        + DatabaseCommands.getDBCommands().getLrn() + " = '" + studentControll.getLrns() + "',"
//                        + DatabaseCommands.getDBCommands().getGuardianName() + " = '" + studentControll.getGuardians() + "',"
//                        + DatabaseCommands.getDBCommands().getGuardian_Contact() + " = '" + studentControll.getGuardianNumbers() + "',"
//                        + DatabaseCommands.getDBCommands().getSage() + " = '" + studentControll.getAges() + "',"
//                        + DatabaseCommands.getDBCommands().getDateOfBirth() + " = '" + studentControll.getBirth() + "',"
//                        + DatabaseCommands.getDBCommands().getSsex() + " = '" + studentControll.getSex() + "'"
//
//                        + " WHERE "
//                        + DatabaseCommands.getDBCommands().getNo() + " = " + studentControll.getNo());
//                studentTable.getItems().clear();
//                studentTable.setItems(DatabaseCommands.getDBCommands().getStudentStatus(""));
//                studentTable.getSelectionModel().selectLast();
//                statement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.println("bobo mo pre");
//            }
//        }
}