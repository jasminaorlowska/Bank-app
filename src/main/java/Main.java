import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {

        Bank bank = new Bank();

        Login login = new Login(bank);
        login.runlogin();

        Menu menu = new Menu(bank.getUser("ProbnyUser"), bank);
        menu.runMenu();

    }
}
