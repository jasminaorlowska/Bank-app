import java.util.ArrayList; //do wyjebania później;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        Bank bank = new Bank();

        //Login login = new Login(bank);
        //login.runLogin();

        for (User user : bank.loginInfo.keySet()){
            System.out.println("--" + user.getAccount().getNumber());
        }
        Menu menu = new Menu(bank.getUser("ProbnyUser"), bank);
        //menu.runMenu();
        //menu.sendMoneyTo();


    }
}
