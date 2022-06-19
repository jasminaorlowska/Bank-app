import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; //do wyjebania później;
import java.util.Scanner;

public class Main {

//    String filepath = "probneDane.csv";
//    public void saveRecord(String username, String password, String bankAccnumber){
//        try {
//            FileWriter fw = new FileWriter(filepath, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            pw.println(username + "," +password + "," + bankAccnumber + ",");
//            pw.flush();
//            pw.close();
//        }
//        catch (Exception e){
//            System.out.println("Record not saved.");
//        }
//    }
    public static void main (String[] args) throws IOException {

        Bank bank = new Bank();

        Login login = new Login(bank);
        login.runLogin();

//        for (User user : bank.loginInfo.keySet()){
//            System.out.println("--" + user.getAccount().getNumber());
//        }

//        Menu menu = new Menu(bank.getUser("ProbnyUser"), bank);
//        menu.runMenu();
//        //menu.sendMoneyTo();

//        Main probny = new Main();
//        probny.saveRecord("Halo", "ocb", "siemano");
    }
}
