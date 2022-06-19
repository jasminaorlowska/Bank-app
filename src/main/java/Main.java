import java.io.IOException;
import java.util.ArrayList; //do wyjebania później;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {

        Bank bank = new Bank();

        Login login = new Login(bank);
        login.runLogin();

//        Menu menu = new Menu(bank.getUser("ProbnyUser"), bank);
//        menu.runMenu();
//        //menu.sendMoneyTo();


    }
}
